package com.gh.dao;

import com.gh.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    /**
     * 根据用户id获取用户信息
     * @param id
     * @return
     */
    @Select("select * from xx_user where user_id = ${id}")
    User findById(@Param(value = "id") Integer id);

}
