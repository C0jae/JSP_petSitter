package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Member;
import dto.Pet;
import dto.Ps_board;
import dto.R_board;
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
	
	public Member m_getList(int idx) {	// 회원정보 불러오기
		SqlSession mapper = factory.openSession();
		Member dto = mapper.selectOne("ps_board.m_getList", idx);
		mapper.close();
		return dto;
	}
	
	public R_board rate(String ps_nick) {	// 펫시터 평점 불러오기
		SqlSession mapper = factory.openSession();
		R_board dto = mapper.selectOne("ps_board.rate", ps_nick);
		mapper.close();
		return dto;
	}
	
	public R_board rateCnt(String ps_nick) {	// 펫시터 후기 갯수 불러오기
		SqlSession mapper = factory.openSession();
		R_board dto = mapper.selectOne("ps_board.rateCnt", ps_nick);
		mapper.close();
		return dto;
	}
	
	public void psr_insert(Reservation dto) {		// 예약테블에 insert
		SqlSession mapper = factory.openSession();
		mapper.insert("ps_board.psr_insert", dto);
		mapper.commit();
		mapper.close();
	}
	
	public void plusPoint(Map<String, Integer> map) {	// 펫시터 포인트 증가
		SqlSession mapper = factory.openSession();
		mapper.update("ps_board.plusPoint", map);
		mapper.commit();
		mapper.close();
	}
	
	public void minusPoint(Map<String, Integer> map) {	// 예약자 포인트 감소
		SqlSession mapper = factory.openSession();
		mapper.update("ps_board.minusPoint", map);
		mapper.commit();
		mapper.close();
	}
	
	public void plusIncome(Map<String, Integer> map) {	// 거래에 따른 수익 insert
		SqlSession mapper = factory.openSession();
		mapper.update("ps_board.plusIncome", map);
		mapper.commit();
		mapper.close();
	}
	
	
	
	
}
