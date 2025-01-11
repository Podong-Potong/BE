package org.coffeepower.podongpotong.domain.spending.service;

import lombok.RequiredArgsConstructor;
import org.coffeepower.podongpotong.domain.spending.dto.SpendRegisterReqDto;
import org.coffeepower.podongpotong.domain.spending.entity.Spending;
import org.coffeepower.podongpotong.domain.spending.repository.SpendingRepository;
import org.coffeepower.podongpotong.domain.user.entity.User;
import org.coffeepower.podongpotong.domain.user.exception.NoUserDataException;
import org.coffeepower.podongpotong.domain.user.repository.UserRepository;
import org.coffeepower.podongpotong.global.exception.ResponseResult;
import org.coffeepower.podongpotong.global.exception.ErrorCode;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpendingService {
    private final SpendingRepository spendingRepository;
    private final UserRepository userRepository;

    public String saveSpending(long userId, SpendRegisterReqDto spendRegisterReqDto) {
        User user = null;

        try {
            user = userRepository.findById(userId).orElseThrow(NoUserDataException::new);
        } catch (NoUserDataException e) {
            return new ResponseResult<>(ErrorCode.FAIL_TO_FIND_USER).toReturn();
        }

        spendingRepository.save(new Spending(spendRegisterReqDto, user));

        return new ResponseResult<>(ErrorCode.SUCCESS).toReturn();
    }
}
