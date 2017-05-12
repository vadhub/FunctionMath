package numbrsFunction;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class DataBase {
	Connection con = null;
	ResultSet rt = null;
	Statement stm = null;

	// connect to db
	public void ConnectToDataBass() throws SQLException {

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/my_bd","my", "1234");
			} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// enter statement
	public void SQLstm(String sql) throws SQLException {
		PreparedStatement prepar =null;
		try {
			prepar = con.prepareStatement(sql);
			prepar.executeUpdate(sql);
		} catch (SQLException e) {
			if (con != null)
				con.close();
			e.printStackTrace();
		} finally {
			try {
								
				if (prepar != null)
					prepar.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
