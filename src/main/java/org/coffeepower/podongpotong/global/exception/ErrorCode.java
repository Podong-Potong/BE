package org.coffeepower.podongpotong.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // 에러 코드 예시
    FAIL_TO_FIND_USER(HttpStatus.NOT_FOUND, "존재하지 않는 회원입니다"),
    TEST_STATUS(HttpStatus.OK, "health");

    private final HttpStatus status;
    private final String message;
}