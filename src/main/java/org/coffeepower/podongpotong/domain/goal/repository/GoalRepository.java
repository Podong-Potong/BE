package org.coffeepower.podongpotong.domain.goal.repository;

import io.lettuce.core.dynamic.annotation.Param;
import org.coffeepower.podongpotong.domain.goal.entity.SpendingGoal;
import org.coffeepower.podongpotong.domain.transaction.entity.TransactionCategory;
import org.coffeepower.podongpotong.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface GoalRepository extends JpaRepository<SpendingGoal,Long> {
    Optional<List<SpendingGoal>> findByUser(User user);

    @Query("SELECT s FROM SpendingGoal s WHERE s.user = :user AND s.category = :category")
    Optional<SpendingGoal> findByCategoryAndUser(@Param("user") User user, @Param("category") TransactionCategory category);
}
