package lt.vu.usecases.cdi.dao;

import lt.vu.entities.Filmas;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FilmasDAO {


    @Inject
    private EntityManager em;

    public void create(Filmas filmas) {
        em.persist(filmas);
    }

    public List<Filmas> getAllFilms() {
        return em.createNamedQuery("Filmas.findAll", Filmas.class).getResultList();
    }


    public Filmas findByMetai(Integer metai){
        return em.find(Filmas.class, metai);
    }
}
