package lt.vu.usecases.cdi.dao;

import lt.vu.entities.Uzsakymas;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;


@ApplicationScoped
public class UzsakymasDAO {
    @Inject
    private EntityManager em;

    public void create(Uzsakymas uzsakymas) {
        em.persist(uzsakymas);
    }

    public List<Uzsakymas> getAllOrders() {
        return em.createNamedQuery("Uzsakymas.findAll", Uzsakymas.class).getResultList();
    }
}
