package org.services;

import org.model.Aluno;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class AlunoService {

    public Aluno update(Long id, Aluno aluno) {
        Aluno alunoEntity = Aluno.findById(id);

        if (alunoEntity == null) {
            throw new WebApplicationException("Aluno with id of " + id + " does not exist.", Response.Status.NOT_FOUND);
        }

        alunoEntity.setNome(aluno.getNome());
        alunoEntity.setMatricula(aluno.getMatricula());
        alunoEntity.setDt_nascimento(aluno.getDt_nascimento());

        return alunoEntity;
    }

    /**
     * This method is main purpose to show simple "Business" example
     * @param aluno
     * @return
     */
    public boolean isAlunoNameIsNotEmpty(Aluno aluno) {
        return aluno.getNome().isEmpty();
    }
}