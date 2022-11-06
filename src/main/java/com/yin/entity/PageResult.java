package com.yin.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Classname PageResult
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/3/22 9:12
 * @Version 1.0
 **/
public class PageResult implements Serializable {
    private long total; // 总数
    private List rows; // 返回的数据集合

    public PageResult(long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
