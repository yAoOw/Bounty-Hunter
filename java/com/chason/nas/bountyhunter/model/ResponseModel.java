package com.chason.nas.bountyhunter.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p>description: </p>
 * <p>Date: 2018/6/1</p>
 * <p>modify：</p>
 *
 * @author zhang qq.773935581
 **/
@Getter
@Setter
@NoArgsConstructor
public class ResponseModel {

    private int code;

    private String desc;

    private Object data;

    public ResponseModel(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public ResponseModel(int code, String desc, Object data) {
        this.code = code;
        this.desc = desc;
        this.data = data;
    }
}
