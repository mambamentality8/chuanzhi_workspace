package cn.itcast.common.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 分页结果类
 * @author Administrator
 *
 */
public class PageResult implements Serializable {

	private long total;//总记录数
	private List rows;//当前页记录
	private int page;
	private int size;
	private int totalPage;
	private int beg;
	private int end;
	private int pre;
	private int next;
	private static int DEFAULT_PAGE_RANGE=4;

	public PageResult(){}
		
	public PageResult(long total, List rows, int page, int size) {
		super();
		this.total = total;
		this.rows = rows;
		this.page = page;
		this.size = size;
		// 计算
        this.totalPage = (int) (total % size == 0 ? (total/size): (total/size+1));
		// 获取显示起始页码
        calcPage(page,totalPage,2);
        this.pre = page == 1 ? 1: page-1;
        this.next = page == totalPage ? totalPage:page+1;
	}

    public void calcPage(int pageNum,int pageCount,int sideNum){
        int startNum = 0;
        int endNum = 0;

        if(pageCount<=sideNum){
            endNum = pageCount;
        }else{
            if((sideNum+pageNum)>=pageCount){
                endNum = pageCount;
            }else{
                endNum = sideNum+pageNum;
                if((sideNum+pageNum)<=(2*sideNum+1)){
                    if((2*sideNum+1)>=pageCount){
                        endNum = pageCount;
                    }else{
                        endNum = 2*sideNum+1;
                    }
                }else{
                    endNum = sideNum + pageNum;
                }
            }
        }
        if(pageNum<=sideNum){
            startNum = 1;
        }else{
            if((pageNum+sideNum)>=pageCount){
                if((2*sideNum+1)>=pageCount){
                    if((pageCount - 2*sideNum)>=1){
                        startNum = pageCount - 2*sideNum;
                    }else{
                        startNum = 1;
                    }
                }else{
                    startNum = pageCount - 2*sideNum;
                }
            }else{
                if((pageNum-sideNum)>=1){
                    startNum = pageNum - sideNum;
                }else{
                    startNum = 1;
                }
            }
        }
        this.beg = startNum;
        this.end = endNum;
    }
	
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getBeg() {
        return beg;
    }

    public void setBeg(int beg) {
        this.beg = beg;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

	public int getPre() {
		return pre;
	}

	public void setPre(int pre) {
		this.pre = pre;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}
}
