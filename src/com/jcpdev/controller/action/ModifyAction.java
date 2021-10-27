package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Q_boardDao;
import dto.Q_board;

public class ModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//수정 버튼-> 내용 변경 -> 저장버튼 으로 실행됩니다.
		request.setCharacterEncoding("UTF-8");
		int pageNo = Integer.parseInt(request.getParameter("page"));
		int q_idx = Integer.parseInt(request.getParameter("q_idx"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		Q_board dto = new Q_board();
		dto.setQ_idx(q_idx);
		dto.setTitle(title);
		dto.setContent(content);

		Q_boardDao dao = Q_boardDao.getInstance();
		dao.update(dto);
		ActionForward foward = new ActionForward();
		
		String message = "내용이 수정되었습니다.";
		String url = "qnaDetail.do?q_idx="+q_idx+"&page="+pageNo;
		
		request.setAttribute("message", message);
		request.setAttribute("url", url);
		
		foward.isRedirect = false;
		foward.url="./error/alert.jsp";
		return foward;
	}

}
