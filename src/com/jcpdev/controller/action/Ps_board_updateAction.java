package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Ps_boardDao;
import dao.RboardDao;
import dto.Ps_board;
import dto.Rboard;

public class Ps_board_updateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward foward = new ActionForward();
		Ps_boardDao dao = Ps_boardDao.getInstance();
		
		int psb_idx =Integer.parseInt(request.getParameter("psb_idx"));
		String nick = request.getParameter("nick");
		request.setAttribute("nick", nick);
		
		Ps_board dto = dao.ps_getList(psb_idx);
		request.setAttribute("ps_board", dto);

		foward.isRedirect = false;
		foward.url="community/ps_board_update.jsp";
		return foward;
	}

}