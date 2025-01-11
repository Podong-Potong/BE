package org.coffeepower.podongpotong.domain.challenge.exception;

import org.coffeepower.podongpotong.global.exception.BusinessException;
import org.coffeepower.podongpotong.global.exception.ErrorCode;

public class WeeklySavingNotRegistered extends BusinessException {
    public WeeklySavingNotRegistered() {
        super(ErrorCode.WEEKLY_SAVING_NOT_REGISTERED);
    }
}
