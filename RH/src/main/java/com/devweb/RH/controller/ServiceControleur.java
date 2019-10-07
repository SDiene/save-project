package com.devweb.RH.controller;

import com.devweb.RH.model.Service;
import com.devweb.RH.repository.ServiceRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin

@RequestMapping(value = "/service") // comme symfony Api/...
public class ServiceControleur {

    @Autowired // ça permet de donner le reference de l'objet
    private ServiceRepository serviceRepository;

    @GetMapping(value = "/liste")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Service> list(){
        return  serviceRepository.findAll();
    }

    @PostMapping (value = "/add",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Service add(@RequestBody(required = false) Service s){
        return  serviceRepository.save(s); // on peut utiliser aussi saveOnUpdate   return "redirect:/user";
    }
}
