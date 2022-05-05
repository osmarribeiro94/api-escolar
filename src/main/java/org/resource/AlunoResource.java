package org.resource;

import org.services.*;
import org.DTO.AlunoDTO;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.model.Aluno;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/aluno")
@Tag(name = "Aluno")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AlunoResource {

    @Inject
    private AlunoService alunoServices;

    @GET
    public List<Aluno> findAll() {
        return Aluno.listAll();
    }

    @POST
    @Transactional
    public Response create(AlunoDTO dto) {

        Aluno aluno = alunoServices.create(dto);

        return Response.ok(aluno).status(201).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, AlunoDTO dto) {

        if (alunoServices.isAlunoNameIsNotEmpty(dto)) {
            return Response.ok("Nome was not found").type(MediaType.APPLICATION_JSON_TYPE).build();
        }

        Aluno alunoEntity = alunoServices.update(id, dto);

        return Response.ok(alunoEntity).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        Aluno alunoEntity = Aluno.findById(id);

        if (alunoEntity == null) {
            throw new WebApplicationException("Aluno with id " + id + " does not exist.", Response.Status.NOT_FOUND);
        }

        alunoEntity.delete();
        return Response.status(204).build();
    }

}