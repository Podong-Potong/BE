package org.coffeepower.podongpotong.domain.goal.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.coffeepower.podongpotong.domain.goal.dto.GoalResDto;
import org.coffeepower.podongpotong.domain.goal.dto.RegisterGoalReqDto;
import org.coffeepower.podongpotong.domain.goal.entity.SpendingGoal;
import org.coffeepower.podongpotong.domain.goal.repository.GoalRepository;
import org.coffeepower.podongpotong.domain.user.entity.User;
import org.coffeepower.podongpotong.domain.user.exception.NoUserDataException;
import org.coffeepower.podongpotong.domain.user.repository.UserRepository;
import org.coffeepower.podongpotong.global.exception.ErrorCode;
import org.coffeepower.podongpotong.global.exception.Result;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GoalService {
    private final GoalRepository goalRepository;
    private final UserRepository userRepository;

    // 목표 등록
    public Result<?> saveGoal(Long userId, RegisterGoalReqDto registerGoalReqDto) {
        User user = null;

        try {
            user = userRepository.findById(userId).orElseThrow(NoUserDataException::new);
        } catch (NoUserDataException e) {
            return new Result<>(ErrorCode.FAIL_TO_FIND_USER);
        }

        SpendingGoal spendingGoal = new SpendingGoal(registerGoalReqDto, user);
        goalRepository.save(spendingGoal);

        return new Result<>(ErrorCode.SUCCESS);
    }

    // 목표 출력
    public Result<?> getGoalList(Long userId) {
        User user = null;

        try {
            user = userRepository.findById(userId).orElseThrow(NoUserDataException::new);
        } catch (NoUserDataException e) {
            return new Result<>(ErrorCode.FAIL_TO_FIND_USER);
        }

        List<SpendingGoal> spendingGoalList = goalRepository.findByUser(user).orElse(null);
        List<GoalResDto> goalResDtoList = new ArrayList<>();

        if (spendingGoalList != null) {
            for (SpendingGoal spendingGoal : spendingGoalList) {
                goalResDtoList.add(new GoalResDto(spendingGoal));
            }
        }

        return new Result<>(ErrorCode.SUCCESS, goalResDtoList);
    }
}
