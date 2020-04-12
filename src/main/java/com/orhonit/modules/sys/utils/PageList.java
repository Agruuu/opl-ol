package com.orhonit.modules.sys.utils;

import java.util.List;

public class PageList<T> {
	private int currentPage = 1; // 当前页
	private int pageSize = 20; // 每页显示记录数
	private int startRecord = 1; // 起始查询记录
	private int totalPage = 0; // 总页数
	private int totalRecord = 0; // 总记录数
//	private int startIndex = 1;
//	private int endIndex = 1;

	private List<T> datas;

	public PageList() {
	}

	public PageList(int currentPage, int pageSize) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		if (this.currentPage <= 0) {
			this.currentPage = 1;
		}
		if (this.pageSize <= 0) {
			this.pageSize = 1;
		}
	}

	public PageList(int currentPage, int pageSize, int totalRecord) {
		this(currentPage, pageSize);
		this.totalRecord = totalRecord;
		if (this.totalRecord <= 0) {
			this.totalRecord = 1;
		}
	}

	public int getCurrentPage() {
		if (currentPage <= 0) {
			return 1;
		}
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecord() {
		if (totalRecord < 0) {
			return 0;
		}
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	public int getTotalPage() {
		if (totalRecord <= 0) {
			return 0;
		}
		int size = totalRecord / pageSize;// 总条数/每页显示的条数=总页数
		int mod = totalRecord % pageSize;// 最后一页的条数
		if (mod != 0) {
			size++;
		}
		totalPage = size;
		return totalPage;
	}

	public int getStartRecord() {
		startRecord = (getCurrentPage() - 1) * pageSize;
		return startRecord;
	}

	//根据当前所在页数和每页显示记录数计算出startIndex和endIndex
	public void setStartIndexEndIndex(){
		this.startRecord=(this.getCurrentPage()-1)*this.getPageSize();
//		this.endIndex= (this.getCurrentPage()-1)*this.getPageSize()+this.getPageSize();
	}
}