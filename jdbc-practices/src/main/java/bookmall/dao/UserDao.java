package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.UserVo;

public class UserDao {
	
	public int deleteByNo(Long no) {
		int result = 0;
		
		try(Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement("delete from user = ?");) {
			pstmt.setLong(1, no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error: " + e);
		}
		return result;
	}
	
	public int insert(UserVo vo) {
		int result = 0;
		
		try(Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement("insert into user(phone, password) values(?, ?)");) {
			pstmt.setString(1, vo.getPhone());
			pstmt.setString(2, vo.getPassword());
			
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println("error: " + e);
		}
		return result;
	}
	
	public List<UserVo> findAll() {
		List<UserVo> result = new ArrayList<UserVo>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql = "select no, phone, password from bookmall order by no desc";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Long no = rs.getLong(1);
				String phone = rs.getString(2);
				String password = rs.getString(3);
				
				UserVo vo = new UserVo();
				vo.setNo(no);
				vo.setPhone(phone);
				vo.setPassword(password);
				
				result.add(vo);
			}
		} catch(SQLException e) {
			System.out.println("error: "+ e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
 				if(con != null) {
 					con.close();
 				}
 				if(rs != null) {
 					rs.close();
 				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			}
		return result;
		}
	
	private Connection getConnection() throws SQLException {
		Connection con = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");

			String url = "jdbc:mariadb://192.168.0.179:3306/webdb";
			con = DriverManager.getConnection(url, "webdb", "webdb");
		
		} catch (ClassNotFoundException ex) {
			System.out.println("Driver Class Not Found");

	}
		return con;
		
		}
	}

