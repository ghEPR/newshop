package com.gh.directive;

import com.gh.model.ProductCategory;
import com.gh.service.ProductCategoryService;
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
public class ProductCategoryRootListDirective extends BaseDirective{

    @Autowired
    private ProductCategoryService productCategoryService;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body) throws TemplateException, IOException {

        Integer limit = getParams(params, "limit", Integer.class);

        List<ProductCategory> productCategories = productCategoryService.findRootList(limit);

        setVariable(env,body,"productCategories",productCategories);
    }
}
