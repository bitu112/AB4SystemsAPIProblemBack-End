package com.gpch.login.repository;

import com.gpch.login.model.Spot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("spotRepository")
public interface SpotRepository extends JpaRepository<Spot,Long> {
    Spot findSpotByName(String name);
    Spot findSpotByCountry(String country);
    Spot findSpotById(Long id);
}
