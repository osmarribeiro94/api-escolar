package org.services;

import org.model.Professor;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class ProfessorService {

    public Professor update(Long id, Professor professor) {
        Professor professorEntity = Professor.findById(id);

        if (professorEntity == null) {
            throw new WebApplicationException("Professor with id of " + id + " does not exist.", Response.Status.NOT_FOUND);
        }

        professorEntity.setNome(professor.getNome());
        professorEntity.setMatricula(professor.getMatricula());

        return professorEntity;
    }

    /**
     * This method is main purpose to show simple "Business" example
     * @param professor
     * @return
     */
    public boolean isProfessorNameIsNotEmpty(Professor professor) {
        return professor.getNome().isEmpty();
    }
    
}