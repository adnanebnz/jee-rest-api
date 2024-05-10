package com.example.api.resource;

import com.example.api.models.AddressModel;
import com.example.api.models.Carnet;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.HashMap;

@Path("carnets")
public class SampleResource {

    private static Carnet carnet = new Carnet();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response lister() {
        AddressModel adresse = new AddressModel("Imama", 123, "Paris");
        carnet.ensemble.put("Adnane", adresse);
        HashMap<String, AddressModel> ensemble = carnet.ensemble;
        return Response.ok(ensemble).build();
    }

    @POST
    @Path("{personne}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response enregistrer(@PathParam("personne") String personne, AddressModel newAddress) {
        carnet.enregistrer(personne, newAddress);
        return Response.ok().build();
    }

    @DELETE
    @Path("{personne}")
    public Response effacer(@PathParam("personne") String personne) {
        carnet.effacer(personne);
        carnet.lister();
        HashMap<String, AddressModel> ensemble = carnet.ensemble;
        return Response.ok(ensemble).build();
    }

    @GET
    @Path("{personne}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response chercher(@PathParam("personne") String personne) {
        AddressModel AddressModel = carnet.chercher(personne);
        return Response.ok(AddressModel).build();
    }
}