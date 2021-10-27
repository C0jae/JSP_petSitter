package dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Rate;
import mybatis.SqlSessionBean;

public class RateDao {
	SqlSessionFactory factory = SqlSessionBean.getSessionFactory();
	private static RateDao dao = new RateDao();
	
	private RateDao() {}
	public static RateDao getInstance() {
		return dao;
	}
	
	public int getIdx(String ps_nick) {
		SqlSession mapper = factory.openSession();
		int idx = mapper.selectOne("getPsNick", ps_nick);
		mapper.close();
		return idx;
	}
	
	public void insert(Rate dto) {
		SqlSession mapper = factory.openSession();
		mapper.insert("rate.insert", dto);
		mapper.commit();
		mapper.close();
	}
	
	public void update(Rate dto) {
		SqlSession mapper = factory.openSession();
		mapper.update("rate.update",dto);
		mapper.commit();
		mapper.close();
	}
	
	
}
