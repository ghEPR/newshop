package com.gh.model;

import com.gh.base.BaseModel;
import lombok.Getter;
import lombok.Setter;


/**
 * @author finally
 */
@Getter
@Setter
public class Navigation extends BaseModel{

    // 排序
    private Integer orders;
    // 是打开新窗体
    private Boolean isBlankTarget;
    private String name;
    // 0=顶部 1= 中间 2=底部
    private Integer position;
    // 点击后跳转的地址
    private String url;


}
