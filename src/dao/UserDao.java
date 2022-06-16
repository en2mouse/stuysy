package dao;

import java.sql.Connection;
import java.sql.PreparedStatement ;
import java.sql.ResultSet ;

import model.User;
public class UserDao {

	public User login(Connection con,User user)throws Exception{
		User resultUser=null;
		String sq1= "select*from user where userName=? and password=? and power=?";
		PreparedStatement pstmt = con. prepareStatement(sq1);
		pstmt.setString(1,user.getUserName());
		pstmt.setString(2,user.getPassword());
		pstmt.setString(3,user.getPower());
		ResultSet rs=pstmt. executeQuery();

	if(rs.next()) {
		resultUser=new User();
		resultUser.setId(rs.getInt("id"));
		resultUser.setUserName (rs. getString("userName"));
		resultUser.setPassword(rs. getString("password"));
		resultUser.setPower(rs. getString( "power"));
	
	}
	return resultUser;
	
}
}
