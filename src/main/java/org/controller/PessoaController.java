package org.controller;

import org.services.PessoaService;
import org.repository.PessoaRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/pessoa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaController {

    @Inject
    private PessoaService pessoaServices;

    @GET
    public List<PessoaRepository> findAll() {
        return PessoaRepository.listAll();
    }

    @POST
    @Transactional
    public Response create(PessoaRepository pessoa) {
        PessoaRepository.persist(pessoa);
        return Response.ok(pessoa).status(201).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, PessoaRepository pessoa) {

        if (pessoaServices.isFoodNameIsNotEmpty(pessoa)) {
            return Response.ok("Food was not found").type(MediaType.APPLICATION_JSON_TYPE).build();
        }

        PessoaRepository pessoaEntity = pessoaServices.update(id, pessoa);

        return Response.ok(pessoaEntity).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        PessoaRepository pessoaEntity = PessoaRepository.findById(id);

        if (pessoaEntity == null) {
            throw new WebApplicationException("Food with id " + id + " does not exist.", Response.Status.NOT_FOUND);
        }

        pessoaEntity.delete();
        return Response.status(204).build();
    }
}