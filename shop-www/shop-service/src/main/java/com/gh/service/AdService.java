package com.gh.service;

import com.gh.dao.AdDao;
import com.gh.model.Ad;
import com.gh.util.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author finally
 */
@Service
public class AdService {

    @Autowired
    private AdDao adDao;

    public List<Ad> findById(Integer positionId){

        AssertUtil.intIsNotEmpty(positionId);

        List<Ad> ads = adDao.findById(positionId);

        return ads;
    }

}
