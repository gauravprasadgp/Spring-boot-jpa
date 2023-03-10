package com.JavaJPA.test.service;

import com.JavaJPA.test.entity.Station;
import com.JavaJPA.test.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StationService {
  @Autowired
  private StationRepository stationRepository;
  public List<Station> getAllStation(){
    List<Station> allStation = new ArrayList<Station>();
    stationRepository.findAll()
      .forEach(station -> allStation.add(station));
    return allStation;
  }
  public Optional<Station> getStationById(Integer id){
    return stationRepository.findById(id);
  }
  public Station addStation(Station station){
    return stationRepository.save(station);
  }
  public Optional<Station> updateStation(Integer id, Station station){
    return stationRepository.findById(id)
      .map(dbStation -> {
        if(dbStation.getStation_id().equals(station.getStation_id())){
          return stationRepository.save(station);
        }
        else{
          return null;
        }
      });
  }
  public void deleteStation(Integer id){
    stationRepository.deleteById(id);
  }
}
