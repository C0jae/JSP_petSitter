package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import dto.Admin;
import mybatis.SqlSessionBean;

public class AdminDao {
	private static AdminDao dao = new AdminDao();
	private AdminDao() { }
	public static AdminDao getInstance() {
		return dao;
	}
	
	SqlSessionFactory factory = SqlSessionBean.getSessionFactory();
	
	public List<Admin> selectAll(Map<String, Integer> map){
		List<Admin> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("admin.selectAll",map);
		return list;
	}
	public Admin select(int a_idx) {
		SqlSession mapper = factory.openSession();
		Admin dto = mapper.selectOne("admin.selectOne",a_idx);
		mapper.close();
		return dto;
	}
	
	public int insert(Admin a_dto) {
		SqlSession mapper = factory.openSession();
		mapper.insert("admin.insert",a_dto);
		mapper.commit();
		mapper.close();
		return a_dto.getA_idx();
	}
	public int delete(int a_idx) {
		SqlSession mapper =factory.openSession();
		int n = mapper.delete("admin.delete", a_idx);
		mapper.commit();
		mapper.close();
		return n;
	}
	public int update(Admin a_dto) {
		SqlSession mapper = factory.openSession();
		int n=mapper.update("admin.update", a_dto);
		mapper.commit();
		mapper.close();
		return n;
	}
	
	public Admin login(Map<String,String> map) {
		Admin a_dto = null;
		SqlSession mapper = factory.openSession();
		a_dto = mapper.selectOne("admin.loginCheck",map);
		return a_dto;
	}
}
