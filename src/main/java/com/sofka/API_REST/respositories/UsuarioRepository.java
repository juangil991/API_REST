package com.sofka.API_REST.respositories;

import com.sofka.API_REST.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel,Long> {
    public abstract ArrayList<UsuarioModel> findByPrioridad(Long prioridad);
}
