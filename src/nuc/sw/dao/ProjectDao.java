package nuc.sw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import nuc.sw.entity.Project;
import nuc.sw.entity.ProjectSelf;
import nuc.sw.util.StringUtil;

public class ProjectDao {
	/**
	 * 毕设题目的添加
	 * @throws Exception
	 */
	public int add(Connection con,Project project)throws Exception{
		String sql = "insert into t_project values(null,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);	
		 pstmt.setString(1, project.getProjectName());
		 pstmt.setString(2, project.getSummary());
		 pstmt.setInt(3, project.getProjectTypeId());
		 pstmt.setString(4, project.getTeacherName());
		 pstmt.setString(5, project.getTeacherPhone());
		 return pstmt.executeUpdate();
	}
	/**
	 * 毕设的查看
	 */
	public ResultSet list(Connection con,Project project)throws Exception{
		StringBuffer sb = new StringBuffer("select * from t_project b,t_type bt where b.ProjectTypeId=bt.ProjectTypeId");
		if(StringUtil.isNotEmpty(project.getProjectName())) {
			sb.append(" and b.ProjectName like '%"+project.getProjectName()+"%'");
		}
		if(StringUtil.isNotEmpty(project.getTeacherName())) {
			sb.append(" and b.TeacherName like '%"+project.getTeacherName()+"%'");
		}
		if(project.getProjectTypeId()!=null && project.getProjectTypeId()!=-1) {
			sb.append(" and b.ProjectTypeId="+project.getProjectTypeId());
		}
		PreparedStatement pstmt =  con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	/**
	 * 毕设的删除
	 */
	public int delete(Connection con ,String Id )throws Exception{
		String sql ="delete from t_project where ProjectId=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, Id);
		return pstmt.executeUpdate();
	}
	/**
	 * 毕设的修改
	 */
	public int update(Connection con , Project project)throws Exception{
		String sql ="update t_project set ProjectName=?,Summary=?,ProjectTypeId=?,TeacherName=?,TeacherPhone=? where ProjectId=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, project.getProjectName());
		pstmt.setString(2, project.getSummary());
		pstmt.setInt(3, project.getProjectTypeId());
		pstmt.setString(4, project.getTeacherName());
		pstmt.setString(5, project.getTeacherPhone());
		pstmt.setInt(6, project.getId());
		return pstmt.executeUpdate();
		
	}
}
