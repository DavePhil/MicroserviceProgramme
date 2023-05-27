package com.foft.microserviceprogramme.proxies;


import com.foft.microserviceprogramme.Bean.UniteEnseignementBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name ="MicroserviceUniteEnseignement", url = "http://localhost:9002")
public interface MicroserviceUniteEnseignementProxy {

    @GetMapping("/ue/{id}")
    Optional<UniteEnseignementBean> uniteEnseignement (@PathVariable("id") Integer id);

    @GetMapping("/ues")
    Iterable<UniteEnseignementBean> uniteEnseignements();

}
