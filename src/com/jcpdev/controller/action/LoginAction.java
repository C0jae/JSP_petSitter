package controller.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MembersDao;
import dto.Member;
import dto.SessionDto;

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		
		if(session.getAttribute("readIdx") ==null){
			StringBuilder readIdx=new StringBuilder("/");
			session.setAttribute("readIdx",readIdx);
		}

		Map<String,String> map = new HashMap<>();
		map.put("id",id);
		map.put("password",password);

		MembersDao dao = MembersDao.getInstance();
		SessionDto user = dao.login(map);
		if(user!=null){
			session.setAttribute("user", user);
			request.setAttribute("message", "로그인 되었습니다.");
			request.setAttribute("url", "./");
		}
		else {
			request.setAttribute("message", "로그인 정보가 올바르지 않습니다.");
			request.setAttribute("url", "login.do");  
		}
		ActionForward foward = new ActionForward();
		foward.isRedirect = false;
		foward.url="error/alert.jsp";   
		return foward;
	}

}