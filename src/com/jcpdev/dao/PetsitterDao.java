package dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.AdopttimeDto;
import dto.AdopttimeDto_second;
import dto.PetsitterDto;
import mybatis.SqlSessionBean;

public class PetsitterDao {
	SqlSessionFactory factory = SqlSessionBean.getSessionFactory();
	private static PetsitterDao dao = new PetsitterDao();
	//java.lang.NoClassDefFoundError: Could not initialize class dao.AddressDao 
	//-> 이 오류는 db 연결문제 
	private PetsitterDao() { }
	public static PetsitterDao getInstance() {
		return dao;
	}
	
	public List<PetsitterDto> select(AdopttimeDto_second ado) {
		//SqlSession mapper = sqlFactory.openSession(true); //auto commit을 true
		List<PetsitterDto> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("petsitter.PetSitter_Select", ado); 
		mapper.close();
		return list;
	}
	
	public PetsitterDto selectOne(int idx) {
		PetsitterDto Petsitter_Per = null;
		SqlSession mapper = factory.openSession();
		Petsitter_Per = mapper.selectOne("petsitter.petsitter_Select_one", idx); 
		mapper.close();
		return Petsitter_Per;
	}
	
	//테이블 데이터 행의 개수 조회
	public int getCount(AdopttimeDto total_cnt) {
		SqlSession mapper = factory.openSession();
		int cnt = mapper.selectOne("petsitter.getCount", total_cnt);
		mapper.close();     
		return cnt;
	}
	
	//체크박스 , 주소, 조건 모두 입력안했을때 행의 갯수
		public int getCount_All() {
			SqlSession mapper = factory.openSession();
			int cnt = mapper.selectOne("petsitter.getCount_All");
			mapper.close();     
			return cnt;
		}
			
	//주소만 입력했을때 행의 개수
	public int getCount_Adrr(AdopttimeDto addr) {
		SqlSession mapper = factory.openSession();
		int cnt = mapper.selectOne("petsitter.getCount_Adrr",addr);
		mapper.close();     
		return cnt;
	}
		
	//체크박스 , 주소, 조건 모두 입력안했을때 모두출력하게하는 sql
	public List<PetsitterDto> select_All(AdopttimeDto_second ado2) {
		//SqlSession mapper = sqlFactory.openSession(true); //auto commit을 true
		List<PetsitterDto> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("petsitter.PetSitter_Select_All",ado2); 
		mapper.close();
		return list;
	}
		
	//체크박스 , 주소, 조건 모두 입력안했을때 모두출력하게하는 sql
	public List<PetsitterDto> select_addr(AdopttimeDto_second ado3) {
		//SqlSession mapper = sqlFactory.openSession(true); //auto commit을 true
		List<PetsitterDto> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("petsitter.PetSitter_Select_Addr",ado3); 
		mapper.close();
		return list;
	}
	
	//주소 날짜란만 입력하고 조회했을때 행의 총 갯수sql 
	public int getCount_Add_Date(AdopttimeDto add_date) {
		SqlSession mapper = factory.openSession();
		int cnt = mapper.selectOne("petsitter.getCount_Add_Date",add_date);
		mapper.close();     
		return cnt;
	}
			
	//주소 날짜란만 입력하고 조회했을때 행 조회 sql 
	public List<PetsitterDto> select_addr_date(AdopttimeDto_second addr_date) {
		//SqlSession mapper = sqlFactory.openSession(true); //auto commit을 true
		List<PetsitterDto> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("petsitter.PetSitter_Select_Addr_date",addr_date); 
		mapper.close();
		return list;
	}	
	
	//조건만 체크 하고 조회했을때 행의 갯수 sql
	public int getCount_terms(AdopttimeDto terms) {
		SqlSession mapper = factory.openSession();
		int cnt = mapper.selectOne("petsitter.getCount_terms", terms);
		mapper.close();     
		return cnt;
	}	
		
	//조건만 체크하고 조회했을때 행의갯수
	public List<PetsitterDto> select_terms(AdopttimeDto_second select_terms) {
		//SqlSession mapper = sqlFactory.openSession(true); //auto commit을 true
		List<PetsitterDto> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("petsitter.PetSitter_Select_terms",select_terms); 
		mapper.close();
		return list;
	}
	
	//주소와 체크박스만 기입을 했을때
	public int getCount_Adrr_terms(AdopttimeDto addr_terms) {   //추가
		SqlSession mapper = factory.openSession();
		int cnt = mapper.selectOne("petsitter.getCount_Adrr_terms",addr_terms);
		mapper.close();     
		return cnt;
	}
		
	//조건만 체크하고 조회했을때 행의갯수
	public List<PetsitterDto> select_Adrr_terms(AdopttimeDto_second Adrr_terms) { //추가
		//SqlSession mapper = sqlFactory.openSession(true); //auto commit을 true
		List<PetsitterDto> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("petsitter.select_Adrr_terms",Adrr_terms); 
		mapper.close();
		return list;
	}
	
}
