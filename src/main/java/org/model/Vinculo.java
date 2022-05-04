package org.model;

import javax.persistence.*;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Vinculo extends PanacheEntityBase{
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}