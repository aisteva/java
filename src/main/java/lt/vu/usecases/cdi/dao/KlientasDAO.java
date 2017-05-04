package lt.vu.usecases.cdi.dao;


import lt.vu.entities.Klientas;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class KlientasDAO {

    @Inject
    private EntityManager em;

    public void create(Klientas klientas) {
        em.persist(klientas);
    }

    public void updateAndFlush(Klientas klientas){
        em.merge(klientas);
        em.flush();
    }

    public List<Klientas> getAllClients() {
        return em.createNamedQuery("Klientas.findAll", Klientas.class).getResultList();
    }

    public Klientas findByKlientoNr(Integer klientoNr){
        return em.find(Klientas.class, klientoNr);
    }
}