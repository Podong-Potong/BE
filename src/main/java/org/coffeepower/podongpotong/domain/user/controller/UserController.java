package org.coffeepower.podongpotong.domain.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.coffeepower.podongpotong.domain.user.dto.RegisterReqDto;
import org.coffeepower.podongpotong.domain.user.service.UserService;
import org.coffeepower.podongpotong.global.exception.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
@Tag(name = "User API", description = "유저 인증 관련 API")
public class UserController {

    private final UserService userService;

    @GetMapping("/DuplicateEmailCheck")
    @Operation(summary = "이메일 중복 확인", description = "회원가입 시, 이메일 중복 확인 API")
    public Result<?> DuplicateEmailCheck(@RequestParam("email") String email) { return userService.duplicateEmailCheck(email); }

    @PostMapping("/")
    @Operation(summary = "회원가입", description = "회원가입 API")
    public Result<?> registerUser(@RequestBody RegisterReqDto registerReqDto) { return userService.registerUser(registerReqDto); }
}
