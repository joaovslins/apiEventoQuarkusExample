package org.acme.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "USUARIO")
@Entity
@Data
@NoArgsConstructor
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String sobrenome;
    private Integer idade;
    private String email;

    @JsonIgnore
    @ManyToOne
    private EventoEntity evento;
}
