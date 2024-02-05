package org.acme.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.acme.dto.StatusEnum;

import java.util.Date;

@Entity
@Table(name = "EVENTO")
@Data
@NoArgsConstructor
public class EventoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private StatusEnum status;
    private Date data;

    @ManyToOne
    private UsuarioEntity usuario;
}
