package com.demo.dto;



public class PageQueryDTO {

    /**
     * 当前页
     */
    private int pageNo;

    /**
     * 每页记录数
     */
    private int pageSize;

    /**
     * 排序字段名
     */
    private String order = "createTime";

    /**
     * 排序顺序
     */
    private String orderDesc = "desc";

    public int getPageNo() {
        return pageNo = pageNo <= 0 ? 1 : pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize = pageSize <= 0 ? 10 : pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }
}
