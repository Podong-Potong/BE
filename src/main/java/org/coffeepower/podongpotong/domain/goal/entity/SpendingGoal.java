package org.coffeepower.podongpotong.domain.goal.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.coffeepower.podongpotong.domain.goal.dto.RegisterGoalReqDto;
import org.coffeepower.podongpotong.domain.transaction.entity.TransactionCategory;
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
    private TransactionCategory category; // 카테고리
    private LocalDate startDate;    // 목표 설정 날짜

    public SpendingGoal(RegisterGoalReqDto registerGoalReqDto, User user) {
        this.user = user;
        this.amount = registerGoalReqDto.amount();
        this.category = registerGoalReqDto.category();
        this.startDate = registerGoalReqDto.startDate();
    }

    public SpendingGoal(User user, int amount, TransactionCategory category, LocalDate startDate) {
        this.user = user;
        this.amount = amount;
        this.category = category;
        this.startDate = startDate;
    }
}
