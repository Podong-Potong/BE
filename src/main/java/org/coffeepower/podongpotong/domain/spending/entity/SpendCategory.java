package org.coffeepower.podongpotong.domain.spending.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SpendCategory {
    FOOD("식비"),
    CAFE("카페/간식"),
    ALCOHOL("술/유흥"),
    LIVING("생활"),
    SHOPPING("쇼핑"),
    BEAUTY("뷰티/미용"),
    TRANSPORTATION("교통"),
    CAR("자동차"),
    HOUSING("주거/통신"),
    HEALTH("의료/건강"),
    BANK("금융"),
    CULTURE("문화/여가"),
    TRAVEL("여행/숙박"),
    EDUCATION("교육/학습"),
    CHILDCARE("자녀/육아"),
    PET("반려동물"),
    GIFTS("경조/선물"),
    SAVINGS("모임통장 및 청약"),
    FRIEND("친구"),
    ETC("기타");

    private final String description;
}
