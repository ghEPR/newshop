package com.gh.directive;

import com.gh.model.AdPosition;
import com.gh.service.AdPositionService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author finally
 */
@Component
public class AdPositionDirective extends BaseDirective {

    @Autowired
    private AdPositionService adPositionService;

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body) throws TemplateException, IOException {

        //获取参数
        Integer id = getParams(params, "id", Integer.class);

        //获取数据
        AdPosition adPosition = adPositionService.findAdById(id);

        /**
         * 因为在该表的里，字段template中有了前端的代码 也即是模板 故不用在写到前端去  即不调用setVariable();
         *
         * 模板内容   数据 + 模板 = 输出
         */

        String contant = adPosition.getTemplate();

        // 获取模板
        Configuration configuration = freeMarkerConfigurer.getConfiguration();
        Template  template = new Template("adTemplate",contant,configuration);

        //输出
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("template",template);
        template.process(dataModel,env.getOut());

    }
}
