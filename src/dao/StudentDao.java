package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Util.StringUtil;
import model.Department;
import model.Student;

public class StudentDao {
	/*
	 * 信息录入
	 */
	public int add(Connection con, Student student) throws Exception {
		String sql = "insert into student values(null,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, student.getStuName());
		pstmt.setString(2, student.getStuId());
		pstmt.setString(3, student.getSex());
		pstmt.setString(4, student.getBirth());
		pstmt.setString(5, student.getFace());
		pstmt.setString(6, student.getAddress());
		pstmt.setString(7, student.getPhone());
		pstmt.setString(8, student.getDormitory());
		pstmt.setInt(9, student.getDepartmentId());
		return pstmt.executeUpdate();
}
	/*
	 * 信息查询
	 */
	public ResultSet list(Connection con, Student student) throws Exception {
		StringBuilder strb = new StringBuilder("select *from student stu, department depart where stu.departmentId=depart.id");
		if (StringUtil.isNotEmpty(student.getStuName())) {
			strb.append(" and stu.stuName like '%" + student.getStuName() + "%'");
		}
		if (StringUtil.isNotEmpty(student.getStuId())) {
			strb.append(" and stu.stuId like '%" + student.getStuId() + "%'");
		}
		if (student.getDepartmentId()!=null&&student.getDepartmentId() != -1) {
			strb.append(" and stu.departmentId =" + student.getDepartmentId());
		}


		PreparedStatement pstmt = con.prepareStatement(strb.toString());
		return pstmt.executeQuery();
	}
	/**
	 * 删除学生信息
	 */
	public int delete(Connection con,String id)throws Exception{
		String sql="delete from student where id=?";
		PreparedStatement pstmt = con. prepareStatement(sql);
		pstmt.setString(1,id);
		return pstmt. executeUpdate();
		}
	/**
	 * 修改学生信息
	 */
	public int update( Connection con, Student student )throws Exception{
		String sql="update student set stuName=? , stuId=? ,sex=? , birth=? , face=? , address=? , phone=? , dormitory=? , departmentId=?  where id=?";
		PreparedStatement pstmt = con. prepareStatement(sql);
		pstmt . setString(1, student . getStuName());
		pstmt . setString(2, student . getStuId());
		pstmt . setString(3, student . getSex());
		pstmt . setString(4, student . getBirth());
		pstmt . setString(5, student . getFace());
		pstmt . setString(6, student . getAddress());
		pstmt . setString(7, student . getPhone());
		pstmt . setString(8, student . getDormitory());
		pstmt . setInt(9, student. getDepartmentId());
		pstmt. setInt(10, student. getId());
		return pstmt. executeUpdate();
	}
}