package org.coffeepower.podongpotong.domain.challenge.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ChallengeType {
    NO_SPENDING("무지출 챌린지", "최대한 무지출하는 챌린지"),
    YEARLY_SAVING("1년 기준 NNN 모으기", "1년 동안 목표치만큼 돈 모으기"),
    SAVING_GAME("숫자 게임 저축", "하루에 100원 200원 300원.. 등등"),
    WEEKLY_SAVING("요일 소비제한", "월요일: 20000 제한, 화요일: 30000원 제한.. 등등");

    private final String name;
    private final String description;
}
