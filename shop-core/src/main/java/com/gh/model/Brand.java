package com.gh.model;

import com.gh.base.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author finally
 */
@Getter
@Setter
public class Brand extends BaseModel{

    private Integer orders;
    // 介绍
    private String introduction;
    // logo
    private String logo;
    // 品牌名称
    private String name;
    // 0=文本 1=图片
    private Integer type;
    // 网址
    private String url;

}
