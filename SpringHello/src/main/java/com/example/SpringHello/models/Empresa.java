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
@Table(name="empresa")
public class Empresa implements Serializable {
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "Nombre")
    private String nombre;
    
    @Column(name = "Telefono")
    private String telefono;
    
    @Column(name = "Email")
    private String email;
    
    @Column(name = "Responsable")
    private String responsable;
    
    @Column(name = "Observaciones")
    private String observaciones;
    
}
