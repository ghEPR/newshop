package com.gh.dao;

import com.gh.model.AdPosition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * @author finally
 */
@Repository
public interface AdPositionDao {

    AdPosition findAdById(@Param(value = "positionId") Integer positionId);

}
