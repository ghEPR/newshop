package com.gh.directive;

import com.gh.model.Promotion;
import com.gh.service.PromotionService;
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
public class PromotionListDirective extends BaseDirective{

    @Autowired
    private PromotionService promotionService;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body) throws TemplateException, IOException {

        Integer productCagetoryId = getParams(params, "promotions", Integer.class);
        Integer limit = getParams(params, "limit", Integer.class);

        List<Promotion> promotions = promotionService.findProductCategoryPromotions(productCagetoryId,limit);

        setVariable(env,body,"promotions",promotions);
    }
}
