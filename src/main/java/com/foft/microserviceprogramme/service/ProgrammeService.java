package com.foft.microserviceprogramme.service;

import com.foft.microserviceprogramme.modele.Programme;
import com.foft.microserviceprogramme.repository.ProgrammeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Data
@Service
public class ProgrammeService {
    @Autowired
    private ProgrammeRepository programmeRepository;


    public Optional<Programme> getProgramme(Integer id){
        return programmeRepository.findById(id);
    }
    public Programme getprogramme(Integer id ){return  programmeRepository.getById(id);}

    public Iterable<Programme> getProgrammes(){
        return programmeRepository.findAll();
    }

    public List<Programme> getprogrammes(){return  programmeRepository.findAll();}

    public void deleteProgramme (Integer id){
        programmeRepository.deleteById(id);
    }

    public Programme saveProgramme ( Programme programme){
        return programmeRepository.save(programme);
    }



    public List<Programme> findByJour (int jourId) {return programmeRepository.findProgrammeByJour(jourId);}



    public List<Programme> findByClasseAndSemestre(int idJour, int idClasse , int semestreId ){
        return programmeRepository.findProgrammeByJourAndIdClasse( idJour,idClasse,semestreId);
    }



//    public Programme updateProgramme(int id, LocalTime heureDeDebut, LocalTime heureDeFin, String totalHoraire, Enseignant enseignant, UniteEnseignement uniteEnseignement, Salle salle, Seance seance, Jour jour){
//        Programme current = getProgramme(id).get();
//        if(heureDeFin!=null)current.setHeureDeFin(heureDeFin);
//        if(heureDeDebut!=null) current.setHeureDeDebut(heureDeDebut);
//        if(totalHoraire!=null) current.setTotalHoraire(totalHoraire);
//        if(enseignant!=null) current.setEnseignant(enseignant);
//        if (uniteEnseignement!=null) current.setUe(uniteEnseignement);
//        if(salle!=null) current.setSalle(salle);
//        if(seance!=null) current.setSeance(seance);
//        if(jour!=null) current.setJour(jour);
//        return saveProgramme(current);
//    }













}
