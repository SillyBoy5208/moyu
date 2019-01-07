package com.demo.form;

import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.NotNull;


public class PageForm {
    @NotNull(message = "page.pageNo.illegal")
    @Range(min = 1, max = Integer.MAX_VALUE, message = "page.pageNo.illegal")
    private Integer pageNo;

    @NotNull(message = "page.pageNo.illegal")
    private Integer pageSize;

    private String order;

    private String orderDesc;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
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
