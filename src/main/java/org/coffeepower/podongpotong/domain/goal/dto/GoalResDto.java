package org.coffeepower.podongpotong.domain.goal.dto;

import lombok.Getter;
import org.coffeepower.podongpotong.domain.goal.entity.SpendingGoal;
import org.coffeepower.podongpotong.domain.transaction.entity.TransactionCategory;

import java.time.LocalDate;

/**
 * @param amount    목표 금액
 * @param category  카테고리
 * @param startDate 목표 설정 날짜
 */

public record GoalResDto(int amount, TransactionCategory category, LocalDate startDate) {
    public GoalResDto(SpendingGoal spendingGoal) {
        this(spendingGoal.getAmount(), spendingGoal.getCategory(), spendingGoal.getStartDate());
    }
}
