package com.gh.model;

import com.gh.base.BaseModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleCategory extends BaseModel {

    /** 名称 */
    private String name;

    /** 页面标题 */
    private String seoTitle;

    /** 页面关键词 */
    private String seoKeywords;

    /** 页面描述 */
    private String seoDescription;

    /** 树路径 */
    private String treePath;

    /** 层级 */
    private Integer grade;
    /** 父级id */
    private Integer parent;

}
