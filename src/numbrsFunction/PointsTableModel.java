package numbrsFunction;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class PointsTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private int column = 3;

	// data
	ArrayList<int[]> dataList;

	public PointsTableModel() {
		dataList = new ArrayList<int[]>();
		for (int i = 0; i < dataList.size(); i++) {
			dataList.add(new int[getColumnCount()]);
		}
	}

	// count column
	@Override
	public int getColumnCount() {
		return column;
	}

	// count row
	@Override
	public int getRowCount() {
		return dataList.size();
	}

	// get data
	@Override
	public Object getValueAt(int index, int columnIndex) {
		int[] rows = dataList.get(index);

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
		return null;

	}

	// add data inn table one element(row)
	public void addData(int[] r) {

		int[] add = new int[getColumnCount()];
		add = r;
		dataList.add(add);
	}

}
