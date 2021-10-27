package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Member;
import dto.SessionDto;
import mybatis.SqlSessionBean;

public class MembersDao {
	private static MembersDao dao = new MembersDao();
	private MembersDao() { }
	public static MembersDao getInstance() {
		return dao;
	}
	
	SqlSessionFactory factory = SqlSessionBean.getSessionFactory();
	
	public List<Member> selectAll(Map<String, Integer> map){
		List<Member> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("members.Members_selectAll",map);
		return list;
	}
	public Member select(int idx) {
		SqlSession mapper = factory.openSession();
		Member dto = mapper.selectOne("members.Members_selectOne",idx);
		mapper.close();
		return dto;
	}
	
	public int insert(Member dto) {
		SqlSession mapper = factory.openSession();
		mapper.insert("members.Members_insert",dto);
		mapper.commit();
		mapper.close();
		return dto.getIdx();
	}
	public int delete(Map<String,Object> map) {
		SqlSession mapper =factory.openSession();
		int n = mapper.delete("Members_delete", map);
		mapper.commit();
		mapper.close();
		return n;
	}
	public int update(Member dto) {
		SqlSession mapper = factory.openSession();
		int n=mapper.update("members.Members_update", dto);
		mapper.commit();
		mapper.close();
		return n;
	}
	public int update_point(Member dto) {
		SqlSession mapper = factory.openSession();
		int n=mapper.update("members.update_point", dto);
		mapper.commit();
		mapper.close();
		return n;
	}
	public SessionDto login(Map<String,String> map) {
		SessionDto dto = null;
		SqlSession mapper = factory.openSession();
		dto = mapper.selectOne("members.loginCheck",map);
		return dto;
	}
	public int IdCheck(String id){
		SqlSession mapper =factory.openSession();
		int count = mapper.selectOne("members.IdCheck", id);
		mapper.close();
		return count;
	}
	public int NickCheck(String nick){
		SqlSession mapper =factory.openSession();
		int cnt = mapper.selectOne("members.NickCheck", nick);
		mapper.close();
		return cnt;
	}

}


