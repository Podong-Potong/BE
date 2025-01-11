package org.coffeepower.podongpotong.domain.transaction.dto;

import lombok.Data;
import org.coffeepower.podongpotong.domain.transaction.entity.TransactionCategory;
import org.coffeepower.podongpotong.domain.transaction.entity.TransactionType;

import java.time.LocalDate;

@Data
public class SpendRegisterReqDto {
    private String description;     // 소비 설명
    private int amount;             // 소비 금액
    private TransactionCategory category; // 카테고리
    private LocalDate date;
    private TransactionType type;
}
