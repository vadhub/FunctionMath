package numbrsFunction;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Numbrs extends JPanel {
	Functions fuc = new Functions();
	DataBase db = new DataBase();
	PointsTableModel ptm = new PointsTableModel();
	Render r = new Render();	
	
	JFrame frame = new JFrame();
	JFrame frameT = new JFrame();
	JMenu menu = new JMenu("menu");
	JMenuBar menuBar = new JMenuBar();
	JMenuItem menuitm = new JMenuItem("Save");
	JMenuItem menuitm2 = new JMenuItem("Table Points");
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panelT = new JPanel();
	JButton rezult = new JButton("Draw");
	JButton delete = new JButton("Delete");
	
	JTable table = new JTable(ptm);
	JScrollPane js = new JScrollPane(table);
	
	JLabel kl = new JLabel("k:");
	JLabel bl = new JLabel("b:");

	JTextField pryamK = new JTextField(10);
	JTextField pryamB = new JTextField(10);
	int w;
	int h;

	int k = 0;
	int b = 0;

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
		//open connect db
		try {
			db.ConnectToDataBass();			
			ptm.addDatas(db.con);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		//enter statement
		menuitm.addActionListener((e) -> {
			try {
				db.SQLstm("INSERT INTO points VALUES ('0','" + k + "','" + b	+ "')");
				ptm.addDatas(db.con);
				frameT.repaint();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		menuitm2.addActionListener((e)->{	
			frameT.setVisible(true);
			frameT.repaint();
		});	
		
		delete.addActionListener((e)->{			
			try {
				int indexRow = table.getSelectedRow();
				if(indexRow !=0){				
				db.SQLstm("DELETE FROM my_bd.points WHERE points.id ="+indexRow);			
				ptm.addDatas(db.con);	
				frameT.repaint();
				}				
			} catch (Exception e1) {				
				e1.printStackTrace();
			}
			
		});
		
		
		table.repaint();
		
		table.setDefaultRenderer(Object.class, r);
			
		js.setPreferredSize(new Dimension(300,300));
		panelT.add(js);
		panelT.add(delete);
		frameT.setLayout(new GridLayout());
		frameT.add(panelT);
				
		frameT.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameT.pack();		
		frameT.setLocation(300, 400);	
		
		menu.add(menuitm);
		menu.add(menuitm2);
		menuBar.add(menu);	
		
		menuBar.setBackground(Color.ORANGE);
		
		menuitm.setBackground(Color.ORANGE);
		menuitm2.setBackground(Color.ORANGE);
		
		panel1.add(menuBar);
			
		panel1.add(rezult);
		panel1.add(kl);
		panel1.add(pryamK);
		panel1.add(bl);
		panel1.add(pryamB);
		panel1.setBackground(Color.white);		

		frame.setSize(430, 430);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setLocation(400, 300);

		frame.getContentPane().add(this);
		frame.add(panel1, "North");
		frame.add(panel2, "South");
	}
}
