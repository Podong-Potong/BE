package org.coffeepower.podongpotong.domain.spending.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.coffeepower.podongpotong.domain.spending.dto.SpendRegisterReqDto;
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

    @Enumerated(EnumType.STRING)
    private SpendCategory category; // 카테고리

    private String description;     // 소비 설명
    private int amount;             // 소비 금액
    private LocalDate date;         // 소비 날짜

    public Spending(SpendRegisterReqDto spendRegisterReqDto, User user) {
        this.user = user;
        this.description = spendRegisterReqDto.getDescription();
        this.amount = spendRegisterReqDto.getAmount();
        this.date = spendRegisterReqDto.getDate();
        this.category = spendRegisterReqDto.getCategory();
    }
}
