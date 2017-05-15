package numbrsFunction;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DeleteT {
	DataBase d= new DataBase();
public void ActioButton(JButton btn, JTable table){
	int indexRow = table.getSelectedRow();
	btn.addActionListener((e)->{
		
		if(indexRow !=-1){		
			try {
				int modelIndex = table.convertRowIndexToModel(indexRow);
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				model.removeRow(modelIndex);			
				d.SQLstm("DELETE FROM my_bd.points WHERE points.id = 2");
			} catch (Exception e1) {				
				e1.printStackTrace();
			}
		}
	});
}
}
