package ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class loginDAO {
	public ResultSet check(String un,String pw) {
		ResultSet rs = null;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement pst = con.prepareStatement("select * from login where uname=? and pword=?");
			pst.setString(1, un);
			pst.setString(2, pw);
			rs = pst.executeQuery();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
}
