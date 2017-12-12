package cn.just_do.springboot.domain;


import java.util.ArrayList;
import java.util.List;


public class Page<T> {
	private T pageNumber;// 当前页编号  
	private int pageSize;// 每页显示条数  
	private int total;// 总共的记录条数  
	private int totalPage;// 总共的页数，通过总共的记录条数以及每页大小计算而得  
	private List<T> rows;
	
	public Page(){
		rows = new ArrayList<>();
	}
	public int getTotalPage() {
		return totalPage;
	}
	public Page<T> setTotalPage(int totalPage) {
		this.totalPage = totalPage;
		return this;
	}
	public T getPageNumber() {
		return pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public int getTotal() {
		return total;
	}
	public List<T> getRows() {
		return rows;
	}
	public Page<T> setPageNumber(T pageNumber){
		this.pageNumber = pageNumber;
		return this;
	}
	public Page<T> setPageSize(int pageSize) {
		this.pageSize = pageSize;
		return this;
	}
	public Page<T> setTotal(int total) {
		this.total = total;
		if (pageSize > 0 && total > -1) {
            this.totalPage = (int) (total % pageSize == 0 ? total / pageSize: total / pageSize + 1);
        }
		return this;
	}
	public Page<T> setRows(List<T> rows) {
		this.rows = rows;
		return this;
	}
	
}
