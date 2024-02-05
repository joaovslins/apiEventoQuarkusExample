package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.entity.EventoEntity;
import org.acme.repository.EventoRepository;

import java.util.List;

@ApplicationScoped
public class EventoService {

    @Inject
    private EventoRepository eventoRepository;

    public List<EventoEntity> getAllEventos(){
        return eventoRepository.findAll().list();
    }

    public EventoEntity addEvento(EventoEntity entity){
        eventoRepository.persist(entity);
        return entity;
    }

    public List<EventoEntity> findByUsuario(Long id){
        return eventoRepository.findEventoByIdUsuario(id);
    }

    public EventoEntity atualizarEvento(Long id, EventoEntity entity){
        var model = eventoRepository.findById(id);
        model.setStatus(entity.getStatus());
        model.setNome(entity.getNome());
        model.setData(entity.getData());
        eventoRepository.persist(model);
        return entity;
    }
}
