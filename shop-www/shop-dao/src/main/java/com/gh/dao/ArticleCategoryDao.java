package com.gh.dao;

import com.gh.model.ArticleCategory;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author finally
 */
@Repository
public interface ArticleCategoryDao {

    @Select("SELECT id, name FROM xx_article_category WHERE grade = 0 ORDER BY orders LIMIT ${count}")
    List<ArticleCategory> findRootList(@Param(value = "count") Integer count);

}
