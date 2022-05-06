package datos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import entidades.Persona;

public class DataRandom {

//   private String rutaRandom = "PersonasRandom.csv";//Ruta de fichero para ejecutable.
   private String rutaRandom = "../Ficheros/PersonasRandom.csv";//Ruta de fichero.
   
   //Metodo leer fichero de personas Random(de un fichero CSV con datos de personas),devolviendo una lista de personas.
	public ArrayList<Persona> leerPersonasRandom() {
		
		ArrayList<Persona> personasRandom = new ArrayList<>();

		FileReader fr = null;
		String cadena = "";
		String[] part;

		try {
			fr = new FileReader(rutaRandom);
			BufferedReader entrada = new BufferedReader(fr);
			cadena = entrada.readLine();
			while (cadena != null) {
				part = cadena.split(",");
				personasRandom.add(new Persona(part[0], part[1], part[2]));
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
		return personasRandom;
	}

	//Metodo para guardar las personas random en el mismo fichero para así rehutilizarlas y que nunca se quede el programa sin personas.
	//Además este llamara el metodo de escribir, añadiendo al final.
	public void guardarPersonasRandom(ArrayList<Persona> unaLista) {
		String cadena = "";
		for(int i =0;i <unaLista.size();i++) {
			if(i < unaLista.size()-1) {
			cadena+=unaLista.get(i).getNombre()+","+unaLista.get(i).getDNI()+","+unaLista.get(i).getPrio()+"\n";
			}else {
				cadena+=unaLista.get(i).getNombre()+","+unaLista.get(i).getDNI()+","+unaLista.get(i).getPrio();
			}			
		}
		
		escribirEnFicheroCSV(rutaRandom, cadena);

	}
	//Este metodo escribe una cadena en un fichero concreto.
	public void escribirEnFicheroCSV(String ruta, String frase) {
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

}
