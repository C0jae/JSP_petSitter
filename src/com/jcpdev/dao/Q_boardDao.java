package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Comment;
import dto.Q_board;
import mybatis.SqlSessionBean;

public class Q_boardDao {

	
	SqlSessionFactory factory = SqlSessionBean.getSessionFactory();
	private static Q_boardDao dao = new Q_boardDao();
	
	private Q_boardDao() { }
	public static Q_boardDao getInstance() {
		return dao;
	}
	//getList
	public List<Q_board> getList(Map<String, Integer> map){   
							//key(변수명처럼 이해) String, value  는 int
		List<Q_board> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("q_board.getList",map);
		return list;
	}
	
	//idx로 한개 행 조회
	public Q_board getOne(int idx) {
		SqlSession mapper = factory.openSession();
		Q_board dto = mapper.selectOne("q_board.selectByIdx", idx);  
		mapper.close();
		return dto;
	}
	
	//테이블 데이터 행의 개수 조회
	public int getCount() {
		SqlSession mapper = factory.openSession();
		int cnt = mapper.selectOne("q_board.getCount");  
		mapper.close();     
		return cnt;
	}
	
	public void insert(Q_board dto) {
		SqlSession mapper = factory.openSession();
		mapper.insert("q_board.insert",dto);
		mapper.commit();
		mapper.close();
	}
	
	public void update(Q_board dto) {
		SqlSession mapper = factory.openSession();
		mapper.update("q_board.update",dto);
		mapper.commit();
		mapper.close();
	}
	
	public int delete(Map<String,Object> map) {
		SqlSession mapper = factory.openSession();
		int n = mapper.delete("q_board.delete",map);
		mapper.commit();
		mapper.close();
		return n;
	}
	
	public Q_board passwordCheck(Map<String,Object> map) {
		SqlSession mapper = factory.openSession();
		Q_board dto = mapper.selectOne("q_board.passwordCheck", map);
		mapper.close();
		return dto;
	}
	
	public void q_cnt(int idx) {
		SqlSession mapper =factory.openSession();
		mapper.update("q_board.q_cnt", idx);
		mapper.commit();
		mapper.close();
	}
	
	public int qc_cnt(int q_idx) {
		
		SqlSession mapper =factory.openSession();
		int a =mapper.selectOne("q_board.qc_cnt", q_idx);
		mapper.close();
		return a;
	}
	
}
