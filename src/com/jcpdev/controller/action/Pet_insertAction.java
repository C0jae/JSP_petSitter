package controller.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PetProfileDao;
import dto.Pet;

public class Pet_insertAction implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PetProfileDao dao = PetProfileDao.getInstance();
		
		
		String idx = request.getParameter("idx");
		int idx1 = Integer.parseInt(idx);		// dto부분 idx(int값으로 변환)
		
		
		String pet = request.getParameter("pet");
		String p_name = request.getParameter("p_name");
		String p_gender = request.getParameter("p_gender");
		double p_weight = Double.parseDouble(request.getParameter("p_weight"));
		String p_birth = request.getParameter("p_birth");
		String p_neu = request.getParameter("p_neu");
		
		
		// 입력받은 펫의 정보가 Pet 테이블에 존재하는지 확인(주인, 펫이름, 생년월일, 성별로 판단)
		Map<String, String> map = new HashMap<>();
		map.put("idx", idx);
		map.put("p_name", p_name);
		map.put("p_birth", p_birth);
		map.put("p_gender", p_gender);
		Pet pdto = dao.p_check(map);	// 해당정보 Pet 테이블에 select
		
		
		if(pdto == null) {		// Pet 테이블에 존재하지 않는 펫 정보일 경우 해당 정보 insert
			Pet dto = new Pet();
			dto.setIdx(idx1);
			dto.setPet(pet);
			dto.setP_name(p_name);
			dto.setP_gender(p_gender);
			dto.setP_weight(p_weight);
			dto.setP_birth(p_birth);
			dto.setP_neu(p_neu);
			
			dao.p_insert(dto);
		}
		
		String message = "완료되었습니다.";
		String url = "./index.do";
		request.setAttribute("message", message);
		request.setAttribute("url", url);
		
		
		ActionForward forward = new ActionForward();
		forward.isRedirect = false;
		forward.url = "error/alert.jsp";	// 알림창 이동
		return forward;
	}
}
