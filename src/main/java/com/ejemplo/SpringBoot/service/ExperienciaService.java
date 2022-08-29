/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.Entity.Experiencia;
import com.ejemplo.SpringBoot.repository.ExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaService {
    @Autowired
    ExperienciaRepository repoExperiencia;
    
    public List <Experiencia> list(){
        return repoExperiencia.findAll();
    }
    
    public Optional <Experiencia> getOne(int id){
        return repoExperiencia.findById(id);
    }
    
    public Optional <Experiencia> getByNombreE(String nombreE){
        return repoExperiencia.findByNombreE(nombreE);
    }
    
    public void save(Experiencia exp){
        repoExperiencia.save(exp);
    }
    
    public void delete(int id){
        repoExperiencia.deleteById(id);
    }
    
    public boolean existsById(int id){
        return repoExperiencia.existsById(id);
    }
    
    public boolean existsByNombreE(String nombreE){
        return repoExperiencia.existsByNombreE(nombreE);
    }
}
