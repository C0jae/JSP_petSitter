package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MembersDao;
import dto.Member;

public class MemberDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		MembersDao dao = MembersDao.getInstance();
		
		Member dto = dao.select(idx);
		
		request.setAttribute("dto", dto);
		ActionForward foward = new ActionForward();
		foward.isRedirect = false;
		foward.url="member/memberdetail.jsp";
		return foward;
	}

}
