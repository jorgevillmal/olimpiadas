package com.olimpiadas.springbootolimpiadasbackend.models.controllers;

import com.olimpiadas.springbootolimpiadasbackend.models.dao.IEntrenador;
import com.olimpiadas.springbootolimpiadasbackend.models.entity.Entrenador;
import com.olimpiadas.springbootolimpiadasbackend.models.services.IEntrenadorService;


import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class EntrenadorRestController {

    @Autowired
    private IEntrenadorService entrenadorService;

    @GetMapping("/entrenadores")
    public List<Entrenador> index() {
        return entrenadorService.findAll();
    }

    @GetMapping("/entrenadores/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {
        Entrenador entrenador = null;
        Map<String, Object> response = new HashMap<>();
        try {
            entrenador = entrenadorService.findById(id);
        } catch (DataAccessException e){
            response.put("message", "Error en la base de datos. ");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }


        if(entrenador == null){
            response.put("message", "El cliente ID: ".concat(id.toString().concat(" no existe en la base de datos")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Entrenador>(entrenador,HttpStatus.OK);
    }

    @PostMapping("/entrenadores")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody Entrenador entrenador) {

        Entrenador entrenadorNew = null;
        Map<String, Object> response = new HashMap<>();
        try {
            entrenadorNew = entrenadorService.save(entrenador);
        }catch (DataAccessException e){
            response.put("message", "Error en el insert de la base de datos. ");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("Message", "El entrenador se ha creado con exito");
        response.put("Entrenador", entrenadorNew);
        return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
    }

    @PutMapping("/entrenadores/{id}")
    public ResponseEntity<?> update(@RequestBody Entrenador entrenador, @PathVariable Long id) {
        Entrenador currentEntrenador = this.entrenadorService.findById(id);
        Entrenador updateEntrenador = null;
        Map<String, Object> response = new HashMap<>();

        if(currentEntrenador == null){
            response.put("message", "Error: no se pudo editar, cliente ID: ".concat(id.toString().concat(" no existe en la base de datos")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }



        try {

            currentEntrenador.setNombre(entrenador.getNombre());
            currentEntrenador.setApellido(entrenador.getApellido());
            currentEntrenador.setEmail(entrenador.getEmail());
            currentEntrenador.setCreateAt(entrenador.getCreateAt());

            updateEntrenador = entrenadorService.save(currentEntrenador);

        }catch (DataAccessException e){
            response.put("message", "Error al actualizar en la base de datos. ");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("Message", "El entrenador se ha actualizado con exito");
        response.put("Entrenador", updateEntrenador);
        return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
    }

    @DeleteMapping("/entrenadores/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            entrenadorService.delete(id);
        }catch (DataAccessException e){
            response.put("message", "Error al eliminar en la base de datos. ");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("Message", "El entrenador fue eliminado con exito");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }
}