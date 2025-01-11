package org.coffeepower.podongpotong.domain.spending.dto;

import lombok.Getter;
import org.coffeepower.podongpotong.domain.spending.entity.SpendCategory;
import org.coffeepower.podongpotong.domain.spending.entity.Spending;
import java.time.LocalDate;

@Getter
public class SpendResDto {
    private SpendCategory category; // 카테고리
    private String description;     // 소비 설명
    private int amount;             // 소비 금액
    private LocalDate date;         // 소비 날짜

    public SpendResDto(Spending spending) {
        this.category = spending.getCategory();
        this.description = spending.getDescription();
        this.amount = spending.getAmount();
        this.date = spending.getDate();
    }
}
