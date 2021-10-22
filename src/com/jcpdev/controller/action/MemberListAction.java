package controller.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MembersDao;
import dto.Member;

public class MemberListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		MembersDao dao = MembersDao.getInstance();
		
		Map<String,Integer> map = new HashMap<>();
		List<Member> list = dao.selectAll(map);
		request.setAttribute("list", list);
		
		ActionForward forward = new ActionForward();
		forward.isRedirect = false;
		forward.url="list.jsp";
		return forward;

	}

}
