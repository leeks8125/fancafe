package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.MemberDTO;

public class MemberDAO {

	
	//싱글톤
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getIstance() {
		return instance;
	}
	
	// 컨넥션풀에서 컨넥션을 구해오는 메소드
	private Connection getConnection() throws Exception{
		Context init = new InitialContext();
  		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
  		return ds.getConnection();
	}
	
	
	
	//회원가입
	public int insert(MemberDTO member) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			
			String sql="insert into member values(?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?)";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, member.getId());
			ps.setString(2, member.getPass());
			ps.setString(3, member.getName());
			ps.setString(4, member.getMailid());
			ps.setString(5, member.getDomain());
			ps.setString(6, member.getPost());
			ps.setString(7, member.getAddress());
			ps.setString(8, member.getBirth());
			ps.setString(9, member.getPhone1());
			ps.setString(10, member.getPhone2());
			ps.setString(11, member.getPhone3());
			ps.setString(12, member.getSex());
			ps.setInt(13, 0);   //grade
			ps.setInt(14, 0);   //state

			result = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		

		return result;
	}
	
	// ID 중복검사
	public int idcheck(String id) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql="select * from member where id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = 1;
			}else {
				result = -1;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		
		return result;
	}
	
	//로그인 회원인증
	public int login(String id, String pass) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql="select * from member where id=? and pass=?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = 1;
			}else {
				result = -1;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		
		
		return result;
	}
	
	// 내정보 구해오기(로그인사용자)
	public MemberDTO getmyinfo(String id) {
		MemberDTO member = new MemberDTO();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql ="select * from member where id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				member.setId(rs.getString("id"));
				member.setPass(rs.getString("pass"));
				member.setName(rs.getString("name"));
				member.setMailid(rs.getString("mailid"));
				member.setDomain(rs.getString("domain"));
				member.setPost(rs.getString("post"));
				member.setAddress(rs.getString("address"));
				member.setBirth(rs.getString("birth"));
				member.setPhone1(rs.getString("phone1"));
				member.setPhone2(rs.getString("phone2"));
				member.setPhone3(rs.getString("phone3"));
				member.setSex(rs.getString("sex"));
				member.setReg_date(rs.getTimestamp("reg_date"));
				member.setGrade(rs.getInt("grade"));
				member.setState(rs.getInt("state"));
			}
				
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		
		
		return member;
	}
	
	// 내정보 업데이트
	public int updateinsert(MemberDTO member) {
		int result = 0;
		Connection con =null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			
			String sql="update member set name=?, mailid=?, domain=?, post=?, address=?,";
				   sql+="birth=?, phone1=?, phone2=?, phone3=?, sex=? where id=?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getName());
			ps.setString(2, member.getMailid());
			ps.setString(3, member.getDomain());
			ps.setString(4, member.getPost());
			ps.setString(5, member.getAddress());
			ps.setString(6, member.getBirth());
			ps.setString(7, member.getPhone1());
			ps.setString(8, member.getPhone2());
			ps.setString(9, member.getPhone3());
			ps.setString(10, member.getSex());
			ps.setString(11, member.getId());
			
			result = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		
		
		
		return result;
	}
	
	// 회원탈퇴
	public int quitmemberoperation(MemberDTO member) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			
			String sql="update member set state=? where id=?";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.setString(2, member.getId());
			
			result = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		
		
		return result;
	}
	
	// 비밀번호 변경
	public int updatepassinsert(MemberDTO member) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			
			String sql = "update member set pass=? where id=?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getPass());
			ps.setString(2, member.getId());
			
			result = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		
		return result;
	}
	
	// 아이디 찾기
	public MemberDTO getmyid(String name, String mailid, String domain) {
		MemberDTO member = new MemberDTO();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql ="select * from member where name=? and mailid=? and domain=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, mailid);
			ps.setString(3, domain);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				member.setId(rs.getString("id"));
			}else {
				member = null;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		
		
		return member;
	}
	
	// 비밀번호 찾기
	public MemberDTO getmypass(String id, String name, String mailid, String domain) {
		MemberDTO member = new MemberDTO();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql ="select * from member where id=? and name=? and mailid=? and domain=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, mailid);
			ps.setString(4, domain);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				member.setPass(rs.getString("pass"));
			}else {
				member = null;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		
		
		return member;
	}
	
	
	
}
