package numbrsFunction;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Numbrs extends JPanel {
	JFrame frame = new JFrame();
	Functions fuc = new Functions();

	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JButton rezult = new JButton("Output");
	JButton qwerty = new JButton("?");
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

		g4 = (Graphics2D) g2;

		g4.setStroke(new BasicStroke(2));

		w = getWidth();
		h = getHeight();

		rezult.setBackground(Color.ORANGE);
		
		//change variables k and b 		
		rezult.addActionListener((e) -> {
			k = Integer.valueOf(pryamK.getText());
			b = Integer.valueOf(pryamB.getText());

			frame.repaint();

		});
		g4.setColor(Color.RED);
		fuc.line(k, b, g4, w, h);

	}

	public void frame() {
		
		//load image
		qwerty.addActionListener((e) -> {
			ImageIcon im = new ImageIcon(Numbrs.class.getResource("/grafik.jpg"));
			JOptionPane.showConfirmDialog(null, im, "r1",JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION);

		});
		qwerty.setBackground(Color.ORANGE);

		panel1.add(qwerty);
		panel1.add(rezult);
		panel1.add(kl);
		panel1.add(pryamK);
		panel1.add(bl);
		panel1.add(pryamB);
		panel1.setBackground(Color.white);

		frame.setSize(412, 412);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setLocation(400, 300);

		frame.getContentPane().add(this);
		frame.add(panel1, "North");
		frame.add(panel2, "South");
	}
}
