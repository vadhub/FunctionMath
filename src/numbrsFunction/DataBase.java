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
	PreparedStatement prepar = null;

	// connect to db
	public void ConnectToDataBass() {

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/my_bd",
					"my", "1234");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// enter statement
	public void SQLstm(String sql) {
		try {
			stm = con.createStatement();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (stm != null)
					stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
}
