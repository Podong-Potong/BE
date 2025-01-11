package org.coffeepower.podongpotong.domain.challenge.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.coffeepower.podongpotong.domain.challenge.dto.ChallengeResDto;
import org.coffeepower.podongpotong.domain.challenge.dto.ManagementChallengeReqDto;
import org.coffeepower.podongpotong.domain.challenge.entity.Challenge;
import org.coffeepower.podongpotong.domain.challenge.entity.ChallengeType;
import org.coffeepower.podongpotong.domain.challenge.exception.NoSpendingNotRegisted;
import org.coffeepower.podongpotong.domain.challenge.exception.YearlySavingNotRegistered;
import org.coffeepower.podongpotong.domain.challenge.repository.ChallengeRepository;
import org.coffeepower.podongpotong.domain.transaction.repository.SpendingRepository;
import org.coffeepower.podongpotong.domain.transaction.service.SpendingService;
import org.coffeepower.podongpotong.domain.user.entity.User;
import org.coffeepower.podongpotong.domain.user.exception.NoUserDataException;
import org.coffeepower.podongpotong.domain.user.repository.UserRepository;
import org.coffeepower.podongpotong.global.exception.ErrorCode;
import org.coffeepower.podongpotong.global.exception.Result;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ChallengeService {
    private final ChallengeRepository challengeRepository;
    private final UserRepository userRepository;
    private final SpendingRepository spendingRepository;

    // 챌린지가 등록이 안되어 있으면 챌린지 등록
    // 되어 있는 경우, 날짜 수정
    @Transactional
    public Result<?> managementChallenge(Long userId, ManagementChallengeReqDto managementChallengeReqDto) {

        User user = null;

        try {
            user = userRepository.findById(userId).orElseThrow(NoUserDataException::new);
        } catch (NoUserDataException e) {
            return new Result<>(ErrorCode.FAIL_TO_FIND_USER);
        }

        // 챌린지가 등록이 되어 있을 경우
        Optional<Challenge> challenge = challengeRepository.findByUserAndChallengeType(user, managementChallengeReqDto.getChallengeType());
        if (challenge.isPresent()) {
            challenge.get().setSelectedDays(managementChallengeReqDto.getSelectedDays());
            challenge.get().setYearGoal(managementChallengeReqDto.getYearGoal());
            challenge.get().setWeekOfMonthGoal(managementChallengeReqDto.getWeekOfMonthGoal());
            return new Result<>(ErrorCode.SUCCESS, "Change Challenge Days");
        } else {
            challengeRepository.save(new Challenge(managementChallengeReqDto, user));
            return new Result<>(ErrorCode.SUCCESS, "Register Challenge");
        }
    }

    // 유저의 챌린지 목록 출력
    public Result<?> getChallengeList(Long userId) {
        User user = null;

        try {
            user = userRepository.findById(userId).orElseThrow(NoUserDataException::new);
        } catch (NoUserDataException e) {
            return new Result<>(ErrorCode.FAIL_TO_FIND_USER);
        }

        List<Challenge> challengeList = challengeRepository.findByUser(user).orElse(null);
        List<ChallengeResDto> challengeResDtos = new ArrayList<>();

        if (challengeList != null) {
            for (Challenge challenge : challengeList) {
                challengeResDtos.add(new ChallengeResDto(challenge));
            }
        }

        return new Result<>(ErrorCode.SUCCESS, challengeResDtos);
    }

    // 무지출 챌린지 달성률 출력
    public Result<?> getNoSpendingChallenge(Long userId) {
        User user = null;

        try {
            user = userRepository.findById(userId).orElseThrow(NoUserDataException::new);
        } catch (NoUserDataException e) {
            return new Result<>(ErrorCode.FAIL_TO_FIND_USER);
        }

        try {
            Challenge challenge = challengeRepository.findByUserAndChallengeType(user, ChallengeType.NO_SPENDING).orElseThrow(NoSpendingNotRegisted::new);

            // 요일을 뽑아냄
            String dayOfWeek = challenge.getSelectedDays();
            List<DayOfWeek> days = new ArrayList<>();

            for (int i = 0; i < dayOfWeek.length(); i++) {
                if (dayOfWeek.charAt(i) == '1') {
                    days.add(DayOfWeek.values()[i]);
                }
            }

            // 이번달에 적합한 요일의 날짜를 넣음
            List<LocalDate> selectedDays = new ArrayList<>();

            YearMonth currentYearMonth = YearMonth.now();       // 현재 연도와 월
            int daysInMonth = currentYearMonth.lengthOfMonth(); // 현재 월의 일 수

            for (int i = 1; i <= daysInMonth; i++) {
                LocalDate day = currentYearMonth.atDay(i);
                DayOfWeek d = day.getDayOfWeek();

                if (days.contains(d)) { selectedDays.add(day); }
            }

            // 이번달에 적합한 요일의 날짜 중 지출이 없는 날짜를 넣음
            Integer expenseCnt = spendingRepository.findExpenseCnt(selectedDays, user);
            int noSpendingDays = selectedDays.size() - expenseCnt;

            return new Result<>(ErrorCode.SUCCESS, ((float)noSpendingDays / (float)selectedDays.size()) * 100);

        } catch (NoSpendingNotRegisted e) {
            return new Result<>(ErrorCode.NO_SPENDING_CHALLENGE_NOT_REGISTERED);
        }
    }

    // "1년 기준 NNN 모으기" 챌린지 달성률 출력
    public Result<?> getYearGoalChallenge(Long userId) {
        User user = null;

        try {
            user = userRepository.findById(userId).orElseThrow(NoUserDataException::new);
        } catch (NoUserDataException e) {
            return new Result<>(ErrorCode.FAIL_TO_FIND_USER);
        }

        try {
            Challenge challenge = challengeRepository.findByUserAndChallengeType(user, ChallengeType.YEARLY_SAVING).orElseThrow(YearlySavingNotRegistered::new);

            Float goal = challenge.getYearGoal().floatValue();

            // 올해의 시작과 끝 계산
            LocalDate startOfYear = LocalDate.of(LocalDate.now().getYear(), 1, 1);
            LocalDate endOfYear = LocalDate.of(LocalDate.now().getYear(), 12, 31);

            Float totalSaving = spendingRepository. sumFundAmountForCurrentYear(startOfYear, endOfYear, user);

            if (totalSaving == null) { totalSaving = 0f; }

            return new Result<>(ErrorCode.SUCCESS, ( totalSaving / goal) * 100);

        } catch (YearlySavingNotRegistered e) {
            return new Result<>(ErrorCode.YEARLY_SAVING_NOT_REGISTERED);
        }
    }

}
