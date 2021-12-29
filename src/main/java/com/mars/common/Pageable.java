package com.mars.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 具体分页数据
 *
 * @param <T>
 * @author sunshuai
 */
@Getter
@Setter
@ToString
public class Pageable<T> implements Serializable {

    private static final long serialVersionUID = 1438689936475605207L;
    /**
     * 总记录条数
     */
    private int totalCount;
    /**
     * 每页显示条数
     */
    private int pageSize;
    /**
     * 当前页
     */
    private int pageNo;
    /**
     * 总页数
     */
    private int totalPage;

    private Boolean hasNext;

    private List<T> list;
}
