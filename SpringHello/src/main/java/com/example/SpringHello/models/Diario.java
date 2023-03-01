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
@Table(name="diario")
public class Diario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    private int id;
    
    @Column(name = "AlumnoID")
    public Integer alumnoId;
    
    @Column(name = "Fecha")
    public String fecha;
    
    @Column(name = "Tipo")
    private String tipo;
    
    @Column(name = "HorasTrabajadas")
    private Integer horasTrabajadas;
    
    @Column(name = "Actividad")
    private String actividad;
    
    @Column(name = "Observaciones")
    private String observaciones;
    
}
