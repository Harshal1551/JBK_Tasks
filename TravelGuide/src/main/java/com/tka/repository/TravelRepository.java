package com.tka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tka.entity.TravelGuide;


public interface TravelRepository extends JpaRepository<TravelGuide, Integer> {

}
