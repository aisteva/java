package lt.vu.rest;

import lt.vu.entities.Klientas;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
}
