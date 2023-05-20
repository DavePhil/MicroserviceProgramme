package com.foft.microserviceprogramme.repository;

import com.foft.microserviceprogramme.modele.Jour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JourRepository extends JpaRepository<Jour, Integer> {
}
