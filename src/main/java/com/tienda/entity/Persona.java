/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author Hillary
 */
//Definimos que es una entidad, pero como quiere traer la info de una tabla pongo tabke
@Entity
@Table(name="personas")

public class Persona implements Serializable{
    // Se agregan las columnas
    @Id // Se define como PK
    // Se le da las caracteristicas del id 
    @GeneratedValue (strategy= GenerationType.IDENTITY) 
    private long id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String telefono;
    private String email;
    
    //Foreign Key
    @ManyToOne
    @JoinColumn (name="paises_id")
    //Objetyo de tipo pais que apunta  aotra tabla
    private Pais pais;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public Pais getPais() {
        return pais;
    }
    
    
}
