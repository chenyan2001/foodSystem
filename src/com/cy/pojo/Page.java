package com.cy.pojo;

import java.util.List;

public class Page<T> {

		//ҳ��Ĳ�ѯ����
		private List<T> list;
		//��ǰҳ
		private int currpage;
		//��ҳ��
		private int totalPage;
		//������
		private int totalCount;
		//ÿҳ����
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
