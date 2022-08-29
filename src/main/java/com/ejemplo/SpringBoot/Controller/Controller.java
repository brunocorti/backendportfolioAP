/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.SpringBoot.Controller;

import com.ejemplo.SpringBoot.model.Persona;
import com.ejemplo.SpringBoot.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Usuario
 */

@RestController
@CrossOrigin (origins = "https://portfolioap-4f438.web.app")
public class Controller {

    @Autowired
    private IPersonaService persoServ;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public void agregarPersona(@RequestBody Persona pers) {
        persoServ.crearPersona(pers);
    }

    @GetMapping("/personas/ver")
    @ResponseBody
    public List<Persona> verPersonas() {
        return persoServ.verPersonas();
    }

    @DeleteMapping("/personas/borrar/{id}")
    public void borrarPersona(@PathVariable Long id) {
        persoServ.borrarPersona(id);
    }
    
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido){
        Persona persona = persoServ.buscarPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        
        persoServ.crearPersona(persona);
        return persona;
    }
    
    @GetMapping("personas/traer/perfil")
    public Persona buscarPersona(){
        return persoServ.buscarPersona((long)1);
    }
}
