package datos;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class DataVentanilla {
	
	//Este metodo escribe en el fichero final TXT que se muestra al usuario. 
	public void escribirEnFicheroTxt(String ruta, String frase) {
		FileWriter fw;
		PrintWriter salida = null;
		try {
			fw = new FileWriter(ruta, false);
			salida = new PrintWriter(fw);
			salida.println(frase);
			salida.flush();

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());

		} finally {
			salida.close();
		}

	}
	/*----------recursos..............*/

	//Metodo que abre automaticamente un fichero.
	public void abrirArchivoDeTexto(String ruta) {

		try {

			File objetofile = new File(ruta);
			Desktop.getDesktop().open(objetofile);

		} catch (IOException ex) {

			System.out.println(ex);

		}

	}
	
}
