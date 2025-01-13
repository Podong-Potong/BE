package org.coffeepower.podongpotong.domain.transaction.dto;

import lombok.Data;
import org.coffeepower.podongpotong.domain.transaction.entity.TransactionCategory;
import org.coffeepower.podongpotong.domain.transaction.entity.TransactionType;

import java.time.LocalDate;

/**
 * @param description 소비 설명
 * @param amount      소비 금액
 * @param category    카테고리
 */

public record SpendRegisterReqDto(String description, int amount, TransactionCategory category, LocalDate date,
                                  TransactionType type) {
}
