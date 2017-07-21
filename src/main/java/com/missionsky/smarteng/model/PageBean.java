package com.missionsky.smarteng.model;

import java.util.List;

/**
 * Created by andy.li on 2017/7/21.
 *  PageBean实体类
 */
public class PageBean {

    //总记录数
    private long totals;
    //总页数
    private int pageCount;
    //结果集
    private List<?> results;
    //当前页码
    private int pageIndex;

    public void setTotals(long totals) {
        this.totals = totals;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setResults(List<?> results) {
        this.results = results;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public long getTotals() {

        return totals;
    }

    public int getPageCount() {
        return pageCount;
    }

    public List<?> getResults() {
        return results;
    }

    public int getPageIndex() {
        return pageIndex;
    }
}
