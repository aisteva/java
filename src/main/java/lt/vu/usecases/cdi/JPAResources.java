package lt.vu.usecases.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.SynchronizationType;

@ApplicationScoped
public class JPAResources {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @Default
    @Produces
    @RequestScoped // Smalsiems: kodel ne @TransactionScoped? Kada @RequestScoped bus blogai o @TransactionScoped - gerai?
    private EntityManager createJTAEntityManager() {
        /*
         * From JavaDoc: Create a new JTA application-managed EntityManager...
         */
        return emf.createEntityManager(SynchronizationType.SYNCHRONIZED);
    }

//    private void closeUnsynchronizedEntityManager(@Disposes EntityManager em) {
//        em.close();
//    }



    @Produces
    @RescueOrAsync // Savo susikurta anotacija (Qualifier), skirta: 1. Asinchroniniams komponentams 2. JPA klaidoms apdoroti (pvz.: OptimisticLockException)
    @Dependent
    private EntityManager createJTATransactionalEntityManager() {
        return emf.createEntityManager(SynchronizationType.SYNCHRONIZED);
    }
    private void closeDefaultEntityManager(@Disposes @Default EntityManager em) {
        em.close();
    }
    private void closeResqueEntityManager(@Disposes @RescueOrAsync EntityManager em) {
        em.close();
    }

}
