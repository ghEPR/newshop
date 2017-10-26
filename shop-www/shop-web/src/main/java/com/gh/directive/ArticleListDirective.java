package com.gh.directive;

import com.gh.model.Article;
import com.gh.service.ArticleService;
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
public class ArticleListDirective extends BaseDirective {

    @Autowired
    private ArticleService articleService;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body) throws TemplateException, IOException {

        Integer categoryId = getParams(params, "categoryId", Integer.class);
        Integer limit = getParams(params, "limit", Integer.class);

        List<Article> articles = articleService.findByCategoryId(categoryId, limit);

        setVariable(env,body,"articles",articles);

    }
}
