package nuc.sw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import nuc.sw.entity.SelectType;
import nuc.sw.util.StringUtil;

public class SelectTypeDao {
	
	/**
	 * 选课状态的添加
	 */
	public int add(Connection con,SelectType selectType)throws Exception{
		String sql = "insert into t_select values(null,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);	
		 pstmt.setString(1, selectType.getStudentId());
		 pstmt.setString(2, selectType.getProjectId());
		 pstmt.setString(3, selectType.getProjectName());
		 pstmt.setString(4, selectType.getState());

		 return pstmt.executeUpdate();
		
	}
	
	/**
	 * 选课状态的查询
	 */
	public ResultSet list(Connection con, SelectType selectType)throws Exception{
		StringBuffer sb = new StringBuffer("select * from t_select");
		if(StringUtil.isNotEmpty(selectType.getStudentId())) {
			sb.append(" and StudentId like '%"+selectType.getStudentId()+"%'");
		}
		PreparedStatement pstmt =  con.prepareStatement(sb.toString().replaceFirst("and","where"));
		return pstmt.executeQuery();
	}
}
