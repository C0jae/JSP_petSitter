package controller.action;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MembersDao;
import dao.Ps_boardDao;
import dto.Member;
import dto.Reservation;
import dto.SessionDto;

public class Ps_reserveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = new ActionForward();
		Ps_boardDao dao = Ps_boardDao.getInstance();
		Reservation dto = new Reservation();
		MembersDao mdao = MembersDao.getInstance();
		HttpSession session = request.getSession();
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		String date1 = request.getParameter("s_date");
		String date2 = request.getParameter("f_date");

		/*
		 * if(request.getParameter("idx") == null) { String message = "회원만 가능합니다.";
		 * String message2 = "로그인을 해주세요."; String url = "./login.do";
		 * 
		 * request.setAttribute("message", message); request.setAttribute("message2",
		 * message2); request.setAttribute("url", url); }
		 */
		
		int idx = Integer.parseInt(request.getParameter("idx"));	// 예약자 idx
		int ps_idx = Integer.parseInt(request.getParameter("ps_idx"));	// 펫시터 idx
		Date s_date = Date.valueOf(request.getParameter("s_date"));
		Date f_date = Date.valueOf(request.getParameter("f_date"));
		
		int money = 0;
		int vat = 0;
		int pay = 0;
		
		int small = 0;
		int middle = 0;
		int big = 0;
		
		if(request.getParameter("small") == "") small = 0;
		else small = Integer.parseInt(request.getParameter("small"));
		
		if(request.getParameter("middle") == "") middle = 0;
		else middle = Integer.parseInt(request.getParameter("middle"));
		
		if(request.getParameter("big") == "") big = 0;
		else big = Integer.parseInt(request.getParameter("big"));
		
		// 날짜계산
		try {
			java.util.Date date11 = new SimpleDateFormat("yyyy-MM-dd").parse(date1);
			java.util.Date date22 = new SimpleDateFormat("yyyy-MM-dd").parse(date2);
			Calendar cmpDate1 = Calendar.getInstance();
			Calendar cmpDate2 = Calendar.getInstance();
			cmpDate1.setTime(date11);
			cmpDate2.setTime(date22);
			long diffSec = (cmpDate2.getTimeInMillis() - cmpDate1.getTimeInMillis()) / 1000;
			long diffDays = diffSec / (24*60*60);
			
			System.out.println(diffDays);
			
			if(diffDays == 0) {
				diffDays = 1;
				
				money = (small * 50000) + (middle * 65000) + (big * 80000);
				vat = money / 10;
				pay = money + vat;
			}
			else {
				money = (int) (((small * 50000) + (middle * 65000) + (big * 80000)) * diffDays);
				vat = money / 10;
				pay = money + vat;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
		dto.setIdx(idx);
		dto.setPs_idx(ps_idx);
		dto.setPay(pay);
		dto.setS_date(s_date);
		dto.setF_date(f_date);
		
		
		
		// 예약자의 포인트 정보 불러오기
		Member mdto = dao.m_getList(idx);
		System.out.println(mdto);
		System.out.println(mdto.getPoint());
		System.out.println(pay);
		
		if(mdto.getPoint() < pay) {	// 예약자의 포인트가 결제금액보다 적을때
			String message = "결제에 실패하였습니다.";
			String message2 = "잔여 포인트를 확인해주세요";
			String url = "./index.jsp";
			
			request.setAttribute("message", message);
			request.setAttribute("message2", message2);
			request.setAttribute("url", url);
		}
		else {	// 예약자의 포인트가 충분할때
			// 펫시터 포인트 증가
			Map<String, Integer> plusPoint = new HashMap<>();
			plusPoint.put("money", money);
			plusPoint.put("idx", ps_idx);
			dao.plusPoint(plusPoint);
			
			// 예약자 포인트 감소
			Map<String, Integer> minusPoint = new HashMap<>();
			minusPoint.put("pay", pay);
			minusPoint.put("idx", idx);
			dao.minusPoint(minusPoint);
			
			// 수익 테이블 insert
			Map<String, Integer> plusIncome = new HashMap<>();
			plusIncome.put("idx", idx);
			plusIncome.put("vat", vat);
			dao.plusIncome(plusIncome);
			
			dao.psr_insert(dto);	// 예약정보 r_board에 insert
			
			// 세션 업데이트
			String id = mdto.getId();
			String password = mdto.getPassword();
			
			Map<String,String> map = new HashMap<>();
			map.put("id",id);
			map.put("password",password);
			
			SessionDto user = mdao.login(map);
			session.setAttribute("user", user);
			
			String message = "결제가 완료되었습니다.";
			String message2 = "펫정보를 입력해주세요.";
			String url = "community/pet_insert.jsp";
			
			request.setAttribute("message", message);
			request.setAttribute("message2", message2);
			request.setAttribute("url", url);
		}
		
		
		forward.isRedirect = false;
		forward.url = "error/alert.jsp";
		return forward;
	}

}
