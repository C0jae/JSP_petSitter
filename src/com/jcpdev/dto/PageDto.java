package dto;

import lombok.Data;


@Data
public class PageDto {
	private int currentPage;	//현재페이지
	private int totalCount;		//글의 전체갯수
	private int pageSize;		//한개페이지에 보여줄 글 갯수
	
	private int totalPage;	//전체 페이지수
	private int startPage;	
	private int endPage;
	
	private int StartNo;
	private String m_addr;
	private String wdate_start;
	private String wdate_final;
	private String terms;
	
	public PageDto(int currentPage,int totalCount,int pageSize,String m_addr,String wdate_start,String wdate_final,String terms) {
		this.currentPage=currentPage;
		this.totalCount=totalCount;
		this.pageSize = pageSize;
		this.m_addr = m_addr;
		this.wdate_start = wdate_start;
		this.wdate_final = wdate_final;
		this.terms = terms;
		
		totalPage = (totalCount-1)/pageSize +1;
		this.currentPage = (currentPage > totalPage)?totalPage:currentPage;
		this.currentPage = (currentPage < 1)? 1:currentPage;
		
		StartNo = (this.currentPage-1)*pageSize;
		
		startPage = (this.currentPage)/10 *10+1;
		endPage = startPage+9;
		endPage = endPage > totalPage ? totalPage:endPage;
	}
	
	
}
