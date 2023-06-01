package com.foft.microserviceprogramme.proxies;


import com.foft.microserviceprogramme.Bean.EnseignantBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name ="MicroserviceEnseignant")
@RibbonClient(name = "MicroserviceEnseignant")
public interface MicroserviceEnseignantProxy {
    @GetMapping("/MicroEnseignant/Enseignant/{id}")
    EnseignantBean getEnseignant(@PathVariable("id") final Integer id );

    @GetMapping("/MicroEnseignant/Enseignant")
    public Iterable<EnseignantBean> getEnseignants();

}
