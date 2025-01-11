package org.coffeepower.podongpotong.domain.spending.dto;

import lombok.Data;
import org.coffeepower.podongpotong.domain.spending.entity.SpendCategory;

import java.time.LocalDate;

@Data
public class SpendRegisterReqDto {
    private String description;     // 소비 설명
    private int amount;             // 소비 금액
    private SpendCategory category; // 카테고리
    private LocalDate date;
}
