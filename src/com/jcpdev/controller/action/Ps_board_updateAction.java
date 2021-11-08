/*
 *  작성자 : 최영재
 *  기능 : 펫시터 게시글 수정을 누르게 될 경우 수정하는 페이지로 넘겨주는 기능
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

// By최영재 - 펫시터 게시글 수정화면 페이지도 이동
public class Ps_board_updateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward foward = new ActionForward();
		Ps_boardDao dao = Ps_boardDao.getInstance();
		
		// 게시글 번호와 닉네임 값 받아온 후 해당 게시글 자료를 받아와 넘겨주기
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