package com.gh.service;

import com.gh.dao.NavigationDao;
import com.gh.model.Navigation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


/**
 * @author finally
 */
@Service
public class NavigationService {

    /**
     *
     */
    @Autowired
    private NavigationDao navigationDao;

    /**
     * @param pojo
     * @return
     */
    public int insert(Navigation pojo){
        return navigationDao.insert(pojo);
    }

    /**
     * @param pojos
     * @return
     */
    public int insertList(List< Navigation> pojos){
        return navigationDao.insertList(pojos);
    }


    /**
     * @param position
     * @return
     */
    public List<Navigation> findByPosition(Integer position){

        List<Navigation> navigations = navigationDao.findByPosition(position);

        return navigations;
    }

    /**
     * @param pojo
     * @return
     */
    public int update(Navigation pojo){
        return navigationDao.update(pojo);
    }

}
