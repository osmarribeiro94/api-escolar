package org.model;

import java.util.List;

import javax.persistence.*;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.*;

@Getter
@Setter
@Table(name = "aluno")
@Entity
public class Aluno extends PanacheEntityBase{
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String matricula;

    @Column
    private String nome;

    @Column
    private String dt_nascimento;

    @ManyToMany(mappedBy = "disciplinas")
    private List<Vinculo> vinculos;


}