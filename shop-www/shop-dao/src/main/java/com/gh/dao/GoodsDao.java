package com.gh.dao;

import com.gh.model.Goods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author finally
 */
@Repository
public interface GoodsDao {

    @Select("SELECT g.id, g.NAME, g.caption, g.image, g.price FROM xx_goods g LEFT JOIN xx_product_category pc " +
            "ON g.product_category = pc.id LEFT JOIN xx_goods_tag gt " +
            "ON gt.goods = g.id WHERE pc.tree_path LIKE ',${categoryId},%' " +
            "AND gt.tags = #{tagId} AND g.is_marketable=1 LIMIT #{count}")
    List<Goods> findHotGoods(@Param(value = "categoryId") Integer categoryId,
                             @Param(value = "tagId") Integer tagId,
                             @Param(value = "count") Integer count);

}
