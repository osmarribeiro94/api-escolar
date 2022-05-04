package org.controller;

import org.services.DisciplinaService;
import org.model.Disciplina;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/disciplina")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DisciplinaController {

    @Inject
    private DisciplinaService disciplinaServices;

    @GET
    public List<Disciplina> findAll() {
        return Disciplina.listAll();
    }

    @POST
    @Transactional
    public Response create(Disciplina disciplina) {
        Disciplina.persist(disciplina);
        return Response.ok(disciplina).status(201).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, Disciplina disciplina) {

        if (disciplinaServices.isDisciplinaNameIsNotEmpty(disciplina)) {
            return Response.ok("Nome was not found").type(MediaType.APPLICATION_JSON_TYPE).build();
        }

        Disciplina disciplinaEntity = disciplinaServices.update(id, disciplina);

        return Response.ok(disciplinaEntity).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        Disciplina disciplinaEntity = Disciplina.findById(id);

        if (disciplinaEntity == null) {
            throw new WebApplicationException("Disciplina with id " + id + " does not exist.", Response.Status.NOT_FOUND);
        }

        disciplinaEntity.delete();
        return Response.status(204).build();
    }


}