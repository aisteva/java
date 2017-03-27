package lt.vu.usecases.cdi.simple;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lt.vu.usecases.mybatis.dao.UzsakymasMapper;
import lt.vu.usecases.mybatis.model.Uzsakymas;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;


@Model // tas pats kaip: @Named ir @RequestScoped
@Slf4j
public class UzsakymasControllerMyBatis {

    @Getter
    private Uzsakymas uzsakymas = new Uzsakymas();

    @Inject
    private UzsakymasMapper uzsakymasMapper;


    public List<lt.vu.usecases.mybatis.model.Uzsakymas> getAllOrders() {
        return uzsakymasMapper.selectAll();
    }



}
