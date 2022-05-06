package gestorSys;

import entidades.Persona;

public class ColaD implements IColaD {
	//Nodo
	class Nodo {
		private Persona dato;
		private Nodo sig;

	}

	private Nodo P1;
	private Nodo R1;
	private int T1;
	private Nodo P2;
	private Nodo R2;
	private int T2;
	private Nodo P3;
	private Nodo R3;
	private int T3;
	
	//Constructor
	public ColaD() {
		P1 = null;
		R1 = P1;
		T1 = 0;
		P2 = null;
		R2 = P2;
		T2 = 0;
		P3 = null;
		R3 = P3;
		T3 = 0;
	}

	//Metodo que encola en funcion de la prioridad de la persona.
	public void encolar(Persona dato) {
		Nodo aux = new Nodo();
		if (dato.getPrio().toString().equals("uno")) {
			if (T1 == 0) {
				aux.dato = dato;
				aux.sig = P2;
				P1 = aux;
				R1 = null;
				T1++;
			} else {
				if (T1 == 1) {
					R1 = P1;
					aux.dato = dato;
					aux.sig = R1.sig;
					R1.sig = aux;
					R1 = aux;
					T1++;
				} else {
					aux.dato = dato;
					aux.sig = R1.sig;
					R1.sig = aux;
					R1 = aux;
					T1++;
				}

			}
		}  if (dato.getPrio().toString().equals("dos")) {
			if (T2 == 0) {
				aux.dato = dato;
				aux.sig = P3;
				P2 = aux;
				R2 = null;
				T2++;
			} else {
				if (T2 == 1) {
					R2 = P2;
					aux.dato = dato;
					aux.sig = R2.sig;
					R2.sig = aux;
					R2 = aux;
					T2++;
				} else {
					aux.dato = dato;
					aux.sig = R2.sig;
					R2.sig = aux;
					R2 = aux;
					T2++;
				}

			}
		}  if (dato.getPrio().toString().equals("tres")) {
			if (T3 == 0) {
				aux.dato = dato;
				aux.sig = null;
				P3 = aux;
				R3 = null;
				T3++;
			} else {
				if (T3 == 1) {
					R3 = P3;
					aux.dato = dato;
					aux.sig = R3.sig;
					R3.sig = aux;
					R3 = aux;
					T3++;
				} else {
					aux.dato = dato;
					aux.sig = R3.sig;
					R3.sig = aux;
					R3 = aux;
					T3++;
				}

			}
		} 
	}

	//Metodo que desencola en funcion de la prioridad de la persona.
	public Persona desEncolar() {
		Persona ejecutar = null;
		Nodo aux = new Nodo();
		if (T1 != 0) {
			ejecutar = P1.dato;
			aux = P1.sig;
			P1 = aux;
			T1--;

		} else if (T2 != 0) {
			ejecutar = P2.dato;
			aux = P2.sig;
			P2 = aux;
			T2--;

		} else if (T3 != 0) {
			ejecutar = P3.dato;
			aux = P3.sig;
			P3 = aux;
			T3--;

		}

		return ejecutar;
	}

	//Metodo que devuelve el tamaño de la cola, en funcion del integer que pases como argumento.
	//1-cantidad de personas prioridad uno, 2- prioridad dos, 3- prioridad tres, y si es un numero mayor directamente te muestra todos los que hay en la cola.
	public int verTamanio(int num) {
		if (num == 1) {
			return T1;
		} else if (num == 2) {
			return T2;
		} else if (num == 3) {
			return T3;
		} else
			return (T1 + T2 + T3);

	}

	//Metodo que devuelve.
	public boolean esColaVacia() {
		return verTamanio(40) == 0;
	}
}
