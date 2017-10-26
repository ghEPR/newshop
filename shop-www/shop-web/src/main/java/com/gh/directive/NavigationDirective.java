package com.gh.directive;

import com.alibaba.fastjson.JSON;
import com.gh.model.Navigation;
import com.gh.service.NavigationService;
import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author finally
 */

@Component
public class NavigationDirective extends BaseDirective{

    @Autowired
    private NavigationService navigationService;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body) throws TemplateException, IOException {

        /**
         * 1.解析参数
         * 2.调用service获取数据
         * 3.输出
         */
        Integer position = getParams(params, "position", Integer.class);

        List<Navigation> navigations = navigationService.findByPosition(position);

        setVariable(env,body,"navigations",navigations);
    }
}
