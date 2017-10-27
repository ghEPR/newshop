package com.gh.controller;

import com.gh.base.BaseController;
import com.gh.constant.GoodsSortType;
import com.gh.dto.GoodsDto;
import com.gh.service.GoodsService;
import com.gh.vo.GoodsVo;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author finally
 */
@Controller
@RequestMapping("goods")
public class GoodsController extends BaseController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("search")
    public String search(GoodsDto goodsDto, Model model){

        PageList<GoodsVo> goodsVos = goodsService.selectForPage(goodsDto);

        setModel(model,goodsVos,goodsDto);

        return "goods/search";
    }


    public void setModel(Model model , PageList<GoodsVo> goodsVos , GoodsDto goodsDto){
        model.addAttribute("resultList",goodsVos);
        model.addAttribute("paginator",goodsVos.getPaginator());
        model.addAttribute("keyword",goodsDto.getKeyword());
        model.addAttribute("goodsDto",goodsDto);

        //获取排序字段
        String showSortType = GoodsSortType.findShowType(goodsDto.getSort());

        model.addAttribute("showSortType",showSortType);
        model.addAttribute("sorts",GoodsSortType.values());
    }
}
