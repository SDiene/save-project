package com.devweb.RH.controller;

import com.devweb.RH.model.Employe;
import com.devweb.RH.model.Service;
import com.devweb.RH.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin

@RequestMapping(value = "/employe") // comme symfony Api/...
public class EmployeControleur {

    @Autowired // ça permet de donner le reference de l'objet
    private EmployeRepository employeRepository;

    @GetMapping(value = "/liste") // on peut faire un getMapping et lui passer tous notre url en parametre
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Employe> list(){
        return  employeRepository.findAll();
    }

    @PostMapping(value = "/add",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Employe add(@RequestBody(required = false) Employe employe){
        return  employeRepository.save(employe); // on peut utiliser aussi saveOnUpdate
    }
}

