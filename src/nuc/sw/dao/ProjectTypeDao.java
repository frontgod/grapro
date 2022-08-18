package nuc.sw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import nuc.sw.entity.ProjectType;
import nuc.sw.util.StringUtil;
/**
 * �������Dao��
 * @author 24872
 *
 */
public class ProjectTypeDao {
	/**
	 * ����������
	 * @param con
	 * @param projectType
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,ProjectType projectType)throws Exception{
		 String sql = "insert into t_type values(null,?,?)";
		 PreparedStatement pstmt = con.prepareStatement(sql);	
		 pstmt.setString(1, projectType.getProjectTypeName());
		 pstmt.setString(2, projectType.getProjectTypeDeco());
		 return pstmt.executeUpdate();
	}
	
	/**
	 * ��ѯ���
	 * @param con
	 * @param projectType
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con,ProjectType projectType)throws Exception{
		StringBuffer sb = new StringBuffer("select * from t_type");
		if(StringUtil.isNotEmpty(projectType.getProjectTypeName())) {
			sb.append(" and ProjectTypeName like '%"+projectType.getProjectTypeName()+"%'");
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and","where"));
		return pstmt.executeQuery();
	}
	/**
	 * ����ɾ��
	 */
	public int delete(Connection con ,String Id )throws Exception{
		String sql ="delete from t_type where ProjectTypeId=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, Id);
		return pstmt.executeUpdate();
	}
}
