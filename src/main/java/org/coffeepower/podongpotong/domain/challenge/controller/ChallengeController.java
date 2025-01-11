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
    @Operation(summary = "챌린지 출력", description = "유저의 챌린지 목록을 출력")
    public Result<?> getChallengeList() { return challengeService.getChallengeList(1L); }
}
