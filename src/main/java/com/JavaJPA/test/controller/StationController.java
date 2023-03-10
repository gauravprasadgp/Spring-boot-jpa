package com.JavaJPA.test.controller;

import com.JavaJPA.test.entity.Station;
import com.JavaJPA.test.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:8080")
public class StationController {
  @Autowired
  StationService stationService;
  @GetMapping()
  public ResponseEntity<List<Station>> getAllStations(){
    return ResponseEntity.status(200).body(stationService.getAllStation());
  }
  @PostMapping()
  public ResponseEntity<Station> addStation(@RequestBody Station station){
    return ResponseEntity.status(200).body(stationService.addStation(station));
  }
  @GetMapping("show/{id}")
  public ResponseEntity<Optional<Station>> getStationById(@PathVariable("id") Integer id){
    return ResponseEntity.status(200).body(stationService.getStationById(id));
  }
  @PutMapping("{id}/edit")
  public ResponseEntity<Optional<Station>> updateStationById(@PathVariable("id") Integer id,
                                             @RequestBody Station station){
    return ResponseEntity.status(200).body(stationService.updateStation(id, station));
  }
  @DeleteMapping("delete/{id}")
  public ResponseEntity<String> deleteStation(@PathVariable("id") Integer id){
    stationService.deleteStation(id);
    return ResponseEntity.status(200).body("Success");
  }
}
