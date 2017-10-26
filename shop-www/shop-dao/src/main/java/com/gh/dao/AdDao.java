package com.gh.dao;

import com.gh.model.Ad;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author finally
 */
@Repository
public interface AdDao {

    @Select("SELECT id,title,path FROM xx_ad WHERE ad_position = ${positionId}")
    List<Ad> findById(@Param(value = "positionId") Integer positionId);

}
