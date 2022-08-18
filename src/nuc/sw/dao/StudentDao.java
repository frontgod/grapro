package nuc.sw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import nuc.sw.entity.Student;

public class StudentDao {
	/**
	 * 登录验证
	 * @param con
	 * @param student
	 * @return
	 * @throws Exception
	 */
	
	public Student login(Connection con,Student student)throws Exception{
		Student resultStudent = null;
		String sql="select * from t_Student where StudentUserName=? and StudentPassword=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1,student.getStudentUserName());
		pstmt.setString(2, student.getStudentPassword());
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			resultStudent = new Student();
			resultStudent.setId(rs.getInt("Id"));
			resultStudent.setStudentUserName(rs.getString("StudentUserName"));
			resultStudent.setStudentPassword(rs.getString("StudentPassword"));
			resultStudent.setStudentId(rs.getString("StudentId"));
			resultStudent.setStudentName(rs.getString("StudentName"));
			resultStudent.setSex(rs.getString("Sex"));
		}
		return resultStudent;
	}
	/**
	 * 注册Student
	 */
	public int add(Connection con,Student student)throws Exception{
		String sql = "insert into t_student values(null,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);	 
		 pstmt.setString(1, student.getStudentUserName());
		 pstmt.setString(2, student.getStudentPassword());
		 pstmt.setString(3, student.getStudentId());
		 pstmt.setString(4, student.getStudentName());
		 pstmt.setString(5, student.getSex());
		 return pstmt.executeUpdate();
	}
	/**
	 * 修改学生信息
	 * @param con
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con, Student student) throws Exception {
        String sql = "UPDATE t_student SET StudentPassword=?,StudentId=?,StudentName=?,Sex=? WHERE Id=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, student.getStudentPassword());
        pstmt.setString(2, student.getStudentId());
        pstmt.setString(3, student.getStudentName());
        pstmt.setString(4, student.getSex());
        pstmt.setInt(5, student.getId());
        return pstmt.executeUpdate();
    }
	
}
