package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.RboardDao;
import dto.Rboard;

public class RbInsertAction implements Action {

	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws javax.servlet.ServletException ,java.io.IOException {
		
		request.setCharacterEncoding("UTF-8");

		Rboard dto = new Rboard();
		RboardDao dao = RboardDao.getInstance();
		
		String title = request.getParameter("title");
		String nick = request.getParameter("nick");
		String ps_nick = request.getParameter("ps_nick");
		String content = request.getParameter("content");
		int idx = Integer.parseInt(request.getParameter("idx"));
		int r_rate = Integer.parseInt(request.getParameter("rate"));
		

		
		dto.setTitle(title);
		dto.setNick(nick);
		dto.setPs_nick(ps_nick);
		dto.setContent(content);
		dto.setIdx(idx);
		dto.setRate(r_rate);
		dao.insert(dto);
	
//		response.sendRedirect("listAction.jsp");
		ActionForward foward = new ActionForward();
		foward.isRedirect = false;
		foward.url="rblist.jsp";
		return foward;
	};
}