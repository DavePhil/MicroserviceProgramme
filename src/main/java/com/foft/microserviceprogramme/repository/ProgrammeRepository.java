package com.foft.microserviceprogramme.repository;

import com.foft.microserviceprogramme.modele.Programme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgrammeRepository extends JpaRepository<Programme, Integer> {

}
