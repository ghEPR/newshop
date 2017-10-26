package com.gh.controller;

import com.alibaba.fastjson.JSON;
import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

@Component
public class HelloDirective implements TemplateDirectiveModel{

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body) throws TemplateException, IOException {

        // 页面通过指令传入参数，同时显示一段html内容
        System.out.println("页面传入的参数是："+params);

        // beans的包装类
        BeansWrapper beansWrapper = new BeansWrapperBuilder(Configuration.VERSION_2_3_0).build();
        TemplateModel templateModel = (TemplateModel) params.get("name");
        String name = (String) beansWrapper.unwrap(templateModel, String.class);

        // 构建返回结果
        Map<String,String> result = new HashMap<>();
        result.put("userName",name);
        result.put("text","hello world!");

        // Map是一个java对象 转化为TemplateModel
        env.setVariable("helloworld",beansWrapper.wrap(result));

        // 输出给页面
        Writer out = env.getOut();

        if(body != null){
            body.render(out);
        }else {
            out.write(JSON.toJSONString(result));
        }

    }
}
