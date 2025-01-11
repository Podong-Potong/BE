package org.coffeepower.podongpotong.domain.goal.dto;

import lombok.Data;
import org.coffeepower.podongpotong.domain.transaction.entity.TransactionCategory;

import java.time.LocalDate;

@Data
public class RegisterGoalReqDto {
    private int amount;             // 목표 금액
    private TransactionCategory category; // 카테고리
    private LocalDate startDate;         // 목표 설정 날짜
}
