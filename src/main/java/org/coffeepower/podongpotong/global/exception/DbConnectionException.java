package org.coffeepower.podongpotong.global.exception;

public class DbConnectionException extends BusinessException {
    public DbConnectionException() {
        super(ErrorCode.DB_ERROR);
    }
}
