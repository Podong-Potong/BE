package org.coffeepower.podongpotong.domain.challenge.exception;

import org.coffeepower.podongpotong.global.exception.BusinessException;
import org.coffeepower.podongpotong.global.exception.ErrorCode;

public class SavingGameNotRegistered extends BusinessException {
    public SavingGameNotRegistered() {
        super(ErrorCode.SAVING_GAME_NOT_REGISTERED);
    }
}
