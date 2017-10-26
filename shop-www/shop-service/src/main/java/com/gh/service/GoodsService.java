package com.gh.service;

import com.gh.constant.Constant;
import com.gh.dao.GoodsDao;
import com.gh.model.Goods;
import com.gh.util.AssertUtil;
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

    public List<Goods> findHotGoods(Integer categoryId, Integer tagId, Integer limit ){

        AssertUtil.intIsNotEmpty(tagId);

        if (null == limit) {
            limit = Constant.TEN;
        }

        List<Goods> goods = null;

        if (null != categoryId && categoryId > 1) {
            goods = goodsDao.findHotGoods(categoryId, tagId, limit);
        } else {
            goods = goodsDao.findHotGoodsByTagId(tagId,limit);
        }

        return goods;

    }
}
