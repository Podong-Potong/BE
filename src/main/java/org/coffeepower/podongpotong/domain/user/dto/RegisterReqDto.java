package org.coffeepower.podongpotong.domain.user.dto;

import lombok.Data;
import org.coffeepower.podongpotong.domain.user.entity.Gender;

public record RegisterReqDto(String email, String password, String name, Gender gender) {
}
