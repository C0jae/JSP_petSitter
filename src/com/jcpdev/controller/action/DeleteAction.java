package controller.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Q_boardDao;

public class DeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		System.out.println("ddd");
		
		System.out.println("idx: "+ request.getParameter("q_idx"));
		
		int q_idx = Integer.parseInt(request.getParameter("q_idx"));
		int pageNo = Integer.parseInt(request.getParameter("page"));
		
		System.out.println("gd"+q_idx);
		System.out.println("dd"+pageNo);

		Q_boardDao dao = Q_boardDao.getInstance();
		Map<String,Object> map = new HashMap<>();
		map.put("q_idx", q_idx);
		
		int n = dao.delete(map);
		out.print("<script>");
		String message=null;
		String href=null;
		if(n==1){  //정상 delete 실행
			message ="글삭제 되었습니다.";
			href="qnaList.do?page="+pageNo;
		}
		out.print("alert('"+message+"');");
		out.print("location.href='"+href+"';");
		out.print("</script>");
	
		return null;
	}

}
