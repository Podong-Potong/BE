package org.coffeepower.podongpotong.domain.spending.service;

import lombok.RequiredArgsConstructor;
import org.coffeepower.podongpotong.domain.spending.dto.MonthSpendReq;
import org.coffeepower.podongpotong.domain.spending.dto.SpendResDto;
import org.coffeepower.podongpotong.domain.spending.dto.SpendRegisterReqDto;
import org.coffeepower.podongpotong.domain.spending.entity.Spending;
import org.coffeepower.podongpotong.domain.spending.repository.SpendingRepository;
import org.coffeepower.podongpotong.domain.user.entity.User;
import org.coffeepower.podongpotong.domain.user.exception.NoUserDataException;
import org.coffeepower.podongpotong.domain.user.repository.UserRepository;
import org.coffeepower.podongpotong.global.exception.ErrorCode;
import org.coffeepower.podongpotong.global.exception.Result;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SpendingService {
    private final SpendingRepository spendingRepository;
    private final UserRepository userRepository;

    // 지출 등록
    public Result<?> saveSpending(long userId, SpendRegisterReqDto spendRegisterReqDto) {
        User user = null;

        try {
            user = userRepository.findById(userId).orElseThrow(NoUserDataException::new);
        } catch (NoUserDataException e) {
            return new Result<>(ErrorCode.FAIL_TO_FIND_USER);
        }

        spendingRepository.save(new Spending(spendRegisterReqDto, user));

        return new Result<>(ErrorCode.SUCCESS);
    }

    // 지출 출력
    public Result<?> getSpending(long userId, MonthSpendReq monthSpendReq) {
        User user = null;

        try {
            user = userRepository.findById(userId).orElseThrow(NoUserDataException::new);
        } catch (NoUserDataException e) {
            return new Result<>(ErrorCode.FAIL_TO_FIND_USER);
        }

        List<Spending> spendingList = spendingRepository.findByUserBetweenYearAndMonth(user, monthSpendReq.getYear(), monthSpendReq.getMonth());
        List<SpendResDto> spendResDtos = new ArrayList<>();

        for (Spending spending : spendingList) {
            spendResDtos.add(new SpendResDto(spending));
        }

        return new Result<>(ErrorCode.SUCCESS, spendResDtos);
    }
}
