package com.foft.microserviceprogramme.controller;

import com.foft.microserviceprogramme.modele.Seance;
import com.foft.microserviceprogramme.service.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("MicroSeance")
public class SeanceController {

    @Autowired
    private SeanceService seanceService;

    @PostMapping("/seance")
    public Seance createSeance(@RequestBody Seance salle){
        return seanceService.saveSeance(salle);
    }

    @GetMapping("/seance/{id}")
    public Seance getSeance(@PathVariable("id") final Integer id ){
        Optional<Seance> seance = seanceService.getSeance(id);
        if(seance.isPresent()) {
            return seance.get();
        } else {
            return null;
        }
    }

    @GetMapping("/seance")
    public Iterable<Seance> getSeances() {
        return seanceService.getSeances();
    }

    @DeleteMapping("/seance/{id}")
    public void deleteSalle(@PathVariable("id") final Integer id) {
        seanceService.deleteSeance(id);
    }

}
