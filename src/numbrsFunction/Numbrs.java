package numbrsFunction;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


//main realization
@SuppressWarnings("serial")
public class Numbrs extends JPanel {
	Functions fuc = new Functions();
	DataBase db = new DataBase();
	PointsTableModel ptm = new PointsTableModel();
	Render r = new Render();
	
	//user 2
	System.out.println("user2");
	////////////
	
	JFrame frame = new JFrame();
	JFrame frameT = new JFrame();
	
	JMenu menu = new JMenu("menu");
	
	JMenuBar menuBar = new JMenuBar();
	
	JMenuItem menuitm = new JMenuItem("Save");
	JMenuItem menuitm2 = new JMenuItem("Table Points");
	JMenuItem update = new JMenuItem("Update");
	
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panelT = new JPanel();
	
	JButton rezult = new JButton("Draw");
	
	JButton delete = new JButton("Delete");	

	JTable table = new JTable(ptm);
	JScrollPane js = new JScrollPane(table);

	JLabel idP = new JLabel("id:");
	JLabel kl = new JLabel("k:");
	JLabel bl = new JLabel("b:");

	JTextField id3 = new JTextField(4);

	JTextField pryamK = new JTextField(10);
	JTextField pryamB = new JTextField(10);

	int w;
	int h;
	int id1;
	int k = 0;
	int b = 0;

	//draw lines on frame
	protected void paintComponent(Graphics g2) {
		super.paintComponent(g2);
		Graphics2D g4;
		System.out.println("p");
		g4 = (Graphics2D) g2;

		g4.setStroke(new BasicStroke(2));

		w = getWidth();
		h = getHeight();

		rezult.setBackground(Color.ORANGE);

		// change variables k and b

		rezult.addActionListener((e) -> {
			k = Integer.valueOf(pryamK.getText());
			b = Integer.valueOf(pryamB.getText());

			frame.repaint();
		});
		
		g4.setColor(Color.RED);
		fuc.line(k, b, g4, w, h);
	}

	public void frame() {
		// open connect db
		try {
			db.ConnectToDataBass();			
			ptm.addDatas(db.con);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}

		// enter statement
		menuitm.addActionListener((e) -> {
			try {
				id1 = Integer.parseInt(id3.getText());
				db.SQLstm("INSERT INTO points VALUES ('" + id1 + "','" + k + "','" + b + "')");
				ptm.addDatas(db.con);				
				JOptionPane.showMessageDialog(null, "coordinate save");
			} catch (Exception e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, e1.getStackTrace());
			}
		});	
		
		menuitm2.addActionListener((e) -> {
			frameT.setVisible(true);
			frameT.repaint();
		});

		// delete form bd element
		delete.addActionListener((e) -> {
			try {
				int indexRow = table.getSelectedRow();
				if (indexRow != -1) {
					int modelIndex = table.convertRowIndexToModel(indexRow);					
					db.SQLstm("DELETE FROM my_bd.points WHERE points.id = "+ String.valueOf(modelIndex));
					
					JOptionPane.showMessageDialog(null, "coordinate deleted");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, e1.getStackTrace());
			}
		});
		//dates from table output in jtextfields 
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ar) {

				int indexRow = table.getSelectedRow();

				if (indexRow != -1) {
					id3.setText(ptm.getValueAt(indexRow, 0).toString());
					pryamK.setText(ptm.getValueAt(indexRow, 1).toString());
					pryamB.setText(ptm.getValueAt(indexRow, 2).toString());
				}

			}
		});
	//Update table
		update.addActionListener((e)->{
			ptm.fireTableDataChanged();
			try {
				db.SQLstm("UPDATE my_bd.points SET k = '"+pryamK.getText() +"' WHERE points.id = "+id3.getText()+" AND points.b = '"+pryamB.getText()+"'");
				JOptionPane.showMessageDialog(null, "coordinate update");
				} catch (Exception e1) {				
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, e1.getStackTrace());
			}
			//UPDATE `my_bd`.`points` SET `k` = '100' WHERE `points`.`id` =4 AND `points`.`k` =0 AND `points`.`b` = '-9' 
			//UPDATE `my_bd`.`points` SET `id` = '4' WHERE `points`.`id` = '6' AND `points`.`k` =10 AND `points`.`b` = '-10'
		});

		table.setDefaultRenderer(Object.class, r);

		js.setPreferredSize(new Dimension(300, 300));
		panelT.add(js);
		panelT.add(delete);		
		frameT.setLayout(new GridLayout());
		frameT.add(panelT);

		frameT.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameT.setSize(350, 400);
		frameT.setLocation(300, 400);
		
		//menu in frame

		menu.add(menuitm);
		menu.add(update);
		menu.add(menuitm2);
		
		menuBar.add(menu);

		menuBar.setBackground(Color.ORANGE);

		menuitm.setBackground(Color.ORANGE);
		menuitm2.setBackground(Color.ORANGE);
		update.setBackground(Color.ORANGE);

		panel1.add(menuBar);
		
		//pane add components

		panel1.add(rezult);
		panel1.add(kl);
		panel1.add(pryamK);
		panel1.add(bl);
		panel1.add(pryamB);
		panel1.add(idP);
		panel1.add(id3);
		panel1.setBackground(Color.white);
		
		//main frame

		frame.setSize(490, 490);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setLocation(400, 300);

		frame.getContentPane().add(this);
		frame.add(panel1, "North");
		frame.add(panel2, "South");
		
	}
}
