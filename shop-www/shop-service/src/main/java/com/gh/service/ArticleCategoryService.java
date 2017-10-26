package com.gh.service;

import com.gh.constant.Constant;
import com.gh.dao.ArticleCategoryDao;
import com.gh.model.ArticleCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author finally
 */
@Service
public class ArticleCategoryService {

    @Autowired
    private ArticleCategoryDao articleCategoryDao;

    public List<ArticleCategory> findRootList(Integer limit){

        if (limit == null) {
            limit = Constant.TWO;
        }
        List<ArticleCategory> articleCategories = articleCategoryDao.findRootList(limit);

        return articleCategories;

    }

}
