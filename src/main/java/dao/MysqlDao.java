package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MysqlDao {
	private Connection con;
	private Statement sta;
	private ResultSet rs;
	
	private void connect(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/testdata";
			con=DriverManager.getConnection(url, "root", "");
			sta=con.createStatement();
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public StuBean findProById(String id){
		connect();
		String sql="select * from stu where id="+id;
		System.out.println(sql);
	
		try {
			rs=sta.executeQuery(sql);
			while(rs.next()){
				StuBean stu=new StuBean();
				stu.setId(rs.getInt(1));
				stu.setName(rs.getString(2));
				stu.setPass(rs.getString(3));
				return stu;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
