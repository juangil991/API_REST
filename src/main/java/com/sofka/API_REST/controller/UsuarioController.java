package com.sofka.API_REST.controller;

import com.sofka.API_REST.models.UsuarioModel;
import com.sofka.API_REST.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel>obtenerUsuarios(){
        return usuarioService.obtenerUsusarios();
    }

    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }
    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id")Long id){
        return this.usuarioService.obtenerPorId(id);
    }
    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorNombre(@RequestParam("prioridad") Long prioridad){
        return usuarioService.obtenerPorPrioridad(prioridad);
    }
    @DeleteMapping(path = "/{id}")
    public String eliminarUsuarioPorId(@PathVariable("id") Long id){
            if(usuarioService.elimiarUsuario(id)){
                return "se elimino el usuario con id: "+id;
            }
            else return "fallo al eliminar usuario";
    }
    @PutMapping(path = "/{id}")
    public String  actualizaUsuarioPorId(@PathVariable("id") Long id, @RequestBody UsuarioModel usuario){
        if(usuarioService.verificarUsuario(id)){
            UsuarioModel usuarioaux=usuario;
            usuarioaux.setId(id);
            usuarioService.guardarUsuario(usuarioaux);
            return "el usuario con id: "+usuarioaux.getId()+ " fue modificado";
        }
        else return "el usuario no existe";
    }
}
