package org.coffeepower.podongpotong.domain.challenge.dto;

import lombok.Data;
import org.coffeepower.podongpotong.domain.challenge.entity.ChallengeType;

import java.time.LocalDate;

@Data
public class ManagementChallengeReqDto {
    private ChallengeType challengeType;
    private String selectedDays;
    private LocalDate startDate;
}
