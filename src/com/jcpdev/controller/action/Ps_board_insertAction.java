/*
 *  작성자 : 최영재
 *  기능 : 펫시터 게시글 등록
 */

package controller.action;

import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.PetProfileDao;
import dao.Ps_boardDao;
import dto.Pet;
import dto.Ps_board;

// By최영재 - 펫시터 게시글 저장
public class Ps_board_insertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		Ps_boardDao dao = Ps_boardDao.getInstance();
		request.setCharacterEncoding("UTF-8");
		
		
		// 사진파일 받아올 경로 및 크기 설정
		String path = "E:\\Program\\upload";
		int size=10*1024*1024;
		MultipartRequest mr = new MultipartRequest(request, path, size, "UTF-8",
				new DefaultFileRenamePolicy());
		
		// 입력받은 게시글 내용 및 정보 불러오기(회원idx, 제목, 내용, 날짜 등)
		int idx = Integer.parseInt(mr.getParameter("idx")); // 펫시터 idx
		String title = mr.getParameter("title");			// 제목
		String content = mr.getParameter("content");		// 내용
		String ps_sdate = mr.getParameter("ps_sdate");		// 시작일
		String ps_fdate = mr.getParameter("ps_fdate");		// 종료일
		String[] p_size = mr.getParameterValues("size");	// 맡을 수 있는 반려동물 크기(소형, 중형, 대형)
		String[] terms = mr.getParameterValues("terms");	// 조건(마당있음, 픽업가능 등)
		String m_addr = mr.getParameter("m_addr");			// 기본주소
		String g_fname = mr.getFilesystemName("pic");		// 사진
		String comment = mr.getParameter("comment");		// 코멘트

		Date ps_sdate1 = Date.valueOf(ps_sdate);
		Date ps_fdate1 = Date.valueOf(ps_fdate);
		
		// 불러온 값을 Ps_board에 정의
		Ps_board dto = new Ps_board();
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
		
		// 펫시터 게시글(ps_board)에 insert
		dao.psb_insert(dto);
		
		// 알림 메세지 및 url 정의 후 alert.jsp로 이동
		String message = "내용저장이 완료되었습니다.";
		String message2 = "펫정보를 입력해주세요.";
		String url = "./community/pet_insert.jsp";
		
		request.setAttribute("message", message);
		request.setAttribute("message2", message2);
		request.setAttribute("url", url);
		
		
		forward.isRedirect = false;
		forward.url = "./error/alert.jsp";
		return forward;
	}

}
