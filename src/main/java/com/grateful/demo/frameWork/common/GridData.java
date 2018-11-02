package com.grateful.demo.frameWork.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * DESC: 返回给grid表格的数据类型
 * USER: C.HE
 * DATE: 2018/10/23 14:04
 * VERSION: 0.0.1
 */
public class GridData<T> implements Serializable {

    /**
     * 返回的总记录数
     */
    private Integer total = 0;

    /**
     * 返回的数据列表
     */
    private List<T> rows;


    /**
     * 无参构造方法
     */
    public GridData() {
    }

    /**
     * 带参构造方法
     * @param total
     * @param rows
     */
    public GridData(Integer total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
