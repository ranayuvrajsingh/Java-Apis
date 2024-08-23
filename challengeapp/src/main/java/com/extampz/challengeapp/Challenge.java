package com.extampz.challengeapp;

public class Challenge {
    private int challengeId;
    private String challengeName;
    private String challengeDescription;
    private String challengeMonth;

    // Default constructor
    public Challenge() {}

    // Parameterized constructor
    public Challenge(int challengeId, String challengeName, String challengeDescription, String challengeMonth) {
        this.challengeId = challengeId;
        this.challengeName = challengeName;
        this.challengeDescription = challengeDescription;
        this.challengeMonth = challengeMonth;
    }

    // Getters and Setters
    public int getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(int nextId) {
        this.challengeId = nextId;
    }

    public String getChallengeName() {
        return challengeName;
    }

    public void setChallengeName(String challengeName) {
        this.challengeName = challengeName;
    }

    public String getChallengeDescription() {
        return challengeDescription;
    }

    public void setChallengeDescription(String challengeDescription) {
        this.challengeDescription = challengeDescription;
    }

    public String getChallengeMonth() {
        return challengeMonth;
    }

    public void setChallengeMonth(String challengeMonth) {
        this.challengeMonth = challengeMonth;
    }

    // Optional: Basic validation (example)
    public boolean isValid() {
        return challengeName != null && !challengeName.trim().isEmpty();
    }
}
