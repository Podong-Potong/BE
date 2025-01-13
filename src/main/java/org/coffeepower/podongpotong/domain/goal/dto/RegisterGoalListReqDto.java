package org.coffeepower.podongpotong.domain.goal.dto;

import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

public record RegisterGoalListReqDto(
        List<Integer> amountList,
        LocalDate startDate
) {}
