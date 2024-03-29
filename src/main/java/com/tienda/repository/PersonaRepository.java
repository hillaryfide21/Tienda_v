/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.repository;

import com.tienda.entity.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Hillary
 */

@Repository
public interface PersonaRepository extends CrudRepository<Persona,Long>{
    Persona findByNombre(String nombre);
    
    //Aca uno puede llegar a insertar SP o otros metodos que notenga 
}
