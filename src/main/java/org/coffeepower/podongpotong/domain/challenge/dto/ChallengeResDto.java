package org.coffeepower.podongpotong.domain.challenge.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import org.coffeepower.podongpotong.domain.challenge.entity.Challenge;
import org.coffeepower.podongpotong.domain.challenge.entity.ChallengeType;
import org.coffeepower.podongpotong.domain.user.entity.User;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Getter
public class ChallengeResDto {

    private final ChallengeType challengeType;
    private final String selectedDaysNoSpending;
    private final String selectedDaysWeeklySaving;
    private final LocalDate startDate;
    private final Integer yearGoal;        // 연간 목표
    private final Integer weekOfMonthGoal; // 요일별 목표
    private final Integer startAmount;     // 시작 금액
    private final Integer plusAmount;       // 증가 금액


    public ChallengeResDto(Challenge challenge) {
        this.challengeType = challenge.getChallengeType();
        this.selectedDaysNoSpending = challenge.getSelectedDaysNoSpending();
        this.selectedDaysWeeklySaving = challenge.getSelectedDaysWeeklySaving();
        this.startDate = challenge.getStartDate();
        this.yearGoal = challenge.getYearGoal();
        this.weekOfMonthGoal = challenge.getWeekOfMonthGoal();
        this.startAmount = challenge.getStartAmount();
        this.plusAmount = challenge.getPlusAmount();
    }
}
