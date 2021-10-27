package controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CommentDao;
import dao.Q_boardDao;
import dto.Comment;
import dto.Q_board;
public class DetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		//글 상세보기
		int q_idx = Integer.parseInt(request.getParameter("q_idx"));
		int pageNo = Integer.parseInt(request.getParameter("page"));
		
		Q_boardDao q_dao = Q_boardDao.getInstance();
		
	      if(session.getAttribute("readIdx") !=null){
	         StringBuilder readIdx = (StringBuilder)session.getAttribute("readIdx");
	         boolean status = readIdx.toString().contains("/"+q_idx+"/");
	         if(!status) {   //읽은 글 목록 문자열에 idx 가 포함되어지 있지 않으면
	            q_dao.q_cnt(q_idx);   //조회수 증가
	            readIdx.append(q_idx + "/");   //읽은 글 목록에 추가
	         }
	      }else{
	         StringBuilder readIdx=new StringBuilder("/");
	         session.setAttribute("readIdx", readIdx);
	      }
	      
		 
		
		Q_board bean = q_dao.getOne(q_idx);
		
		//Q_board 테이블 idx 의 댓글 목록 가져오기
		CommentDao cdao = CommentDao.getInstance();
		//cdao.updateCountAll(q_idx);			//댓글 갯수 update
		
		List<Comment> cmts = cdao.getComments(q_idx);
		
		System.out.println("comment : "+cmts);
		
		String qc_cnt = cdao.qc_cnt(q_idx);
		request.setAttribute("qc_cnt", qc_cnt);
		
		request.setAttribute("cmtlist", cmts);
		request.setAttribute("page", pageNo);
		
		//bean 객체로 참조하고 있는값은 detailView.jsp 에게 전달하고 브라우저에 출력하도록 합니다.
		request.setAttribute("bean", bean);
		ActionForward foward = new ActionForward();
		foward.isRedirect = false;
		foward.url="community/detail.jsp";
		return foward;
	}

}
