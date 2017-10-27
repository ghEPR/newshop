package com.gh.service;

import com.gh.constant.Constant;
import com.gh.constant.GoodsSortType;
import com.gh.dao.GoodsDao;
import com.gh.dto.GoodsDto;
import com.gh.model.Goods;
import com.gh.model.ProductCategory;
import com.gh.util.AssertUtil;
import com.gh.vo.GoodsVo;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author finally
 */
@Service
public class GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private ProductCategoryService productCategoryService;

    public List<Goods> findHotGoods(Integer categoryId, Integer tagId, Integer limit ){

        AssertUtil.intIsNotEmpty(tagId);

        if (null == limit) {
            limit = Constant.TEN;
        }

        String treePath = "";

        List<Goods> goods = null;

        if (null != categoryId && categoryId > 1) {

            ProductCategory productCategory = productCategoryService.findTreePathById(categoryId);

            // 根級分類
            if (productCategory.getGrade() == 0) {
                treePath = ","+productCategory.getId()+",";
            } else {
                treePath = productCategory.getTreePath() + productCategory.getId();
            }

            goods = goodsDao.findHotGoods(treePath, tagId, limit);
        } else {
            goods = goodsDao.findHotGoodsByTagId(tagId,limit);
        }

        return goods;

    }


    /**
     * 分页查询
     * @param goodsDto  分页参数
     * @return
     */
    public PageList<GoodsVo> selectForPage(GoodsDto goodsDto) {

        if (StringUtils.isBlank(goodsDto.getSort())) {
            //默认日期的降序
            goodsDto.setSort(GoodsSortType.create_date.getSortType());
        }

        PageList<GoodsVo> goodsVo = goodsDao.selectForPage(goodsDto,
                goodsDto.buildPageBounds());

        return null;

    }
}
