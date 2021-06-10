package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.NoticeBean;

public class NoticeDAO {
	
	// 싱글톤
	private static NoticeDAO instance = new NoticeDAO();
	
	public static NoticeDAO getInstance() {
		return instance;
	}
	
	// 커넥션 풀
	private Connection getConnection() throws Exception {
		Context init = new InitialContext();
  		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
  		return ds.getConnection();
	}
	
	// 글 작성
	public int insert(NoticeBean notice) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
			String sql = "insert into notice values(notice_seq.nextval, ?, ?, ?, ?, sysdate)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, notice.getId());
			pstmt.setString(2, notice.getSubject());
			pstmt.setString(3, notice.getContent());
			pstmt.setInt(4, 0);
			
			result = pstmt.executeUpdate();	// SQL문 실행
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
		}
		
		return result;
	}
	
	// 총 데이터 갯수
	public int getCount() {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql = "select count(*) from notice";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();	// SQL문 실행
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(pstmt != null) try { pstmt.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
		}
		
		return result;
	}
	
	// 글 목록
	public List<NoticeBean> getList(int start, int end) {
		List<NoticeBean> list = new ArrayList<NoticeBean>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql = "select * from (select rownum rnum, notice.* from ";
				sql += " (select * from notice order by num desc) notice) ";
				sql += " where rnum >= ? and rnum <= ? ";
				
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();	// SQL문 실행
			
			while(rs.next()) {
				NoticeBean notice = new NoticeBean();
				notice.setNum(rs.getInt("num"));
				notice.setId(rs.getString("id"));
				notice.setSubject(rs.getString("subject"));
				notice.setContent(rs.getString("content"));
				notice.setReadcount(rs.getInt("readcount"));
				notice.setReg_date(rs.getTimestamp("reg_date"));
				
				list.add(notice);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(pstmt != null) try { pstmt.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
		}
		
		return list;
	}
	
	// 조회수 증가
	public void readcountUpate(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
			String sql = "update notice set readcount = readcount+1 ";
				sql += " where num = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();	// SQL문 실행
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try { pstmt.close(); }catch(Exception e) {}
			if(con!=null) try { con.close(); }catch(Exception e) {}
		}
		
	}
	
	// 상세 페이지
	public NoticeBean getDetail(int num) {
		NoticeBean notice = new NoticeBean();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql = "select * from notice where num = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();		// SQL문 실행
			
			if(rs.next()) {
				notice.setNum(rs.getInt("num"));
				notice.setId(rs.getString("id"));
				notice.setSubject(rs.getString("subject"));
				notice.setContent(rs.getString("content"));
				notice.setReadcount(rs.getInt("readcount"));
				notice.setReg_date(rs.getTimestamp("reg_date"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try { rs.close(); }catch(Exception e) {}
			if(pstmt!=null) try { pstmt.close(); }catch(Exception e) {}
			if(con!=null) try { con.close(); }catch(Exception e) {}
		}
		
		return notice;
	}
	
	// 글 수정
	public int update(NoticeBean notice) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
			String sql = "update notice set subject= ?, content= ? where num = ?";
				
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, notice.getSubject());
			pstmt.setString(2, notice.getContent());
			pstmt.setInt(3, notice.getNum());
			result = pstmt.executeUpdate();		// SQL문 실행
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try { pstmt.close(); }catch(Exception e) {}
			if(con!=null) try { con.close(); }catch(Exception e) {}
		}
		
		return result;
	}
	
	// 글 삭제
	public int delete(int num) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
			String sql = "delete from notice where num = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			result = pstmt.executeUpdate();	// SQL문 실행
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try { pstmt.close(); }catch(Exception e) {}
			if(con!=null) try { con.close(); }catch(Exception e) {}
		}
		
		return result;
	}
	
}
