package org.repository;

import javax.enterprise.context.ApplicationScoped;
import org.model.Aluno;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class AlunoRepository implements PanacheRepository<Aluno> {
   
    public Aluno findByName(String nome){
        return find("nome", nome).firstResult();
    }
 
}