package com.olimpiadas.springbootolimpiadasbackend.models.services;

import com.olimpiadas.springbootolimpiadasbackend.models.entity.Entrenador;

import java.util.List;

public interface IEntrenadorService {
    // Esta interfaz nos ayudar para implementar el CRUD de nuestro


    public List<Entrenador> findAll();
    public Entrenador findById(Long id); // Busco a un entrenador por id.
    public Entrenador save(Entrenador entrnador); // Guardo un enetrenado en la base de datos.
    public  void delete(Long id);// Borro un entrenador de la base de datos.

}
