/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.service;


import java.util.List;
import com.tienda.entity.Persona;
/**
 *
 * @author Hillary
 */
public interface IPersonaService {
    public List<Persona> getAllPersona();
    public Persona getPersonaById (long id);
    public void savePersona (Persona persona);
    public void delete (long id);
     
}
