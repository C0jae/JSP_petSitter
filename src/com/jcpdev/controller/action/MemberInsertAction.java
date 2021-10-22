package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MembersDao;
import dto.Member;

public class MemberInsertAction implements Action {

	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws javax.servlet.ServletException ,java.io.IOException {

	
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String nick = request.getParameter("nick");
	String gender = request.getParameter("gender");
	String birth = request.getParameter("birth");
	String tel = request.getParameter("tel");
	String m_addr = request.getParameter("m_addr");
	String s_addr = request.getParameter("s_addr");
	String p_auth = request.getParameter("p_auth");
	int point = Integer.parseInt(request.getParameter("point"));
	String license = request.getParameter("license");
	int work_date = Integer.parseInt(request.getParameter("work_date"));
	String home = request.getParameter("home");
	if(home.equals("기타")) home= request.getParameter("home_etc");
	
	Member dto = new Member();
	dto.setIdx(0);
	dto.setName(name);
	dto.setId(id);
	dto.setPassword(password);
	dto.setNick(nick);
	dto.setGender(gender);
	dto.setBirth(birth);
	dto.setTel(tel);
	dto.setM_addr(m_addr);
	dto.setS_addr(s_addr);
	dto.setP_auth(p_auth);
	dto.setPoint(point);
	dto.setLicense(license);
	dto.setWork_date(work_date);
	dto.setHome(home);
	MembersDao dao = MembersDao.getInstance();
	int idx = dao.insert(dto);
	dto.setIdx(idx);
	
	ActionForward foward = new ActionForward();
	foward.isRedirect = false;
	foward.url="login.jsp";
	return foward;
	};
}