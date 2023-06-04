package com.foft.microserviceprogramme.Bean;

import com.foft.microserviceuniteenseignement.modele.Semestre;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UniteEnseignementBean {

    private Integer id;
    private String code;
    private int idClasse;
    private SemestreBean semestre;

}
