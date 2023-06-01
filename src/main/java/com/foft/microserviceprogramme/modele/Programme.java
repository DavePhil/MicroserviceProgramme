package com.foft.microserviceprogramme.modele;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalTime;

@Data
@Entity
@DynamicUpdate
public class Programme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalTime heureDeDebut;
    private LocalTime heureDeFin;
    private String totalHoraire;
    private Integer idUe;
    private Integer idSalle;
    private Integer idEnseignant;
    private Integer idSemestre;
    private Integer idClasse;

    @ManyToOne
    private Jour jour;

    @ManyToOne
    private Seance Seance;




    public Programme() {
        super();
    }
}
