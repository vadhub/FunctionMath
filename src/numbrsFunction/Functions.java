package numbrsFunction;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Functions {
	
	//calculates coordinates for draw lines

	public void line(int k, int b, Graphics g, int w, int h) {
		//formula - y = kx + b

		g.setColor(Color.BLACK);
		
		//coordinates main lines

		g.drawLine(w / 2, 0, w / 2, h);

		g.drawLine(0, h / 2, w, h / 2);		

		Graphics2D g4;	

		g4 = (Graphics2D) g;	

		g4.setStroke(new BasicStroke(5));

		//coordinates lines
		if (k == 0 && (b == 0)) {
			
			g.setColor(Color.RED);
			h = h / 2;
			g.drawLine(0, h, w, h);

		}
	
		if (k > 0 && (b == 0)) {		

			g.setColor(Color.RED);
			g.drawLine(0, h / 2 + w / k, w, h / 2 - w / k);

		}
		
		
		if (k < 0 && (b == 0)) {
			
			g.setColor(Color.RED);
			g.drawLine(0, h / 2 + w / k / 2, w, h / 2 + w / k / -2);

		}
		
		if (k == 0 && b < 0) {
			
			g.setColor(Color.RED);
			g.drawLine(0, (h / 2) + b*5 / -2, w, (h / 2) -  b*5 / 2);	

		}
	
		if (k == 0 && b > 0) {
			
			g.setColor(Color.RED);
			g.drawLine(0, h / 2 -  b *5/2, w, h / 2 +  b *5/-2);	
			System.out.println(h / 2 + w / b / -2);

		}
		
		if (k > 0 && b > 0) {
			
			g.setColor(Color.RED);
			g.drawLine(0, h + b / 1 + k, w, h -b / 1-w * k);

		}
		
		if (k < 0 && b > 0) {
			
			g.setColor(Color.RED);
			g.drawLine(0, h / b / 4 - w / -k, w, h / b / 4 + w / -k);

		}
		
		if (k < 0 && b < 0) {
			
			g.setColor(Color.RED);
			g.drawLine(0, h + b /-1 + w /k, w, h - b / 1 - w / k/3);
			System.out.println(h / b / 6 +k/w);
		}
		
		if (k > 0 && b < 0) {
			
			g.setColor(Color.RED);
			g.drawLine(0, (w/2 - b*4) + h / k, w+100, (w/2 - b*4) - h / k);

		}

	}

}
