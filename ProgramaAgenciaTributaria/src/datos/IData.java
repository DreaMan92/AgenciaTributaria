package datos;

import java.util.ArrayList;

public interface IData<T> {
	
	//Interfaz para Data reserva.
	public  void guardar(T datos);
	public  ArrayList<T> leer();

}
