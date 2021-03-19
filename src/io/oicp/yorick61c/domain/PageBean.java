package io.oicp.yorick61c.domain;

import java.util.List;
import java.util.Objects;

public class PageBean<T> {
    private List<T> items;
    private Integer currentPage;
    private Integer rows;
    private Integer totalPages;
    private Integer totalItems;

    public PageBean() {
    }

    public PageBean(List<T> items, Integer currentPage, Integer rows, Integer totalPages, Integer totalItems) {
        this.items = items;
        this.currentPage = currentPage;
        this.rows = rows;
        this.totalPages = totalPages;
        this.totalItems = totalItems;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PageBean<?> pageBean = (PageBean<?>) o;

        if (!Objects.equals(items, pageBean.items)) return false;
        if (!Objects.equals(currentPage, pageBean.currentPage))
            return false;
        if (!Objects.equals(rows, pageBean.rows)) return false;
        if (!Objects.equals(totalPages, pageBean.totalPages)) return false;
        return Objects.equals(totalItems, pageBean.totalItems);
    }

    @Override
    public int hashCode() {
        int result = items != null ? items.hashCode() : 0;
        result = 31 * result + (currentPage != null ? currentPage.hashCode() : 0);
        result = 31 * result + (rows != null ? rows.hashCode() : 0);
        result = 31 * result + (totalPages != null ? totalPages.hashCode() : 0);
        result = 31 * result + (totalItems != null ? totalItems.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "items=" + items +
                ", currentPage=" + currentPage +
                ", rows=" + rows +
                ", totalPages=" + totalPages +
                ", totalItems=" + totalItems +
                '}';
    }
}
