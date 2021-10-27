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

public class PointChargeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		int idx = Integer.parseInt(request.getParameter("idx"));
		int point = Integer.parseInt(request.getParameter("point"));

		Member dto = new Member();
		dto.setPoint(point);
		dto.setIdx(idx);
		MembersDao dao = MembersDao.getInstance(); 
		dao.update_point(dto);
		
		dto = dao.select(idx);
		HttpSession session = request.getSession();
		
		String id = dto.getId();
		String password = dto.getPassword();
		
		if(session.getAttribute("readIdx") ==null){
			StringBuilder readIdx=new StringBuilder("/");
			session.setAttribute("readIdx",readIdx);
		}

		Map<String,String> map = new HashMap<>();
		map.put("id",id);
		map.put("password",password);

		SessionDto user = dao.login(map);
		session.setAttribute("user", user);
		
		ActionForward forward = new ActionForward();
		forward.isRedirect = false;
		forward.url="list.do";
		return forward;
	}

}
