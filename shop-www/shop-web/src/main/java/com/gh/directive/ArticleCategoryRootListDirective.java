package com.gh.directive;

import com.gh.model.ArticleCategory;
import com.gh.service.ArticleCategoryService;
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
public class ArticleCategoryRootListDirective extends BaseDirective {

    @Autowired
    private ArticleCategoryService articleCategoryService;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body) throws TemplateException, IOException {

        Integer limit = getParams(params, "limit", Integer.class);

        List<ArticleCategory> articleCategories = articleCategoryService.findRootList(limit);

        setVariable(env,body,"articleCategories",articleCategories);

    }
}
