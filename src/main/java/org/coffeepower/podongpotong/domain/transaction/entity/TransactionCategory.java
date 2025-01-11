package org.coffeepower.podongpotong.domain.transaction.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TransactionCategory {
    EDUCATION("교육 및 자기계발"),
    CAFE("커피 및 디저트"),
    CULTURE("뮤지컬 및 영화"),
    BEAUTY("뷰티"),
    ELECTRONICS("전자기기 및 IT"),
    TRAVEL("여행 및 레저"),
    WELLNESS("건강 및 웰니스"),
    TRANSPORTATION("교통 및 이동"),
    CLOTHING("옷 쇼핑"),
    FOOD("배달 음식"),
    FUND("저금 및 저축"),

    SALARY("급여"),
    BONUS("상여금"),
    PART_TIME("아르바이트"),
    USED_TRADE("중고거래"),
    ALLOWANCE("용돈"),
    FINANCIAL_INCOME("금융수입"),
    INSURANCE("보험금"),
    SCHOLARSHIP("장학금"),
    SNS("SNS"),
    APP_TECH("앱테크"),

    ETC("기타");

    private final String description;
}
