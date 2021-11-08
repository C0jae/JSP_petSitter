/*
 *  작성자 : 최영재
 *  기능 : 펫시터 게시글 불러오기(상세내용)
 */

package controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.a.NativeConstants.IntegerDataType;

import dao.Ps_boardDao;
import dao.RboardDao;
import dto.Member;
import dto.Pet;
import dto.Ps_board;
import dto.R_board;
import dto.Rboard;

// By최영재 - 펫시터 게시글 불러오기
public class Ps_board_readAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("UTF-8");
		
		Ps_boardDao dao = Ps_boardDao.getInstance();
		
		int ps_idx = Integer.parseInt(request.getParameter("idx"));	// 펫시터의 idx
		int psb_idx = Integer.parseInt(request.getParameter("psb_idx"));	// 펫시터 게시판 idx

		String s_date = request.getParameter("s_date");	// 희망 시작일
		String f_date = request.getParameter("f_date");	// 희망 종료일
		request.setAttribute("s_date", s_date);
		request.setAttribute("f_date", f_date);
		
		List<Pet> plist = dao.p_getList(ps_idx);	// 펫시터의 펫 정보 불러오기
		request.setAttribute("pet", plist);
		
		Ps_board ps_getList = dao.ps_getList(psb_idx);	// 펫시터 게시판 정보 불러오기
		request.setAttribute("ps_board", ps_getList);
		
		String p_size = ps_getList.getP_size();	// 펫시터 게시판의 허용가능 펫사이즈 목록 불러오기
		request.setAttribute("p_size", p_size);
		
		Member m_getList = dao.m_getList(ps_idx);	// 펫시터 회원정보 불러오기
		request.setAttribute("petSitter", m_getList);
		String ps_nick = m_getList.getNick();
		
		String rateCnt = dao.rateCnt(ps_nick);	// 펫시터의 후기 게시판 갯수 불러오기
		request.setAttribute("rateCnt", rateCnt);
		
		// 후기가 있을경우
		if(rateCnt != null) {
			double rate = dao.rate(ps_nick);	// 펫시터의 평점 불러오기
			double rate1 = rate * 10;
			rate1 = ((double)Math.round(rate1))/10;
			request.setAttribute("rate", rate1);
		}
		
		request.setAttribute("ps_idx", ps_idx);	// 펫시터 idx 넘기기
		
		List<R_board> r_getList = dao.r_getList(ps_nick);	// 펫시터 회원정보 불러오기
		request.setAttribute("review", r_getList);
		
		
		
		forward.isRedirect = false;
		forward.url = "community/ps_board_read.jsp";
		return forward;
	}

}
