package com.chason.nas.bountyhunter.enums;

import lombok.Getter;

/**
 * <p>description: </p>
 * <p>Date: 2018/6/2</p>
 * <p>modify：</p>
 *
 * @author zhang qq.773935581
 **/
@Getter
public enum ResponseEnum {

    SUCCESS(1,"SUCCESS"),
    FAILED(0,"FAILED");

    private int code;

    private String desc;

    ResponseEnum(int code,String desc){
        this.code =code;
        this.desc = desc;
    }

}
