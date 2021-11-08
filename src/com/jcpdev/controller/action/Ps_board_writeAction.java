/*
 *  작성자 : 최영재
 *  기능 : 펫시터 게시글 작성화면으로 이동하는 기능
 */

package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Ps_boardDao;
import dto.Member;

// By최영재 - 펫시터 게시글 작성 jsp로 이동
public class Ps_board_writeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		Ps_boardDao dao = Ps_boardDao.getInstance();
		
		// 세션에 저장되어있는 회원번호를 받아와 회원정보 불러오기(펫시터)
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		Member m_getLIst = dao.m_getList(idx);
		request.setAttribute("petsitter", m_getLIst);
		
		
		forward.isRedirect = false;
		forward.url = "./community/ps_board_write.jsp";
		
		
		
		return forward;
	}

}
