package gestorSys;

import entidades.*;
import interfazDeUsuario.GestorMain;
import interfazDeUsuario.SalaDeEspera;
import datos.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.function.Consumer;

public class Gestor {	
	
	private String ficheroMostrarReservas="../Ficheros/FicheroMostrarReservas.txt";//ruta para guardar y abrir fichero de Reservas.
	private String ficheroMostrarVentanillas="../Ficheros/FicheroMostrarVentanillas.txt";//ruta para guardar y abrir fichero de Ventanillas.
//	private String ficheroMostrarReservas="FicheroMostrarReservas.txt";//ruta para guardar y abrir fichero de Reservas, para ejecutable.
//	private String ficheroMostrarVentanillas="FicheroMostrarVentanillas.txt";//ruta para guardar y abrir fichero de Ventanillas, para ejecutable.
	
	private ArrayList<Persona> atendidosVen1 = new ArrayList<>();
	private ArrayList<Persona> atendidosVen2 = new ArrayList<>();
	private ArrayList<Persona> atendidosVen3 = new ArrayList<>();
	private Ventanilla ventanilla1 = new Ventanilla("1", "Agente especial Harrison",atendidosVen1);
	private Ventanilla ventanilla2 = new Ventanilla("2", "Agente especial Roger",atendidosVen2);
	private Ventanilla ventanilla3 = new Ventanilla("3", "Agente especial Smith",atendidosVen3);
	
	DataReserva RepoReservas;
	DataRandom RepoPersonasRandom;
	DataVentanilla RepoVentanilla;

	private ColaD banco= new ColaD();
	private ArrayList<Consumer<ColaD>> funciones;
	
	//Constructores 2.
	public Gestor() {};
	public Gestor(DataReserva repoR,DataRandom repoPRandom, DataVentanilla repoVent) {
		RepoReservas=repoR;
		RepoPersonasRandom = repoPRandom;
		RepoVentanilla=repoVent;	
		funciones = new ArrayList<>();
	};
		
	/*----------gestion Cola y Ventanilla------------------*/
	
	//Metodo para meter en la cola y porvocar las actualizaciones de la animación.
	public void meterSalaDeEspera(Persona personaNueva){
		banco.encolar(personaNueva);
		invocarFunciones();	
	}
	//Metodo que cada vez que el banco cambia, es decir cada vez que se encola o desencola acepta las funciones guardas, de tal forma que ejecuta las funciones.
	//En mi caso es el metodo actualizar de Sala de espera.
	private void invocarFunciones() {
		funciones.forEach(fn -> fn.accept(banco));
	}
	//Metodo que añade una funcion a la lista de funciones que no devuelven nada, guardas en el consumer.
	public void subscribe(Consumer<ColaD> fn) {
		funciones.add(fn);
	}	
	//Una vez que la cola no esta vacía, si hay ventnaillas libres este metodo se encarga de asignar a la ventanilla libre la persona siguiente.
	//Ademas se encarga de llamr a las metodos encargados de la animación.
	public void gestionVentanilla() {
		while (ventanillaLibre(ventanilla1) || ventanillaLibre(ventanilla2) || ventanillaLibre(ventanilla3)) {
			if (banco.verTamanio(67) > 0) {
				Persona auxP = new Persona();
				if (ventanillaLibre(ventanilla1)) {
					SalaDeEspera.noSalir1 = true;
					auxP = banco.desEncolar();
					ventanilla1.setAtendiendo(auxP);
					invocarFunciones();
					pintarBola(1, auxP);
					ventanilla1.setOcupado(true);
					desLlamarSiguiente(1);
					caminando(1);
					if (banco.verTamanio(67) == 0) {
						break;
					}

				}
				if (ventanillaLibre(ventanilla2)) {
					SalaDeEspera.noSalir2 = true;
					auxP = banco.desEncolar();
					ventanilla2.setAtendiendo(auxP);
					invocarFunciones();
					pintarBola(2, auxP);
					ventanilla2.setOcupado(true);
					desLlamarSiguiente(2);
					caminando(2);
					if (banco.verTamanio(67) == 0) {
						break;
					}
				}
				if (ventanillaLibre(ventanilla3)) {
					SalaDeEspera.noSalir3 = true;
					auxP = banco.desEncolar();
					ventanilla3.setAtendiendo(auxP);
					invocarFunciones();
					pintarBola(3, auxP);
					ventanilla3.setOcupado(true);
					desLlamarSiguiente(3);
					caminando(3);
					if (banco.verTamanio(67) == 0) {
						break;
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "No hay mas gente esperando.\nDescanso para café??");
				break;
			}

		}
	}
	//Los siguientes 3 metodos se encargan de provocar el funcionamiento al pulsar los botones de liberar ventanilla 1, 2 y 3.
	//Ademas vuelve a llamar al metodo de gestion de ventanilla.
	public void liberarVent1(){
		if(!ventanillaLibre(ventanilla1)) {
		quitarBola(1);
		ventanilla1.getAtendidos().add(ventanilla1.getAtendiendo());
		ventanilla1.setAtendiendo(null);
		ventanilla1.setOcupado(false);
		cambiarALibre(1);	
		llamarSiguiente(1);	
		JOptionPane.showMessageDialog(null, "Siguiente!!");
		gestionVentanilla();
		}else {
			JOptionPane.showMessageDialog(null,"La ventanilla ya esta libre!!");
		}
	}
	public void liberarVent2(){
		if(!ventanillaLibre(ventanilla2)) {
		quitarBola(2);
		ventanilla2.getAtendidos().add(ventanilla2.getAtendiendo());
		ventanilla2.setAtendiendo(null);
		ventanilla2.setOcupado(false);
		cambiarALibre(2);	
		llamarSiguiente(2);	
		JOptionPane.showMessageDialog(null, "Siguiente!!");
		gestionVentanilla();
		}else {
			JOptionPane.showMessageDialog(null,"La ventanilla ya esta libre!!");
		}
	}
	public void liberarVent3(){
		if(!ventanillaLibre(ventanilla3)) {
		quitarBola(3);
		ventanilla3.getAtendidos().add(ventanilla3.getAtendiendo());
		ventanilla3.setAtendiendo(null);
		ventanilla3.setOcupado(false);
		cambiarALibre(3);	
		llamarSiguiente(3);	
		JOptionPane.showMessageDialog(null, "Siguiente!!");
		gestionVentanilla();
		}else {
			JOptionPane.showMessageDialog(null,"La ventanilla ya esta libre!!");
		}
	}
	
	//Este metodo corresponde al boton del Menu principal. Sirve para liberar tres ventanillas de golpe.
	public void liberarTodas() {
		if ((!ventanillaLibre(ventanilla1) || !ventanillaLibre(ventanilla2) || !ventanillaLibre(ventanilla3)) &&(banco.verTamanio(67) != 0) ){
			liberarVent1();
			liberarVent2();
			liberarVent3();
			
		}else {
			if(!ventanillaLibre(ventanilla1)) {
				JOptionPane.showMessageDialog(null, "Esta opción no funciona cuando no se pueden liberar la tres ventanillas,\nse hará de forma unitaria desde la sala de espera.\nMuchas gracias.");
			}else if(!ventanillaLibre(ventanilla2)) {
				JOptionPane.showMessageDialog(null, "Esta opción no funciona cuando no se pueden liberar la tres ventanillas,\nse hará de forma unitaria desde la sala de espera.\nMuchas gracias.");
			}else if(!ventanillaLibre(ventanilla3)) {
				JOptionPane.showMessageDialog(null, "Esta opción no funciona cuando no se pueden liberar la tres ventanillas,\nse hará de forma unitaria desde la sala de espera.\nMuchas gracias.");
			}else {
				JOptionPane.showMessageDialog(null, "Las Ventanillas ya estan libres!!");
			}
			
		}
	}

	//Metodo que devuelve un boolean en funcion del estado de la ventanilla libre y Ocupado.
	public boolean ventanillaLibre(Ventanilla una) {
		
		if(una.libre().equals("libre")) {
			return true;
		}
		return false;
	}
	/*--------------------gestion fichero Ventanillas----------------*/
	//Este metodo es el que se llama al pulsar el boton de la pantalla de inicio de ver atendidos por ventanilla.
	//Además genera un string con toda la información por ventanilla, lo escribe en un fichero, y lo muestra.
	public void generarFicheroVentanillas() {
		String cadena= "";
		cadena = "Informe diario de personas antendidas por ventanilla: \n\n";
		cadena+=ventanilla1.toString()+"\n";
		cadena+=ventanilla2.toString()+"\n";
		cadena+=ventanilla3.toString()+"\n";	
		
		RepoVentanilla.escribirEnFicheroTxt(ficheroMostrarVentanillas, cadena);
		RepoVentanilla.abrirArchivoDeTexto(ficheroMostrarVentanillas);		
	}
	
	
	/*-----------gestion_Reservas---------------*/	
	
	//Este metodo es el que se llama al pulsar el boton de la pantalla de inicio de ver reservas generadas.
	//Además genera un string con toda la información por reserva, lo escribe en un fichero, y lo muestra.
	public void mostrarReservas() {
		String cadena="";
		cadena="                                     Fichero reservas de citas\n";
		cadena+="\n";
		cadena+="        Fecha       Hora         DNI             Nombre            Dia reservado     Hora reservada     \n";
		cadena+="\n";
		
		for (Reserva i : RepoReservas.leer()) {
			cadena+="     "+i.getFechaP()+"     "+i.getHoraP()+"     "+i.getDniP()+"      "+RepoReservas.agregarEspaciosNom(i.getNombreP())+"       "+RepoReservas.agregrarEspaciosFecha(i.getFecha())+"          "+i.getHora()+"     \n";			
		}
		RepoReservas.escribirEnFicheroTxt(ficheroMostrarReservas, cadena);
		RepoReservas.abrirArchivoDeTexto(ficheroMostrarReservas);
		
	}	
	//Metodo que llama al metodo guardar reserva en el repositorio csv.
	public void guardarReserva(Reserva esta) {
		RepoReservas.guardar(esta);		
	}
	
	/*-----------gestion inyectar Personas Random-------------*/
	//Este metodo ha sido un capricho que se me ocurrio hacer.
	//Por no estar continuamente introduciendo datos correctos para probar, genere este metodo que inyecta datos de 10 personas.
	//El metodo llama a los metodos de DataRandom.
	//Basicamente extrae las 10 primeras personas del texto, las introduce en el sistema, y luego las vuelve a añadir al csv, de tal forma nunca nos quedamos sin personas que meter, y no son siempre las mismas.
	public void inyectarPersonas(){
		ArrayList<Persona> listaPersInyectar = new ArrayList<>();
		ArrayList<Persona> listaPersInyectadas = new ArrayList<>();
		
		//guardamos la lista de leer el CSV en listaPersInyectar.
		listaPersInyectar= RepoPersonasRandom.leerPersonasRandom();
		
		//le quitamos las 10 primeras personas y las metemos en listaPersInyectadas.
		for(int i =0 ; i <10;i++) {
			listaPersInyectadas.add(listaPersInyectar.remove(i));
		}
		
		//las volvemos a meter en la primera lista pero al final, para que nunca nos quedemos sin personas.

		for(Persona i : listaPersInyectadas) {
			listaPersInyectar.add(i);
		}
		RepoPersonasRandom.guardarPersonasRandom(listaPersInyectar);

		for(Persona i : listaPersInyectadas) {
			meterSalaDeEspera(i);
		}		
		JOptionPane.showMessageDialog(null, "10 personas Añadidas a la sala de espera\nAceptar para atender.");
		gestionVentanilla();
	}
	
	/*--------------------bloque animacion-----------------------*/
	//Metodo que hacen lo que su nombre indica.
	//Además llaman a los verdaderos metodos que estan en sala de espera.
	public void cambiarAOcupado(int num) {
		GestorMain.una.cambiarAOcupado(num);
	}
	public void cambiarALibre(int num) {
		GestorMain.una.cambiarALibre(num);
	}
	public void llamarSiguiente(int num) {
		GestorMain.una.llamarSiguiente(num);
	}
	public void desLlamarSiguiente(int num) {
		GestorMain.una.desLlamarSiguiente(num);
	}
	
	//Metodo que pinta la Bola con el color adecuado.
	public void pintarBola(int num,Persona una) {
		if(num ==1) {
			GestorMain.una.ventana1.asignarColorBola(una);
			GestorMain.una.ventana1.pintarBola();
		}else if( num == 2) {
			GestorMain.una.ventana2.asignarColorBola(una);
			GestorMain.una.ventana2.pintarBola();
		}else if(num == 3) {
			GestorMain.una.ventana3.asignarColorBola(una);
			GestorMain.una.ventana3.pintarBola();
		}
				
	}
	//Metodo que llama a quitarBola de SalaDeEspera
	public void quitarBola(int num) {
		if(num ==1) {
			GestorMain.una.ventana1.quitarBola();
		}else if( num == 2) {
			GestorMain.una.ventana2.quitarBola();
		}else if(num == 3) {
			GestorMain.una.ventana3.quitarBola();
		}
	}

	//Metodo que llama a metodo caminando de SalaDeEspera
	public void caminando(int num){
		GestorMain.una.caminando(num);
	}
}

