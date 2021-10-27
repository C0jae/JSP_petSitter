package controller.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

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
	    String password = request.getParameter("password");
	    
		MembersDao dao = MembersDao.getInstance();
		Map<String,Object> map = new HashMap<>();
		map.put("idx", idx);
		map.put("password", password);
		
		int n = dao.delete(map);
		
		out.print("<script>");
		String message=null;
		String href=null;
		if(n==1){  //정상 delete 실행
			message ="회원탈퇴 되었습니다.";
			session.invalidate();
			href="./";
		}else {  //n=0 : password 가 틀릴때
			message ="비밀번호가 틀립니다.";
			href="update.do?&idx=" +idx;
		}
		out.print("alert('"+message+"');");
		out.print("location.href='"+href+"';");
		out.print("</script>");
		
		return null;
	}

}

