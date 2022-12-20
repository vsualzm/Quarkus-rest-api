package controller;


import dto.AlatDto;
import model.Alat;
import service.AlatService;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/alat")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AlatController {

    @Inject
    AlatService service;


    @GET
    @Path("/get")
    public Response listAlat(){
        List<Alat> alat = service.listAlat();
        return Response.ok(alat).build();
    }

    @POST
    @Path("/post")
    public Response saveAlat(AlatDto dto){
        Alat alat = service.saveAlat(dto);
        return Response.ok(alat).status(201).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateAlat(@PathParam("id") Long id, AlatDto dto){
        service.updateAlat(id, dto);
        return Response.status(204).build();
    }

    @DELETE
    @Path("/{id}")
    public Response removeAlat(@PathParam("id") Long id){
        service.removeAlat(id);
        return Response.status(204).build();
    }










}
