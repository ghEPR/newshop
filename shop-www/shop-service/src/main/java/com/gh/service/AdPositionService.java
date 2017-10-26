package com.gh.service;

import com.gh.dao.AdPositionDao;
import com.gh.model.AdPosition;
import com.gh.util.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author finally
 */
@Service
public class AdPositionService {

    @Autowired
    private AdPositionDao adPositionDao;

    public AdPosition findAdById (Integer positionId) {
        AssertUtil.intIsNotEmpty(positionId);

        AdPosition adPosition = adPositionDao.findAdById(positionId);

        return adPosition;
    }

}
