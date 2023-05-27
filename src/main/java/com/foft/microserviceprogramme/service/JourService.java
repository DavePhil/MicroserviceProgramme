package com.foft.microserviceprogramme.service;

import com.foft.microserviceprogramme.modele.Jour;
import com.foft.microserviceprogramme.repository.JourRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class JourService {
    @Autowired
    private JourRepository jourRepository;


    public Jour saveJour(Jour jour){
        Jour saved = jourRepository.save(jour);
        return saved;
    }

    public Optional<Jour> findJourById(int id){
        return jourRepository.findById(id);
    }

    public List<Jour> findJours(){
        return jourRepository.findAll();
    }

}
