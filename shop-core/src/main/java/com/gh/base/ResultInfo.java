package com.gh.base;

import lombok.Getter;
import lombok.Setter;

/**
 * @author finally
 */
@Getter
@Setter
public class ResultInfo {

    private Integer resultCode;
    private String resultMessage;
    private Object result;

}
