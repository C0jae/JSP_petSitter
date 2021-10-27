package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RboardDao;
import dto.Rboard;

public class RbModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//수정 버튼-> 내용 변경 -> 저장버튼 으로 실행됩니다.
		request.setCharacterEncoding("UTF-8");
		int pageNo = Integer.parseInt(request.getParameter("page"));
		int r_idx = Integer.parseInt(request.getParameter("r_idx"));
		int rate = Integer.parseInt(request.getParameter("rate"));
		String title = request.getParameter("title");
//		String password = request.getParameter("password");
		String content = request.getParameter("content");
//		String ip = request.getRemoteAddr();

		Rboard dto = new Rboard();
//		dto.setIp(ip);
//		dto.setPassword(password);
		dto.setR_idx(r_idx);
		dto.setTitle(title);
		dto.setRate(rate);
		dto.setContent(content);

		RboardDao dao = RboardDao.getInstance();
		dao.update(dto);
//		response.sendRedirect("updateAction.jsp?update=&idx="+idx);
//		response.sendRedirect("detailAction.jsp?update=&idx="+idx + "&page="+pageNo);
		ActionForward foward = new ActionForward();
		foward.isRedirect = true;
		foward.url="rbdetail.do?rbupdate=&r_idx="+r_idx + "&page="+pageNo;
		return foward;
	}

}