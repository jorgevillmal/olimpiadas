package com.olimpiadas.springbootolimpiadasbackend.models.dao;

import com.olimpiadas.springbootolimpiadasbackend.models.entity.Entrenador;
import org.springframework.data.repository.CrudRepository;

public interface IEntrenador extends CrudRepository<Entrenador, Long> {

}
