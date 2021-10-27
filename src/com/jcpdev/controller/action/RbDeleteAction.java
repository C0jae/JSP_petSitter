package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import dao.RboardDao;
import dto.Rboard;


public class RbDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		
		int r_idx = Integer.parseInt(request.getParameter("r_idx"));
		int pageNo = Integer.parseInt(request.getParameter("page"));


		RboardDao dao = RboardDao.getInstance();
		Rboard dto = dao.getOne(r_idx);
		dao.delete(dto);
		
		request.setAttribute("page", pageNo);
		ActionForward forward = new ActionForward();
		forward.isRedirect = false;
		forward.url="rblist.jsp?page="+pageNo;
		return forward;


//		ActionForward foward = new ActionForward();
//		foward.isRedirect = false;
//		foward.url="list.jsp";
	

	}

}