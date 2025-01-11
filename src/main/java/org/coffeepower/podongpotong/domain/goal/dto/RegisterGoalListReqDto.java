package org.coffeepower.podongpotong.domain.goal.dto;

import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class RegisterGoalListReqDto {
    List<Integer> amountList;
    LocalDate startDate;
}
