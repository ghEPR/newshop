package com.gh.directive;

import com.gh.model.Brand;
import com.gh.service.BrandService;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author finally
 */
@Component
public class BrandListDirective extends BaseDirective{
    
    @Autowired
    private BrandService brandService;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body) throws TemplateException, IOException {

        Integer productCategoryId = getParams(params, "productCategoryId", Integer.class);
        Integer limit = getParams(params, "limit", Integer.class);

        List<Brand> brands = brandService.findProductCategoryBrands(productCategoryId,limit);

        setVariable(env,body,"productCategoryId",brands);

    }
}
