package org.coffeepower.podongpotong.domain.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.coffeepower.podongpotong.domain.user.dto.RegisterReqDto;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String name;
    private LocalDate registerDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    public User(RegisterReqDto registerReqDto) {
        this.email = registerReqDto.getEmail();
        this.password = registerReqDto.getPassword();
        this.name = registerReqDto.getName();
        this.gender = registerReqDto.getGender();
        this.roleType = RoleType.USER;
        this.registerDate = LocalDate.now();
    }
}
