package com.extampz.challengeapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/challenges")
public class ChallengeController {

    private final ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping
    public ResponseEntity<List<Challenge>> getAllChallenges() {
        List<Challenge> challenges = challengeService.getAllChallenges();
        return new ResponseEntity<>(challenges, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createChallenge(@RequestBody Challenge challenge) {
        boolean isChallengeAdded = challengeService.createChallenge(challenge);
        if (isChallengeAdded) {
            return new ResponseEntity<>("Challenge Added Successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Request Failed", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/by-month")
    public ResponseEntity<Challenge> getChallenge(@RequestParam(value = "month") String month) {
        Challenge challenge = challengeService.getChallenge(month);
        if (challenge != null) {
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable int id, @RequestBody Challenge updateChallenge) {
        boolean isChallengeUpdated = challengeService.updateChallenge(id, updateChallenge);
        if (isChallengeUpdated) {
            return new ResponseEntity<>("Challenge Updated Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Request Failed", HttpStatus.NOT_FOUND);
        }
    }
 
    @DeleteMapping("/challenges/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable int id) {
        boolean isChallengeDeleted = challengeService.deleteChallenge(id);
        if (isChallengeDeleted) {
            return new ResponseEntity<>("Challenge Deleted Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Request Failed", HttpStatus.NOT_FOUND);
        }
    }
    
}
