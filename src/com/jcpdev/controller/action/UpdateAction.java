package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Q_boardDao;
import dto.Q_board;

public class UpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		int idx =Integer.parseInt(request.getParameter("q_idx"));
		int pageNo = Integer.parseInt(request.getParameter("page"));
		Q_boardDao dao = Q_boardDao.getInstance();
		Q_board bean = dao.getOne(idx);

		request.setAttribute("page", pageNo);
		request.setAttribute("bean", bean);
		ActionForward foward = new ActionForward();
		foward.isRedirect = false;
		foward.url="community/update.jsp";
		return foward;
	}

}
