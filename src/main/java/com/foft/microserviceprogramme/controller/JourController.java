package com.foft.microserviceprogramme.controller;

import com.foft.microserviceprogramme.modele.Jour;
import com.foft.microserviceprogramme.service.JourService;
import com.foft.microserviceuniteenseignement.exceptions.ImpossibleToAdd;
import com.foft.microserviceuniteenseignement.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class JourController {
    @Autowired
    private JourService jourService;

    @PostMapping("/jour")
    public ResponseEntity<Jour> create(@RequestBody Jour jour){
        Jour added =  jourService.saveJour(jour);
        if (Objects.isNull(added)) throw new ImpossibleToAdd("Nous ne pouvons pas ajouter le jour suivant");
        return new ResponseEntity<>(jour, HttpStatus.CREATED);
    }

    @GetMapping("/jour/{id}")
    public Optional<Jour> getJour(@PathVariable("id") int id){
        Optional<Jour> jour =  jourService.findJourById(id);
        if (!jour.isPresent()) throw new NotFoundException("Nous n'avons pas retrouvé ce jour");
        return jour;
    }

    @GetMapping("/jours")
    @ResponseBody
    public List<Jour> getJours(){
        return jourService.findJours();
    }

}
