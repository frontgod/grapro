package nuc.sw.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Myjdbc {
	private static final String CLS = "com.mysql.jdbc.Driver";//������
	private static final String URL = "jdbc:mysql://localhost:3306/project";//URL
	private static final String USER = "root";//���ݿ��û���
	private static final String PWD = "420";//���ݿ�����
	
	private static Connection conn;//���Ӷ���
	private static Statement stmt;//���
	private static PreparedStatement pStmt;//Ԥ�����ָ�
	private static ResultSet rs;//�����

/**
 * 
 * @return
 * @throws ��ȡ����
 */
	
	public Connection getCon()throws Exception{
		Class.forName(CLS);
		Connection con = DriverManager.getConnection(URL,USER,PWD);
		return con;	
		}
	/**
	 * 
	 * @param con
	 * @throws �ر�����
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
			System.out.println("���ݿ����ӳɹ���");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ�ܣ�");
		}
	}
	
}
	
	
	
	
	
	