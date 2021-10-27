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
import controller.action.CommentAction;
import controller.action.DeleteAction;
import controller.action.DetailAction;
import controller.action.IndexAction;
import controller.action.InsertAction;
import controller.action.ListAction;
import controller.action.LoginAction;
import controller.action.LogoutAction;
import controller.action.MemberDeleteAction;
import controller.action.MemberDetailAction;
import controller.action.MemberIdCheckAction;
import controller.action.MemberInsertAction;
import controller.action.MemberListAction;
import controller.action.MemberModifyAction;
import controller.action.MemberNickCheckAction;
import controller.action.MemberUpdateAction;
import controller.action.ModifyAction;
import controller.action.Pay_checkAction;
import controller.action.Pet_insertAction;
import controller.action.Pet_multiWriteAction;
import controller.action.Pet_writeAction;
import controller.action.PointAction;
import controller.action.PointChargeAction;
import controller.action.Ps_board_deleteAction;
import controller.action.Ps_board_insertAction;
import controller.action.Ps_board_readAction;
import controller.action.Ps_board_saveAction;
import controller.action.Ps_board_updateAction;
import controller.action.Ps_board_writeAction;
import controller.action.Ps_reserveAction;
import controller.action.Ps_selectAction;
import controller.action.Qna_writeAction;
import controller.action.RbDeleteAction;
import controller.action.RbDetailAction;
import controller.action.RbInsertAction;
import controller.action.RbListAction;
import controller.action.RbModifyAction;
import controller.action.RbPopupAction;
import controller.action.RbUpdateAction;
import controller.action.SearchPsAction;
import controller.action.Select_PetSitter_Action;
import controller.action.UpdateAction;

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
		
		
		String spath = request.getServletPath();
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
		else if(spath.equals("/petWrite.do")) {	// 펫정보 입력창으로 이동
			Action action = new Pet_writeAction();
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
		else if(spath.equals("/petInsert.do")) {		// 펫정보 insert
			Action action = new Pet_insertAction();
			forward = action.execute(request, response);
		}
		else if(spath.equals("/p_multi_write.do")) {	// 펫정보 다중 입력
			Action action = new Pet_multiWriteAction();
			forward = action.execute(request, response);
		}
		else if(spath.equals("/ps_boardUpdate.do")) {	// 펫시터 게시글 수정
			Action action = new Ps_board_updateAction();
			forward = action.execute(request, response);
		}
		else if(spath.equals("/psb_updateSave.do")) {	// 펫시터 수정 게시글 update
			Action action = new Ps_board_saveAction();
			forward = action.execute(request, response);
		}
		else if(spath.equals("/ps_boardDelete.do")) {	// 펫시터 수정 게시글 삭제
			Action action = new Ps_board_deleteAction();
			forward = action.execute(request, response);
		}
		else if(spath.equals("/list.do")) {
			Action action = new MemberListAction();
			forward = action.execute(request, response);
		}
		else if(spath.equals("/login.do")) {
			path = "login.jsp";
			forward = new ActionForward(false,path); 
		}
		else if(spath.equals("/join.do")) {
			Action action = new MemberInsertAction();
			forward = action.execute(request, response);
			forward.setUrl("member/join.jsp");
		}
		else if(spath.equals("/register.do")) {
			path ="member/join.jsp";
			forward = new ActionForward(false,path); 
		}
		else if(spath.equals("/save.do")) {
			Action action = new MemberInsertAction();
			forward = action.execute(request, response);
			url = "login.do";
			forward.setUrl(url);
		}
		else if(spath.equals("/update.do")) {
			Action action = new MemberUpdateAction();
			forward = action.execute(request, response);
		}
		else if(spath.equals("/detail.do")) {
			Action action = new MemberDetailAction();
			forward = action.execute(request, response);
		}
		else if(spath.equals("/modify.do")) {
			Action action = new MemberModifyAction();
			forward = action.execute(request, response);
		}
		else if(spath.equals("/delete.do")) {
			Action action = new MemberDeleteAction();
			forward = action.execute(request, response);
		}
		else if(spath.equals("/loginAction.do")) {
			Action action = new LoginAction();
			forward = action.execute(request, response);
		}
		else if(spath.equals("/logout.do")) {
			Action action = new LogoutAction();
			forward = action.execute(request, response);
		}
		else if(spath.equals("/point.do")) {
		Action action = new PointAction();
		forward = action.execute(request, response);
		}
		else if(spath.equals("/charge.do")) {
		Action action = new PointChargeAction();
		forward = action.execute(request, response);
		}
		else if(spath.equals("/Select_PetSitter.do")) {
			Action action = new Select_PetSitter_Action();
			forward = action.execute(request, response); 
		}
		else if(spath.equals("/psSelect.do")) {
			Action action = new Ps_selectAction();
			forward = action.execute(request, response); 
		}
		else if(spath.equals("/CheckId.do")) {
			path ="member/IdCheck.jsp";
			forward = new ActionForward(false,path); 
		}
		else if(spath.equals("/CheckNick.do")) {
			path ="member/NickCheck.jsp";
			forward = new ActionForward(false,path); 
		}
		else if(spath.equals("/success.do")) {
			path ="member/success.jsp";
			forward = new ActionForward(false,path); 
		}
		else if(spath.equals("/success2.do")) {
			path ="member/success2.jsp";
			forward = new ActionForward(false,path); 
		}
		else if(spath.equals("/IdCheck.do")) {
			Action action = new MemberIdCheckAction();
			forward = action.execute(request, response);
		}
		else if(spath.equals("/NickCheck.do")) {
			Action action = new MemberNickCheckAction();
			forward = action.execute(request, response);
		}
		else if(spath.equals("/qnaList.do")) {
			Action action = new ListAction();
			forward = action.execute(request, response);     
			forward.setUrl("community/list.jsp");
		}
		else if(spath.equals("/qnaDetail.do")) {
			Action action = new DetailAction();
			forward = action.execute(request, response);
		}
		else if(spath.equals("/qnaSave.do")) {
			Action action = new InsertAction();
			forward = action.execute(request, response);
			url = "qnaList.do";
			forward.setUrl(url);
		}
		else if(spath.equals("/qnaUpdate.do")) {
			Action action = new UpdateAction();
			forward = action.execute(request, response);
		}
		else if(spath.equals("/qnaModify.do")) {
			Action action = new ModifyAction();
			forward = action.execute(request, response);
		}
		else if(spath.equals("/qnaDelete.do")) {
			Action action = new DeleteAction();
			forward = action.execute(request, response);
		}
		else if(spath.equals("/comment.do")) {
			Action action = new CommentAction();
			forward = action.execute(request, response);
		}
		else if(spath.equals("/qnaWrite.do")) {
			Action action = new Qna_writeAction();
			forward = action.execute(request, response);
		}
		else if(spath.equals("/rblist.do")) {
			Action action = new RbListAction();
			forward = action.execute(request, response);
			forward.setUrl("community/rblist.jsp");
		}
		else if(spath.equals("/rbdetail.do")) {
			Action action = new RbDetailAction();
			forward = action.execute(request, response);
		}
		else if(spath.equals("/rbinsert.do")) {
			path ="community/rbinsert.jsp";
			forward = new ActionForward(false,path);
		}
		else if(spath.equals("/rbpopup.do")) {
			Action action = new RbPopupAction();
			forward = action.execute(request, response);
			forward.setUrl("community/rbpopup.jsp");
		}
		else if(spath.equals("/searchps.do")) {
			Action action = new SearchPsAction();
			forward = action.execute(request, response);
			forward.setUrl("community/rbsearch_view.jsp");
		}
		else if(spath.equals("/rbupdate.do")) {
			Action action = new RbUpdateAction();
			forward = action.execute(request, response);
		}
		else if(spath.equals("/rbdelete.do")) {
			Action action = new RbDeleteAction();
			forward = action.execute(request, response);
			url = "rblist.do";
			forward.setUrl(url);
		}
		else if(spath.equals("/rbmodify.do")) {
			Action action = new RbModifyAction();
			forward = action.execute(request, response);
		}
		else if(spath.equals("/rbsave.do")) {
			Action action = new RbInsertAction();
			forward = action.execute(request, response);
			url = "rblist.do";
			forward.setUrl(url);
		}
		
		if(forward != null) {
			if(!forward.isRedirect()) {
				RequestDispatcher rd = request.getRequestDispatcher(forward.getUrl());
				rd.forward(request, response);
			}
			else {
				response.sendRedirect(forward.getUrl());
			}
		}
		
	}

}
