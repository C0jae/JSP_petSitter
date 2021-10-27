package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import dto.RbMember;
import dto.SessionDto;
import mybatis.SqlSessionBean;

public class RbMemberDao {
	SqlSessionFactory factory = SqlSessionBean.getSessionFactory();
	private static RbMemberDao dao = new RbMemberDao();
	
	private RbMemberDao() {}
	
	public static RbMemberDao getInstance() {
		return dao;
	}
	public SessionDto login(Map<String,String> map) {
		SessionDto dto=null;
		SqlSession mapper = factory.openSession();
		dto = mapper.selectOne("rbmember.loginCheck", map);
		return dto;
	}
	public SessionDto admin(Map<String,String> map) {
		SessionDto dto=null;
		SqlSession mapper = factory.openSession();
		dto = mapper.selectOne("rbmember.adminCheck", map);
		return dto;
	}
	public int getCount() {
		SqlSession mapper = factory.openSession();
		int cnt = mapper.selectOne("rbmember.getCount");
		mapper.close();
		return cnt;
	}
	public List<RbMember> getList(Map<String,Integer> map) {
		List<RbMember> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("rbmember.getList", map);
		mapper.close();
		return list;
	}
	public List<RbMember> getPsList(String nick) {
		List<RbMember> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("rbmember.psbyNick",nick);
		mapper.close();
		return list;
	}
	
	public int resultCount(String nick) {
		SqlSession mapper = factory.openSession();
		int cnt = mapper.selectOne("rbmember.resultCount", nick);
		mapper.close();
		return cnt;
	}
	
}
