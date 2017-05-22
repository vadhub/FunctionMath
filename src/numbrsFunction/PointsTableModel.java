package numbrsFunction;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class PointsTableModel extends AbstractTableModel {

	DataBase db = new DataBase();
	DefaultTableModel model = new DefaultTableModel();

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
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
