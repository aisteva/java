package lt.vu.usecases.cdi.optimisticLocking;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lt.vu.entities.Klientas;
import lt.vu.usecases.cdi.dao.KlientasDAO;
import org.omnifaces.cdi.ViewScoped;
import org.primefaces.context.RequestContext;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
@Slf4j
public class EditClientUseCaseController implements Serializable {

    /*
     * Būsena, kurią saugome ViewScoped kontekste:
     */
    @Getter private Klientas selectedClient;
    @Getter private Klientas conflictingClient;
    @Getter private List<Klientas> allClients;



    /*
     * DAO:
     */
    @Inject private KlientasDAO klientasDAO;


    @PostConstruct
    public void init() {
        reloadAll();
    }

    public void prepareForEditing(Klientas klientas) {
        selectedClient = klientas;
        conflictingClient = null;
    }

    @Transactional
    public void updateSelectedClient() {
        try {
            klientasDAO.updateAndFlush(selectedClient);
            reloadAll();
        } catch (OptimisticLockException ole) {
            conflictingClient = klientasDAO.findByKlientoNr(selectedClient.getKlientoNr());
            // Pranešam PrimeFaces dialogui, kad užsidaryti dar negalima:
            RequestContext.getCurrentInstance().addCallbackParam("validationFailed", true);
        }
    }

    @Transactional
    public void overwriteClient() {
        selectedClient.setOptLockVersion(conflictingClient.getOptLockVersion());
        updateSelectedClient();
    }

    public void reloadAll() {
        allClients = klientasDAO.getAllClients();
    }

}
