package Util;
/*
 * 连接数据库
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	private String dbUrl="jdbc:mysql://localhost:3306/infosystem?useUnicode=true&characterEncoding=UTF-8&useSSL=false";//库地址
	private String dbUserName="root";//用户名
	private String dbPassword="123456";//密码
	private String jdbcName="com.mysql.jdbc.Driver";//驱动器名
	
	/*
	 * 获取链接
	 */
	public  Connection getCon()throws Exception{
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;
	}
	/*
	 * 关库
	 */
	public void closeCon(Connection Con)throws Exception{
		if(Con!=null) {
			Con.close();
		}
	}
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("connection access");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("connection faild");
		}
	}
}
	