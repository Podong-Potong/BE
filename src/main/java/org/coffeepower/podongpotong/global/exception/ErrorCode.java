package org.coffeepower.podongpotong.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // 에러 코드 예시
    TEST_STATUS(HttpStatus.OK, "health"),
    SUCCESS(HttpStatus.OK, "성공"),

    // User
    FAIL_TO_FIND_USER(HttpStatus.NOT_FOUND, "존재하지 않는 회원입니다"),
    DUPLICATE_EMAIL(HttpStatus.BAD_REQUEST, "이미 사용중인 이메일입니다");

    private final HttpStatus status;
    private final String message;
}