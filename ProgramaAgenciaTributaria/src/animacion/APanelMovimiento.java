package animacion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import entidades.Persona;

@SuppressWarnings("serial")
public class APanelMovimiento extends JPanel {
	
	Color colorBola= Color.PINK;
	AbolaMovimiento ball;
	AVentanilla vent;
	public boolean pintar = false;
	
	//Constructor.
	public APanelMovimiento() {
		vent = new AVentanilla(this);
		ball = new AbolaMovimiento(this,colorBola);
		this.add(ball);
		
	}
	//llama al metodo move de Ball.
	public void move(int num) {
		ball.move(num);
		}
	
	//metodo para pintar la bola en el panel.
	public void pintarBola() {
		pintar = true;
		repaint();
	}
	//metodo para repintar el panel sin bola. 
	public void quitarBola() {
		pintar = false;
		vent.desOcupado();
		validate();
		repaint();
	}
	//metodo para asignar el color de la bola cuando la dibujo en funcion de la prioridad.
	public void asignarColorBola(Persona unaPers) {
		if(unaPers.getPrio().toString().equals("uno")) {
			ball.setUnColor(Color.BLUE);
		}else if( unaPers.getPrio().toString().equals("dos")) {
			ball.setUnColor(Color.ORANGE);
		}else if(unaPers.getPrio().toString().equals("tres")) {
			ball.setUnColor(Color.CYAN);
		}		
	}
	//setter para el color de la bola.
	public void setUnColor(Color colorBola) {
		this.colorBola = colorBola;
	}
	// metodo paint de JPanel.
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		vent.paint(g2d);
		if(pintar) {
			ball.paint(g2d);
		}
	}

}
