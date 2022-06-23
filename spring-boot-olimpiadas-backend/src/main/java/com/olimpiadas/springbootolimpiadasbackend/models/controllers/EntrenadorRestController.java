package com.olimpiadas.springbootolimpiadasbackend.models.controllers;

import com.olimpiadas.springbootolimpiadasbackend.models.dao.IEntrenador;
import com.olimpiadas.springbootolimpiadasbackend.models.entity.Entrenador;
import com.olimpiadas.springbootolimpiadasbackend.models.services.IEntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class EntrenadorRestController {
    @Autowired
    public IEntrenadorService entrenadorService;
    @GetMapping("/entrenador")
    public List<Entrenador> index(){
        return entrenadorService.findAll();
    }
}
