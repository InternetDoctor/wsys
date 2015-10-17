package doctor;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.resource.cci.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class MysqlJdbc {
	public final static String driver="com.mysql.jdbc.Driver";
	public final static String ur1="jdbc:mysql://localhost:3306/doctor";
	public final static String dbName="root";
	public final static String dbPass="000000";
	public Connection getConn()throws ClassNotFoundException,SQLException{
		Class.forName(driver);
		Connection conn=(Connection) DriverManager.getConnection(ur1,dbName,dbPass);
		return conn;
	}
	public void closeAll(Connection conn,PreparedStatement pstmt,ResultSet rs){
		if(rs!=null){
			try{
				rs.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		if(pstmt!=null){
			try{
				pstmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try{
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	public int executeSQL(String preparedSql,String[] param){
		Connection conn=null;
	   PreparedStatement pstmt=null;
		int num=0;
		try{
			conn=getConn();
			pstmt=(PreparedStatement) conn.prepareStatement(preparedSql);
			if(param!=null){
				for(int i=0;i<param.length;i++){
					pstmt.setString(i+1, param[i]);
				}
					
				}
			num=pstmt.executeUpdate();
			}catch(ClassNotFoundException e){
				e.printStackTrace();
				
			}catch(SQLException e){
				e.printStackTrace();
				
			}finally{
				closeAll(conn,pstmt,null);
				}
		return num;

	}
	public User findUser(String uName) {
		// TODO Auto-generated method stub
		return null;
	}

}
