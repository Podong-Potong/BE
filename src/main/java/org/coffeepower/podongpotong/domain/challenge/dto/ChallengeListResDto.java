package org.coffeepower.podongpotong.domain.challenge.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class ChallengeListResDto {
    public ChallengeListResDto(String noSpendRate, String weekGoalRate, String monthGoalRate, String yearGoalRate) {
        this.noSpendRate = noSpendRate;
        this.weekGoalRate = weekGoalRate;
        this.monthGoalRate = monthGoalRate;
        this.yearGoalRate = yearGoalRate;
    }

    private String noSpendRate;
    private String weekGoalRate;
    private String monthGoalRate;
    private String yearGoalRate;
}
