package org.acme.controller;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import org.acme.entity.UsuarioEntity;
import org.acme.service.UsuarioService;

import java.util.List;

@Path(value = "/api/usuario")
public class UsuarioController {
    @Inject
    UsuarioService service;

    @GET
    public List<UsuarioEntity> findAllUsuarios(){
        return service.findAllUsuario();
    }

    @GET
    @Path("/email/{email}")
    public UsuarioEntity findByEmail(@PathParam("email") String email){
        return service.findByEmail(email);
    }

    @POST
    @Transactional
    public UsuarioEntity addUsuario(UsuarioEntity entity){
        return service.addUsuario(entity);
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Boolean deleteUsuario(@PathParam("id") Long id){
        return service.deleteUsuario(id);
    }
}
