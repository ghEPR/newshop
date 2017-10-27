package com.gh.dao;

import com.gh.dto.GoodsDto;
import com.gh.model.Goods;
import com.gh.vo.GoodsVo;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author finally
 */
@Repository
public interface GoodsDao {

    @Select("SELECT g.id, g.name, g.caption, g.image, g.price FROM xx_goods g LEFT JOIN xx_product_category pc " +
            "ON g.product_category = pc.id LEFT JOIN xx_goods_tag gt " +
            "ON gt.goods = g.id WHERE pc.tree_path LIKE '${treePath}%' " +
            "AND gt.tags = #{tagId} AND g.is_marketable=1 LIMIT #{count}")
    List<Goods> findHotGoods(@Param(value = "treePath") String treePath,
                             @Param(value = "tagId") Integer tagId,
                             @Param(value = "count") Integer count);


    @Select("SELECT g.id, g.name, g.caption, g.image, g.price, g.market_price FROM xx_goods g " +
            "LEFT JOIN xx_goods_tag gt ON gt.goods = g.id " +
            "WHERE gt.tags = #{tagId} AND g.is_marketable = 1 " +
            "LIMIT #{count}")
    List<Goods> findHotGoodsByTagId(@Param(value = "tagId") Integer tagId,
                                    @Param(value = "count") Integer count);


    PageList<GoodsVo> selectForPage(GoodsDto goodsDto, PageBounds pageBounds);
}
