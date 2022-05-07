package animacion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.JComponent;
import interfazDeUsuario.SalaDeEspera;

@SuppressWarnings("serial")
public class AbolaMovimiento extends JComponent{
	
	private APanelMovimiento panel;
	Color unColor;
	private final int DIAMETER = 30;
	int y = 355;
	int ya = 1;

	//Constructor.
	public AbolaMovimiento(APanelMovimiento panel,Color unColor) {
		this.unColor=unColor;
		this.panel= panel;
	}
	//setter para atributo.
	public void setUnColor(Color unColor) {
		this.unColor = unColor;
	}
	//metodo que mueve la bola y controla colision.
	void move(int num) {
		if (y + ya < 0)
			ya = 1;
		if (y + ya > panel.getHeight() - DIAMETER)
			ya = -1;
		if (collision()) {
			if (num == 1) {
				y = panel.getHeight() - 280;
				panel.vent.Ocupado();
				SalaDeEspera.noSalir1 = false;

			} else if (num == 2) {
				y = panel.getHeight() - 280;
				panel.vent.Ocupado();
				SalaDeEspera.noSalir2 = false;

			} else if (num == 3) {
				y = panel.getHeight() - 280;
				panel.vent.Ocupado();
				SalaDeEspera.noSalir3 = false;

			}
		}
		y = y + ya;
	}

	//metodo paint de JComponent para pintar bola.
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(unColor);
		g.fillOval(panel.getWidth()/2-15, y, DIAMETER, DIAMETER);
	}
	
	//metodos para generar la colision de los dos objetos(bolaPersona,cuadradoVentanilla).
	public Rectangle getBounds() {
		return new Rectangle(panel.getWidth()/2-15, y, DIAMETER, DIAMETER);
	}
	private boolean collision() {
		return panel.vent.getBounds().intersects(getBounds());
	}
}