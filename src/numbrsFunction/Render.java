package numbrsFunction;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Render extends DefaultTableCellRenderer {
	private static final long serialVersionUID = 1L;

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		
		setText(value.toString());
		
		if(isSelected){
			setBackground(Color.ORANGE);
			setForeground(Color.black);
		}else{
			setBackground(Color.white);
			setForeground(Color.black);
		}
		return this;
	}

}
