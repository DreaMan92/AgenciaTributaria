package interfazDeUsuario;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

import gestorSys.ColaD;
import gestorSys.Gestor;
import animacion.APanelMovimiento;
import animacion.BPanelDibujoBanco;



@SuppressWarnings("serial")
public class SalaDeEspera extends JFrame implements ActionListener{
	
	public static boolean noSalir1 = false;
	public static boolean noSalir2 = false;
	public static boolean noSalir3 = false;
	
	private Gestor gestor;
	private Container contenedor; 
	
	private JPanel salaVentanillas;
	
	private JPanel cuadroVentanilla1;
	private JPanel cuadroVentanilla2;
	private JPanel cuadroVentanilla3;
	private JLabel etqNombre1;
	private JLabel etqLibre1;
	private JLabel etqSiguiente1;
	private JPanel etiquetas1;
	private JLabel etqNombre2;
	private JLabel etqLibre2;
	private JLabel etqSiguiente2;
	private JPanel etiquetas2;
	private JLabel etqNombre3;
	private JLabel etqLibre3;
	private JLabel etqSiguiente3;
	private JPanel etiquetas3;
	
	public APanelMovimiento ventana1;
	public APanelMovimiento ventana2;
	public APanelMovimiento ventana3;
	/*-----------------*/	
	private JPanel salaEspera;
	
	private JPanel etqSalaEspera;
	private JLabel etqTituloEspera;	
	private JPanel etiquetasBancos;
	private JLabel etqBanco1;
	private JLabel etqBanco2;
	private JLabel etqBanco3;	
	private JPanel bancos;		
	private BPanelDibujoBanco banco1;
	private BPanelDibujoBanco banco2;	
	private BPanelDibujoBanco banco3;	
	private JPanel botonesBancos;
	private JButton btnBanco1;
	private JButton btnBanco2;
	private JButton btnBanco3;
	
	//Constructor
	public SalaDeEspera(Gestor gestor) {
		setResizable(false);
		this.gestor=gestor;
		setTitle("     Animación Ventanillas");
		setBounds(750, 50, 900, 740);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PuestoInfo.class.getResource("/Recursos/icono.png")));
		contenedor = getContentPane();
		contenedor.setLayout(null);
		salaVentanillas = new JPanel(new GridLayout(1,3));	
		salaVentanillas.setBounds(0,0,885,470);
		salaEspera = new JPanel(new BorderLayout());	
		salaEspera.setBounds(0, 470, 885, 230);
		contenedor.add(salaVentanillas);
		contenedor.add(salaEspera);
		iniciarComp(salaVentanillas,salaEspera);		
		gestor.subscribe(cola -> renderizar(cola));//cristian
		
	}
 //este metodo actualiza la animacion del banco de espera, manteniendo siempre el numero correcto de personas por prioridad dibujado. 
	private void renderizar(ColaD cola) {
		banco1.actualizar(cola.verTamanio(1), Color.BLUE);
		banco2.actualizar(cola.verTamanio(2), Color.ORANGE);
		banco3.actualizar(cola.verTamanio(3), Color.CYAN);
	}

	//Metodo que inicia todos los componentes de la ventana;
	private void iniciarComp(JPanel salaVentanillas, JPanel salaEspera){
		
		cuadroVentanilla1 = new JPanel();
		cuadroVentanilla1.setLayout(new BorderLayout());
		cuadroVentanilla1.setBorder(new EtchedBorder());
		
		etqNombre1 = new JLabel("Ventanilla UNO");
		etqNombre1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		etqNombre1.setHorizontalAlignment(SwingConstants.CENTER);
		etqLibre1 = new JLabel("Libre");
		etqLibre1.setFont(new Font("DejaVu Serif Condensed", Font.PLAIN, 15));
		etqLibre1.setHorizontalAlignment(SwingConstants.CENTER);
		etqSiguiente1 = new JLabel("...");
		etqSiguiente1.setFont(new Font("Tahoma", Font.BOLD, 15));
		etqSiguiente1.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetas1 = new JPanel(new GridLayout(3,1));
		etiquetas1.setBorder(new BevelBorder(BevelBorder.RAISED));
		etiquetas1.add(etqNombre1);
		etiquetas1.add(etqLibre1);
		etiquetas1.add(etqSiguiente1);
		cuadroVentanilla1.add(etiquetas1, BorderLayout.NORTH);
		
		ventana1= new APanelMovimiento();		
		cuadroVentanilla1.add(ventana1, BorderLayout.CENTER);		
		
		cuadroVentanilla2 = new JPanel();
		cuadroVentanilla2.setLayout(new BorderLayout());
		cuadroVentanilla2.setBorder(new EtchedBorder());
		
		etqNombre2 = new JLabel("Ventanilla DOS");
		etqNombre2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		etqNombre2.setHorizontalAlignment(SwingConstants.CENTER);
		etqLibre2 = new JLabel("Libre");
		etqLibre2.setFont(new Font("DejaVu Serif Condensed", Font.PLAIN, 15));
		etqLibre2.setHorizontalAlignment(SwingConstants.CENTER);
		etqSiguiente2 = new JLabel("...");
		etqSiguiente2.setFont(new Font("Tahoma", Font.BOLD, 15));
		etqSiguiente2.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetas2 = new JPanel(new GridLayout(3,1));
		etiquetas2.setBorder(new BevelBorder(BevelBorder.RAISED));
		etiquetas2.add(etqNombre2);
		etiquetas2.add(etqLibre2);
		etiquetas2.add(etqSiguiente2);
		cuadroVentanilla2.add(etiquetas2, BorderLayout.NORTH);
		
		ventana2 = new APanelMovimiento();
		cuadroVentanilla2.add(ventana2, BorderLayout.CENTER);
		
		cuadroVentanilla3 = new JPanel();
		cuadroVentanilla3.setLayout(new BorderLayout());
		cuadroVentanilla3.setBorder(new EtchedBorder());
		
		etqNombre3 = new JLabel("Ventanilla TRES");
		etqNombre3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		etqNombre3.setHorizontalAlignment(SwingConstants.CENTER);
		etqLibre3 = new JLabel("Libre");
		etqLibre3.setFont(new Font("DejaVu Serif Condensed", Font.PLAIN, 15));
		etqLibre3.setHorizontalAlignment(SwingConstants.CENTER);
		etqSiguiente3 = new JLabel("...");
		etqSiguiente3.setFont(new Font("Tahoma", Font.BOLD, 15));
		etqSiguiente3.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetas3 = new JPanel(new GridLayout(3,1));
		etiquetas3.setBorder(new BevelBorder(BevelBorder.RAISED));
		etiquetas3.add(etqNombre3);
		etiquetas3.add(etqLibre3);
		etiquetas3.add(etqSiguiente3);
		cuadroVentanilla3.add(etiquetas3, BorderLayout.NORTH);
		
		ventana3 = new APanelMovimiento();		
		cuadroVentanilla3.add(ventana3, BorderLayout.CENTER);
		
		salaVentanillas.add(cuadroVentanilla1);
		salaVentanillas.add(cuadroVentanilla2);
		salaVentanillas.add(cuadroVentanilla3);
		
		etqSalaEspera = new JPanel(new GridLayout(2,1));
		etqTituloEspera = new JLabel("Sala de espera");
		etqTituloEspera.setHorizontalAlignment(SwingConstants.CENTER);
		etqTituloEspera.setFont(new Font("Tahoma", Font.PLAIN, 24));
		etqTituloEspera.setBorder(new BevelBorder(BevelBorder.RAISED));
		etiquetasBancos = new JPanel(new GridLayout(1,3));
		etqBanco1 = new JLabel("Representación para personas de Prioridad UNO");
		etqBanco1.setHorizontalAlignment(SwingConstants.CENTER);
		etqBanco1.setBorder(new EtchedBorder());
		etqBanco2 = new JLabel("Representación para personas de Prioridad DOS");
		etqBanco2.setHorizontalAlignment(SwingConstants.CENTER);
		etqBanco2.setBorder(new EtchedBorder() );
		etqBanco3 = new JLabel("Representación para personas de Prioridad TRES");
		etqBanco3.setHorizontalAlignment(SwingConstants.CENTER);
		etqBanco3.setBorder(new EtchedBorder() );
		etiquetasBancos.add(etqBanco1);
		etiquetasBancos.add(etqBanco2);
		etiquetasBancos.add(etqBanco3);
		etqSalaEspera.add(etqTituloEspera);
		etqSalaEspera.add(etiquetasBancos);
		
		bancos = new JPanel(new GridLayout(1,3));
		banco1 = new BPanelDibujoBanco();
		banco1.setBorder(new EtchedBorder());		
		banco2 = new BPanelDibujoBanco();
		banco2.setBorder(new EtchedBorder());		
		banco3 = new BPanelDibujoBanco();
		banco3.setBorder(new EtchedBorder());		
		bancos.add(banco1);
		bancos.add(banco2);
		bancos.add(banco3);	
		botonesBancos= new JPanel(new GridLayout(1,3));
		btnBanco1 = new JButton("Liberar Ventanilla 1");
		btnBanco1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBanco1.setForeground(Color.WHITE);
		btnBanco1.setBackground(Color.LIGHT_GRAY);
		btnBanco1.addActionListener(this);
		btnBanco1.setToolTipText("Esta opción liberará la ventanilla 1 y si hay gente esperando llamara al siguiente.");
		btnBanco2 = new JButton("Liberar Ventanilla 2");
		btnBanco2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBanco2.setForeground(Color.WHITE);
		btnBanco2.setBackground(Color.LIGHT_GRAY);
		btnBanco2.addActionListener(this);
		btnBanco2.setToolTipText("Esta opción liberará la ventanilla 2 y si hay gente esperando llamara al siguiente.");
		btnBanco3 = new JButton("Liberar Ventanilla 3");
		btnBanco3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBanco3.setForeground(Color.WHITE);
		btnBanco3.setBackground(Color.LIGHT_GRAY);
		btnBanco3.addActionListener(this);
		btnBanco3.setToolTipText("Esta opción liberará la ventanilla 3 y si hay gente esperando llamara al siguiente.");
		botonesBancos.add(btnBanco1);
		botonesBancos.add(btnBanco2);
		botonesBancos.add(btnBanco3);

		salaEspera.add(etqSalaEspera,BorderLayout.NORTH);		
		salaEspera.add(bancos,BorderLayout.CENTER);	
		salaEspera.add(botonesBancos, BorderLayout.SOUTH);
	}
/*--------------------------------------------------------------------------*/
	
	//Los siguiente metodos son llamados desde el gestor
	//Hacen basicamente lo que dicen.
	public void cambiarAOcupado(int num) {
		if(num == 1) {
			etqLibre1.setText("Ocupado");
		}else if(num == 2) {
			etqLibre2.setText("Ocupado");
		}else if(num == 3) {
			etqLibre3.setText("Ocupado");
		}
	}
	public void cambiarALibre(int num) {
		if(num == 1) {
			etqLibre1.setText("Libre");
		}else if(num == 2) {
			etqLibre2.setText("Libre");
		}else if(num == 3) {
			etqLibre3.setText("Libre");
		}
	}
	public void llamarSiguiente(int num) {
		if(num == 1) {
			etqSiguiente1.setText("Siguiente!!");
		}else if(num == 2) {
			etqSiguiente2.setText("Siguiente!!");
		}else if(num == 3) {
			etqSiguiente3.setText("Siguiente!!");
		}
	}
	public void desLlamarSiguiente(int num) {
		if(num == 1) {
			etqSiguiente1.setText("...");
		}else if(num == 2) {
			etqSiguiente2.setText("...");
		}else if(num == 3) {
			etqSiguiente3.setText("...");
		}
	}

//Este metodo es el que mueve la bola y la repinta
//Para ello me ha tocado investigar a cerca de lo que es un timer, el cual he empleado para crear un subproceso con un pequeño retardo.
	public void caminando(int num) {
	if(num==1) {
		noSalir1 = true;
		while(noSalir1) {
			java.util.Timer uno = new java.util.Timer();
			uno.schedule(new TimerTask() {
				
				@Override
				public void run() {
					ventana1.move(1);
					ventana1.repaint();		
					uno.cancel();
				}
			}, 150);
		
					
		}
		cambiarAOcupado(1);
	} if(num==2) {
		noSalir2 = true;
		while(noSalir2) {
			java.util.Timer dos = new java.util.Timer();
			dos.schedule(new TimerTask() {
				
				@Override
				public void run() {	
					ventana2.move(2);
					ventana2.repaint();		
					dos.cancel();
				}
			}, 150);
		}
		cambiarAOcupado(2);
	} if(num==3) {
		noSalir3 = true;
		while(noSalir3) {
			java.util.Timer tres = new java.util.Timer();
			tres.schedule(new TimerTask() {
				
				@Override
				public void run() {
					ventana3.move(3);
					ventana3.repaint();					
					tres.cancel();
				}
			}, 150);	
		}
		cambiarAOcupado(3);
	}
	
}
	
	//Metodo de sobreescritura de oyentes.
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Liberar Ventanilla 1":
				gestor.liberarVent1();
			break;
		case "Liberar Ventanilla 2":
				gestor.liberarVent2();
			break;
		case "Liberar Ventanilla 3":
				gestor.liberarVent3();
			break;
		}
		
	}
}
