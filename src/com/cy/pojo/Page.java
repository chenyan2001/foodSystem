package com.cy.pojo;

import java.util.List;

public class Page<T> {

		//页面的查询对象
		private List<T> list;
		//当前页
		private int currpage;
		//总页数
		private int totalPage;
		//总条数
		private int totalCount;
		//每页条数
		private int pageSize;
		public List<T> getList() {
			return list;
		}
		public void setList(List<T> list) {
			this.list = list;
		}
		public int getCurrpage() {
			return currpage;
		}
		public void setCurrpage(int currpage) {
			this.currpage = currpage;
		}
		public int getTotalPage() {
			return totalPage;
		}
		public void setTotalPage(int totalPage) {
			this.totalPage = totalPage;
		}
		public int getTotalCount() {
			return totalCount;
		}
		public void setTotalCount(int totalCount) {
			this.totalCount = totalCount;
		}
		public int getPageSize() {
			return pageSize;
		}
		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}
		@Override
		public String toString() {
			return "Page [list=" + list + ", currpage=" + currpage + ", totalPage=" + totalPage + ", totalCount="
					+ totalCount + ", pageSize=" + pageSize + "]";
		}
		
		
}
