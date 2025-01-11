package org.coffeepower.podongpotong.domain.user.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import org.coffeepower.podongpotong.domain.user.entity.Gender;
import org.coffeepower.podongpotong.domain.user.entity.RoleType;

import java.time.LocalDate;

@Data
public class RegisterReqDto {
    private String email;
    private String password;
    private String name;
    private Gender gender;
}
