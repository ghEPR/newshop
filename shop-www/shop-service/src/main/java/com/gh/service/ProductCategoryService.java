package com.gh.service;

import com.gh.constant.Constant;
import com.gh.dao.ProductCategoryDao;
import com.gh.model.ProductCategory;
import com.gh.util.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author finally
 */
@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    public List<ProductCategory> findRootList(Integer limit){
        if (null == limit) {
            limit = Constant.SIX;
        }

        List<ProductCategory> productCategories = productCategoryDao.findRootList(limit);
        return productCategories;

    }

    /**
     * @param parentId
     * @return
     */
    public List<ProductCategory> findChildrenList(Integer parentId,Integer limit){

        AssertUtil.intIsNotEmpty(parentId);

        if (null == limit) {
            limit = Constant.TEN;
        }

        List<ProductCategory> childrenList = productCategoryDao.findChildrenList(parentId,limit);
        return childrenList;

    }

    public ProductCategory findTreePathById(Integer categoryId) {

        AssertUtil.intIsNotEmpty(categoryId);

        ProductCategory productCategory = productCategoryDao.findTreePathById(categoryId);

        return productCategory;

    }
}
