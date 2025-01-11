package org.coffeepower.podongpotong.domain.spending.repository;

import org.coffeepower.podongpotong.domain.spending.entity.Spending;
import org.coffeepower.podongpotong.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpendingRepository extends JpaRepository<Spending, Long> {

    List<Spending> findByUser(User user);
}
