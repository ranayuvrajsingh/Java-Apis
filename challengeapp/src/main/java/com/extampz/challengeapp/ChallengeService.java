package com.extampz.challengeapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ChallengeService {

    @Autowired
    private ChallengeRepository challengeRepository;
    private int nextId = 1;

    public List<Challenge> getAllChallenges() {
        return challengeRepository.findAll();
    }

    public boolean createChallenge(Challenge challenge) {
        challenge.setChallengeId(nextId++);
        challengeRepository.save(challenge);
        return true;
    }

    public Challenge getChallenge(String month) {
        Optional<Challenge> challenge = challengeRepository.findByChallengeMonthIgnoreCase(month);
        return challenge.orElse(null);
    }

    public boolean updateChallenge(int id, Challenge updateChallenge) {
        Optional<Challenge> existingChallenge = challengeRepository.findById(id);
        if (existingChallenge.isPresent()) {
            Challenge challengeToUpdate = existingChallenge.get();
            challengeToUpdate.setChallengeName(updateChallenge.getChallengeName());
            challengeToUpdate.setChallengeDescription(updateChallenge.getChallengeDescription());
            challengeToUpdate.setChallengeMonth(updateChallenge.getChallengeMonth());
            challengeRepository.save(challengeToUpdate);
            return true;
        }
        return false;
    }

    public boolean deleteChallenge(int id) {
        Optional<Challenge> challenge = challengeRepository.findById(id);
        if (challenge.isPresent()) {
            challengeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
