package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MembersDao;



public class MemberNickCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

	    String nick = request.getParameter("nick");
	    
	    MembersDao dao = MembersDao.getInstance();

		int cnt= dao.NickCheck(nick);
		System.out.println(cnt);
		out.print("<script>");
		String message=null;
		String href=null;
		System.out.println(cnt);
		if(cnt == 0){ 
			message ="사용가능한 닉네임 입니다.";
			href="success2.do";
		}else {  
			message ="사용할 수 없는 닉네임입니다.";
			href="CheckNick.do";
		}
		out.print("alert('"+message+"');");
		out.print("location.href='"+href+"';");
		out.print("</script>");
		
		return null;
	}

}

