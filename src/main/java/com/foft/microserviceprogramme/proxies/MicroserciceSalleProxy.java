package com.foft.microserviceprogramme.proxies;


import com.foft.microserviceprogramme.Bean.SalleBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name ="MicroserviceSalle")
@RibbonClient(name = "MicroserviceSalle")
public interface MicroserciceSalleProxy {

    @GetMapping("/MicroSalle/Salle/{id}")
    SalleBean getSalle(@PathVariable("id") final Integer id);

    @GetMapping("/MicroSalle/Salle")
    Iterable<SalleBean> getSalles();
}
