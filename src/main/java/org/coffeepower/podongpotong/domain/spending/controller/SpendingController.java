package org.coffeepower.podongpotong.domain.spending.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.coffeepower.podongpotong.domain.spending.dto.MonthSpendReq;
import org.coffeepower.podongpotong.domain.spending.dto.SpendRegisterReqDto;
import org.coffeepower.podongpotong.domain.spending.service.SpendingService;
import org.coffeepower.podongpotong.global.exception.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/spending")
@Tag(name = "Spending API", description = "지출 관련 API")
public class SpendingController {

    private final SpendingService spendingService;

    @PostMapping("")
    @Operation(summary = "지출 등록", description = "지출 등록 API")
    public Result<?> saveSpending(@RequestBody SpendRegisterReqDto spendRegisterReqDto) { return spendingService.saveSpending( 1L, spendRegisterReqDto); }

    @PostMapping("/getlist")
    @Operation(summary = "지출 목록", description = "년도, 월을 이용하여 유저의 지출 목록 출력 API")
    public Result<?> getSpending(@RequestBody MonthSpendReq monthSpendReq) { return spendingService.getSpending(1L, monthSpendReq); }
}
