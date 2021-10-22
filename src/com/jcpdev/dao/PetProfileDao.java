package dao;


import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Pet;
import mybatis.SqlSessionBean;

public class PetProfileDao {

	
		SqlSessionFactory factory = SqlSessionBean.getSessionFactory();
		private static PetProfileDao dao = new PetProfileDao();
		private PetProfileDao() {}
		public static PetProfileDao getInstance() {
			return dao;
		}
		
		public void p_insert(Pet dto) {
			SqlSession mapper = factory.openSession();
			mapper.insert("petprofile.p_insert", dto);
			mapper.commit();
			mapper.close();
		}
		
		public dto.Pet p_check(Map<String, String> map) {
			SqlSession mapper = factory.openSession();
			Pet dto = mapper.selectOne("petprofile.p_check", map);
			return dto;
		}
	
}
