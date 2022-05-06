package datos;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import entidades.Reserva;

public class DataReserva implements IData<Reserva> {

	//	private String rutaReservas = "Reservas.csv";//para ejecutable
	private String rutaReservas = "../Ficheros/Reservas.csv";

	//Metodo que lee un fichero CSV donde se guardan la reservas de forma persistente.
	public  ArrayList<Reserva> leer() {
		
		ArrayList<Reserva> misReservas= new ArrayList<>();

		FileReader fr = null;
		String cadena = "";
		String[] part;

		try {
			fr = new FileReader(rutaReservas);
			BufferedReader entrada = new BufferedReader(fr);
			cadena = entrada.readLine();
			while (cadena != null) {
				part = cadena.split(",");
				misReservas.add(new Reserva(part[0], part[1], part[2], part[3], part[4], part[5]));
				cadena = entrada.readLine();
			}
			entrada.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
		return misReservas;
	}

	//Metodo que recibe un objeto reserva y lo guarda en una string apto para escribir en CSV.
	//Ademas llama al metodo escribir en CSV, que escribe los datos de la reserva en el fichero CSV.
	public  void guardar(Reserva una) {
		DateTimeFormatter formateadorFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter formateadorHora = DateTimeFormatter.ofPattern("HH:mm");
		String cadena = "";

		cadena += formateadorFecha.format(una.getPersona().getFecha()) + ",";
		cadena += formateadorHora.format(una.getPersona().getHora()) + ",";
		cadena += una.getPersona().getNombre() + ",";
		cadena += una.getPersona().getDNI() + ",";
		cadena += una.getFecha() + ",";
		cadena += una.getHora();

		escribirEnFicheroCSV(rutaReservas, cadena);

	}

	
	//Hago dos metodos, uno sobreescribe y el otro no, añade.
	
	//Este metodo escribe en CSV sin sobreescribir el fichero, para no perder datos.
	public void escribirEnFicheroCSV(String ruta, String frase) {
		FileWriter fw;
		PrintWriter salida = null;
		try {
			fw = new FileWriter(ruta, true);
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
	
	//Metodo que formatea la escritura añadiendo espacios en funcion de la longitud del nombre.
	public String agregarEspaciosNom(String cadena) {
		int longitudNombre = 0;
		int longitud = 0;
		int espacioAgregrar = 0;

		for (Reserva i : leer()) {
			longitudNombre = i.getNombreP().length();
			if (longitudNombre > longitud) {
				longitud = longitudNombre;
			}
		}

		if (cadena.length() <= longitud) {
			espacioAgregrar = longitud - cadena.length();
			for (int i = 0; i < espacioAgregrar + 1; i++) {
				cadena = cadena + " ";
			}
		}
		return cadena;
	}
	//Metodo que formatea la escritura añadiendo espacios en funcion de la longitud de la fecha.
	public String agregrarEspaciosFecha(String cadena) {
		int longitudFecha = 0;
		int longitud = 0;
		int espacioAgregrar = 0;

		for (Reserva i : leer()) {
			longitudFecha = i.getFecha().length();
			if (longitudFecha > longitud) {
				longitud = longitudFecha;
			}
		}

		if (cadena.length() <= longitud) {
			espacioAgregrar = longitud - cadena.length();
			for (int i = 0; i < espacioAgregrar + 1; i++) {
				cadena = cadena + " ";
			}
		}
		return cadena;
	}

}
