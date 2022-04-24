package org.services;

import org.repository.PessoaRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class PessoaService {

    public PessoaRepository update(Long id, PessoaRepository pessoa) {
        PessoaRepository pessoaEntity = PessoaRepository.findById(id);

        if (pessoaEntity == null) {
            throw new WebApplicationException("Food with id of " + id + " does not exist.", Response.Status.NOT_FOUND);
        }

        pessoaEntity.setName(pessoa.getName());
        pessoaEntity.setCalories(pessoa.getCalories());

        return pessoaEntity;
    }

    /**
     * This method is main purpose to show simple "Business" example
     * @param food
     * @return
     */
    public boolean isFoodNameIsNotEmpty(PessoaRepository pessoa) {
        return pessoa.getName().isEmpty();
    }
}