package org.coffeepower.podongpotong.domain.challenge.exception;

import org.coffeepower.podongpotong.global.exception.BusinessException;
import org.coffeepower.podongpotong.global.exception.ErrorCode;

public class YearlySavingNotRegistered extends BusinessException {
    public YearlySavingNotRegistered() {
        super(ErrorCode.YEARLY_SAVING_NOT_REGISTERED);
    }
}
