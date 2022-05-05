package org.resource;

import org.services.VinculoService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.model.Vinculo;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/vinculo")
@Tag(name="Vinculo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VinculoResource {

    @Inject
    private VinculoService vinculoServices;

    @GET
    public List<Vinculo> findAll() {
        return Vinculo.listAll();
    }

    @POST
    @Transactional
    public Response create(Vinculo vinculo) {
        Vinculo.persist(vinculo);
        return Response.ok(vinculo).status(201).build();
    }

    // @PUT
    // @Path("{id}")
    // @Transactional
    // public Response update(@PathParam("id") Long id, Vinculo vinculo) {

    //     if (vinculoServices.isVinculoNameIsNotEmpty(vinculo)) {
    //         return Response.ok("Nome was not found").type(MediaType.APPLICATION_JSON_TYPE).build();
    //     }

    //     Vinculo vinculoEntity = vinculoServices.update(id, vinculo);

    //     return Response.ok(vinculoEntity).build();
    // }

    // @DELETE
    // @Path("{id}")
    // @Transactional
    // public Response delete(@PathParam("id") Long id) {
    //     Vinculo vinculoEntity = Vinculo.findById(id);

    //     if (vinculoEntity == null) {
    //         throw new WebApplicationException("Vinculo with id " + id + " does not exist.", Response.Status.NOT_FOUND);
    //     }

    //     vinculoEntity.delete();
    //     return Response.status(204).build();
    // }


}