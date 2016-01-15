package com.android.ads.manage.utils;

import java.util.List;

public class Pager<T> {
	
	private List<T> list; //对象记录结果集
    private long total = 0; // 总记录数
    private int pageSize = 20;
    private long pages = 1; // 总页数

    public Pager(long total, int pageSize) {
    	this.total = total;
    	this.pageSize = pageSize;
    	this.pages = (this.total - 1) / this.pageSize + 1;
    }
    
    public Pager(List<T> list, int pageSize) {
    	this.list = list;
    	this.pageSize = pageSize;
    	this.pages = (this.total - 1) / this.pageSize + 1;
    }
    
    public Pager(List<T> list, long total, int pageSize) {
        this.list = list;
        this.total = total;
        this.pageSize = pageSize;
        this.pages = (this.total - 1) / this.pageSize + 1;
    }

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getPages() {
		return pages;
	}

	public void setPages(long pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pager [list=");
		builder.append(list);
		builder.append(", total=");
		builder.append(total);
		builder.append(", pageSize=");
		builder.append(pageSize);
		builder.append(", pages=");
		builder.append(pages);
		builder.append("]");
		return builder.toString();
	}
}
