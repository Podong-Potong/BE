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

    private ChallengeType challengeType;
    private String selectedDays;
    private LocalDate startDate;

    public ChallengeResDto(Challenge challenge) {
        this.challengeType = challenge.getChallengeType();
        this.selectedDays = challenge.getSelectedDays();
        this.startDate = challenge.getStartDate();
    }
}
