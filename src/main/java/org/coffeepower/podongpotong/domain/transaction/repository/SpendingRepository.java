package org.coffeepower.podongpotong.domain.transaction.repository;

import io.lettuce.core.dynamic.annotation.Param;
import org.coffeepower.podongpotong.domain.transaction.entity.TransactionDetail;
import org.coffeepower.podongpotong.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpendingRepository extends JpaRepository<TransactionDetail, Long> {

    List<TransactionDetail> findByUser(User user);

    @Query("SELECT s FROM TransactionDetail s WHERE s.user = :user AND YEAR(s.date) = :year AND MONTH(s.date) = :month")
    List<TransactionDetail> findByUserBetweenYearAndMonth(@Param("user") User user, @Param("year") int year, @Param("month") int month);
}
