package lt.vu.interceptor;

import lt.vu.entities.Filmas;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Aiste on 2017-05-06.
 */
@MyInterceptor
@Stateful
@Named
public class MoviesCatalog implements Serializable{

    @Inject
    private EntityManager em;

    private static final long serialVersionUID = 635L;
    public List<Filmas> getMoviesList() {
        List<Filmas> moviesAvailable = em.createNamedQuery("Filmas.findAll", Filmas.class).getResultList();
        return moviesAvailable;
    }

}
