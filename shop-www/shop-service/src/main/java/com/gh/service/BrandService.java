package com.gh.service;

import com.alibaba.fastjson.serializer.ASMSerializerFactory;
import com.gh.constant.Constant;
import com.gh.dao.BrandDao;
import com.gh.exception.ParamException;
import com.gh.model.Brand;
import com.gh.util.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author finally
 */
@Service
public class BrandService {

    @Autowired
    private BrandDao brandDao;

    public List<Brand> findProductCategoryBrands(Integer productCategoryId,Integer limit){

        if (null == limit) {
            limit = Constant.TEN;
        }

        List<Brand> brands = null;

        if (null != productCategoryId || productCategoryId < 1) {
            //查询分类品牌
            brands = brandDao.findProductCategoryBrands(productCategoryId,limit);
        } else {
            brands =brandDao.findBrands(limit);
        }


        return brands;

    }
}
