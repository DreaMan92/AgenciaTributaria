package animacion;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BPanelDibujoBanco extends JPanel {

	BDibujarCirculoEspera dibujarCirculo;

	//Constructor vacío.
	public BPanelDibujoBanco() {}

	//Metodo para actualizar la cantidad de bolas dibujadas en la sala de espera.
	public void actualizar(int cantidad, Color unColor) {
		removeAll();
		for (int i = 0; i < cantidad; i++) {
			BDibujarCirculoEspera dibujarCirculo = new BDibujarCirculoEspera(unColor);
			dibujarCirculo.setPreferredSize(new Dimension(30, 30));
			add(dibujarCirculo);
		}
		validate();
		repaint();
	}

}
