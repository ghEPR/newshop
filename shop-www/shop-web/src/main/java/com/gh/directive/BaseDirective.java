package com.gh.directive;

import com.alibaba.fastjson.JSON;
import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.*;

import java.io.IOException;
import java.util.Map;

/**
 * @author finally
 */
public abstract class BaseDirective implements TemplateDirectiveModel{

    /**
     * 获取参数值
     * @param params
     * @param paramsName
     * @param clazz
     * @param <T>
     * @return
     */
    protected <T>T getParams(Map params, String paramsName, Class<?> clazz){

        BeansWrapper beansWrapper = new BeansWrapperBuilder(Configuration.VERSION_2_3_0).build();
        TemplateModel templateModel = (TemplateModel) params.get(paramsName);
        T value = null;
        try {
            value = (T) beansWrapper.unwrap(templateModel, clazz);
        } catch (TemplateModelException e) {
            e.printStackTrace();
        }

        return value;
    }



    /**
     * 输出
     * @param env
     * @param body
     * @param key
     * @param result
     */
    protected void setVariable(Environment env,TemplateDirectiveBody body,
                               String key, Object result){

        try {
            BeansWrapper beansWrapper = new BeansWrapperBuilder(Configuration.VERSION_2_3_0).build();
            TemplateModel templateModel = beansWrapper.wrap(key);

            env.setVariable(key,templateModel);

            if (null != body){

                body.render(env.getOut());

            }else {
                env.getOut().write(JSON.toJSONString(templateModel));
            }
        } catch (TemplateModelException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

}
