package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MembersDao;



public class MemberIdCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

	    String id = request.getParameter("id");
	    
	    MembersDao dao = MembersDao.getInstance();

		int count= dao.IdCheck(id);
		System.out.println(count);
		out.print("<script>");
		String message=null;
		String href=null;
		if(count == 0){ 
			message ="사용가능한 아이디 입니다.";
			href="success.do";
		}else {  
			message ="사용할 수 없는 아이디입니다.";
			href="CheckId.do";
		}
		out.print("alert('"+message+"');");
		out.print("location.href='"+href+"';");
		out.print("</script>");
		
		return null;
	}

}

