package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.EventoEntity;

import java.util.List;

@ApplicationScoped
public class EventoRepository implements PanacheRepository<EventoEntity> {

    public List<EventoEntity> findEventoByIdUsuario(Long id){
        return find("usuario.id", id).list();
    }

}
