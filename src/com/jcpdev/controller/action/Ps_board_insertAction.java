package controller.action;

import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.Ps_boardDao;
import dto.Gallery;
import dto.Ps_board;

public class Ps_board_insertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		Ps_boardDao dao = Ps_boardDao.getInstance();
		request.setCharacterEncoding("UTF-8");
		String path = "E:\\Program\\upload";
		int size=10*1024*1024;
		MultipartRequest mr = new MultipartRequest(request, path, size, "UTF-8",
				new DefaultFileRenamePolicy());
		
		int idx = 1;
		String nick = mr.getParameter("nick");
		String title = mr.getParameter("title");
		String content = mr.getParameter("content");
		String ps_sdate = mr.getParameter("ps_sdate");
		String ps_fdate = mr.getParameter("ps_fdate");
		String[] p_size = mr.getParameterValues("size");

		int psb_idx = 7;	// 나중에 자료 종합하고나면 psb_idx = psb_idx + 1 / if psb_idx = null => psb_idx = 0 / 젤 마지막 psb_idx 의 +1 해주기
		// select psb_idx from gallery orderby psb_idx desc; <= 첫번째 행만 나오게
		
		Date ps_sdate1 = Date.valueOf(ps_sdate);
		Date ps_fdate1 = Date.valueOf(ps_fdate);
		
		Ps_board dto = new Ps_board();
		dto.setIdx(idx);
		dto.setNick(nick);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setPs_sdate(ps_sdate1);
		dto.setPs_fdate(ps_fdate1);
		dto.setP_size(Arrays.toString(p_size));
		
		
		Gallery gdto = new Gallery();
		gdto.setPsb_idx(psb_idx);
		
		String g_fname = mr.getFilesystemName("pic");
		gdto.setG_fname(g_fname);
		
//		String[] g_fname = mr.getFilesystemName("pic");
//		gdto.setG_fname(Arrays.toString(g_fname));
		
		System.out.println(g_fname);
		
		
		dao.psb_insert(dto);
		dao.g_insert(gdto);
		
		
		forward.isRedirect = true;
		
		//이게 문제죠. jsp로는 화면에 데이터 뿌려주러 가는건데 false 가되야하는거고
		//만약에 다른 url로 갈거면 아래가 index.jsp가 아니죠.
		//서블릿에서 정한 url 이 되야죠. 이거 엑셀로 계속 띄워놓는 화면인데
		forward.url = "index.do";
		return forward;
	}

}
