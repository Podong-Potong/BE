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
    private String selectedDays;

    private LocalDate startDate;

    public Challenge(ManagementChallengeReqDto managementChallengeReqDto, User user) {
        this.user = user;
        this.challengeType = managementChallengeReqDto.getChallengeType();
        this.selectedDays = managementChallengeReqDto.getSelectedDays();
        this.startDate = managementChallengeReqDto.getStartDate();
    }
}
