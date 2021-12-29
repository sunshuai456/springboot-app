package com.mars.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class Base implements Serializable {
    private static final long serialVersionUID = -6700636136484498780L;

    /**
     * 数据库标识
     */
    private int id;
    /**
     * 添加时间
     */
    private Date addTime;
    /**
     * 删除时间
     */
    private Date deleteTime;

}
