package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.GalleryBean;



public class GalleryDAO_test {

	// 싱글톤
	private static GalleryDAO_test instance = new GalleryDAO_test();
	
	public static GalleryDAO_test getInstance() {
		return instance;
	}
	
	// 컨넥션풀에서 컨넥션을 구해오는 메소드
	private Connection getConnection() throws Exception{
		Context init = new InitialContext();
  		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
  		return ds.getConnection();
	}
	
	// 글작성 : 원문작성
	public int insert(GalleryBean gallery) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();

			String sql="insert into gallery values(gallery_seq.nextval,?,?,?,sysdate,?,?)";
       
       		pstmt = con.prepareStatement(sql);
//       		pstmt.setInt(1, gallery.getNo());
       		pstmt.setString(1, gallery.getAuthor());
       		pstmt.setString(2, gallery.getTitle());
     		pstmt.setInt(3, 0);
//       		pstmt.setString(5, gallery.getUploaddate());
       		pstmt.setString(4, gallery.getFname());
       		pstmt.setString(5, gallery.getContents());
       		
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
			
			String sql="select count(*) from gallery";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();	// SQL문 실행
			
			if(rs.next()) {
//				result = rs.getInt(1);
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
	public List<GalleryBean> getList(){
		List<GalleryBean> list = new ArrayList<GalleryBean>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();

			String sql="select * from gallery order by uploaddate desc";	
	   
	   		pstmt = con.prepareStatement(sql);

	   		
	   		rs = pstmt.executeQuery();	// SQL문 실행
	   		
	   		while(rs.next()) {
	   			GalleryBean gallery = new GalleryBean();
	   			gallery.setNo(rs.getInt("no"));
	   			gallery.setTitle(rs.getString("title"));
	   			gallery.setContents(rs.getString("contents"));
	   			gallery.setFname(rs.getString("fname"));
	   			gallery.setAuthor(rs.getString("author"));
	   			gallery.setHits(rs.getInt("hits"));
	   			gallery.setUploaddate(rs.getString("uploaddate"));
	   			
	   			list.add(gallery);
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
	public void readcountUpdate(int hits) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
			String sql="update gallery set hits=hits+1 ";
			       sql+=" where no = ?";		

       		pstmt = con.prepareStatement(sql);
       		pstmt.setInt(1, hits);
       		pstmt.executeUpdate();		// SQL문 실행
       
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try { pstmt.close(); }catch(Exception e) {}
			if(con!=null) try { con.close(); }catch(Exception e) {}
		}
		
	}
	
	
	// 상세 페이지
	public GalleryBean getDetail(int hits) {
		GalleryBean gallery = new GalleryBean();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql="select * from gallery where no=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, hits);
			rs = pstmt.executeQuery();		// SQL문 실행
			
			if(rs.next()) {
				gallery.setNo(rs.getInt("no"));
	   			gallery.setTitle(rs.getString("title"));
	   			gallery.setContents(rs.getString("contents"));
	   			gallery.setFname(rs.getString("fname"));
	   			gallery.setAuthor(rs.getString("author"));
	   			gallery.setHits(rs.getInt("hits"));
	   			gallery.setUploaddate(rs.getString("uploaddate"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) try { rs.close(); }catch(Exception e) {}
			if(pstmt!=null) try { pstmt.close(); }catch(Exception e) {}
			if(con!=null) try { con.close(); }catch(Exception e) {}
		}
		
		return gallery;
	}
	
	// 글 수정
	public int update(GalleryBean gallery) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
			String sql="update gallery set title= ?, contents= ? where no = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, gallery.getTitle());
			pstmt.setString(2, gallery.getContents());
			pstmt.setInt(3, gallery.getNo());
			result = pstmt.executeUpdate();	//SQL문 실행
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null)
				try {
					pstmt.close();
				}catch(Exception e) {
					
				}
			if(con!= null) 
				try {
					con.close();
				}catch(Exception e)	{
					
				}
		}
		
		return result;
	}

	//글 삭제
	public int delete(int hits) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
			String sql="delete from gallery where no=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, hits);
			result = pstmt.executeUpdate();		//SQL문 실행
						
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			if(pstmt!=null)
				try {
					pstmt.close();
				}catch(Exception e) {
					
				}
			if(con!= null) 
				try {
					con.close();
				}catch(Exception e)	{
					
				}
		}
		
		return result;
	}
	
	
}
