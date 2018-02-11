package com.hbt.gd.helper;

public class PagingParameter<T> {
    private Integer page;
    private Integer pageSize;
    private T filterData;

    public PagingParameter() {
    }

    public PagingParameter(Integer page, Integer pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public T getFilterData() {
        return filterData;
    }

    public void setFilterData(T filterData) {
        this.filterData = filterData;
    }
}
