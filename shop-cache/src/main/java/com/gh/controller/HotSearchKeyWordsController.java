package com.gh.controller;

import com.gh.base.BaseController;
import com.gh.base.ResultInfo;
import com.gh.constant.Constant;
import com.gh.service.HotSearchKeyWordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author finally
 */

@RestController
@RequestMapping("hot_search_keyword")
public class HotSearchKeyWordsController extends BaseController{

    @Autowired
    private HotSearchKeyWordsService hotSearchKeyWordsService;

    @RequestMapping("get")
    public ResultInfo findHotSearchKeywords(){
        List<String> keywords = hotSearchKeyWordsService.find();
        return success(keywords);
    }

    @RequestMapping("set")
    public ResultInfo addHotSearchKeywords(String keywords){
        Long aLong = hotSearchKeyWordsService.set(keywords);
        return success(aLong);
    }
}
