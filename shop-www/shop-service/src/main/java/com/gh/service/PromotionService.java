package com.gh.service;

import com.gh.dao.PromotionDao;
import com.gh.exception.ParamException;
import com.gh.model.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author finally
 */
@Service
public class PromotionService {

    @Autowired
    private PromotionDao promotionDao;

    /**
     * @param productCagetoryId
     * @return
     */
    public List<Promotion> findProductCategoryPromotions(Integer productCagetoryId){

        if (null == productCagetoryId || productCagetoryId < 1){
            throw new ParamException();
        }

        List<Promotion> promotions = promotionDao.findProductCategoryPromotions(productCagetoryId);
        return promotions;
    }
}
