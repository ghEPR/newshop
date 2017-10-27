package com.gh.vo;



import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author finally
 */
@Getter
@Setter
public class GoodsVo implements Serializable {

    private Integer id;
    private String name;
    private String caption;
    private String image;
    private BigDecimal price;
    private BigDecimal marketPrice;

    private String unit;
    private Integer type;
    private String productImages;
    private String specificationItems;
    private String parameterValues;
    private String introduction;
    private Integer productCategory;

}