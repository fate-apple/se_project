package com.se.Domain.Business;

public class Pager {
    private int pageSize;
    private int totalSize;
    private int currentPage;
    private int totalPage;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public Pager(int pageSize, int totalSize, int currentPage) {
        this.pageSize = pageSize;
        this.totalSize = totalSize;
        this.currentPage = currentPage;
        this.totalPage=totalSize/pageSize+1;
    }
}
