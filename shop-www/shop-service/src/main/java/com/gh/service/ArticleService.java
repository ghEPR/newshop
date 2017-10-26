package com.gh.service;

import com.gh.constant.Constant;
import com.gh.dao.ArticleDao;
import com.gh.model.Article;
import com.gh.util.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author finally
 */
@Service
public class ArticleService {


    @Autowired
    private ArticleDao articleDao;

    /**
     * 查询分类下的文章
     * @param categoryId
     * @param limit
     * @return
     */
    public List<Article> findByCategoryId(Integer categoryId, Integer limit){

        AssertUtil.intIsNotEmpty(categoryId);
        if (null == limit) {
            limit = Constant.TEN;
        }

        List<Article> articles = articleDao.findByCategoryId(categoryId, limit);

        return articles;

    }

}
