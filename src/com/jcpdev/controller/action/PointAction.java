package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MembersDao;
import dto.Member;

public class PointAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		String alert = request.getParameter("alert");
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		MembersDao dao = MembersDao.getInstance();
		Member dto = dao.select(idx);
		
		request.setAttribute("dto", dto);
		if (alert!=null) request.setAttribute("alert", "y");    

		ActionForward forward = new ActionForward();
		forward.isRedirect = false;
		forward.url="member/point.jsp";
		return forward;
	}

}
