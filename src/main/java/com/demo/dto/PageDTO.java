package com.demo.dto;

import org.springframework.data.domain.Page;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 分页DTO
 *
 * @author BAOJIE371
 * @date 2017/2/20
 * @since 1.0.0
 */
public final class PageDTO<V> {

    private final long pageNo;
    private final long pageSize;
    private final long pageTotal;
    private final long total;

    private final List<V> list;

    public PageDTO(long pageNo, long pageSize, long pageTotal, long total, List<V> list) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.pageTotal = pageTotal;
        this.total = total;
        this.list = list;
    }

    public PageDTO(long total, List<V> list) {
        this.pageNo = 1;
        this.pageSize = total;
        this.pageTotal = 1;
        this.total = total;
        this.list = list;
    }

    public PageDTO(Page<?> page, List<V> list) {
        this.pageNo = page.getNumber();
        this.pageSize = page.getSize();
        this.pageTotal = page.getTotalPages();
        this.total = page.getTotalElements();
        this.list = list;
    }

    public PageDTO(PageDTO<?> page, List<V> list) {
        this.pageNo = page.getPageNo();
        this.pageSize = page.getPageSize();
        this.pageTotal = page.getPageTotal();
        this.total = page.getTotal();
        this.list = list;
    }

    /**
     * Builder构造器
     *
     * @param datas
     * @param <V>
     *
     * @return
     */
    public static <V> Builder<V> builder(List<V> datas) {
        return new Builder<>(datas);
    }

    /**
     * 将Page转换为PageDTO
     *
     * @param page
     * @param <V>
     *
     * @return
     */
    public static <V> PageDTO<V> of(Page<V> page) {
        Objects.requireNonNull(page, "page is null");
        return new PageDTO<>(page.getNumber(), page.getSize(), page.getTotalPages(), page.getTotalElements(),
                Optional.ofNullable(page.getContent()).orElse(Collections.emptyList()));
    }

    public static <V> PageDTO<V> of(Page<?> page, List<V> list) {
        Objects.requireNonNull(page, "page is null");
        return new PageDTO<V>(page, Optional.ofNullable(list).orElse(Collections.emptyList()));
    }

    public static <V> PageDTO<V> of(PageDTO<?> page, List<V> list) {
        Objects.requireNonNull(page, "page is null");
        return new PageDTO<V>(page, Optional.ofNullable(list).orElse(Collections.emptyList()));
    }

    /**
     * 将Page转换为PageDTO，需提供转换器对列表数据进行转换
     *
     * @param page
     * @param converter
     * @param <T>
     * @param <V>
     *
     * @return
     */
    public static <T, V> PageDTO<V> of(Page<T> page, Function<T, V> converter) {

        Objects.requireNonNull(page, "page is null");
        Objects.requireNonNull(converter, "converter is null");

        return new PageDTO<>(page.getNumber(), page.getSize(), page.getTotalPages(), page.getTotalElements(),
                Optional.ofNullable(page.getContent())
                        .map(content -> content.stream().map(converter).collect(Collectors.toList()))
                        .orElse(Collections.emptyList()));
    }

    /**
     * 根据转换器构造PageDTO
     *
     * @param page
     * @param converter
     * @param <T>
     * @param <V>
     *
     * @return
     */
    public static <T, V> PageDTO<V> of(PageDTO<T> page, Function<T, V> converter) {
        Objects.requireNonNull(page, "page is null");
        Objects.requireNonNull(converter, "converter is null");
        return new PageDTO<>(page.getPageNo(), page.getPageSize(), page.pageTotal, page.getTotal(),
                Optional.ofNullable(page.getList())
                        .map(content -> content.stream().map(converter).collect(Collectors.toList()))
                        .orElse(Collections.emptyList()));
    }

    public final long getTotal() {
        return total;
    }

    public final List<V> getList() {
        return list;
    }

    public long getPageNo() {
        return pageNo;
    }

    public long getPageSize() {
        return pageSize;
    }

    public long getPageTotal() {
        return pageTotal;
    }

    /**
     * Builder构造器
     *
     * @param <V>
     */
    public static class Builder<V> {
        private long pageNo;
        private long pageSize;
        private long totalPage;
        private long totalRecords;
        private final List<V> datas;

        private Builder(List<V> datas) {
            Objects.requireNonNull(datas, "list is null");
            this.datas = datas;
            totalRecords = datas.size();
        }

        public final Builder<V> pageNo(long pageNo) {
            this.pageNo = pageNo;
            return this;
        }

        public final Builder<V> pageSize(long pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public final Builder<V> totalPage(long totalPage) {
            this.totalPage = totalPage;
            return this;
        }

        public final Builder<V> totalRecords(long totalRecords) {
            this.totalRecords = totalRecords;
            return this;
        }

        public final PageDTO<V> build() {
            return new PageDTO<V>(pageNo, pageSize, totalPage, totalRecords, datas);
        }
    }
}
