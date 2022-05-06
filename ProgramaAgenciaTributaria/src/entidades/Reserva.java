package entidades;

import java.time.format.DateTimeFormatter;

public class Reserva {
	private Persona persona;
	private String fecha;
	private String hora;
	private String fechaP,horaP,nombreP,dniP;
	DateTimeFormatter formateadorFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	DateTimeFormatter formateadorHora = DateTimeFormatter.ofPattern("HH:mm");
	
	//Constructores 2.
	public Reserva(Persona una,String fecha,String hora) {
		this.persona =una;
		this.fecha=fecha;
		this.hora =hora;
	}
	public Reserva(String fechaP,String horaP,String nombreP,String dniP,String fecha,String hora) {
		this.fechaP=fechaP;
		this.horaP=horaP;
		this.nombreP=nombreP;
		this.dniP=dniP;
		this.fecha=fecha;
		this.hora=hora;		
	}
	//Getters y Setters
	
	public String getFechaP() {
		return fechaP;
	}
	public void setFechaP(String fechaP) {
		this.fechaP = fechaP;
	}
	public String getHoraP() {
		return horaP;
	}
	public void setHoraP(String horaP) {
		this.horaP = horaP;
	}
	public String getNombreP() {
		return nombreP;
	}
	public void setNombreP(String nombreP) {
		this.nombreP = nombreP;
	}
	public String getDniP() {
		return dniP;
	}
	public void setDniP(String dniP) {
		this.dniP = dniP;
	}
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona una) {
		this.persona = una;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	//ToString
	@Override
	public String toString() {
		return "Hoy dia "+formateadorFecha.format(persona.getFecha())+" a las "+formateadorHora.format(persona.getHora())+" se genera una cita para "+persona.getNombre()+" con DNI: "+persona.getDNI()+"  para el dia "+getFecha()+" a las "+getHora()+"\n";
		
	}

}
