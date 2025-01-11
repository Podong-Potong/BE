package org.coffeepower.podongpotong.domain.goal.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.coffeepower.podongpotong.domain.goal.dto.RegisterGoalReqDto;
import org.coffeepower.podongpotong.domain.goal.service.GoalService;
import org.coffeepower.podongpotong.global.exception.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/goal")
@Tag(name = "Gole API", description = "카테고리별 지출 목표 API")
public class GoalController {

    private final GoalService goalService;

    @PostMapping("")
    @Operation(summary = "목표 등록", description = "카테고리별 목표 등록 API")
    public Result<?> registerGoal(@RequestBody RegisterGoalReqDto registerGoalReqDto) { return goalService.saveGoal(1L, registerGoalReqDto); }

    @PostMapping("/getlist")
    @Operation(summary = "목표 목록", description = "유저의 목표들 출력 API")
    public Result<?> getGoalList() { return goalService.getGoalList(1L); }
}
