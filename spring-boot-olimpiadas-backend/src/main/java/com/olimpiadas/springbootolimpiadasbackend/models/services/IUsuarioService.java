package com.olimpiadas.springbootolimpiadasbackend.models.services;

import com.olimpiadas.springbootolimpiadasbackend.models.entity.Usuario;
import org.springframework.stereotype.Repository;
public interface IUsuarioService {

    public Usuario findByUsername(String username);
}
