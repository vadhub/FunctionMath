package numbrsFunction;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class DataBase {

	public void ConnectToDataBass(int k, int b) throws SQLException {
		Connection con = null;			
		Statement stm = null;
		PreparedStatement prepar = null;
		try{
			con = DriverManager.getConnection("jdbc:mysql://localhost/my_bd","Chel","1234");		
			
			stm = con.createStatement();			
			
			
			String sql = "INSERT INTO points VALUES ('0','"+k+"','"+b+"')";
			
			prepar = con.prepareStatement(sql);
			
			prepar.executeUpdate(sql);
					
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(con!=null)
				con.close();
		}
		
	}
}
