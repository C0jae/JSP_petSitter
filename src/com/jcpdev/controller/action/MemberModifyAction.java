package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MembersDao;
import dto.Member;

public class MemberModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		int idx = Integer.parseInt(request.getParameter("idx"));
		String password = request.getParameter("password");
		String tel = request.getParameter("tel");
		String m_addr = request.getParameter("m_addr");
		String s_addr = request.getParameter("s_addr");
		
		Member dto = new Member();
		dto.setPassword(password);
		dto.setTel(tel); 
		dto.setM_addr(m_addr);
		dto.setS_addr(s_addr);
		dto.setIdx(idx);
		
		MembersDao dao = MembersDao.getInstance();     
		dao.update(dto);
		
		ActionForward forward = new ActionForward();
		forward.isRedirect = true;
		forward.url="list.do";
		return forward;
	}

}
