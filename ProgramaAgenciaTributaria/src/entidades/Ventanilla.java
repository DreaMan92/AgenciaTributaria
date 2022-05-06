package entidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Ventanilla {
	private String ID;
	private String empleado;
	private boolean Ocupado;
	private LocalDateTime hora;
	private ArrayList<Persona> atendidos;
	DateTimeFormatter formateadorHora = DateTimeFormatter.ofPattern("HH:mm");
	private Persona atendiendo;

	//Constructores 2.
	public Ventanilla() {};
	
	public Ventanilla(String ID, String empleado,ArrayList<Persona> atendidos){
		this.ID= ID;
		this.empleado=empleado;
		this.Ocupado=false;
		this.hora= LocalDateTime.now();
		this.atendidos=atendidos;
		this.atendiendo = null;
	}

	//Getters y setters.
	public Persona getAtendiendo() {
		return atendiendo;
	}

	public void setAtendiendo(Persona atendiendo) {
		this.atendiendo = atendiendo;
	}

	public String getEmpleado() {
		return empleado;
	}


	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}


	public String getID() {
		return ID;
	}


	public void setID(String iD) {
		ID = iD;
	}


	public boolean isOcupado() {
		return Ocupado;
	}


	public void setOcupado(boolean ocupado) {
		Ocupado = ocupado;
	}
	public LocalDateTime getHora() {
		return hora;
	}

	public void setHora(LocalDateTime hora) {
		this.hora = hora;
	}

	public ArrayList<Persona> getAtendidos() {
		return atendidos;
	}

	public void setAtendidos(ArrayList<Persona> atendidos) {
		this.atendidos = atendidos;
	}

	//Metodo que traduce un boolean a string.
	public String libre(){
		if(this.Ocupado==true){
			return "ocupada";
		}else{
			return "libre";
		}
	}
	//Metodo que guarda todos los atendidos por ventanilla en un string.
	public String verAtendidos(LocalDateTime hora) {
		String cadena="";
		for(Persona i : this.atendidos) {
			cadena+=i.toString()+"\nAtendido a las "+formateadorHora.format(hora)+"\n\n";
		}
		return cadena;
	}

	
	//ToString.
	@Override
	public String toString(){
		LocalDateTime hora = LocalDateTime.now();
		return "Ventanilla nº"+getID()+". Atendida por "+getEmpleado()+"\nSe ha atendido hoy :\n\n"+verAtendidos(hora);
	}

}
