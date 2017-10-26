package com.gh.directive;

import com.alibaba.fastjson.JSON;
import com.gh.base.ResultInfo;
import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author finally
 */
@Component
public class HotSearchKeywordsDirective implements TemplateDirectiveModel {

    @Value("${cache.url}")
    private String cacheUrl;

    @Value("cache.hot_search_keywords.url")
    private String hotSearchKeywordsUrl;


    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body) throws TemplateException, IOException {

        RestTemplate restTemplate = new RestTemplate();
        ResultInfo resultInfo = restTemplate.getForObject(cacheUrl + hotSearchKeywordsUrl, ResultInfo.class);
        List<String> hotKeywords = (List<String>) resultInfo.getResult();

        BeansWrapper beansWrapper = new BeansWrapperBuilder(Configuration.VERSION_2_3_0).build();

        env.setVariable("hotKeywords",beansWrapper.wrap(hotKeywords));

        if (null != body){
            body.render(env.getOut());
        }else {
            env.getOut().write(JSON.toJSONString(beansWrapper.wrap(hotKeywords)));
        }

    }
}
