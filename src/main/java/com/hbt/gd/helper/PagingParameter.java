package com.hbt.gd.helper;

public class PagingParameter {
    private Integer page;
    private Integer itemPerPage;

    public PagingParameter() {
    }

    public PagingParameter(Integer page, Integer itemPerPage) {
        this.page = page;
        this.itemPerPage = itemPerPage;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getItemPerPage() {
        return itemPerPage;
    }

    public void setItemPerPage(Integer itemPerPage) {
        this.itemPerPage = itemPerPage;
    }
}
