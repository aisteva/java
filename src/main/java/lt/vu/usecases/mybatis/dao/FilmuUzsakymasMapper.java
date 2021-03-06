package lt.vu.usecases.mybatis.dao;

import lt.vu.usecases.mybatis.model.FilmuUzsakymas;
import org.apache.ibatis.annotations.Param;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface FilmuUzsakymasMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.filmu_uzsakymas
     *
     * @mbg.generated Thu Mar 23 09:42:23 EET 2017
     */
    int deleteByPrimaryKey(@Param("filmoId") Integer filmoId, @Param("uzsakymoNr") Integer uzsakymoNr);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.filmu_uzsakymas
     *
     * @mbg.generated Thu Mar 23 09:42:23 EET 2017
     */
    int insert(FilmuUzsakymas record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.filmu_uzsakymas
     *
     * @mbg.generated Thu Mar 23 09:42:23 EET 2017
     */
    List<FilmuUzsakymas> selectAll();
}