package com.gh.directive;

import com.gh.model.Goods;
import com.gh.service.GoodsService;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author finally
 */
@Component
public class GoodsListDirective extends BaseDirective {

    @Autowired
    private GoodsService goodsService;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body) throws TemplateException, IOException {

        Integer productCategoryId = getParams(params, "productCategoryId", Integer.class);
        Integer tagId = getParams(params, "tagId", Integer.class);
        Integer limit = getParams(params, "limit", Integer.class);

        List<Goods> goods = goodsService.findHotGoods(productCategoryId, tagId, limit);

        setVariable(env,body,"goods",goods);

    }
}
