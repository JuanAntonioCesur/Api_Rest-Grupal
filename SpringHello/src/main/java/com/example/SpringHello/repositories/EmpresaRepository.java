/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.example.SpringHello.repositories;

import com.example.SpringHello.models.Empresa;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author yuan-
 */
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    public Optional<Empresa> findByNombre(String nombre);
    
}

