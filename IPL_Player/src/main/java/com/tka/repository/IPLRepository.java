package com.tka.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tka.entity.IPL_Player;

@Repository
public interface IPLRepository extends JpaRepository<IPL_Player, Integer> {
	
	// 3 & 4
	List<IPL_Player> findByCategory(String category);

	// 6
	List<IPL_Player> findByTname(String tname);
	
	// 7
	IPL_Player findTopByOrderByScoreDesc();
	
	// 8
	IPL_Player findTopByOrderByWicketsDesc();

	// 13
	void deleteByTname(String tname);
	
	// 14
	List<IPL_Player> findTop3ByOrderByScoreDesc();

	// 15
	List<IPL_Player> findByScoreGreaterThanAndWicketsGreaterThan(int score, int wickets);

	
	

	
	
}
