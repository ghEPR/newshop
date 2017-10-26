package com.gh.dao;

import com.gh.model.Promotion;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author finally
 */
@Repository
public interface PromotionDao {


    /**
     * 查询分类促销
     * @param productCategoryId
     * @param count
     * @return
     */
    @Select("SELECT p.id,p.name,p.image FROM xx_promotion p LEFT JOIN " +
            "xx_product_category_promotion pcp ON p.id = pcp.promotions " +
            "WHERE product_categories = ${productCategoryId} LIMIT #{count}")
    List<Promotion> findProductCategoryPromotions(@Param(value = "productCategoryId") Integer productCategoryId,
                                                  @Param(value = "count") Integer count);


    /**
     * 获取三个促销
     * @param limit
     * @return
     */
    @Select("SELECT t1.id, image, title FROM xx_promotion t1 order by id limit #{limit}")
    List<Promotion> findPromotions(@Param(value = "limit") Integer limit);
}
