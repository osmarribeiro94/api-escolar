package org.model;

import javax.persistence.*;

import java.util.List;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.*;

@Getter
@Setter
@Table(name = "vinculo")
@Entity
public class Vinculo extends PanacheEntityBase{
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<Aluno> alunos;

    @ManyToMany
    private List<Disciplina> disciplinas;


}