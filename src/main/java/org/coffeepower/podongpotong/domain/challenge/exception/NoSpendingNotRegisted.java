package org.coffeepower.podongpotong.domain.challenge.exception;

import org.coffeepower.podongpotong.global.exception.BusinessException;
import org.coffeepower.podongpotong.global.exception.ErrorCode;

public class NoSpendingNotRegisted extends BusinessException {
    public NoSpendingNotRegisted() {
        super(ErrorCode.NO_SPENDING_CHALLENGE_NOT_REGISTERED);
    }
}
