package com.foft.microserviceprogramme.controller;

import com.foft.microserviceprogramme.Bean.EnseignantBean;
import com.foft.microserviceprogramme.Bean.UniteEnseignementBean;
import com.foft.microserviceprogramme.modele.Jour;
import com.foft.microserviceprogramme.modele.Programme;
import com.foft.microserviceprogramme.modele.Seance;
import com.foft.microserviceprogramme.proxies.MicroserviceEnseignantProxy;
import com.foft.microserviceprogramme.proxies.MicroserviceUniteEnseignementProxy;
import com.foft.microserviceprogramme.service.ProgrammeService;
import com.foft.microserviceuniteenseignement.exceptions.ImpossibleToAdd;
import com.foft.microserviceuniteenseignement.exceptions.NotFoundException;
import com.foft.microserviceuniteenseignement.proxies.MicroserviceClasseProxy;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("MicroProg")
public class ProgrammeController {

    @Autowired
    ProgrammeService programmeService;
    @Autowired
    MicroserviceEnseignantProxy enseignantProxy;
    @Autowired
    MicroserviceUniteEnseignementProxy uniteEnseignementProxy;

    @PostMapping("/programme")
    public ResponseEntity<Programme> createProgramme(@RequestParam("heureDeDebut") @DateTimeFormat(pattern = "HH:mm") LocalTime heureDeDebut,
                                                     @RequestParam("heureDeFin") @DateTimeFormat(pattern = "HH:mm") LocalTime heureDeFin,
                                                     @RequestParam("totalHoraire") String totalHoraire,
                                                     @RequestParam("enseignant") Integer idEnseignant,
                                                     @RequestParam("ue") Integer idUniteEnseignement,
                                                     @RequestParam("salle") Integer idSalle,
                                                     @RequestParam("seance") Seance seance,
                                                     @RequestParam("jour") Jour jour){
        Programme programme = new Programme();
        programme.setJour(jour);
        programme.setIdUe(idUniteEnseignement);
        programme.setIdSalle(idSalle);
        programme.setHeureDeFin(heureDeFin);
        programme.setHeureDeDebut(heureDeDebut);
        programme.setTotalHoraire(totalHoraire);
        programme.setIdEnseignant(idEnseignant);
        // Appel du microservice UE pour récupérer la classe donc t'il est question
        Optional<UniteEnseignementBean> uniteEnseignement =uniteEnseignementProxy.uniteEnseignement(idUniteEnseignement);
        programme.setIdClasse(uniteEnseignement.get().getIdClasse());
        programme.setIdSemestre(uniteEnseignement.get().getSemestre().getId());
        programme.setSeance(seance);
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

    @GetMapping("/ue/{id}")
    UniteEnseignementBean uniteEnseignement (@PathVariable("id") Integer id){
        Optional<UniteEnseignementBean> uniteEnseignementBean = uniteEnseignementProxy.uniteEnseignement(id);
        if (!uniteEnseignementBean.isPresent()) throw new NotFoundException("Unite d'enseignement pas présent");
        return uniteEnseignementBean.get();
    }

    @GetMapping("/ues")
    Iterable<UniteEnseignementBean> uniteEnseignements(){
        return uniteEnseignementProxy.uniteEnseignements();
    }

    @GetMapping("/Enseignant/{id}")
    EnseignantBean getEnseignant(@PathVariable("id") final Integer id ){
        return enseignantProxy.getEnseignant(id);
    }

    @GetMapping("/Enseignant")
    public Iterable<EnseignantBean> getEnseignants(){
        return enseignantProxy.getEnseignants();
    }


}
