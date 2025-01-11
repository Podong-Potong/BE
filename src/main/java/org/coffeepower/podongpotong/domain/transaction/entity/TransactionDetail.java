package org.coffeepower.podongpotong.domain.transaction.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.coffeepower.podongpotong.domain.transaction.dto.SpendRegisterReqDto;
import org.coffeepower.podongpotong.domain.user.entity.User;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "transaction_detail")
@NoArgsConstructor
public class TransactionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private TransactionCategory category; // 카테고리

    @Enumerated(EnumType.STRING)
    private TransactionType type;         // 수입 / 지출 / 이체

    private String description;     // 소비 설명
    private int amount;             // 소비 금액
    private LocalDate date;         // 소비 날짜

    public TransactionDetail(SpendRegisterReqDto spendRegisterReqDto, User user) {
        this.user = user;
        this.description = spendRegisterReqDto.getDescription();
        this.amount = spendRegisterReqDto.getAmount();
        this.date = spendRegisterReqDto.getDate();
        this.category = spendRegisterReqDto.getCategory();
        this.type = spendRegisterReqDto.getType();
    }
}
