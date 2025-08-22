package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.BookVo;

public class BookDao {
	
	public int deleteByNo(Long no) {
		int result = 0;
		
		try (Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement("delete from book = ?");) {
			pstmt.setLong(1, no);
			result = pstmt.executeUpdate();
	} catch (SQLException e) {
		System.out.println("error: " + e);
	}
		return result;

}
	
	public int insert(BookVo vo) {
		int result = 0;
		
		try(Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement
					("insert into Book(title, price, order_book_no, category_no) values(?, ?, ?, ?)");) {
			pstmt.setString(1, vo.getTitle());
			pstmt.setLong(2, vo.getPrice());
			pstmt.setLong(3, vo.getOrder_book_no());
			pstmt.setLong(4, vo.getCategory_no());
			
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println("error: " + e);
		}
		
		return result;
	}
	
	public List<BookVo> findAll() {
		List<BookVo> result = new ArrayList<BookVo>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql = "select no, title, price, order_book_no, category_no from bookmall order by no desc";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Long no = rs.getLong(1);
				String title = rs.getString(2);
				int price = rs.getInt(3);
				Long order_book_no =rs.getLong(4);
				Long category_no = rs.getLong(5);
				
				BookVo vo = new BookVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setPrice(price);
				vo.setOrder_book_no(order_book_no);
				vo.setCategory_no(category_no);
				
				result.add(vo);
			}
		} catch(SQLException e) {
			System.out.println("error: " + e);
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
