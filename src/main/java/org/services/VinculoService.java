package org.services;

import org.model.Vinculo;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class VinculoService {

    public Vinculo update(Long id, Vinculo vinculo) {
        Vinculo vinculoEntity = Vinculo.findById(id);

        if (vinculoEntity == null) {
            throw new WebApplicationException("Vinculo with id of " + id + " does not exist.", Response.Status.NOT_FOUND);
        }

        vinculoEntity.setNome(vinculo.getNome());

        return vinculoEntity;
    }

    /**
     * This method is main purpose to show simple "Business" example
     * @param vinculo
     * @return
     */
    public boolean isVinculoNameIsNotEmpty(Vinculo vinculo) {
        return vinculo.getNome().isEmpty();
    }
    
}