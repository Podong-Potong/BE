package org.coffeepower.podongpotong.domain.user.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RoleType {
    ADMIN("관리자", "ADMIN"),
    USER("일반", "USER");

    private final String text;
    private final String role;
}
