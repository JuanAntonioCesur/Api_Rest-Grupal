/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.example.SpringHello.controllers;

import com.example.SpringHello.models.Diario;
import com.example.SpringHello.models.Empresa;
import com.example.SpringHello.repositories.DiarioRepository;
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
@RequestMapping("/diario")
public class DiarioController {
    
 @Autowired
 DiarioRepository repo2;
    
    @GetMapping()
    public List<Diario> list(){
        return repo2.findAll();
    }
    
    
    @GetMapping("/alumnoid/{alumnoId}")
    public ResponseEntity<List<Diario>> getDiarioByAlumnoId(@PathVariable Integer alumnoId){
        List<Diario> listdiario = repo2.findByAlumnoId(alumnoId);
        //var emp =repo2.findByAlumnoId(alumnoId);
        if(listdiario.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(listdiario, HttpStatus.OK);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Diario> get(@PathVariable Integer id) {
        //return repo.findById(id).get();
       if( repo2.existsById(id)){
           return new ResponseEntity<Diario>(repo2.findById(id).get(),HttpStatus.OK);
       }else{
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }
    
    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Diario>> getDiarioByTipo(@PathVariable String tipo){
        List<Diario> listdiario = repo2.findByTipo(tipo);
        
        if(listdiario.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(listdiario,HttpStatus.OK);
        }
    }
    
    @GetMapping("/alumnoid/{alumnoId}/{id}")
    public ResponseEntity<List<Diario>> getDiarioByAlumnoIdById(@PathVariable Integer alumnoId,@PathVariable Integer id){
        List<Diario> listdiario = repo2.findByIdAndAlumnoId(id,alumnoId);
        //var emp =repo2.findByAlumnoId(alumnoId);
        if(listdiario.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(listdiario, HttpStatus.OK);
        }
    }
    
    
    @PostMapping("/nuevo")
    public ResponseEntity<Diario> createBook(@RequestBody Diario diario) {
        Diario savedDiario = repo2.save(diario);
        return new ResponseEntity<>(savedDiario, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Diario> delete(@PathVariable Integer id) {
        ResponseEntity<Diario> salida;
        
        if(repo2.existsById(id)){
            salida = new ResponseEntity<Diario>(repo2.findById(id).get(),HttpStatus.OK);
            repo2.deleteById(id);
        }else{
            salida = new ResponseEntity<Diario>(HttpStatus.NOT_FOUND);
        }
            
        return salida;
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Diario> put(@PathVariable Integer id, @RequestBody Diario input) {

        ResponseEntity<Diario> salida;
        
        if(repo2.existsById(id)){
            repo2.save(input);            
            salida = new ResponseEntity<Diario>(input,HttpStatus.OK);
        }else{
            salida = new ResponseEntity<Diario>(HttpStatus.NOT_FOUND);
        }
            
        return salida;
    }
    
    
}
