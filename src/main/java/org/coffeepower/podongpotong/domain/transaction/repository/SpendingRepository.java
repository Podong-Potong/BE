package org.coffeepower.podongpotong.domain.transaction.repository;

import io.lettuce.core.dynamic.annotation.Param;
import org.coffeepower.podongpotong.domain.transaction.entity.TransactionDetail;
import org.coffeepower.podongpotong.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SpendingRepository extends JpaRepository<TransactionDetail, Long> {

    @Query("SELECT s FROM TransactionDetail s WHERE s.user = :user AND YEAR(s.date) = :year AND MONTH(s.date) = :month")
    List<TransactionDetail> findByUserBetweenYearAndMonth(@Param("user") User user, @Param("year") int year, @Param("month") int month);

    @Query("SELECT COUNT(DISTINCT t.date) FROM TransactionDetail t WHERE t.type = 'EXPENSE' AND t.date IN :list")
    Integer findExpenseCnt(@Param("list") List<LocalDate> list, @Param("user") User user);

    @Query("SELECT SUM(t.amount) FROM TransactionDetail t WHERE t.category = 'FUND' AND t.user = :user AND t.date BETWEEN :startDate AND :endDate")
    Float sumFundAmountForCurrentYear(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate, @Param("user") User user);

    @Query("SELECT COUNT(DISTINCT t.date) " +
            "FROM TransactionDetail t " +
            "WHERE t.type = 'EXPENSE' AND t.date IN :list AND t.user = :user " +
            "GROUP BY t.date " +
            "HAVING SUM(t.amount) < :threshold")
    Integer countDatesWithLowExpenses(@Param("threshold") Integer threshold, @Param("list") List<LocalDate> list, @Param("user") User user);

    @Query("SELECT t FROM TransactionDetail t WHERE t.user = :user AND t.date = :date")
    List<TransactionDetail> findTransactionsForOneDay(@Param("date") LocalDate date, @Param("user") User user);
}
