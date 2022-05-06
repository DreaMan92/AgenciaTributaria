package gestorSys;

import entidades.Persona;

public interface IColaD {
	
	public void encolar(Persona dato);
	
	public Persona desEncolar();
	
	public int verTamanio(int num);
	
	public boolean esColaVacia();
		
}
//Interfaz para Cola.