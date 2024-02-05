package org.acme.controller;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import org.acme.entity.EventoEntity;
import org.acme.service.EventoService;

import java.util.List;

@Path(value = "/api/evento")
public class EventoController {

    @Inject
    private EventoService eventoService;

    @GET
    public List<EventoEntity> getAllEventos(){
        return eventoService.getAllEventos();
    }

    @POST
    @Transactional
    public EventoEntity salvarEvento(EventoEntity entity){
        return eventoService.addEvento(entity);
    }

    @GET
    @Path(value = "/usuario/{id}")
    public List<EventoEntity> getEventosByUsuario(@PathParam("id") Long id){
        return eventoService.findByUsuario(id);
    }

    @PUT
    @Path(value = "/atualizar/{id}")
    @Transactional
    public EventoEntity updateStatusEvento(@PathParam("id") Long id, EventoEntity entity){
        return eventoService.atualizarEvento(id, entity);
    }
}
