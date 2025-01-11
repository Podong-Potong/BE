package org.coffeepower.podongpotong.domain.spending.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.coffeepower.podongpotong.domain.spending.dto.SpendRegisterReqDto;
import org.coffeepower.podongpotong.domain.spending.service.SpendingService;
import org.coffeepower.podongpotong.global.exception.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/spending")
@Tag(name = "Spending API", description = "지출 관련 API")
public class SpendingController {

    private final SpendingService spendingService;

    @PostMapping("/")
    public Result<?> saveSpending(SpendRegisterReqDto spendRegisterReqDto) { return spendingService.saveSpending( 1L, spendRegisterReqDto); }

    @GetMapping("/")
    public Result<?> getSpending() { return spendingService.getSpending(1L); }
}
