package entidades;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;


public class Persona {
	private String nombre;
	private String DNI;
	private LocalDateTime fecha;
	private LocalDateTime hora;
	private EPrioridad prio;
	
	DateTimeFormatter formateadorFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");//Formateador de fecha.
	DateTimeFormatter formateadorHora = DateTimeFormatter.ofPattern("HH:mm");//Formateador de hora.
	
	//Constructores 3	
	public Persona(){
		this.nombre="";
		this.DNI="";
		this.fecha=LocalDateTime.now();
		this.hora= LocalDateTime.now();
		this.prio=EPrioridad.tres;
	};
	public Persona(String Nombre, String DNI, EPrioridad prio) {
		this.nombre=Nombre;
		this.DNI = DNI;
		this.fecha=LocalDateTime.now();
		this.hora= LocalDateTime.now();
		this.prio=prio;
		
	}
	public Persona(String Nombre, String DNI, String prio) {
		this.nombre=Nombre;
		this.DNI = DNI;
		this.fecha=LocalDateTime.now();
		this.hora= LocalDateTime.now();
		this.prio= EPrioridad.valueOf(prio);
		
	}
	
	//Getters y setters.	
	
	public EPrioridad getPrio() {
		return prio;
	}
	public void setPrio(EPrioridad prio) {
		this.prio = prio;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}
	
	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime Fecha) {
		fecha = Fecha;
	}
	public LocalDateTime getHora() {
		return hora;
	}

	public void setTiempo(LocalDateTime Hora) {
		hora = Hora;
	}
	
	//ToString
	@Override
	public String toString() {
		String cadena="";
		cadena="Nombre: "+getNombre()+"\nCon DNI: "+getDNI()+"\nFecha de hoy: "+formateadorFecha.format(LocalDateTime.now())+" a las "+formateadorHora.format(LocalDateTime.now())+"\nPrioridad: "+getPrio();
		return cadena;
	}

}
