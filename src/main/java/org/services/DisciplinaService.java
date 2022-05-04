package org.services;

import org.model.Disciplina;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class DisciplinaService {

    public Disciplina update(Long id, Disciplina disciplina) {
        Disciplina disciplinaEntity = Disciplina.findById(id);

        if (disciplinaEntity == null) {
            throw new WebApplicationException("Disciplina with id of " + id + " does not exist.", Response.Status.NOT_FOUND);
        }

        disciplinaEntity.setNome(disciplina.getNome());

        return disciplinaEntity;
    }

    /**
     * This method is main purpose to show simple "Business" example
     * @param disciplina
     * @return
     */
    public boolean isDisciplinaNameIsNotEmpty(Disciplina disciplina) {
        return disciplina.getNome().isEmpty();
    }
    
}