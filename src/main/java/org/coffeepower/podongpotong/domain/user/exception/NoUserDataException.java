package org.coffeepower.podongpotong.domain.user.exception;

import org.coffeepower.podongpotong.global.exception.BusinessException;
import org.coffeepower.podongpotong.global.exception.ErrorCode;

public class NoUserDataException extends BusinessException {
    public NoUserDataException() {
        super(ErrorCode.FAIL_TO_FIND_USER);
    }
}
