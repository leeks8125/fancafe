package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.ModelBean;
import model.RemodelBean;
import model.MemberDTO;

public class BoardDao {
	private static BoardDao instance = new BoardDao();

	public static BoardDao getInstance() {
		return instance;
	}

	private Connection getConnection() throws Exception {
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
		return ds.getConnection();
	}

	// 글작성
	public int insert(ModelBean mboard) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "insert into board values(board_seq.nextval,?,?,?,?,sysdate)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mboard.getId());
			pstmt.setString(2, mboard.getSubject());
			pstmt.setString(3, mboard.getContent());
			pstmt.setInt(4, 0);
			result = pstmt.executeUpdate(); // SQL문 실행

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

		return result;
	}

	// 글목록
	public List<ModelBean> getList(int start, int end) {
		List<ModelBean> list = new ArrayList<ModelBean>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			String sql = "select * from (select rownum rnum, board1.*  from ";
			sql += " (select * from board order by num desc) board1)";
			sql += " where rnum>=? and rnum<=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery(); // SQL문 실행

			while (rs.next()) {
				ModelBean mboard = new ModelBean();
				mboard.setNum(rs.getInt("num"));
				mboard.setId(rs.getString("id"));
				mboard.setSubject(rs.getString("subject"));
				mboard.setContent(rs.getString("content"));
				mboard.setReadcount(rs.getInt("readcount"));
				mboard.setReg_date(rs.getTimestamp("reg_date"));

				list.add(mboard);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

		return list;
	}

	// 총 데이터 갯수 구하기
	public int getCount() {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			String sql = "select count(*) from board";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(); // SQL문 실행

			if (rs.next()) {
//						result = rs.getInt(1);
				result = rs.getInt("count(*)");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

		return result;
	}

	// 조회수 증가
	public void readcountUpdate(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "update board set readcount=readcount+1 ";
			sql += " where num = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate(); // SQL문 실행

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

	}

	// 상세 페이지
	public ModelBean getDetail(int num) {
		ModelBean mboard = new ModelBean();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			String sql = "select * from board where num=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery(); // SQL문 실행

			if (rs.next()) {

				mboard.setNum(rs.getInt("num"));
				mboard.setId(rs.getString("id"));
				mboard.setSubject(rs.getString("subject"));
				mboard.setContent(rs.getString("content"));
				mboard.setReadcount(rs.getInt("readcount"));
				mboard.setReg_date(rs.getTimestamp("reg_date"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

		return mboard;
	}
//	 	비밀번호
		public MemberDTO getPass(String id) {
			MemberDTO board = new MemberDTO();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				con = getConnection();

				String sql = "select * from member where id=?";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery(); // SQL문 실행

				if (rs.next()) {
					board.setId(rs.getString("id"));
					board.setPass(rs.getString("pass"));
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (rs != null)
					try {
						rs.close();
					} catch (Exception e) {
					}
				if (pstmt != null)
					try {
						pstmt.close();
					} catch (Exception e) {
					}
				if (con != null)
					try {
						con.close();
					} catch (Exception e) {
					}
			}

			return board;
		}
	
	// 상세 댓글페이지
		public RemodelBean getDetailre(int num,int re_seq) {
			RemodelBean rmboard = new RemodelBean();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				con = getConnection();

				String sql = "select * from reboard where num=? and re_seq=?";

				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, num);
				pstmt.setInt(2, re_seq);
				rs = pstmt.executeQuery(); // SQL문 실행

				if (rs.next()) {

					rmboard.setRe_num(rs.getInt("re_num"));
					rmboard.setId(rs.getString("id"));
					rmboard.setContent(rs.getString("content"));
					rmboard.setReg_date(rs.getTimestamp("reg_date"));
					rmboard.setNum(rs.getInt("num"));
					rmboard.setRe_seq(rs.getInt("re_seq"));
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (rs != null)
					try {
						rs.close();
					} catch (Exception e) {
					}
				if (pstmt != null)
					try {
						pstmt.close();
					} catch (Exception e) {
					}
				if (con != null)
					try {
						con.close();
					} catch (Exception e) {
					}
			}

			return rmboard;
		}
	// 댓글정보1
	public RemodelBean getDetailreply(int num ,int re_seq) {
		RemodelBean rmboard = new RemodelBean();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();

			String sql = "select * from reboard where num=? and re_seq=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setInt(2, re_seq);
			rs = pstmt.executeQuery();
			if (rs.next()) {

				rmboard.setNum(rs.getInt("num"));
				rmboard.setId(rs.getString("id"));
				rmboard.setContent(rs.getString("content"));
				rmboard.setReg_date(rs.getTimestamp("reg_date"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

		return rmboard;
	}
	
	// 댓글목록
		public List<RemodelBean> getListre(int num) {
			List<RemodelBean> listre = new ArrayList<RemodelBean>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				con = getConnection();

				
//				String sql0 = "select * from (select rownum rnum, board1.*  from "; s
//				 sql0 += " (select * from reboard order by num desc) board1)";

				
//				String sql="select * from reboard ";
//				       sql+=" where num = (select num from board)";
				String sql="select * from reboard ";
			       sql+=" where num = ? order by reg_date desc";
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, num);
				//pstmt.setInt(1, start);
				//pstmt.setInt(2, end);
				rs = pstmt.executeQuery(); // SQL문 실행
				while (rs.next()) {
					RemodelBean rmboard = new RemodelBean();
					rmboard.setRe_num(rs.getInt("re_num"));
					rmboard.setId(rs.getString("id"));
					rmboard.setContent(rs.getString("content"));
					rmboard.setReg_date(rs.getTimestamp("reg_date"));
					rmboard.setNum(rs.getInt("num"));
					rmboard.setRe_seq(rs.getInt("re_seq"));
					
					listre.add(rmboard);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (rs != null)
					try {
						rs.close();
					} catch (Exception e) {
					}
				if (pstmt != null)
					try {
						pstmt.close();
					} catch (Exception e) {
					}
				if (con != null)
					try {
						con.close();
					} catch (Exception e) {
					}
			}

			return listre;
		}


	// 글삭제
	public int delete(int num) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();
			String sql="delete from reboard where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			result = pstmt.executeUpdate(); // SQL문 실행
			
			sql = "delete from board where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			result = pstmt.executeUpdate(); // SQL문 실행

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

		return result;
	}
	// 댓글삭제
		public int deletere(int num,int re_seq ) {
			int result = 0;
			Connection con = null;
			PreparedStatement pstmt = null;

			try {
				con = getConnection();
				String sql="delete from reboard where (num=? and re_seq=?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, num);
				pstmt.setInt(2, re_seq);
				result = pstmt.executeUpdate(); // SQL문 실행
				
				

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (pstmt != null)
					try {
						pstmt.close();
					} catch (Exception e) {
					}
				if (con != null)
					try {
						con.close();
					} catch (Exception e) {
					}
			}

			return result;
		}

	// 글수정
	public int update(ModelBean mboard) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "update board set id=?, subject=?,";
			sql += "content=? where num = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mboard.getId());
			pstmt.setString(2, mboard.getSubject());
			pstmt.setString(3, mboard.getContent());
			pstmt.setInt(4, mboard.getNum());
			result = pstmt.executeUpdate(); // SQL문 실행

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

		return result;
	}
	// 댓글수정
		public int updatere(RemodelBean rmboard) {
			int result = 0;
			Connection con = null;
			PreparedStatement pstmt = null;

			try {
				con = getConnection();

				String sql = "update reboard set id=?, ";
				sql += "content=? where (num = ? and re_seq=?)";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, rmboard.getId());
				pstmt.setString(2, rmboard.getContent());
				pstmt.setInt(3, rmboard.getNum());
				pstmt.setInt(4, rmboard.getRe_seq());
				result = pstmt.executeUpdate(); // SQL문 실행

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (pstmt != null)
					try {
						pstmt.close();
					} catch (Exception e) {
					}
				if (con != null)
					try {
						con.close();
					} catch (Exception e) {
					}
			}

			return result;
		}
	// 댓글 작성
	public int boardreply(RemodelBean rmboard) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String sql = "insert into reboard values(reboard_seq.nextval,?,?,sysdate,?,re_seq.nextval)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rmboard.getId());
			pstmt.setString(2, rmboard.getContent());
			pstmt.setInt(3, rmboard.getNum());	//fk
			result = pstmt.executeUpdate(); // SQL문 실행
			
//			sql = "update reboard set re_seq=re_seq+1 ";
//			sql += " where num=? order by re_seq desc";

//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, num);
//			
//			pstmt.executeUpdate();
			
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

		return result;
	}
}
