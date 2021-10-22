package controller.action;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PetsitterDao;
import dto.AdopttimeDto;
import dto.AdopttimeDto_second;
import dto.PageDto;
import dto.PetsitterDto;


public class Select_PetSitter_Action implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		//비지니스 로직을 처리하는 jsp 파일
		PetsitterDao cdao = PetsitterDao.getInstance();
		//페이지 번호는 파라미터로 전달됩니다.
		request.setCharacterEncoding("UTF-8");
		String m_addr = request.getParameter("m_addr");
		String wdate_start = request.getParameter("wdate_start");
		String wdate_final = request.getParameter("wdate_final");
		String terms = Arrays.toString(request.getParameterValues("terms"));
		terms = terms.substring(1, terms.length()-1);

		int pageNo;
		if(request.getParameter("page")==null) pageNo=1;
		else pageNo = Integer.parseInt(request.getParameter("page"));
		int pageSize =3;
		
		AdopttimeDto adopt = new AdopttimeDto(m_addr,wdate_start,wdate_final,terms);
		
		PageDto pageDto = new PageDto(pageNo,cdao.getCount(adopt),pageSize,m_addr,wdate_start,wdate_final,terms);
		
		int StartNo = pageDto.getStartNo();
		int startPage = pageDto.getStartPage();

		AdopttimeDto_second adopt_second = new AdopttimeDto_second(m_addr,wdate_start,wdate_final,terms,pageSize,StartNo);
		
		List<PetsitterDto> cmts = cdao.select(adopt_second);
		
		request.setAttribute("s_date", wdate_start);
		request.setAttribute("f_date", wdate_final);
		
		request.setAttribute("pageDto",pageDto);
		request.setAttribute("cmtlist",cmts);
//		pageContext.forward("home_View.jsp"); 
		
		forward.isRedirect=false;
		forward.url="petsitter/home_View.jsp";
		return forward;
	}

}