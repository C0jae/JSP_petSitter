package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MembersDao;



public class MemberDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
	    int idx = Integer.parseInt(request.getParameter("idx"));
	    
		MembersDao dao = MembersDao.getInstance();
		
		int n = dao.delete(idx);
		session.invalidate();
		
		out.print("<script>");
		String message=null;
		if(n==1) {
			message ="회원탈퇴 완료";
		}
		out.print("alert('"+message+"');");
		out.print("location.href='./';");
		out.print("</script>");
		
		return null;
	}

}

