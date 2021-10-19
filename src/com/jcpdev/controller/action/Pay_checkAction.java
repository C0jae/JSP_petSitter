package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Pay_checkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		int small;
		int middle;
		int big;
		
		if(request.getParameter("small") == null) {
			small = 0;
		}
		else {
			small = Integer.parseInt(request.getParameter("small"));
		}
		if(request.getParameter("middle") == null) {
			middle = 0;
		}
		else {
			middle = Integer.parseInt(request.getParameter("middle"));
		}
		if(request.getParameter("big") == null) {
			big = 0;
		}
		else {
			big = Integer.parseInt(request.getParameter("big"));
		}
		
		int pay = (50000 * small) + (65000 * middle) + (80000 * big);
		
		
		
		forward.isRedirect = true;
		forward.url = "ps_reserve.do";
		return forward;
	}

}
