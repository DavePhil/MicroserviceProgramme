package com.foft.microserviceprogramme.controller;

import com.foft.microserviceprogramme.modele.Programme;
import com.foft.microserviceprogramme.service.ProgrammeService;
import com.foft.microserviceuniteenseignement.exceptions.ImpossibleToAdd;
import com.foft.microserviceuniteenseignement.exceptions.NotFoundException;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class ProgrammeController {

    @Autowired
    ProgrammeService programmeService;

    @PostMapping("/programme")
    public ResponseEntity<Programme> createProgramme(@RequestBody Programme programme){
        Programme added = programmeService.saveProgramme(programme);
        if(Objects.isNull(added)) throw new ImpossibleToAdd("Impossible d'ajouter ce programme ");
        return new ResponseEntity<>(programme, HttpStatus.CREATED);

    }

    @GetMapping("/programme/{id}")
    public Optional<Programme> getProgrammes(@PathVariable int id){
        Optional<Programme> programme = programmeService.getProgramme(id);
        if (!programme.isPresent()) throw new NotFoundException("Le programme suivant n'est pas présent ");
        return programme;
    }

    @GetMapping("/programmes")
    public Iterable<Programme> getProgrammes(){
        return programmeService.getProgrammes();
    }

    @GetMapping("/programme/{idjour}")
    public List<Programme> programmes (@PathVariable("idjour") Integer idjour){
        return programmeService.findByJour(idjour);
    }

    @DeleteMapping("/deleteprogramme/{id}")
    public void deleteProgramme(@PathVariable int id){
        Optional<Programme> programme = programmeService.getProgramme(id);
        if (!programme.isPresent()) throw new NotFoundException("Le programme suivant n'est pas présent ");
        programmeService.deleteProgramme(id);
    }

//    @GetMapping("/jourP")
//    @ResponseBody
//    public List<Programme> verify(){
//
//        return programmeService.findByJour(programmeService.idOfJour(programmeService.getJour()));
//    }


    @PutMapping("/programmec/{id}")
    public  Programme updateProgramme(@PathVariable("id") int id, @RequestBody Programme programme) {
        Optional<Programme> current = programmeService.getProgramme(id);
        if (!current.isPresent()) throw new NotFoundException("Le programme suivant n'est pas présent ");
        Programme programme1 = current.get();
        if (programme.getJour()!=null) programme1.setJour(programme.getJour());
        if (programme.getHeureDeDebut()!=null) programme1.setHeureDeDebut(programme.getHeureDeDebut());
        if (programme.getHeureDeFin()!=null) programme1.setHeureDeFin(programme.getHeureDeFin());
        if (programme.getIdSalle()!=null) programme1.setIdSalle(programme.getIdSalle());
        if (programme.getIdEnseignant()!=null) programme1.setIdEnseignant(programme.getIdEnseignant());
        if (programme.getIdUe()!=null) programme1.setIdEnseignant(programme.getIdEnseignant());
        if (programme.getTotalHoraire()!=null) programme1.setTotalHoraire(programme.getTotalHoraire());
        return programmeService.saveProgramme(programme1);
    }
}
