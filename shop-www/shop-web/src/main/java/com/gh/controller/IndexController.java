package com.gh.controller;

import com.gh.base.BaseController;
import com.gh.base.ResultInfo;
import com.gh.model.Navigation;
import com.gh.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author finally
 */
@RestController
@RequestMapping("index")
public class IndexController extends BaseController{


    @Autowired
    private NavigationService navigationService;

    @RequestMapping("index")
    public String index(Model model){
//        List<Navigation> topNavigations = navigationService.findByPosition(0);
//        List<Navigation> navigations = navigationService.findByPosition(1);
//        model.addAttribute("topNavigations",topNavigations);
//        model.addAttribute("navigations",navigations);

        RestTemplate restTemplate = new RestTemplate();
        ResultInfo resultInfo = restTemplate.getForObject("http://localhost:8081/hot_search_keyword/get",
                ResultInfo.class);
        String result = (String) resultInfo.getResult();
        model.addAttribute("hotKeyWords",result);

        return "index";
    }
}
