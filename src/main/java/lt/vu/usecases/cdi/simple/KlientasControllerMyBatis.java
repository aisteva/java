package lt.vu.usecases.cdi.simple;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lt.vu.usecases.mybatis.dao.KlientasMapper;
import lt.vu.usecases.mybatis.model.Klientas;
import org.mybatis.cdi.Transactional;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model // tas pats kaip: @Named ir @RequestScoped
@Slf4j
public class KlientasControllerMyBatis {


    @Getter
    private Klientas klientas = new Klientas();

    @Inject
    private KlientasMapper klientasMapper;



    public List<lt.vu.usecases.mybatis.model.Klientas> getAllClients() {
        return klientasMapper.selectAll();
    }


    @Transactional
    public void createClient() {
        klientasMapper.insert(klientas);
        log.info("Maybe OK...");
    }



}
