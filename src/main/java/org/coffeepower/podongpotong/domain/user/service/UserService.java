package org.coffeepower.podongpotong.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.coffeepower.podongpotong.domain.user.dto.RegisterReqDto;
import org.coffeepower.podongpotong.domain.user.entity.User;
import org.coffeepower.podongpotong.domain.user.exception.DuplicateEmailException;
import org.coffeepower.podongpotong.domain.user.repository.UserRepository;
import org.coffeepower.podongpotong.global.exception.ErrorCode;
import org.coffeepower.podongpotong.global.exception.Result;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 이미 회원가입이 된 이메일인지 확인
    public Result<?> duplicateEmailCheck(String email) {
        try {
            if (userRepository.findByEmailExists(email)) { throw new DuplicateEmailException(); }
        } catch (DuplicateEmailException e) {
            return new Result<>(ErrorCode.DUPLICATE_EMAIL);
        }

        return new Result<>(ErrorCode.SUCCESS);
    }

    // 회원가입
    public Result<?> registerUser(RegisterReqDto registerReqDto) {
        User user = new User(registerReqDto);
        userRepository.save(user);

        return new Result<>(ErrorCode.SUCCESS);
    }

}
