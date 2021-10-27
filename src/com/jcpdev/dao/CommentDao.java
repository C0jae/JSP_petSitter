package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Comment;
import mybatis.SqlSessionBean;

public class CommentDao {
	
	SqlSessionFactory factory = SqlSessionBean.getSessionFactory();
	private static CommentDao dao = new CommentDao();
	
	private CommentDao() { }
	public static CommentDao getInstance() {
		return dao;
	}

	public List<Comment> getComments(int q_idx){   
		List<Comment> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("comment.getComments",q_idx);
		mapper.close();
		return list;
	}
	
	public void insert(Comment dto) {
		SqlSession mapper = factory.openSession();
		mapper.insert("comment.insert", dto);   // mapper xml 파일의 네임스페이스.id 로 첫번째 인자값.
		mapper.commit();
		mapper.close();
	}
	
	public void delete(int qc_idx) {
		SqlSession mapper = factory.openSession();
		mapper.delete("comment.delete", qc_idx);
		mapper.commit();
		mapper.close();
	}
	
	
	public void updateCommentCnt(int qc_idx) {
		SqlSession mapper = factory.openSession();
		mapper.update("comment.updateCommentCnt", qc_idx);
		mapper.commit();
		mapper.close();
	}
	
	public void updateCountAll(int qc_idx) {
		SqlSession mapper = factory.openSession();
		mapper.update("comment.updateCountAll", qc_idx);
		mapper.commit();
		mapper.close();
	}
	
	public String qc_cnt(int q_idx) {
		SqlSession mapper = factory.openSession();
		String qc_cnt = mapper.selectOne("comment.qc_cnt", q_idx);
		mapper.close();
		return qc_cnt;
	}
	
}
