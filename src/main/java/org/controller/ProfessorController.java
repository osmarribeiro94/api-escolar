package org.controller;

import org.services.ProfessorService;
import org.model.Professor;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/professor")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfessorController {

    @Inject
    private ProfessorService professorServices;

    @GET
    public List<Professor> findAll() {
        return Professor.listAll();
    }

    @POST
    @Transactional
    public Response create(Professor professor) {
        Professor.persist(professor);
        return Response.ok(professor).status(201).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, Professor professor) {

        if (professorServices.isProfessorNameIsNotEmpty(professor)) {
            return Response.ok("Nome was not found").type(MediaType.APPLICATION_JSON_TYPE).build();
        }

        Professor professorEntity = professorServices.update(id, professor);

        return Response.ok(professorEntity).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        Professor professorEntity = Professor.findById(id);

        if (professorEntity == null) {
            throw new WebApplicationException("Professor with id " + id + " does not exist.", Response.Status.NOT_FOUND);
        }

        professorEntity.delete();
        return Response.status(204).build();
    }


}