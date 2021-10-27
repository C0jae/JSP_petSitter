package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Q_boardDao;
import dto.Q_board;

public class InsertAction implements Action {

	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws javax.servlet.ServletException ,java.io.IOException {

		//테이블 insert 
		request.setCharacterEncoding("UTF-8");
		int idx = Integer.parseInt(request.getParameter("idx"));
		String title = request.getParameter("title");
		String nick = request.getParameter("nick");
		String content = request.getParameter("content");

		Q_board q_dto = new Q_board();
		q_dto.setIdx(idx);
		q_dto.setNick(nick);
		q_dto.setTitle(title);
		q_dto.setContent(content);
		Q_boardDao q_dao = Q_boardDao.getInstance();
		q_dao.insert(q_dto);
		ActionForward foward = new ActionForward();
		foward.isRedirect = true;
		foward.url="list.do";
		return foward;
	};
}