package org.repository;

import javax.enterprise.context.ApplicationScoped;
import org.model.Disciplina;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class DisciplinaRepository implements PanacheRepository<Disciplina> {
   

 
}