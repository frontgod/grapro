package nuc.sw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import nuc.sw.entity.ProjectSelf;
import nuc.sw.util.StringUtil;

/**
 * 自拟毕设Dao类
 * @author 24872
 *
 */
public class ProjectSelfDao {
	/**
	 * 自拟毕设添加
	 */
	public int add(Connection con,ProjectSelf projectSelf)throws Exception{
		String sql = "insert into t_probyself values(null,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);	
		 pstmt.setString(1, projectSelf.getProjectSelfName());
		 pstmt.setString(2, projectSelf.getSummary());
		 pstmt.setInt(3, projectSelf.getProjectTypeId());
		 pstmt.setString(4, projectSelf.getStudentId());
		 return pstmt.executeUpdate();
	}
	
	/**
	 * 自拟毕设的查看
	 */
	public ResultSet list(Connection con,ProjectSelf projectSelf)throws Exception{
		StringBuffer sb = new StringBuffer("select * from t_probyself b,t_type bt where b.ProjectTypeId=bt.ProjectTypeId");
		if(StringUtil.isNotEmpty(projectSelf.getProjectSelfName())) {
			sb.append(" and b.ProjectSelfName like '%"+projectSelf.getProjectSelfName()+"%'");
		}
		if(StringUtil.isNotEmpty(projectSelf.getStudentId())) {
			sb.append(" and b.StudentId like '%"+projectSelf.getStudentId()+"%'");
		}
		if(projectSelf.getProjectTypeId()!=null && projectSelf.getProjectTypeId()!=-1) {
			sb.append(" and b.ProjectTypeId="+projectSelf.getProjectTypeId());
		}
		PreparedStatement pstmt =  con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	
	/**
	 * 自拟毕设的删除
	 */
	public int delete(Connection con ,String Id )throws Exception{
		String sql ="delete from t_probyself where Id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, Id);
		return pstmt.executeUpdate();
	}
	
	/**
	 * 自拟毕设的修改
	 */
	public int update(Connection con , ProjectSelf projectSelf)throws Exception{
		String sql ="update t_probyself set ProjectSelfName=?,Summary=?,ProjectTypeId=?,StudentId=? where Id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, projectSelf.getProjectSelfName());
		pstmt.setString(2, projectSelf.getSummary());
		pstmt.setInt(3, projectSelf.getProjectTypeId());
		pstmt.setString(4, projectSelf.getStudentId());
		pstmt.setInt(5, projectSelf.getId());
		return pstmt.executeUpdate();
		
	}
}
