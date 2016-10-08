package com.demo.common;

import com.demo.common.util.StringUtil;

import java.io.Serializable;

/**
 * @Description:分页类
 * @ClassName :com.cdutcm.common.util.Page.java
 * @Author :lijie
 */
public class Page implements Serializable {
	private static final long serialVersionUID = -8921313948485505088L;
	/** 每页的行数 */
	private int rowPerPage;
	/** 当前的页数 */
	private int curPage;
	/** 总行数 */
	private int totalRows;
	/** 总页数 */
	private int totalPages;
	/** 当前页开始行索引 */
	private int startRowIndex;

	public Page() {
		this.rowPerPage = 20;
	}
	public Page(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	public Page(String start, String limit) {
		// 如果limit为null，或者格式错误，默认设置为20
		this.rowPerPage = StringUtil.parseInt(limit, 20);
		// 如果start为null，或者格式错误，默认设置为0
		this.startRowIndex = StringUtil.parseInt(start, 0);
	}
	public Page(int start, int limit) {
		this.rowPerPage = limit;
		this.startRowIndex = start;
	}

	/** 根据查询到的总行数分页 */
	public Page pagging(int totalRows) {
		this.totalRows = totalRows;
		return this;
	}
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	public int getCurPage() {
		return this.curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getTotalRows() {
		return this.totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	public int getTotalPages() {
		return this.totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getStartRowIndex() {
		return this.startRowIndex;
	}
	public void setStartRowIndex(int startRowIndex) {
		this.startRowIndex = startRowIndex;
	}
}
