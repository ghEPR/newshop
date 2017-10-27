package com.gh.dto;

import com.gh.base.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author finally
 */
@Getter
@Setter
public class GoodsDto extends BaseDto {

    private String keyword;
    private BigDecimal startPrice;
    private BigDecimal endPrice;

}
