package com.extampz.challengeapp;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ChallengeRepository extends JpaRepository<Challenge, Integer> {

    Optional<Challenge> findByChallengeMonthIgnoreCase(String challengeMonth);

}
