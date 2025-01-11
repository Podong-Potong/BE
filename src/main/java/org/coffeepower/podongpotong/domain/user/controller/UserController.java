package org.coffeepower.podongpotong.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.coffeepower.podongpotong.domain.user.dto.RegisterReqDto;
import org.coffeepower.podongpotong.domain.user.service.UserService;
import org.coffeepower.podongpotong.global.exception.ResponseResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/DuplicateEmailCheck")
    public String DuplicateEmailCheck(@RequestParam("email") String email) { return userService.duplicateEmailCheck(email); }

    @PutMapping("/")
    public String registerUser(@RequestBody RegisterReqDto registerReqDto) { return userService.registerUser(registerReqDto); }
}
