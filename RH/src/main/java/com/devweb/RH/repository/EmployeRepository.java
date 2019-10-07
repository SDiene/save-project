package com.devweb.RH.repository;

import com.devweb.RH.model.Employe;
import com.devweb.RH.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeRepository extends JpaRepository<Employe, Integer> {

}