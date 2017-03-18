package lt.vu.usecases.cdi.dao;

import lt.vu.entities.Uzsakymas;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;



@ApplicationScoped
public class UzsakymasDAO {
    @Inject
    private EntityManager em;

    public void create(Uzsakymas uzsakymas) {
        em.persist(uzsakymas);
    }
}
