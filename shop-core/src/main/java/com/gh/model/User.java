package com.gh.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class User implements Serializable{

    private Integer userId;
    private String uname;
    private String pwd;
    private String nation;
    private String location;
    private Integer gender;

}
