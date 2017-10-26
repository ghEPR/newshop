package com.gh.model;


import com.gh.base.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author finally
 */

@Getter
@Setter
public class ProductCategory extends BaseModel{

    private Integer orders;
    private Integer grade;
    private String name;
    private String seoDescription;
    private String seoKeywords;
    private String seoTitle;
    private String treePath;
    private Integer parent;

}
