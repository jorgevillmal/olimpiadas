package com.olimpiadas.springbootolimpiadasbackend.models.services;

import com.olimpiadas.springbootolimpiadasbackend.models.dao.IEntrenador;
import com.olimpiadas.springbootolimpiadasbackend.models.entity.Entrenador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EntrenadorService implements  IEntrenadorService{

    @Autowired
    private IEntrenador entrenadorDao;

    @Override
    public List<Entrenador> findAll(){
        return (List<Entrenador>) entrenadorDao.findAll();
    }

    @Override
    public Entrenador findById(Long id) {
        return entrenadorDao.findById(id).orElse(null); // Busca entrenador por id y si no lo encuentrs
        // regresa una excepcion
    }

    @Override
    public Entrenador save(Entrenador entrenador) {
        return entrenadorDao.save(entrenador); // Guarda un entrenador
    }

    @Override
    public void delete(Long id) {

        entrenadorDao.deleteById(id); // Salva un entrenador
    }
}
