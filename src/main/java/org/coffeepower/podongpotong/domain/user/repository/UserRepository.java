package org.coffeepower.podongpotong.domain.user.repository;

import org.coffeepower.podongpotong.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.OptionalInt;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT EXISTS (SELECT true FROM User u where u.email = :email)")
    Boolean findByEmailExists(@Param("email") String email);

    Optional<User> findById(Long id);

}
