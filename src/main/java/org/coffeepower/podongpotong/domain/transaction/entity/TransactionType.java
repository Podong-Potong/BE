package org.coffeepower.podongpotong.domain.transaction.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TransactionType {
    INCOME("수입"),       // 수입
    EXPENSE("지출"),      // 지출
    TRANSFER("이체");     // 이체

    private final String description;
}
