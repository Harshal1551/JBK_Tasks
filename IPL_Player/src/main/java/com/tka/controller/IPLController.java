package com.tka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.tka.entity.IPL_Player;
import com.tka.service.IPLService;

@RestController
public class IPLController {
	
	@Autowired
	private IPLService iplservice;
	
	// 1. Add Player
    @PostMapping("/add-player")
    public IPL_Player addPlayer(@RequestBody IPL_Player player) {
        return iplservice.addPlayer(player);
    }

    // 2. Fetch All Players
    @GetMapping("/all-players")
    public List<IPL_Player> allPlayers() {
        return iplservice.allPlayers();
    }

    // 3. Fetch All Batsman
    @GetMapping("/all-batsman")
    public List<IPL_Player> allBatsman() {
        return iplservice.allBatsman();
    }

    // 4. Fetch All Bowler
    @GetMapping("/all-bowler")
    public List<IPL_Player> allBowler() {
        return iplservice.allBowler();
    }

    // 5. Fetch Player By ID
    @GetMapping("/player/{id}")
    public IPL_Player playerById(@PathVariable int id) {
        return iplservice.playerById(id);
    }

    // 6. Fetch Players By Team Name
    @GetMapping("/team/{tname}")
    public List<IPL_Player> playersByTeamName(@PathVariable String tname) {
        return iplservice.playersByTeamName(tname);
    }

    // 7. Highest Score Player
    @GetMapping("/highest-score")
    public IPL_Player highestScorePlayer() {
        return iplservice.highestScorePlayer();
    }

    // 8. Highest Wicket Player
    @GetMapping("/highest-wicket")
    public IPL_Player highestWicketPlayer() {
        return iplservice.highestWicketPlayer();
    }

    // 9. Update Score By ID
    @PutMapping("/update-score/{id}/{score}")
    public IPL_Player updateScore(@PathVariable int id, @PathVariable int score) {
        return iplservice.updateScore(id, score);
    }

    // 10. Update Wickets By ID
    @PutMapping("/update-wickets/{id}/{wickets}")
    public IPL_Player updateWickets(@PathVariable int id, @PathVariable int wickets) {
        return iplservice.updateWickets(id, wickets);
    }

    // 11. Update Team Name By ID
    @PutMapping("/update-team/{id}/{tname}")
    public IPL_Player updateTeamName(@PathVariable int id, @PathVariable String tname) {
        return iplservice.updateTeamName(id, tname);
    }

    // 12. Delete Player By ID
    @DeleteMapping("/delete-player/{id}")
    public String deletePlayer(@PathVariable int id) {
        return iplservice.deletePlayer(id);
    }

    // 13. Delete Players By Team Name
    @DeleteMapping("/delete-team/{tname}")
    public String deleteByTeamName(@PathVariable String tname) {
        return iplservice.deleteByTeamName(tname);
    }

    // 14. Top 3 Highest Score Players
    @GetMapping("/top-3-score")
    public List<IPL_Player> top3ScorePlayers() {
        return iplservice.top3ScorePlayers();
    }

    // 15. All-Rounder Players
    @GetMapping("/all-rounders")
    public List<IPL_Player> allRounders() {
        return iplservice.allRounders();
    }
  
}
