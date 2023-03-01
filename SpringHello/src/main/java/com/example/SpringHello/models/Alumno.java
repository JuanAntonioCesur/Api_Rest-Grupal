/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SpringHello.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author yuan-
 */
    @Data
    @Entity
    @Table(name = "alumno")
public class Alumno implements Serializable {
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    private int id;
   
    @Column(name = "Nombre")
    private String nombre;
    
    @Column(name = "Apellidos")
    private String apellidos;
  
    @Column(name = "PasswordAlumno")
    private String passwordAlumno;
    
    @Column(name = "DNI")
    private String dni;
  
    @Column(name = "FechaNacimiento")
    private String fechaNacimiento;
  
    @Column(name = "Email")
    private String email;
  
    @Column(name = "ProfesorID")
    private Integer profesorId;
    
    @Column(name = "Telefono")
    private String telefono;
  
    @Column(name = "HorasTotalesDual")
    private Integer horasTotalesDual;

    @Column(name = "HorasTotalesFCT")
    private Integer horasTotalesFct;
   
    @Column(name = "Observaciones")
    private String observaciones;
    

    
}
