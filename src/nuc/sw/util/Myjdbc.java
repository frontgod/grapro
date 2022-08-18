package nuc.sw.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Myjdbc {
	private static final String CLS = "com.mysql.jdbc.Driver";//驱动类
	private static final String URL = "jdbc:mysql://localhost:3306/project";//URL
	private static final String USER = "root";//数据库用户名
	private static final String PWD = "420";//数据库密码
	
	private static Connection conn;//连接对象
	private static Statement stmt;//命令集
	private static PreparedStatement pStmt;//预编译的指令集
	private static ResultSet rs;//结果集

/**
 * 
 * @return
 * @throws 获取连接
 */
	
	public Connection getCon()throws Exception{
		Class.forName(CLS);
		Connection con = DriverManager.getConnection(URL,USER,PWD);
		return con;	
		}
	/**
	 * 
	 * @param con
	 * @throws 关闭连接
	 */
	
	
	public void closeCon(Connection con)throws Exception{
		if(con!=null) {
			con.close();
		}
	}
	
	public static void main(String[] args) {
		Myjdbc myjdbc = new Myjdbc();
		try {
			myjdbc.getCon();
			System.out.println("数据库连接成功！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库连接失败！");
		}
	}
	
}
	
	
	
	
	
	