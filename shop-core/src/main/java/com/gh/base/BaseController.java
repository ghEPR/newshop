package com.gh.base;


import com.gh.constant.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * @author finally
 */
@Controller
public class BaseController {

    @ModelAttribute
    public void preMethod(HttpServletRequest request){
        request.setAttribute("ctx",request.getContextPath());
    }

    /**
     * 成功返回
     * @param result
     * @return
     */
    public ResultInfo success(Object result){

        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setResult(result);
        resultInfo.setResultCode(Constant.SUCCESS_CODE);
        resultInfo.setResultMessage(Constant.SUCCESS_MSG);
        return resultInfo;
    }

    /**
     * 返回失败内容
     * @param errorMsg
     * @param code
     * @return
     */
    public ResultInfo failure(String errorMsg, int code){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setResultMessage(errorMsg);
        resultInfo.setResultCode(code);
        return resultInfo;
    }
}
