package org.coffeepower.podongpotong.global.exception;

import lombok.Getter;
import java.time.Instant;

@Getter
public class Result<T> {
    private int statusCode;     // 상태 코드
    private String message;     // 메시지
    private String timestamp;   // 타임스탬프
    private T data;

    // 응답은 하지만, 응답할 데이터가 없는 경우
    public Result(ErrorCode errorCode) {
        this.statusCode = errorCode.getStatus().value();
        this.message = errorCode.getMessage();
        this.timestamp = Instant.now().toString();
        this.data = null;
    }

    // 응답 코드 및 응답 데이터를 담아 보냄
    public Result(ErrorCode errorCode, T resultObject) {
        this.statusCode = errorCode.getStatus().value();
        this.message = errorCode.getMessage();
        this.timestamp = Instant.now().toString();
        this.data = resultObject;
    }

    @Override
    public String toString(){
        return "Result{" +
                "code=" + statusCode +
                ", msg='" + message + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", data=" + data +
                '}';
    }
}