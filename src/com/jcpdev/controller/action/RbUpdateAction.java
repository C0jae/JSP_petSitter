package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RboardDao;
import dto.Rboard;

public class RbUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		int r_idx =Integer.parseInt(request.getParameter("r_idx"));
		int pageNo = Integer.parseInt(request.getParameter("page"));
		RboardDao dao = RboardDao.getInstance();
		Rboard bean = dao.getOne(r_idx);

//		out.print(dto);
		request.setAttribute("page", pageNo);
		request.setAttribute("bean", bean);
//		pageContext.forward("updateView.jsp");
		ActionForward foward = new ActionForward();
		foward.isRedirect = false;
		foward.url="community/rbupdate.jsp";
		return foward;
	}

}