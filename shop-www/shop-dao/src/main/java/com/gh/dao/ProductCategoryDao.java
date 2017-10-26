package com.gh.dao;

import com.gh.model.ProductCategory;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author finally
 */
@Repository
public interface ProductCategoryDao {

    /**
     * 查询根级分类
     * @return
     */
    @Select("SELECT id, name FROM xx_product_category WHERE grade = 0 ORDER BY orders LIMIT ${count}")
    List<ProductCategory> findRootList(@Param(value = "count") Integer count);

    /**
     * 查询子级分类
     * @param parentId
     * @return
     */
    @Select("SELECT id, name FROM xx_product_category WHERE parent = ${parentId} ORDER BY orders LIMIT ${count}")
    List<ProductCategory> findChildrenList(@Param(value = "parentId") Integer parentId,
                                           @Param(value = "count") Integer count);

}
