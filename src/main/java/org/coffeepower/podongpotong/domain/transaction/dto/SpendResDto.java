package org.coffeepower.podongpotong.domain.transaction.dto;

import lombok.Getter;
import org.coffeepower.podongpotong.domain.transaction.entity.TransactionCategory;
import org.coffeepower.podongpotong.domain.transaction.entity.TransactionType;
import org.coffeepower.podongpotong.domain.transaction.entity.TransactionDetail;
import java.time.LocalDate;

public record SpendResDto(
        TransactionCategory category, // 카테고리
        String description,           // 소비 설명
        int amount,                   // 소비 금액
        LocalDate date,               // 소비 날짜
        TransactionType type          // 수입 / 지출 / 이체
) {
    public SpendResDto(TransactionDetail transactionDetail) {
        this(
                transactionDetail.getCategory(),
                transactionDetail.getDescription(),
                transactionDetail.getAmount(),
                transactionDetail.getDate(),
                transactionDetail.getType()
        );
    }
}
