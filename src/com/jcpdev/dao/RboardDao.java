package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Rboard;
import mybatis.SqlSessionBean;

public class RboardDao {

	SqlSessionFactory factory = SqlSessionBean.getSessionFactory();
	private static RboardDao dao = new RboardDao();

	private RboardDao() {
	}

	public static RboardDao getInstance() {
		return dao;
	}

	public List<Rboard> getList(Map<String, Integer> map) {
		List<Rboard> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("rboard.getList", map);
		mapper.close();
		return list;
	}

	public Rboard getOne(int r_idx) {
		SqlSession mapper = factory.openSession();
		Rboard dto = mapper.selectOne("rboard.selectByIdx", r_idx);
		mapper.close();
		return dto;
	}
	public Rboard getStar(int r_idx) {
		SqlSession mapper = factory.openSession();
		Rboard dto = mapper.selectOne("rboard.getStar",r_idx);
		mapper.close();
		return dto;
	}
	public int getCount() {
		SqlSession mapper = factory.openSession();
		int cnt = mapper.selectOne("rboard.getCount");
		mapper.close();
		return cnt;
	}

	public void insert(Rboard dto) {
		SqlSession mapper = factory.openSession();
		mapper.insert("rboard.insert", dto);
		mapper.commit();
		mapper.close();
	}

	public void update(Rboard dto) {
		SqlSession mapper = factory.openSession();
		mapper.update("rboard.update", dto);
		mapper.commit();
		mapper.close();
	}

	public int delete(Rboard dto) {
		SqlSession mapper = factory.openSession();
		int n = mapper.delete("rboard.delete", dto);
		mapper.commit();
		mapper.close();
		return n;
	}
	
	public void r_cnt(int r_idx) {
		SqlSession mapper = factory.openSession();
		mapper.update("rboard.r_cnt", r_idx);
		mapper.commit();
		mapper.close();
	}

	public Rboard passwordCheck(Map<String, Object> map) {
		SqlSession mapper = factory.openSession();
		Rboard dto = mapper.selectOne("rboard.passwordCheck", map);
		mapper.close();
		return dto;
	}
	

	
}
