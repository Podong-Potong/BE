package org.coffeepower.podongpotong.domain.challenge.dto;

import lombok.Data;
import org.coffeepower.podongpotong.domain.challenge.entity.ChallengeType;

import java.time.LocalDate;

@Data
public class ManagementChallengeReqDto {
    private ChallengeType challengeType;
    private String selectedDays;
    private LocalDate startDate;
    private Integer yearGoal;        // 연간 목표
    private Integer weekOfMonthGoal; // 요일별 목표
}
