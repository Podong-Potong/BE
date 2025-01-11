package org.coffeepower.podongpotong.domain.challenge.dto;

import lombok.Data;
import org.coffeepower.podongpotong.domain.challenge.entity.ChallengeType;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Data
public class ManagementChallengeReqDto {
    private ChallengeType challengeType;
    private String selectedDaysNoSpending;
    private String selectedDaysWeeklySaving;
    private LocalDate startDate;
    private Integer yearGoal;        // 연간 목표
    private Integer weekOfMonthGoal; // 요일별 목표
    private Integer startAmount;     // 시작 금액
    private Integer plusAmount;       // 증가 금액
}
