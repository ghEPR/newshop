package com.gh.directive;

import com.gh.model.Ad;
import com.gh.service.AdService;
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
public class AdDirective extends BaseDirective {

    @Autowired
    private AdService adService;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body) throws TemplateException, IOException {

        Integer positionId = getParams(params, "positionId", Integer.class);

        List<Ad> ads = adService.findById(positionId);

        setVariable(env,body,"ads",ads);

    }
}
