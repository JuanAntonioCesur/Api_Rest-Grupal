/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.example.SpringHello.repositories;

import com.example.SpringHello.models.Diario;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author yuan-
 */
public interface DiarioRepository extends JpaRepository<Diario, Integer> {
    
    List<Diario> findByAlumnoId(Integer alumnoId);

    List<Diario> findByTipo(String tipo);
    
    List<Diario> findByIdAndAlumnoId(Integer id,Integer alumnoId);
}
