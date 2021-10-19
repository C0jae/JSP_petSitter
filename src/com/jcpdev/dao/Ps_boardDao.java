package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Gallery;
import dto.Member;
import dto.Pet;
import dto.Ps_board;
import dto.Rate;
import dto.Reservation;
import mybatis.SqlSessionBean;

public class Ps_boardDao {
	
	SqlSessionFactory factory = SqlSessionBean.getSessionFactory();
	private static Ps_boardDao dao = new Ps_boardDao();
	
	private Ps_boardDao() { }
	
	public static Ps_boardDao getInstance() {
		return dao;
	}
	
	public void psb_insert(Ps_board dto) {	// 펫시터 게시글 작성
		SqlSession mapper = factory.openSession();
		mapper.insert("ps_board.psb_insert", dto);
		mapper.commit();
		mapper.close();
	}
	
	public void g_insert(Gallery dto) {	// 펫시터 게시글 사진 저장
		SqlSession mapper = factory.openSession();
		mapper.insert("ps_board.g_insert", dto);
		mapper.commit();
		mapper.close();
	}
	
	public List<Gallery> g_getList(int psb_idx) {	// 펫시터 게시글 사진 불러오기
		List<Gallery> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("ps_board.g_getList", psb_idx);
		mapper.close();
		return list;
	}
	
	public Ps_board ps_getList(int psb_idx) {	// 펫시터 게시글 불러오기
		SqlSession mapper = factory.openSession();
		Ps_board dto = mapper.selectOne("ps_board.ps_getList", psb_idx);
		return dto;
	}
	
	public List<Pet> p_getList(int idx) {	// 펫 리스트 불러오기
		List<Pet> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("ps_board.p_getList", idx);
		mapper.close();
		return list;
	}
	
	public Member m_getList(int idx) {	// 펫시터 정보 불러오기
		SqlSession mapper = factory.openSession();
		Member dto = mapper.selectOne("ps_board.m_getList", idx);
		mapper.close();
		return dto;
	}
	
	public Rate rate(int idx) {	// 펫시터 평점 불러오기
		SqlSession mapper = factory.openSession();
		Rate dto = mapper.selectOne("ps_board.rate", idx);
		mapper.close();
		return dto;
	}
	
	public void psr_insert(Reservation dto) {
		SqlSession mapper = factory.openSession();
		mapper.insert("ps_board.psr_insert", dto);
		mapper.commit();
		mapper.close();
	}
	
	
	
	
}
