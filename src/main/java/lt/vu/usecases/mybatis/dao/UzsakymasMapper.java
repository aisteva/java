package lt.vu.usecases.mybatis.dao;

import lt.vu.usecases.mybatis.model.Uzsakymas;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface UzsakymasMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.uzsakymas
     *
     * @mbg.generated Thu Mar 23 09:42:23 EET 2017
     */
    int deleteByPrimaryKey(Integer uzsakymoNr);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.uzsakymas
     *
     * @mbg.generated Thu Mar 23 09:42:23 EET 2017
     */
    int insert(Uzsakymas record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.uzsakymas
     *
     * @mbg.generated Thu Mar 23 09:42:23 EET 2017
     */
    Uzsakymas selectByPrimaryKey(Integer uzsakymoNr);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.uzsakymas
     *
     * @mbg.generated Thu Mar 23 09:42:23 EET 2017
     */
    List<Uzsakymas> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.uzsakymas
     *
     * @mbg.generated Thu Mar 23 09:42:23 EET 2017
     */
    int updateByPrimaryKey(Uzsakymas record);
}