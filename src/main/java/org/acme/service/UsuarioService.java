package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.entity.UsuarioEntity;
import org.acme.repository.UsuarioRepository;

import java.util.List;

@ApplicationScoped
public class UsuarioService {

    @Inject
    UsuarioRepository usuarioRepository;

    public List<UsuarioEntity> findAllUsuario(){
        return usuarioRepository.findAll().list();
    }

    public UsuarioEntity addUsuario(UsuarioEntity entity){
        usuarioRepository.persist(entity);
        return entity;
    }

    public UsuarioEntity findByEmail(String email){
        return usuarioRepository.findByEmail(email);
    }

    public Boolean deleteUsuario(Long id){
        return usuarioRepository.deleteById(id);
    }
}
