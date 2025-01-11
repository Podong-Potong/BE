package org.coffeepower.podongpotong.domain.goal.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.coffeepower.podongpotong.domain.spending.entity.SpendCategory;
import org.coffeepower.podongpotong.domain.user.entity.User;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "goals")
public class SpendingGoal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private int amount;             // 목표 금액
    private SpendCategory category; // 카테고리
    private LocalDate startDate;         // 목표 설정 날짜
}
