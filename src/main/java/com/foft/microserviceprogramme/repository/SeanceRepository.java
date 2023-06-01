package com.foft.microserviceprogramme.repository;

import com.foft.microserviceprogramme.modele.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeanceRepository extends JpaRepository<Seance, Integer> {
}
