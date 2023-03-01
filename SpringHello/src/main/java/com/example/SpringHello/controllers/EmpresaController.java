/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.example.SpringHello.controllers;

import com.example.SpringHello.models.Empresa;
import com.example.SpringHello.repositories.EmpresaRepository;
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
@RequestMapping("/empresa")
//como se va a llamar la ruta/////////////// localhost:8080/pokedex 
public class EmpresaController {
    
    @Autowired
    EmpresaRepository repo1;
    
    @GetMapping()
    public List<Empresa> list(){
        return repo1.findAll();
    }
    

    @GetMapping("/empresa/name/{name}")
    public ResponseEntity<Empresa> getEmpresaByName(@PathVariable String name){
        var emp =repo1.findByNombre(name);
        if(emp.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<Empresa>(emp.get(),HttpStatus.OK);
        }
    }
    
    @GetMapping("/empresa/{id}")
    public ResponseEntity<Empresa> get(@PathVariable Long id) {
        //return repo.findById(id).get();
       if( repo1.existsById(id)){
           return new ResponseEntity<Empresa>(repo1.findById(id).get(),HttpStatus.OK);
       }else{
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }
//    
//    @GetMapping("/{id}")
//    public Pokemon get(@PathVariable Long id) {
//        //return repo.findById(id).get();
//    }
//    
    
    
    
//    @PutMapping("/{id}")
//    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
//        return null;
//    }
//    
//    @PostMapping
//    public ResponseEntity<Empresa> post(@RequestBody Empresa input) {
//        repo1.save(input);
//        System.out.println(input);
//        return new ResponseEntity<>(input,HttpStatus.CREATED);
//    }
//    
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> delete(@PathVariable String id) {
//        return null;
//    }
    
}
