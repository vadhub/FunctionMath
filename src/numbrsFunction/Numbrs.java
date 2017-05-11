package numbrsFunction;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Numbrs extends JPanel {
	Functions fuc = new Functions();
	DataBase db = new DataBase();
	PointsTableModel ptm = new PointsTableModel();

	JFrame frame = new JFrame();
	JFrame frameT = new JFrame();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JButton rezult = new JButton("Output");
	JButton save = new JButton("save");
	JButton openT = new JButton("table");
	
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
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		openT.setBackground(Color.ORANGE);
		save.setBackground(Color.ORANGE);

		js.setPreferredSize(new Dimension(100,200));
		//enter statement
		save.addActionListener((e) -> {
			try {
				db.SQLstm("INSERT INTO points VALUES ('0','" + k + "','" + b	+ "')");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		openT.addActionListener((e)->{
			frame.add(js);
			frameT.setVisible(true);
			frameT.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frameT.setSize(100, 200);;
			frameT.setLocation(300, 400);
		});
		
		panel1.add(openT);
		panel1.add(save);
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
