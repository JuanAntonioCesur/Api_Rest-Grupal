/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.example.SpringHello.controllers;

import com.example.SpringHello.models.Alumno;
import com.example.SpringHello.models.Diario;
import com.example.SpringHello.repositories.AlumnoRepository;
import com.example.SpringHello.repositories.DiarioRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author yuan-
 */
@RestController
@RequestMapping("/alumno")
public class AlumnoController {
    
 @Autowired
 AlumnoRepository repo2;
    
    @GetMapping()
    public List<Alumno> list(){
        return repo2.findAll();
    }
    
    
    
    @GetMapping("/{id}")
    public ResponseEntity<Alumno> get(@PathVariable Integer id) {
        //return repo.findById(id).get();
       if( repo2.existsById(id)){
           return new ResponseEntity<Alumno>(repo2.findById(id).get(),HttpStatus.OK);
       }else{
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }
    
}
