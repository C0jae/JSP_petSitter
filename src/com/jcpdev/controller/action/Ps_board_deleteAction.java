/*
 *  작성자 : 최영재
 *  기능 : 펫시터 게시글의 삭제
 */

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
		
		// 게시글의 idx 값을 받아온 후 int값으로 변환 및 해당 값을 이용한 게시글 삭제 
		int psb_idx =Integer.parseInt(request.getParameter("psb_idx"));
		dao.psb_delete(psb_idx);

		// 삭제 메세지와 url 선언 및 정의 후 alert.jsp로 이동
		String message = "삭제가 완료되었습니다.";
		String url = "/index.do";
		
		request.setAttribute("message", message);
		request.setAttribute("url", url);
		

		foward.isRedirect = false;
		foward.url="error/alert.jsp";
		return foward;
	}

}