package org.coffeepower.podongpotong.domain.goal.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.coffeepower.podongpotong.domain.goal.dto.RegisterGoalListReqDto;
import org.coffeepower.podongpotong.domain.goal.dto.RegisterGoalReqDto;
import org.coffeepower.podongpotong.domain.goal.service.GoalService;
import org.coffeepower.podongpotong.global.exception.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/goal")
@Tag(name = "Goal API", description = "카테고리별 지출 목표 API")
public class GoalController {

    private final GoalService goalService;

    @PostMapping("")
    @Operation(summary = "목표 등록", description = "카테고리별 목표 등록 API")
    public Result<?> registerGoal(@RequestBody Integer goal) { return goalService.saveGoalList(1L, goal); }

    @GetMapping("")
    @Operation(summary = "목표 목록", description = "유저의 목표들 출력 API")
    public Result<?> getGoalList() { return goalService.getGoalList(1L); }

    @PostMapping("/list")
    @Operation(summary = "목표 전체 등록", description = "목표 전체 등록 API")
    public Result<?> registerGoalList(@RequestBody RegisterGoalListReqDto registerGoalReqDto) { return goalService.saveGoalList(1L, registerGoalReqDto); }
}
