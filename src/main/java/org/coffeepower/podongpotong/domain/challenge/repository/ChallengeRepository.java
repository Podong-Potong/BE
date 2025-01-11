package org.coffeepower.podongpotong.domain.challenge.repository;

import io.lettuce.core.dynamic.annotation.Param;
import org.coffeepower.podongpotong.domain.challenge.entity.Challenge;
import org.coffeepower.podongpotong.domain.challenge.entity.ChallengeType;
import org.coffeepower.podongpotong.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Long> {
    @Query("SELECT c FROM Challenge c WHERE c.user = :user AND c.challengeType = :challengeType")
    Optional<Challenge> findByUserAndChallengeType(@Param("user") User user, @Param("challengeType") ChallengeType challengeType);

    Optional<List<Challenge>> findByUser(User user);

    @Query("SELECT EXISTS (SELECT true FROM Challenge c where c.user = :user AND c.challengeType = :challengeType)")
    Boolean findByUserAndChallengeTypeExists(@Param("user") User user, @Param("challengeType") ChallengeType challengeType);
}
