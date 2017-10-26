package com.gh.dao;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.gh.model.Navigation;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author finally
 */
@Repository
public interface NavigationDao {

    /**
     * @param position
     * @return
     */
    @Select("select id, is_blank_target, name, url from " +
            " xx_navigation where position = ${position} order by orders")
    List<Navigation> findByPosition(@Param("position") Integer position);

}
