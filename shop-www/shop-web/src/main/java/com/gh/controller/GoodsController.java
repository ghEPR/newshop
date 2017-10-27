package com.gh.controller;

import com.gh.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author finally
 */
@Controller
@RequestMapping("goods")
public class GoodsController extends BaseController {

    @RequestMapping("search")
    public String search(String keyword, Model model){
        model.addAttribute("searchKey",keyword);

        return "goods/search";
    }
}
