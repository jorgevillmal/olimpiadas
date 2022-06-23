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
}
