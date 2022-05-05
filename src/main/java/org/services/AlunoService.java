package org.services;

import org.DTO.AlunoDTO;
import org.model.Aluno;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class AlunoService {

    public Aluno create(AlunoDTO dto){
        Aluno aluno = new Aluno();
        aluno.setDt_nascimento(dto.getDt_nascimento());
        aluno.setMatricula(dto.getMatricula());
        aluno.setNome(dto.getNome());
        aluno.persist();

        return aluno;
    }

    public Aluno update(Long id, AlunoDTO dto) {
        Aluno alunoEntity = Aluno.findById(id);

        if (alunoEntity == null) {
            throw new WebApplicationException("Aluno with id of " + id + " does not exist.", Response.Status.NOT_FOUND);
        }

        alunoEntity.setNome(dto.getNome());
        alunoEntity.setMatricula(dto.getMatricula());
        alunoEntity.setDt_nascimento(dto.getDt_nascimento());

        return alunoEntity;
    }

    public boolean isAlunoNameIsNotEmpty(AlunoDTO dto) {
        return dto.getNome().isEmpty();
    }

    
}