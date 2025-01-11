package org.coffeepower.podongpotong.domain.transaction.dto;

import lombok.Getter;
import org.coffeepower.podongpotong.domain.transaction.entity.TransactionCategory;
import org.coffeepower.podongpotong.domain.transaction.entity.TransactionType;
import org.coffeepower.podongpotong.domain.transaction.entity.TransactionDetail;
import java.time.LocalDate;

@Getter
public class SpendResDto {
    private TransactionCategory category; // 카테고리
    private String description;     // 소비 설명
    private int amount;             // 소비 금액
    private LocalDate date;         // 소비 날짜
    private TransactionType type;         // 수입 / 지출 / 이체

    public SpendResDto(TransactionDetail transactionDetail) {
        this.category = transactionDetail.getCategory();
        this.description = transactionDetail.getDescription();
        this.amount = transactionDetail.getAmount();
        this.date = transactionDetail.getDate();
        this.type = transactionDetail.getType();
    }
}
