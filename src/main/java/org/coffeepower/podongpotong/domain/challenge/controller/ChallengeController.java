package org.coffeepower.podongpotong.domain.challenge.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.coffeepower.podongpotong.domain.challenge.dto.ManagementChallengeReqDto;
import org.coffeepower.podongpotong.domain.challenge.service.ChallengeService;
import org.coffeepower.podongpotong.global.exception.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/challenge")
@Tag(name = "Challenge API", description = "챌린지 관련 API")
public class ChallengeController {

    private final ChallengeService challengeService;

    @PutMapping("")
    @Operation(summary = "챌린지 관리", description = "챌린지 등록 & 등록되어 있으면 챌린지 요일 수정 API")
    public Result<?> managementChallenge(@RequestBody ManagementChallengeReqDto managementChallengeReqDto) {
        return challengeService.managementChallenge(1L, managementChallengeReqDto);
    }

    @PostMapping("")
    @Operation(summary = "챌린지 출력", description = "유저의 챌린지 목록을 출력하는 API")
    public Result<?> getChallengeList() { return challengeService.getChallengeList(1L); }

//    @PostMapping("/NoSpending")
//    @Operation(summary = "무지출 챌린지", description = "무지출 챌린지 달성률을 출력하는 API")
//    public Result<?> getNoSpendingChallenge() { return challengeService.getNoSpendingChallenge(1L); }
//
//    @PostMapping("/YearlySaving")
//    @Operation(summary = "1년 기준 NNN 모으기 챌린지", description = "1년 기준 NNN 모으기 챌린지 달성률을 출력하는 API")
//    public Result<?> getYearlySavingChallenge() { return challengeService.getYearGoalChallenge(1L); }
//
//    @PostMapping("/WeeklySaving")
//    @Operation(summary = "요일 소비제한", description = "요일 소비제한 챌린지 달성률을 출력하는 API")
//    public Result<?> getWeeklySavingChallenge() { return challengeService.getWeeklySavingChallenge(1L); }
//
//    @PostMapping("/SavingGame")
//    @Operation(summary = "저금통 게임", description = "저금통 게임 챌린지 달성률을 출력하는 API")
//    public Result<?> getSavingGameChallenge() { return challengeService.getSavingGameChallenge(1L); }
}
