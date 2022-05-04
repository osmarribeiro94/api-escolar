package org.repository;

import javax.enterprise.context.ApplicationScoped;
import org.model.Professor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ProfessorRepository implements PanacheRepository<Professor> {

 
}