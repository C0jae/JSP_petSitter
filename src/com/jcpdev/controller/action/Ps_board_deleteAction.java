package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Ps_boardDao;
import dao.RboardDao;
import dto.Ps_board;
import dto.Rboard;

public class Ps_board_deleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward foward = new ActionForward();
		Ps_boardDao dao = Ps_boardDao.getInstance();
		
		int psb_idx =Integer.parseInt(request.getParameter("psb_idx"));
		System.out.println(psb_idx);
		dao.psb_delete(psb_idx);
		
		String message = "삭제가 완료되었습니다.";
		String url = "/index.do";
		
		request.setAttribute("message", message);
		request.setAttribute("url", url);
		

		foward.isRedirect = false;
		foward.url="error/alert.jsp";
		return foward;
	}

}