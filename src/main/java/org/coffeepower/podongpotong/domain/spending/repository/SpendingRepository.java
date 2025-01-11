package org.coffeepower.podongpotong.domain.spending.repository;

import io.lettuce.core.dynamic.annotation.Param;
import org.coffeepower.podongpotong.domain.spending.entity.Spending;
import org.coffeepower.podongpotong.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpendingRepository extends JpaRepository<Spending, Long> {

    List<Spending> findByUser(User user);

    @Query("SELECT s FROM Spending s WHERE s.user = :user AND YEAR(s.date) = :year AND MONTH(s.date) = :month")
    List<Spending> findByUserBetweenYearAndMonth(@Param("user") User user, @Param("year") int year, @Param("month") int month);
}
