/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.controller;

import com.tienda.entity.Persona;
import com.tienda.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Hillary
 */

@Controller
public class PersonaController {
    
    @Autowired
    private IPersonaService personaService;
    
    //Metodo Get entonces cuando pongamos esto localhost/persona va a saber que debe hacer eso
    @GetMapping("/persona")
    
    //model permite enviar variables al HTML y que los valores sean de la BD
    public String index (Model model){
        List<Persona> listaPersona = personaService.getAllPersona();
        
        //Cada titulo se va a sustituir con eso 
        model.addAttribute("titulo", "Tabla Personas");
        model.addAttribute("personas", listaPersona);
        return "personas";
    }
          
}
