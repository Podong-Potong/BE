package org.coffeepower.podongpotong.domain.goal.repository;

import org.coffeepower.podongpotong.domain.goal.entity.SpendingGoal;
import org.coffeepower.podongpotong.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface GoalRepository extends JpaRepository<SpendingGoal,Long> {
    Optional<List<SpendingGoal>> findByUser(User user);
}
