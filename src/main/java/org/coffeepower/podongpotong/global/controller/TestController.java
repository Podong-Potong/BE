package org.coffeepower.podongpotong.global.controller;

import org.coffeepower.podongpotong.global.exception.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.coffeepower.podongpotong.global.exception.ErrorCode.TEST_STATUS;

@RestController
public class TestController {

    @GetMapping("/health")
    public String health() {
        return new ResponseResult<>(TEST_STATUS).toReturn();
    }
}
