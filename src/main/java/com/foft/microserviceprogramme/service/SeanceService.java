package com.foft.microserviceprogramme.service;

import com.foft.microserviceprogramme.modele.Seance;
import com.foft.microserviceprogramme.repository.SeanceRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class SeanceService {
    @Autowired
    private SeanceRepository seanceRepository;

    public Optional<Seance> getSeance(Integer id){
        return seanceRepository.findById(id);
    }

    public Iterable<Seance> getSeances(){
        return seanceRepository.findAll();
    }

    public void deleteSeance (Integer id){
        seanceRepository.deleteById(id);
    }

    public Seance saveSeance (Seance seance){
        Seance saved = seanceRepository.save(seance);
        return saved;
    }
}
