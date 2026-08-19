package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tka.entity.IPL_Player;
import com.tka.repository.IPLRepository;

@Service
public class IPLService {

	@Autowired
	private IPLRepository iplrepo;

	// 1. Add Player
	public IPL_Player addPlayer(IPL_Player player) {
		return iplrepo.save(player);
	}

	// 2. Fetch All Players
	public List<IPL_Player> allPlayers() {
		return iplrepo.findAll();
	}

	// 3. Fetch All Batsman
	public List<IPL_Player> allBatsman() {
		return iplrepo.findByCategory("Batsman");
	}

	// 4. Fetch All Bowler
	public List<IPL_Player> allBowler() {
		return iplrepo.findByCategory("Bowler");
	}

	// 5. Fetch Player By ID
	public IPL_Player playerById(int id) {
		return iplrepo.findById(id).orElse(null);
	}

	// 6. Fetch Players By Team Name
	public List<IPL_Player> playersByTeamName(String tname) {
		return iplrepo.findByTname(tname);
	}

	// 7. Highest Score Player
	public IPL_Player highestScorePlayer() {
		return iplrepo.findTopByOrderByScoreDesc();
	}

	// 8. Highest Wicket Player
	public IPL_Player highestWicketPlayer() {
		return iplrepo.findTopByOrderByWicketsDesc();
	}

	// 9. Update Score
	public IPL_Player updateScore(int id, int score) {
	    IPL_Player player = iplrepo.findById(id).get();
	    player.setScore(score);
	    return iplrepo.save(player);
	}
 
	// 10. Update Wickets
	public IPL_Player updateWickets(int id, int wickets) {
	    IPL_Player player = iplrepo.findById(id).get();
	    player.setWickets(wickets);
	    return iplrepo.save(player);
	}

	// 11. Update Team Name
	public IPL_Player updateTeamName(int id, String tname) {
	    IPL_Player player = iplrepo.findById(id).get();
	    player.setTname(tname);
	    return iplrepo.save(player);
	}

	// 12. Delete Player By ID
	public String deletePlayer(int id) {
		iplrepo.deleteById(id);
		return "Player deleted successfully";
	}

	// 13. Delete Players By Team Name
	@Transactional
	public String deleteByTeamName(String tname) {
		iplrepo.deleteByTname(tname);
		return "Players deleted successfully";
	}

	// 14. Top 3 Highest Score Players
	public List<IPL_Player> top3ScorePlayers() {
		return iplrepo.findTop3ByOrderByScoreDesc();
	}

	// 15. All-Rounders
	public List<IPL_Player> allRounders() {
		return iplrepo.findByScoreGreaterThanAndWicketsGreaterThan(500, 20);
	}

}
