package com.gh.dao;

import com.gh.model.Article;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author finally
 */
@Repository
public interface ArticleDao {

    @Select("SELECT id, title FROM xx_article WHERE article_category = ${categoryId} " +
            "AND is_publication = 1 ORDER BY id LIMIT ${count}")
    List<Article> findByCategoryId(@Param(value = "categoryId") Integer categoryId,
                                   @Param(value = "count") Integer count);

}
