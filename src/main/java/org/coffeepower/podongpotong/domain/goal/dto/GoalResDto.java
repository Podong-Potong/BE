package org.coffeepower.podongpotong.domain.goal.dto;

import lombok.Getter;
import org.coffeepower.podongpotong.domain.goal.entity.SpendingGoal;
import org.coffeepower.podongpotong.domain.spending.entity.SpendCategory;

import java.time.LocalDate;

@Getter
public class GoalResDto {
    private int amount;             // 목표 금액
    private SpendCategory category; // 카테고리
    private LocalDate startDate;    // 목표 설정 날짜

    public GoalResDto(SpendingGoal spendingGoal) {
        this.amount = spendingGoal.getAmount();
        this.category = spendingGoal.getCategory();
        this.startDate = spendingGoal.getStartDate();
    }
}
