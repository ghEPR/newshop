package com.gh.dao;

import com.gh.model.Brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author finally
 */
@Repository
public interface BrandDao {

    @Select("SELECT t1.id, t1.name FROM xx_brand t1 LEFT JOIN xx_product_category_brand t2 " +
            " on t1.id = t2.brands WHERE t2.product_categories = ${productCategoryId} ORDER BY orders LIMIT ${count}")
    List<Brand> findProductCategoryBrands(@Param(value = "productCategoryId") Integer productCategoryId,
                                          @Param(value = "count") Integer count);

    @Select("SELECT id,name,logo FROM xx_brand ORDER BY orders LIMIT #{limit}")
    List<Brand> findBrands(@Param(value = "limit") Integer limit);
}
