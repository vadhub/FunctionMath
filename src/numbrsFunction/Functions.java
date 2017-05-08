package numbrsFunction;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Functions {

	public void line(int k, int b, Graphics g, int w, int h) {
		// y = kx + b

		g.setColor(Color.BLACK);

		g.drawLine(w / 2, 0, w / 2, h);

		g.drawLine(0, h / 2, w, h / 2);
		// Color col = new Color(227, 2, 0);

		Graphics2D g4;

		g4 = (Graphics2D) g;

		g4.setStroke(new BasicStroke(5));

		if (k == 0 && (b == 0)) {
			// 1
			g.setColor(Color.RED);
			h = h / 2;
			g.drawLine(0, h, w, h);

		}
		if (k > 0 && (b == 0)) {
			// 2

			g.setColor(Color.RED);
			g.drawLine(0, h / 2 + w / -k, w, h / 2 - w / -k);

		}
		if (k < 0 && (b == 0)) {
			// 3

			g.setColor(Color.RED);
			g.drawLine(0, h / 2 - w / k, w, h / 2 + w / k);

		}
		if (k == 0 && b < 0) {
			// 4

			g.setColor(Color.RED);
			g.drawLine(0, h / 2 - w / b /2, w, h / 2 - w / b /2);

		}
		if (k == 0 && b > 0) {
			// 5

			g.setColor(Color.RED);
			g.drawLine(0, h / 2 - w / b / 2, w, h / 2 + w / b / -2);	
			System.out.println(h / 2 + w / b / -2);

		}
		if (k > 0 && b > 0) {
			// 6
			g.setColor(Color.RED);
			g.drawLine(0, h / b / 2 + w / k, w, h / b / 2 - w / k);

		}
		if (k < 0 && b > 0) {
			// 7
			g.setColor(Color.RED);
			g.drawLine(0, h / b / 2 - w / -k, w, h / b / 2 + w / -k);

		}
		if (k < 0 && b < 0) {
			// 8
			g.setColor(Color.RED);
			g.drawLine(0, w - w / 2 - h / 2, w - 56, w / 2 + h / 2);
		}
		if (k > 0 && b < 0) {
			// 9
			g.setColor(Color.RED);

			g.drawLine(0, w - w / 2 + h / 2, w + 56, w / 2 - h / 2);

		}

	}

}
