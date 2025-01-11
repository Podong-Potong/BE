package org.coffeepower.podongpotong.global.controller;

import org.coffeepower.podongpotong.global.exception.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.coffeepower.podongpotong.global.exception.ErrorCode.TEST_STATUS;

@RestController
public class TestController {

    @GetMapping("/health")
    public Result<?> health() {
        return new Result<>(TEST_STATUS);
    }
}
