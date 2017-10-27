package com.gh.base;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import com.github.miemiedev.mybatis.paginator.domain.Order;
/**
 * @author finally
 */
@Getter
@Setter
public class BaseDto {

    private Integer page;
    private Integer pageSize;
    private String sort;

    /**
     * @return
     */
    public PageBounds buildPageBounds(){

        if (this.page == null || this.page < 1) {
            this.page = 1;
        }
        if (this.pageSize == null || this.pageSize <1) {
            this.pageSize = 10;
        }

        PageBounds pageBounds = new PageBounds(this.page,this.pageSize);
        if (StringUtils.isNotBlank(this.sort)) {
            pageBounds.setOrders(Order.formString(this.sort));
        }
        return pageBounds;
    }

}
