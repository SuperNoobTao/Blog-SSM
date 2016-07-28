package cn.edu.zucc.pojo;

import java.io.Serializable;
import java.util.List;

public class Page<T>  implements Serializable {

	// 每页记录数
	public static final int PAGE_SIZE = 5;
	// 网页中要显示的页码总数
	public static final int PAGE_NUM = 10;
	// 页数据
	private List<T> list;
	// 总页数
	private int totalpage;
	// 总记录数
	private int totalrecord;
	// 每页显示条数
	private int pagesize = PAGE_SIZE;
	// 用户想看的页面
	private int pagenum;
	// 需要显示的页面的第一条记录索引
	private int startindex;
	// 要显示的开始页码
	private int startpage;
	// 要显示的结束页码
	private int endpage;
	// 分页请求url
	private String url;

	public Page(int totalrecord, int pagenum) {
		this.totalrecord = totalrecord;
		// 通过总记录数计算总页数
		if (this.totalrecord % this.pagesize == 0) {
			this.totalpage = this.totalrecord / this.pagesize;
		} else {
			this.totalpage = this.totalrecord / this.pagesize + 1;
		}

		this.pagenum = pagenum;
		if(this.pagenum <=0)
			this.pagenum =1;
		// 计算第一条记录索引地址
		this.startindex = (this.pagenum - 1) * this.pagesize;

		// 计算开始页码和结束页码
		if (this.totalpage <= PAGE_NUM) {
			// 总页数小于网页要显示的页码总数
			this.startpage = 1;
			this.endpage = this.totalpage;
		} else {
			// 总页数大于要显示的页码总数，让用户点击页码处于中间
			this.startpage = this.pagenum - PAGE_NUM / 2 + 1;
			this.endpage = this.pagenum + PAGE_NUM / 2;
			// 起始页码小于1
			if (this.startpage < 1) {
				this.startpage = 1;
				this.endpage = PAGE_NUM;
			}
			// 结束页码大于总页码
			if (this.endpage > this.totalpage) {
				this.endpage = this.totalpage;
				this.startpage = this.endpage - PAGE_NUM + 1;
			}
		}
	}



	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getStartpage() {
		return startpage;
	}

	public void setStartpage(int startpage) {
		this.startpage = startpage;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getEndpage() {
		return endpage;
	}

	public void setEndpage(int endpage) {
		this.endpage = endpage;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public int getTotalrecord() {
		return totalrecord;
	}

	public void setTotalrecord(int totalrecord) {
		this.totalrecord = totalrecord;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getPagenum() {
		return pagenum;
	}

	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}

	public int getStartindex() {
		return startindex;
	}

	public void setStartindex(int startindex) {
		this.startindex = startindex;
	}
}
