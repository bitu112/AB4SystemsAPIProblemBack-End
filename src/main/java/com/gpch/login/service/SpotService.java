package com.gpch.login.service;

import com.gpch.login.model.Spot;
import com.gpch.login.repository.SpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SpotService")
public class SpotService {

    private SpotRepository spotRepository;

    @Autowired
    public SpotService( SpotRepository spotRepository){
        this.spotRepository = spotRepository;
    }

    public Spot findSpotByName(String name) {
        return spotRepository.findSpotByName(name);
    }
    public Spot findSpotByCountry(String country){ return spotRepository.findSpotByName(country);}
    public Spot findSpotById(Long id){ return spotRepository.findSpotById(id);}
    public void delete(Long id) { spotRepository.deleteById(id);}
    public List<Spot> findAll() {
        List<Spot> users = (List<Spot>) spotRepository.findAll();
        return users;
    }
    public Spot saveSpot(Spot spot) {
        return spotRepository.save(spot);
    }
}
