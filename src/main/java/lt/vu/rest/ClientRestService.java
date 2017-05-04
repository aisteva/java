package lt.vu.rest;

import lt.vu.entities.Klientas;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Aiste on 2017-04-27.
 */
@ApplicationScoped
@Path("/klientas")
@Produces(MediaType.APPLICATION_JSON)
public class ClientRestService {

    @Inject
    private EntityManager em;

    @GET
    @Path("/{klientoNr}")
    public Klientas find(@PathParam("klientoNr") Integer klientoNr){
        return em.find(Klientas.class, klientoNr);
    }



    @PUT
    @Path("/create")
    @Transactional
    public Klientas create(
            @QueryParam("klientoNr")Integer klientoNr,
            @QueryParam("vardas")String vardas,
            @QueryParam("pavarde")String pavarde,
            @QueryParam("telefonas")String telefonas){
        Klientas klientas = new Klientas();
        klientas.setKlientoNr(klientoNr);
        klientas.setVardas(vardas);
        klientas.setPavarde(pavarde);
        klientas.setTelefonas(telefonas);
        em.persist(klientas);

        return klientas;


    }

    @POST
    @Path("/update/{klientoNr}")
    @Transactional
    public Response update(@PathParam("klientoNr") Integer klientoNr,
                           @QueryParam("vardas") String vardas,
                           @QueryParam("pavarde") String pavarde,
                           @QueryParam("telefonas") String telefonas){
        Klientas klientas = em.find(Klientas.class, klientoNr);
        if(klientas == null){
            throw new IllegalArgumentException("Kliento nr.: "
                    +klientoNr+ "nerastas");
        }
        klientas.setVardas(vardas);
        klientas.setPavarde(pavarde);
        klientas.setTelefonas(telefonas);
        em.merge(klientas);
        return Response.ok(klientas).build(); //low level API
    }


}
