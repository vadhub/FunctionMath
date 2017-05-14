package numbrsFunction;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class PointsTableModel extends AbstractTableModel {

	DataBase db = new DataBase();

	private static final long serialVersionUID = 1L;

	private int column = 3;

	// data
	ArrayList<String[]> dataList;

	public PointsTableModel() {
		dataList = new ArrayList<String[]>();
		for (int i = 0; i < dataList.size(); i++) {
			dataList.add(new String[getColumnCount()]);
		}
	}

	// count row
	@Override
	public int getRowCount() {
		return dataList.size();
	}

	// count column
	@Override
	public int getColumnCount() {
		return column;
	}

	// get data
	@Override
	public Object getValueAt(int rowindex, int columnIndex) {
		String[] rows = dataList.get(rowindex);

		return rows[columnIndex];
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "id";
		case 1:
			return "k";
		case 2:
			return "b";
		}
		return "5t";
	}
	
	public void addData(String []row){		
		String rows[] = new String[getColumnCount()];
		rows = row;
		dataList.add(rows);
	}

	// add data inn table one element(row)
	public void addDatas(Connection con) {		
		try {
			db.stm = con.createStatement();
			db.rt = db.stm.executeQuery("SELECT * FROM points");			
				
			while (db.rt.next()) {

				String[] row = {						
						db.rt.getString("id"),
						db.rt.getString("k"),
						db.rt.getString("b")						
				};				
				addData(row);
			}			
			if (db.rt != null)
				db.rt.close();
			if (db.stm != null)
				db.stm.close();				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
