package com.example.api.resource;

import com.example.api.models.AddressModel;
import com.example.api.models.Carnet;
import com.example.api.dao.CarnetsDao;
import com.example.api.dao.CarnetsDaoImpl;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Map;

@Path("carnets")
public class SampleResource {

    private static Carnet carnet = new Carnet();
    private static CarnetsDao carnetsDao = new CarnetsDaoImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response lister() {
        AddressModel adresse = new AddressModel("Imama", 123, "Tlemcen");
        carnetsDao.addAddress("Adnane", adresse, carnet);
        Map<String, AddressModel> ensemble = carnetsDao.getAddresses(carnet);
        return Response.ok(ensemble).build();
    }

    @POST
    @Path("{personne}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response enregistrer(@PathParam("personne") String personne, AddressModel newAddress) {
        carnetsDao.addAddress(personne, newAddress, carnet);
        return Response.ok().build();
    }

    @DELETE
    @Path("{personne}")
    public Response effacer(@PathParam("personne") String personne) {
        carnetsDao.removeAddress(personne, carnet);
        Map<String, AddressModel> ensemble = carnetsDao.getAddresses(carnet);
        return Response.ok(ensemble).build();
    }

    @GET
    @Path("{personne}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response chercher(@PathParam("personne") String personne) {
        AddressModel addressModel = carnetsDao.getAddress(personne, carnet);
        return Response.ok(addressModel).build();
    }
}