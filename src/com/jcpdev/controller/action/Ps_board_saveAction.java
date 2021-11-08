/*
 *  작성자 : 최영재
 *  기능 : 펫시터 게시글 수정
 */

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
import dto.Ps_board;

// By최영재 - 펫시터 게시글 수정내용 저장
public class Ps_board_saveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		Ps_boardDao dao = Ps_boardDao.getInstance();
		request.setCharacterEncoding("UTF-8");
		
		// 사진파일 업로드 경로 및 크기 설정
		String path = "E:\\Program\\upload";
		int size=10*1024*1024;
		MultipartRequest mr = new MultipartRequest(request, path, size, "UTF-8",
				new DefaultFileRenamePolicy());
		
		// 필요 데이터 파라미터 변수로 가져오기
		int idx = Integer.parseInt(mr.getParameter("idx"));				// 회원idx
		int psb_idx = Integer.parseInt(mr.getParameter("psb_idx"));		// 게시글 idx
		
		String title = mr.getParameter("title");			// 제목
		String content = mr.getParameter("content");		// 내용
		String ps_sdate = mr.getParameter("ps_sdate");		// 시작일
		String ps_fdate = mr.getParameter("ps_fdate");		// 종료일
		String[] p_size = mr.getParameterValues("size");	// 맡을 수 있는 반려견 사이즈(소형, 중형, 대형)
		String[] terms = mr.getParameterValues("terms");	// 조건
		String m_addr = mr.getParameter("m_addr");			// 기본주소
		String g_fname = mr.getFilesystemName("pic");		// 사진파일이름
		String comment = mr.getParameter("comment");		// 코멘트

		Date ps_sdate1 = Date.valueOf(ps_sdate);
		Date ps_fdate1 = Date.valueOf(ps_fdate);
		
		// Ps_board에 정의
		Ps_board dto = new Ps_board();
		dto.setPsb_idx(psb_idx);
		dto.setIdx(idx);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setPs_sdate(ps_sdate1);
		dto.setPs_fdate(ps_fdate1);
		dto.setP_size(Arrays.toString(p_size));
		dto.setTerms(Arrays.toString(terms));
		dto.setM_addr(m_addr);
		dto.setG_fname(g_fname);
		dto.setComment(comment);
		
		// 펫시터게시글(ps_board) update
		dao.psb_update(dto);
		
		// 알림메세지와 url 선언 및 정의 후 alert.jsp로 전달
		String message = "내용이 수정되었습니다.";
		String url = "/ps_board_read.do?idx="+idx+"&psb_idx="+psb_idx;
		
		request.setAttribute("message", message);
		request.setAttribute("url", url);
		
		
		forward.isRedirect = false;
		forward.url = "./error/alert.jsp";
		return forward;
	}

}
