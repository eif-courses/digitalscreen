package eif.viko.lt.backend.domain.resource;

import eif.viko.lt.backend.domain.model.Exhibit;
import eif.viko.lt.backend.domain.service.ExhibitService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/exhibits")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExhibitResource {

  @Inject
  ExhibitService service;

  @GET
  public Response list() {
    return Response.ok(service.findAll()).build();
  }

  @GET
  @Path("/{id}")
  public Response get(@PathParam("id") Long id) {
    var response = service.findById(id);
    if(response.isPresent()){
      return Response.ok(service.findById(id)).build();
    }
    return Response
        .ok("Exhibit not exists!")
        .status(Response.Status.NOT_FOUND).build();
  }

  @POST
  @Transactional
  public Response create(Exhibit exhibit) {
    service.create(exhibit);
    return Response.ok(exhibit).status(Response.Status.CREATED).build();
  }

  @PUT
  @Path("/{id}")
  @Transactional
  public Response update(@PathParam("id") Long id, Exhibit exhibit) {
    var entity = service.findById(id);

    if(entity.isPresent()) {
      service.update(id, exhibit);
      return Response.ok(exhibit).build();
    }
    return Response.ok("Did not update successfully!").build();
  }

  @DELETE
  @Path("/{id}")
  @Transactional
  public Response delete(@PathParam("id") Long id) {
    var entity = service.findById(id);
    if(entity.isPresent()) {
      service.delete(id);
      return Response.ok("Exhibit successfully deleted!").build();
    }
    return Response.ok("Exhibit not exist!").status(Response.Status.NOT_FOUND).build();
  }
}
