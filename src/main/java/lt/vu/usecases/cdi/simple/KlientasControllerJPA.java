package lt.vu.usecases.cdi.simple;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lt.vu.entities.Klientas;
import lt.vu.usecases.cdi.dao.KlientasDAO;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model // tas pats kaip: @Named ir @RequestScoped
@Slf4j
public class KlientasControllerJPA {

    @Getter
    private Klientas klientas = new Klientas();


    @Inject
    private KlientasDAO klientasDAO;


    @Transactional
    public void createClient() {
        klientasDAO.create(klientas);
        log.info("Maybe OK...");
    }


    public List<Klientas> getAllClients() { return klientasDAO.getAllClients();
    }

}
