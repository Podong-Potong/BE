package org.coffeepower.podongpotong.domain.goal.dto;

import lombok.Data;
import org.coffeepower.podongpotong.domain.transaction.entity.TransactionCategory;

import java.time.LocalDate;

/**
 * @param amount    목표 금액
 * @param category  카테고리
 * @param startDate 목표 설정 날짜
 */

public record RegisterGoalReqDto(int amount, TransactionCategory category, LocalDate startDate) {
}
