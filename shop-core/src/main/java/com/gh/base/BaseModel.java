package com.gh.base;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author finally
 */
@Getter
@Setter
public class BaseModel implements Serializable{

    private Integer id;
    private Date createDate;
    private Date modifyDate;
    private Integer version;

}
