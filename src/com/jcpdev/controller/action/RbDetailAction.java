package controller.action;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.RboardDao;
import dto.Rboard;

public class RbDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		//글 상세보기
		int r_idx = Integer.parseInt(request.getParameter("r_idx"));
		int pageNo = Integer.parseInt(request.getParameter("page"));

		RboardDao dao = RboardDao.getInstance();
		if(session.getAttribute("readIdx") !=null){
			StringBuilder readIdx = (StringBuilder)session.getAttribute("readIdx");
			boolean status = readIdx.toString().contains("/"+r_idx+"/");
			if(!status) {   
				dao.r_cnt(r_idx);  
				readIdx.append(r_idx + "/");   
			}
		}else{
			StringBuilder readIdx=new StringBuilder("/");
			session.setAttribute("readIdx", readIdx);
		}
		
		Rboard bean = dao.getOne(r_idx);
		
		request.setAttribute("page", pageNo);
		request.setAttribute("bean", bean);
		
		ActionForward foward = new ActionForward();
		foward.isRedirect = false;
		foward.url="community/rbdetail.jsp";
		return foward;
	}

}