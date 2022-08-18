package nuc.sw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import nuc.sw.entity.Teacher;

public class TeacherDao {
	/**
	 * ��¼��֤
	 * @param con
	 * @param student
	 * @return
	 * @throws Exception
	 */
	
	public Teacher login(Connection con,Teacher teacher)throws Exception{
		Teacher resultTeacher = null;
		String sql="select * from t_teacher where TeacherUserName=? and TeacherPassword=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1,teacher.getTeacherUserName());
		pstmt.setString(2, teacher.getTeacherPassword());
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			resultTeacher = new Teacher();
			resultTeacher.setId(rs.getInt("Id"));
			resultTeacher.setTeacherUserName(rs.getString("TeacherUserName"));
			resultTeacher.setTeacherPassword(rs.getString("TeacherPassword"));
			resultTeacher.setTeacherId(rs.getString("TeacherId"));
			resultTeacher.setTeacherName(rs.getString("TeacherName"));
			resultTeacher.setSex(rs.getString("Sex"));
			resultTeacher.setPhone(rs.getString("Phone"));
		}
		return resultTeacher;
	}
	/**
	 * ע��Teacher
	 */
	public int add(Connection con,Teacher teacher)throws Exception{
		String sql = "insert into t_teacher values(null,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);	
		 pstmt.setString(1, teacher.getTeacherUserName());
		 pstmt.setString(2, teacher.getTeacherPassword());
		 pstmt.setString(3, teacher.getTeacherId());
		 pstmt.setString(4, teacher.getTeacherName());
		 pstmt.setString(5, teacher.getSex());
		 pstmt.setString(6, teacher.getPhone());
		 return pstmt.executeUpdate();
	}
	/**
	 * �޸�teacher��Ϣ
	 */
	 public int update(Connection con, Teacher teacher) throws Exception {
	        String sql = "UPDATE t_teacher SET TeacherPassword=?,TeacherId=?,TeacherName=?,Sex=?,Phone=? WHERE Id=?";
	        PreparedStatement pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, teacher.getTeacherPassword());
	        pstmt.setString(2, teacher.getTeacherId());
	        pstmt.setString(3, teacher.getTeacherName());
	        pstmt.setString(4, teacher.getSex());
	        pstmt.setString(5, teacher.getPhone());
	        pstmt.setInt(6, teacher.getId());
	        return pstmt.executeUpdate();
	    }
	
}
