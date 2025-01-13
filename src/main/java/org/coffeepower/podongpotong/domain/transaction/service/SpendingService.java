package org.coffeepower.podongpotong.domain.transaction.service;

import lombok.RequiredArgsConstructor;
import org.coffeepower.podongpotong.domain.transaction.dto.SpendResDto;
import org.coffeepower.podongpotong.domain.transaction.dto.SpendRegisterReqDto;
import org.coffeepower.podongpotong.domain.transaction.entity.TransactionDetail;
import org.coffeepower.podongpotong.domain.transaction.repository.SpendingRepository;
import org.coffeepower.podongpotong.domain.user.entity.User;
import org.coffeepower.podongpotong.domain.user.exception.NoUserDataException;
import org.coffeepower.podongpotong.domain.user.repository.UserRepository;
import org.coffeepower.podongpotong.global.exception.ErrorCode;
import org.coffeepower.podongpotong.global.exception.Result;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

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

        System.out.println(spendRegisterReqDto.category());

        spendingRepository.save(new TransactionDetail(spendRegisterReqDto, user));

        return new Result<>(ErrorCode.SUCCESS);
    }

    // 지출 출력
    public Result<?> getSpending(long userId, int year, int month) {
        User user = null;

        try {
            user = userRepository.findById(userId).orElseThrow(NoUserDataException::new);
        } catch (NoUserDataException e) {
            return new Result<>(ErrorCode.FAIL_TO_FIND_USER);
        }

        List<TransactionDetail> transactionDetailList = spendingRepository.findByUserBetweenYearAndMonth(user, year, month);
        List<SpendResDto> spendResDtos = new ArrayList<>();

        for (TransactionDetail transactionDetail : transactionDetailList) {
            spendResDtos.add(new SpendResDto(transactionDetail));
        }

        return new Result<>(ErrorCode.SUCCESS, spendResDtos);
    }

    // 하루 지출 출력
    public Result<?> getSpending(long userId, LocalDate date) {
        User user = null;

        try {
            user = userRepository.findById(userId).orElseThrow(NoUserDataException::new);
        } catch (NoUserDataException e) {
            return new Result<>(ErrorCode.FAIL_TO_FIND_USER);
        }

        List<TransactionDetail> transactionDetailList = spendingRepository.findTransactionsForOneDay(date, user);
        List<SpendResDto> spendResDtos = new ArrayList<>();

        for (TransactionDetail transactionDetail : transactionDetailList) {
            spendResDtos.add(new SpendResDto(transactionDetail));
        }

        return new Result<>(ErrorCode.SUCCESS, spendResDtos);
    }
}
