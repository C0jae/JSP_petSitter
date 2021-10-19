package controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Ps_boardDao;
import dto.Gallery;
import dto.Member;
import dto.Pet;
import dto.Ps_board;
import dto.Rate;

public class Ps_board_readAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("UTF-8");
		
		Ps_boardDao dao = Ps_boardDao.getInstance();
		
		
		int psb_idx = 7;
		int idx = 1;
//		int psb_idx = Integer.parseInt(request.getParameter("psb_idx"));
		
		List<Gallery> list = dao.g_getList(psb_idx);	// 사진 불러오기
		request.setAttribute("glist", list);
		
		
		List<Pet> plist = dao.p_getList(idx);	// 펫 정보 불러오기
		request.setAttribute("pet", plist);
		
		Ps_board ps_getList = dao.ps_getList(psb_idx);	// 펫시터 게시판 정보 불러오기
		request.setAttribute("ps_board", ps_getList);
		String p_size = ps_getList.getP_size();
		request.setAttribute("p_size", p_size);
		
		Member m_getList = dao.m_getList(idx);	// 펫시터 정보 불러오기
		request.setAttribute("member", m_getList);
		
		Rate rate = dao.rate(idx);	// 펫시터 평점 불러오기
		request.setAttribute("rate", rate);
		
		
//		System.out.println(list);
//		System.out.println(plist);
//		System.out.println(ps_getList);
//		System.out.println(m_getList);
//		System.out.println(rate);
//		System.out.println(p_size);
		
		
		forward.isRedirect = false;
		forward.url = "community/ps_board_read.jsp";
		return forward;
	}

}
