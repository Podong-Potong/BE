package org.coffeepower.podongpotong.domain.goal.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.coffeepower.podongpotong.domain.goal.dto.RegisterGoalReqDto;
import org.coffeepower.podongpotong.domain.spending.entity.SpendCategory;
import org.coffeepower.podongpotong.domain.user.entity.User;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "goals")
@RequiredArgsConstructor
public class SpendingGoal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private int amount;             // 목표 금액
    private SpendCategory category; // 카테고리
    private LocalDate startDate;    // 목표 설정 날짜

    public SpendingGoal(RegisterGoalReqDto registerGoalReqDto, User user) {
        this.user = user;
        this.amount = registerGoalReqDto.getAmount();
        this.category = registerGoalReqDto.getCategory();
        this.startDate = registerGoalReqDto.getStartDate();
    }
}
