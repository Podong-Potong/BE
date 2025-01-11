package org.coffeepower.podongpotong.domain.spending.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.coffeepower.podongpotong.domain.user.entity.User;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "spendings")
public class Spending {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String description;     // 소비 설명
    private int amount;             // 소비 금액
    private SpendCategory category; // 카테고리
    private LocalDate date;         // 소비 날짜
}
