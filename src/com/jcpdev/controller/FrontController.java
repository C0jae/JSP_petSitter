package controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.Action;
import controller.action.ActionForward;
import controller.action.IndexAction;
import controller.action.Pay_checkAction;
import controller.action.Ps_board_insertAction;
import controller.action.Ps_board_readAction;
import controller.action.Ps_board_writeAction;
import controller.action.Ps_reserveAction;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ActionForward forward = null;
		
		
		String spath = request.getServletPath(); // 이것저것 해보다가 찾은거는 spath에서 좀 차이가 있는거를 발견하긴 했습니다..
		//	String spath = "/ps_board_save.do"; //이렇게 임의로 주게되면 저거 아니였는데...
		String path = "index.jsp";
		String url = "./";
		
		if(spath.equals("/ps_board_save.do")) {		// 펫시터 게시글 저장(글 + 사진)
			Action action = new Ps_board_insertAction();
			forward = action.execute(request, response);
		} 
		else if(spath.equals("/ps_board_write.do")) {	// 펫시터 게시글 작성 화면으로 이동
			Action action = new Ps_board_writeAction();
			forward = action.execute(request, response);
		}
		else if(spath.equals("/index.do")) {	// 홈화면 이동
			Action action = new IndexAction();
			forward = action.execute(request, response);
		}
		else if(spath.equals("/ps_board_read.do")) {	// 펫시터 게시글 보기
			Action action = new Ps_board_readAction();
			forward = action.execute(request, response);
		}
		else if(spath.equals("/ps_reserve.do")) {	// 펫시터 예약하기
			Action action = new Ps_reserveAction();
			forward = action.execute(request, response);
		}
		else if(spath.equals("/payCheck.do")) {	// 예약금액 확인 및 동의여부 결정
			Action action = new Pay_checkAction();
			forward = action.execute(request, response);
		}
		
		
		
		
		if(!forward.isRedirect()) {
			RequestDispatcher rd = request.getRequestDispatcher(forward.getUrl());
			rd.forward(request, response);
		}
		else {
			response.sendRedirect(forward.getUrl());
		}
		
		
		
		
	}

}
