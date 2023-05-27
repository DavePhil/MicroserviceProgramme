package com.foft.microserviceprogramme.proxies;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name ="MicroserviceEnseignant", url = "http://localhost:9004")
public interface MicroserviceEnseignantProxy {

}
