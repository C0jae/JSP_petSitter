package controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Ps_boardDao;
import dto.Member;
import dto.Pet;
import dto.Ps_board;
import dto.R_board;

public class Ps_board_readAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("UTF-8");
		
		Ps_boardDao dao = Ps_boardDao.getInstance();
		
		int ps_idx = Integer.parseInt(request.getParameter("idx"));	// 펫시터의 idx
		int psb_idx = Integer.parseInt(request.getParameter("psb_idx"));	// 펫시터 게시판 idx

		String s_date = request.getParameter("s_date");
		String f_date = request.getParameter("f_date");
		request.setAttribute("s_date", s_date);
		request.setAttribute("f_date", f_date);
		
		List<Pet> plist = dao.p_getList(ps_idx);	// 펫시터의 펫 정보 불러오기
		request.setAttribute("pet", plist);
		
		Ps_board ps_getList = dao.ps_getList(psb_idx);	// 펫시터 게시판 정보 불러오기
		request.setAttribute("ps_board", ps_getList);
		
		String p_size = ps_getList.getP_size();	// 펫시터 게시판의 허용가능 펫사이즈 목록 불러오기
		request.setAttribute("p_size", p_size);
		
		Member m_getList = dao.m_getList(ps_idx);	// 펫시터 회원정보 불러오기
		request.setAttribute("petSitter", m_getList);
		String ps_nick = m_getList.getNick();
		
		R_board rate = dao.rate(ps_nick);	// 펫시터의 평점 불러오기
		request.setAttribute("rate", rate);
		
		R_board rateCnt = dao.rate(ps_nick);	// 펫시터의 후기 게시판 갯수 불러오기
		request.setAttribute("rateCnt", rateCnt);
		
		request.setAttribute("ps_idx", ps_idx);	// 펫시터 idx 넘기기
		
		
		forward.isRedirect = false;
		forward.url = "community/ps_board_read.jsp";
		return forward;
	}

}
