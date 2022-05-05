package org.model;

import javax.persistence.*;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.*;

@Getter
@Setter
@Table(name = "professor")
@Entity
public class Professor extends PanacheEntityBase{
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String matricula;

    @Column
    private String nome;

    @OneToMany
    @JoinColumn(name="disciplina_id")
    private Disciplina disciplina;

    

}