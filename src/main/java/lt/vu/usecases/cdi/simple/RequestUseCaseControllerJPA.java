package lt.vu.usecases.cdi.simple;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lt.vu.entities.Filmas;
import lt.vu.entities.Klientas;
import lt.vu.entities.Uzsakymas;
import lt.vu.usecases.cdi.dao.FilmasDAO;
import lt.vu.usecases.cdi.dao.KlientasDAO;
import lt.vu.usecases.cdi.dao.UzsakymasDAO;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model // tas pats kaip: @Named ir @RequestScoped
@Slf4j
public class RequestUseCaseControllerJPA {

    @Getter
    private Klientas klientas = new Klientas();
    @Getter
    private Uzsakymas uzsakymas = new Uzsakymas();

    @Getter
    private Filmas filmas = new Filmas();

    @Inject
    private UzsakymasDAO uzsakymasDAO;
    @Inject
    private KlientasDAO klientasDAO;
    @Inject
    private FilmasDAO filmasDAO;

    @Transactional
    public void createCourseStudent() {
       // klientas.getUzsakymasList().add(uzsakymas);
        //uzsakymas.getKlientoNr();
        //uzsakymasDAO.create(uzsakymas);
        klientasDAO.create(klientas);
        log.info("Maybe OK...");
    }

    public List<Filmas> getAllFilms() { return filmasDAO.getAllFilms();
    }

    public List<Klientas> getAllClients() { return klientasDAO.getAllClients();
    }

    //public List<Uzsakymas> getAllOrders() { return uzsakymasDAO.getAllOrders();
    //}

}