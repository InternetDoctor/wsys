package wsyy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Userfind extends db implements UserKou {
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;

	@Override
	public User findUser(String uName) {
		// TODO Auto-generated method stub
		String sql="select * from dor where uName=?";
		User user=null;
		try{
			conn=this.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, uName);
			rs=pstmt.executeQuery();
			while(rs.next()){
				user=new User();
				user.setuName(rs.getString("usename"));
				user.setuPass(rs.getString("password"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
		return user;
	}

}
