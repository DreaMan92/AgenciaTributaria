package animacion;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class AVentanilla {

	private Color unColor=Color.green;
	private APanelMovimiento panel;
	private static final int ancho=100;
	private static final int alto=100;
	
	//Cosntructor.
	public AVentanilla(APanelMovimiento panel) {
		this.panel= panel;
	}
	//Metodos que modifican el color del dibujo de la ventanilla.
	public void Ocupado() {
		unColor= Color.RED;
	}
	
	public void desOcupado() {
		unColor= Color.green;
	}
	
	//Metodo paint.
	public void paint(Graphics2D g) {
		g.setColor(unColor);
		g.fillRect(panel.getWidth()/2-50, 2, ancho, alto);
	}
	//Metodo para que dibuja un rectangunlo para implementar la colision con la bola.
	public Rectangle getBounds() {
		return new Rectangle(panel.getWidth()/2-50,2, ancho, alto);
	}
}

