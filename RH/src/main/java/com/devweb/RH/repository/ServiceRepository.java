package com.devweb.RH.repository;

import com.devweb.RH.model.Service;
import com.devweb.RH.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer> {
    
}