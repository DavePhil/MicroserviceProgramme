package com.foft.microserviceprogramme.proxies;


import com.foft.microserviceprogramme.Bean.UniteEnseignementBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name ="MicroserviceUniteEnseignement")
@RibbonClient(name = "MicroserviceUniteEnseignement")
public interface MicroserviceUniteEnseignementProxy {

    @GetMapping("/MicroUe/ue/{id}")
    Optional<UniteEnseignementBean> uniteEnseignement (@PathVariable("id") Integer id);

    @GetMapping("/MicroUe/ues")
    Iterable<UniteEnseignementBean> uniteEnseignements();

}
