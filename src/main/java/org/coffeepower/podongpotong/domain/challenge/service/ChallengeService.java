package org.coffeepower.podongpotong.domain.challenge.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.coffeepower.podongpotong.domain.challenge.dto.ChallengeResDto;
import org.coffeepower.podongpotong.domain.challenge.dto.ManagementChallengeReqDto;
import org.coffeepower.podongpotong.domain.challenge.entity.Challenge;
import org.coffeepower.podongpotong.domain.challenge.repository.ChallengeRepository;
import org.coffeepower.podongpotong.domain.user.entity.User;
import org.coffeepower.podongpotong.domain.user.exception.NoUserDataException;
import org.coffeepower.podongpotong.domain.user.repository.UserRepository;
import org.coffeepower.podongpotong.global.exception.ErrorCode;
import org.coffeepower.podongpotong.global.exception.Result;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ChallengeService {
    private final ChallengeRepository challengeRepository;
    private final UserRepository userRepository;

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
}
