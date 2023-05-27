package com.foft.microserviceprogramme.proxies;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name ="MicroserviceSalle", url = "http://localhost:9003")
public interface MicroserciceSalleProxy {

}
