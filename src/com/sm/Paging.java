package com.sm;

public class Paging {
	// 总记录数
	private long totalCount = 0;
	// 每页记录数
	private int pageSize = 10;
	// 当前显示的页码
	private int pageNum = 1;
	// 计算出来的起始行=(pageNum-1)*pageSize
	private int startRow = 0;
	// 计算出来的总页数=totalCount/pageSize不整除则+1
	private int totalPage = 1;

	// 分页计算
	private void pageCalculate() {
		if (this.totalCount < 0)
			this.totalCount = 0;
		if (this.pageSize < 1)
			this.pageSize = 1;
		if (this.pageNum < 1)
			this.pageNum = 1;

		if ((this.totalCount % this.pageSize) == 0){
			this.totalPage = (int) (this.totalCount / this.pageSize);}
		else {
			this.totalPage = (int) (this.totalCount / this.pageSize);
			this.totalPage++;
		}

		if (this.pageNum > this.totalPage)
			this.pageNum = this.totalPage;

		this.startRow = (pageNum - 1) * pageSize;
		if(startRow<0)
			this.startRow=0;
	}

	public Paging() {
		// 默认构造函数，什么都不做
	}

	public Paging(int pageNum) {
		this.pageNum = pageNum;
	}

	public Paging(int pageNum, int pageSize) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
		// 操作分页计算
		this.pageCalculate();
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

}
