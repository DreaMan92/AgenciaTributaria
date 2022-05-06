package animacion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class BDibujarCirculoEspera extends JComponent {
	
	Color unColor;
	BCirculoEspera c= new BCirculoEspera(unColor);
	
	//Constructor.
	public BDibujarCirculoEspera(Color unColor) {
		this.unColor= unColor;
	}	
	//Metodo paint de JComponent.
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(unColor);
		g.fillOval(0, 0, 30, 30);
	}
	
}
