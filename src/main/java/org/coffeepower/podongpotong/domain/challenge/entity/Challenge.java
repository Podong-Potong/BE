package org.coffeepower.podongpotong.domain.challenge.entity;

import jakarta.persistence.*;
import lombok.*;
import org.coffeepower.podongpotong.domain.challenge.dto.ManagementChallengeReqDto;
import org.coffeepower.podongpotong.domain.user.entity.User;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "challenges")
@NoArgsConstructor
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ChallengeType challengeType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ColumnDefault("0000000")
    private String selectedDaysNoSpending;

    @ColumnDefault("0000000")
    private String selectedDaysWeeklySaving;

    private LocalDate startDate;
    private Integer yearGoal;        // 연간 목표
    private Integer weekOfMonthGoal; // 요일별 목표
    private Integer startAmount;     // 시작 금액
    private Integer plusAmount;      // 증가 금액

    public Challenge(ManagementChallengeReqDto managementChallengeReqDto, User user) {
        this.user = user;
        this.challengeType = managementChallengeReqDto.challengeType();
        this.selectedDaysNoSpending = managementChallengeReqDto.selectedDaysNoSpending();
        this.selectedDaysWeeklySaving = managementChallengeReqDto.selectedDaysWeeklySaving();
        this.startDate = managementChallengeReqDto.startDate();
        this.yearGoal = managementChallengeReqDto.yearGoal();
        this.weekOfMonthGoal = managementChallengeReqDto.weekOfMonthGoal();
        this.startAmount = managementChallengeReqDto.startAmount();
        this.plusAmount = managementChallengeReqDto.plusAmount();
    }
}
