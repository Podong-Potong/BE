package org.coffeepower.podongpotong.domain.challenge.dto;

import lombok.Data;
import org.coffeepower.podongpotong.domain.challenge.entity.ChallengeType;

import java.time.LocalDate;

/**
 * @param yearGoal        연간 목표
 * @param weekOfMonthGoal 요일별 목표
 * @param startAmount     시작 금액
 * @param plusAmount      증가 금액
 */

public record ManagementChallengeReqDto(ChallengeType challengeType, String selectedDaysNoSpending,
                                        String selectedDaysWeeklySaving, LocalDate startDate, Integer yearGoal,
                                        Integer weekOfMonthGoal, Integer startAmount, Integer plusAmount) {
}
