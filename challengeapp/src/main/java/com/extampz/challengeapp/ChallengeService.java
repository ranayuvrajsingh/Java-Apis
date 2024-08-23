package com.extampz.challengeapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ChallengeService {
  private List<Challenge> challenges = new ArrayList<>();
  private int nextId = 1;

  public ChallengeService() {

  }

  public List<Challenge> getAllChallenges() {
    return challenges;
  }

  public boolean createChallenge(Challenge challenge) {
    challenge.setChallengeId(nextId++);
    {
      challenges.add(challenge);
      return true;
    }
  }

  public Challenge getChallenge(String month) {
    for (Challenge challenge : challenges) {
      if (challenge.getChallengeMonth().equalsIgnoreCase(month)) {
        return challenge;

      }
    }
    return null;

  }

  public boolean updateChallenge(int id, Challenge updateChallenge) {
    return challenges.stream()
        .filter(challenge -> challenge.getChallengeId() == id)
        .findFirst()
        .map(challenge -> {
          challenge.setChallengeName(updateChallenge.getChallengeName());
          challenge.setChallengeDescription(updateChallenge.getChallengeDescription());
          challenge.setChallengeMonth(updateChallenge.getChallengeMonth());
          return true;
        })
        .orElse(false);
  }

  public  boolean deleteChallenge(int id) {
    return challenges.removeIf(challenge->challenge.getChallengeId() == id);
  }

}
