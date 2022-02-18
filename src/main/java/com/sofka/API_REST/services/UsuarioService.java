package com.sofka.API_REST.services;

import com.sofka.API_REST.models.UsuarioModel;
import com.sofka.API_REST.respositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModel>obtenerUsusarios(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }
    public UsuarioModel guardarUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }
    public Optional<UsuarioModel>obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }
    public ArrayList<UsuarioModel> obtenerPorPrioridad(Long prioridad){
        return usuarioRepository.findByPrioridad(prioridad);
    }
    public boolean elimiarUsuario(Long id){
        try {
            usuarioRepository.deleteById(id);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

}
