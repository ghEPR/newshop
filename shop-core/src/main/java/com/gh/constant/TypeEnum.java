package com.gh.constant;

import lombok.Getter;
import lombok.Setter;

/**
 * 枚举类型
 *
 * @author finally
 */

public enum TypeEnum {

    /** 文本 */
    text("text",0),

    /**图片*/
    image("image",1);

    private int type;
    private String name;

    private TypeEnum(){

    }

    private TypeEnum(String name,int type){
        this.type=type;
        this.name=name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
