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
    @ManyToOne
    private Jour jour;




    public Programme() {
        super();
    }
}
