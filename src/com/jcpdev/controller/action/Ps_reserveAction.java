package controller.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Ps_boardDao;
import dto.Member;
import dto.Reservation;

public class Ps_reserveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		ActionForward forward = new ActionForward();
		Ps_boardDao dao = Ps_boardDao.getInstance();
		Reservation dto = new Reservation();
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int idx = 2;
		int ps_idx = 1;
		int pay = 50000;
		
		String s_date = "2021-10-29";
		String f_date = "2021-10-31";
		
		Date s_date1 = Date.valueOf(s_date);
		Date f_date1 = Date.valueOf(f_date);
		
		Member member = dao.m_getList(idx);
		request.setAttribute("mem", member);
		String id = member.getId();
		String nick = member.getNick();
		
		Member petSitter = dao.m_getList(ps_idx);
		request.setAttribute("ps", petSitter);
		String ps_nick = petSitter.getNick();
		
		dto.setIdx(idx);
		dto.setId(id);
		dto.setNick(nick);
		dto.setPs_idx(ps_idx);
		dto.setPs_nick(ps_nick);
		dto.setPay(pay);
		dto.setS_date(s_date1);
		dto.setF_date(f_date1);
		
		dao.psr_insert(dto);
		
		out.print("<script>");
		String message = "결제가 완료되었습니다.";
		String href = "index.do";
		out.print("alert('" + message + "');");
		out.print("location.href='" + href + "';");
		out.print("</script>");
		
//		forward.isRedirect = true;
//		forward.url = "index.do";
		return null;
	}

}
