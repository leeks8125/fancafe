// DAO(Data Access Object)
package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.QnaBean;

public class QnaDAO {

	// 싱글톤
	private static QnaDAO instance = new QnaDAO();
	
	public static QnaDAO getInstance() {
		return instance;
	}
	
	// 컨넥션풀에서 컨넥션을 구해오는 메소드
	private Connection getConnection() throws Exception{
		Context init = new InitialContext();
  		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
  		return ds.getConnection();
	}
	
	// 글작성 : 원문작성
	public int insert(QnaBean qna) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();

 String sql="insert into qna values(qna_seq.nextval, ?, ?, ?, ?, qna_seq.nextval, ?, ?, ?, sysdate)";	
 
       		pstmt = con.prepareStatement(sql);
       		pstmt.setString(1, qna.getId());
       		pstmt.setString(2, qna.getPasswd());
       		pstmt.setString(3, qna.getSubject());
      		pstmt.setString(4, qna.getContent());
       		pstmt.setInt(5, 0);		// re_lev
       		pstmt.setInt(6, 0);     // re_seq
       		pstmt.setInt(7, 0);     // readcount
       		
       		result = pstmt.executeUpdate();		// SQL문 실행
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try { pstmt.close(); }catch(Exception e) {}
			if(con!=null) try { con.close(); }catch(Exception e) {}
		}
		
		return result;
	}
	
	
	// 총 데이터 갯수 구하기
	public int getCount() {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql="select count(*) from qna";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();	// SQL문 실행
			
			if(rs.next()) {
				result = rs.getInt("count(*)");

			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) try { rs.close(); }catch(Exception e) {}
			if(pstmt!=null) try { pstmt.close(); }catch(Exception e) {}
			if(con!=null) try { con.close(); }catch(Exception e) {}
		}
		
		return result;
	}
	
	
	// 글목록
	public List<QnaBean> getList(int start, int end){
		List<QnaBean> list = new ArrayList<QnaBean>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();

String sql="select * from (select rownum rnum, qna.*  from ";
	   sql+= " (select * from qna order by board_re_ref desc, board_re_seq asc) qna ) ";
	   sql+= " where rnum>=? and rnum<=?";	
	   
	   		pstmt = con.prepareStatement(sql);
	   		pstmt.setInt(1, start);
	   		pstmt.setInt(2, end);
	   		
	   		rs = pstmt.executeQuery();	// SQL문 실행
	   		
	   		while(rs.next()) {
	   			QnaBean qna = new QnaBean();
	   			qna.setNum(rs.getInt("num"));
	   			qna.setId(rs.getString("id"));
	   			qna.setPasswd(rs.getString("passwd"));
	   			qna.setSubject(rs.getString("subject"));
	   			qna.setContent(rs.getString("content"));
	   			qna.setBoard_re_ref(rs.getInt("board_re_ref"));
	   			qna.setBoard_re_lev(rs.getInt("board_re_lev"));
	   			qna.setBoard_re_seq(rs.getInt("board_re_seq"));
	   			qna.setReadcount(rs.getInt("readcount"));
	   			qna.setReg_date(rs.getTimestamp("reg_date"));
	   			
	   			list.add(qna);
	   		}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) try { rs.close(); }catch(Exception e) {}
			if(pstmt!=null) try { pstmt.close(); }catch(Exception e) {}
			if(con!=null) try { con.close(); }catch(Exception e) {}
		}
		
		return list;
	}
	
	
	// 조회수 증가
	public void readcountUpdate(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
String sql="update qna set readcount=readcount+1 ";
       sql+=" where num = ?";		

       		pstmt = con.prepareStatement(sql);
       		pstmt.setInt(1, num);
       		pstmt.executeUpdate();		// SQL문 실행
       
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try { pstmt.close(); }catch(Exception e) {}
			if(con!=null) try { con.close(); }catch(Exception e) {}
		}
		
	}
	
	// 상세 페이지
	public QnaBean getDetail(int num) {
		QnaBean qna = new QnaBean();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql="select * from qna where num=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();		// SQL문 실행
			
			if(rs.next()) {
				qna.setNum(rs.getInt("num"));
				qna.setId(rs.getString("id"));
				qna.setPasswd(rs.getString("passwd"));
				qna.setSubject(rs.getString("subject"));
				qna.setContent(rs.getString("content"));
				qna.setBoard_re_ref(rs.getInt("board_re_ref"));
				qna.setBoard_re_lev(rs.getInt("board_re_lev"));
				qna.setBoard_re_seq(rs.getInt("board_re_seq"));
				qna.setReadcount(rs.getInt("readcount"));
				qna.setReg_date(rs.getTimestamp("reg_date"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) try { rs.close(); }catch(Exception e) {}
			if(pstmt!=null) try { pstmt.close(); }catch(Exception e) {}
			if(con!=null) try { con.close(); }catch(Exception e) {}
		}
		
		return qna;
	}
	
	
	// 댓글 작성
	public int qnaReply(QnaBean qna) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		// 부모글에 대한 정보 
		int board_re_ref = qna.getBoard_re_ref();
		int board_re_lev = qna.getBoard_re_lev();
		int board_re_seq = qna.getBoard_re_seq();
		
		try {
			con = getConnection();
			
	String sql="update qna set board_re_seq=board_re_seq+1 ";
		   sql+=" where board_re_ref=? and board_re_seq > ?";	
		   
		    pstmt = con.prepareStatement(sql);
		    pstmt.setInt(1, board_re_ref);
		    pstmt.setInt(2, board_re_seq);
		    pstmt.executeUpdate();
		    
   sql="insert into qna values(qna_seq.nextval,?,?,?,?,?,?,?,?,sysdate)";

   			pstmt = con.prepareStatement(sql);
   			pstmt.setString(1, qna.getId());
   			pstmt.setString(2, qna.getPasswd());
   			pstmt.setString(3, qna.getSubject());
   			pstmt.setString(4, qna.getContent());
   			pstmt.setInt(5, board_re_ref);    	// re_ref
   			pstmt.setInt(6, board_re_lev+1);  	// re_lev
   			pstmt.setInt(7, board_re_seq+1);  	// re_seq
   			pstmt.setInt(8, 0);  				// readcount

   			result = pstmt.executeUpdate();	// SQL문 실행
   
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try { pstmt.close(); }catch(Exception e) {}
			if(con!=null) try { con.close(); }catch(Exception e) {}
		}
		
		return result;
	}
	
	
	// 글수정
	public int update(QnaBean qna) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
	String sql="update qna set id=?, subject=?,";
	       sql+="content=? where num = ?";
	       
	       pstmt = con.prepareStatement(sql);
	       pstmt.setString(1, qna.getId());
	       pstmt.setString(2, qna.getSubject());
	       pstmt.setString(3, qna.getContent());
	       pstmt.setInt(4, qna.getNum());
	       
	       result = pstmt.executeUpdate();	// SQL문 실행
	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try { pstmt.close(); }catch(Exception e) {}
			if(con!=null) try { con.close(); }catch(Exception e) {}
		}		
		
		return result;
	}
	
	
	// 글삭제
	public int delete(int num) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
			String sql="delete from qna where num=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			result = pstmt.executeUpdate();		// SQL문 실행
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try { pstmt.close(); }catch(Exception e) {}
			if(con!=null) try { con.close(); }catch(Exception e) {}
		}
		
		return result;
	}
	

	
}


