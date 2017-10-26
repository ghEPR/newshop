package com.gh.model;

import com.gh.base.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author finally
 */
@Getter
@Setter
public class AdPosition extends BaseModel {

    /** 名称 */
    private String name;

    /** 宽度 */
    private Integer width;

    /** 高度 */
    private Integer height;

    /** 描述 */
    private String description;

    /** 模板 */
    private String template;

    /** 广告 */
    private List<Ad> ads;

}
