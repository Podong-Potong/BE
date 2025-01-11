package org.coffeepower.podongpotong.domain.user.exception;

import org.coffeepower.podongpotong.global.exception.BusinessException;
import org.coffeepower.podongpotong.global.exception.ErrorCode;

public class DuplicateEmailException extends BusinessException {
    public DuplicateEmailException() {
        super(ErrorCode.DUPLICATE_EMAIL);
    }
}
