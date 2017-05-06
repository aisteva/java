package lt.vu.asynchronous;

import lombok.extern.slf4j.Slf4j;
import lt.vu.entities.Klientas;
import lt.vu.usecases.cdi.RescueOrAsync;
import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.concurrent.Future;

@ApplicationScoped
@Slf4j
public class CompB implements Serializable {

    int count;


    @Inject
    @RescueOrAsync            // Asinchroninis komponentas negali naudoti @RequestScoped konteksto
    private EntityManager em; // Jei šis komponentas turi dirbti su DB per JPA


    @Futureable
    @Transactional(Transactional.TxType.REQUIRES_NEW) // be šios anotacijos negalėsime gauti @RescueOrAsync EntityManager
    public Future<String> asyncMethod() {
        System.out.println("Pradedamas klientu skaiciavimas");
        try {
            count = em.createNamedQuery("Klientas.findAll", Klientas.class).getResultList().size();
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }
        System.out.println("Kliento skaiciavimo darbai baigti");
        return new AsyncResult<>("Klientu skaiciavimas buvo atliktas: "+ count);
    }
}
