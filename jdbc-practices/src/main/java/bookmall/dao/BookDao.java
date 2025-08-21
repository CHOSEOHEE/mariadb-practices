package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bookmall.vo.BookVo;

public class BookDao {
	public int insert(BookVo vo) {
		int count = 0;
	
	try {
		Connection con = getConnection();
		PreparedStatement pstmt1 = con.prepareStatement("insert into book(title, price) values (?, ?)");
		PreparedStatement pstmt2 = con.prepareStatement("select order_book_no() from dual");
		
		pstmt1.setString(1, vo.getTitle());
		pstmt2.setInt(2,  vo.getPrice());
		count = pstmt1.executeUpdate();
		
		int rs = pstmt2.executeUpdate();
		
		
	} catch(SQLException e) {
		System.out.println("error:" + e);
	}

	return count;
}

	public int deleteAll() {
		int count = 0;
		return count;
	}
	private Connection getConnection() {
		return null;
	}
}