package interfazDeUsuario;

import javax.swing.*;

import datos.DataRandom;
import datos.DataReserva;
import datos.DataVentanilla;
import gestorSys.Gestor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class GestorMain extends JFrame implements ActionListener{
	
	private Gestor gestor;
	private Container contenedor; 
	
	private JPanel marco;
	private JPanel marco2;
	private JLabel et1;
	private JButton jbtn1;
	private JButton jbtn2;
	private JButton jbtn3;
	private JButton jbtn4;
	private JButton jbtn5;
	private JButton jbtn6;
	
	public static SalaDeEspera una;

	//Metodo MAIN
	public static void main(String[] args) {
		DataReserva repositorioR= new DataReserva();
		DataRandom repositorioPersRandom = new DataRandom();
		DataVentanilla repositorioVentanilla= new DataVentanilla();
		Gestor gestor = new Gestor(repositorioR,repositorioPersRandom,repositorioVentanilla);
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					GestorMain frame = new GestorMain(gestor);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	//He creado dos constructores, que muestran dos pantallas diferentes.
	//Primer constructor, es el inicial y solo nos da dos opciones.
	public GestorMain(Gestor gestor) {
		setResizable(false);
		this.gestor=gestor;
		setTitle(" Gestor");
		setBounds(1, 200, 225, 130);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PuestoInfo.class.getResource("/Recursos/icono.png")));
		contenedor = getContentPane();
		contenedor.setLayout(new BorderLayout());
		et1 = new JLabel("  Selecciona una opcion:");
		et1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		et1.setHorizontalAlignment(SwingConstants.CENTER);
		et1.setSize(40,50);
		contenedor.add( et1,BorderLayout.NORTH);
		marco= new JPanel();
		contenedor.add(marco,BorderLayout.CENTER);
		iniciarComp(marco);
		
		
	}
	//Segundo Constructor.
	//Este se mantiene durante toda la ejecución. Nos muestra los casos de usos ajenos a a la reserva y el puesto de información.
	public GestorMain(Gestor gestor,int num) {
		setResizable(false);
		this.gestor=gestor;
		setTitle(" Gestor");
		setBounds(1, 200, 225, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PuestoInfo.class.getResource("/Recursos/icono.png")));
		contenedor = getContentPane();
		contenedor.setLayout(new BorderLayout());
		et1 = new JLabel("  Selecciona una opcion:");
		et1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		et1.setHorizontalAlignment(SwingConstants.CENTER);
		et1.setSize(40,50);
		contenedor.add( et1,BorderLayout.NORTH);
		marco2= new JPanel();	
		contenedor.add(marco2,BorderLayout.CENTER);
		iniciarComp2(marco2);
			
		
		
	}
	//Esta organizacion he visto que se usa mucho a la hora de progrmar interfaces
	
	//Ambos metodos, uno para el primer constructor y otro para el segundo, inician la mayoria de los componentes de las ventanas.
	public void iniciarComp(JPanel panel) {	
		marco.setLayout(new GridLayout(2,1));
		jbtn1 = new JButton(" Inciar programa ");		
		jbtn1.setToolTipText("Esta opción lanzará las ventanas del puesto de informacion y otra de Sala de espera con control de ventanillas. ");
		jbtn1.addActionListener(this);
		jbtn6 = new JButton(" Finalizar Programa ");
		jbtn6.setToolTipText("Esta opción finalizará el programa principal. Si cierras la ventana, también finalizará el programa. ");
		jbtn6.addActionListener(this);
		marco.add(jbtn1);
		marco.add(jbtn6);		
	}
	public void iniciarComp2(JPanel panel) {	
		marco2.setLayout(new GridLayout(5,1));
		jbtn2 =  new JButton(" Ver atendidos por ventanilla ");
		jbtn2.setToolTipText("Esta opción abrirá un fichero generado, con las personas atendidadas por cada ventanilla. ");
		jbtn2.addActionListener(this);
		jbtn3 = new JButton(" Ver reservas generadas ");
		jbtn3.setToolTipText("Esta opción generará un fichero con las reservas generadas hasta la fecha.  ");
		jbtn3.addActionListener(this);
		jbtn4 = new JButton(" Liberar Ventanillas ");
		jbtn4.setToolTipText("Esta opción liberará las ventanillas ocupadas y llamara al siguiente en cola en función de su prioridad.");
		jbtn4.addActionListener(this);
		jbtn5 = new JButton(" Inyectar 10 personas ");
		jbtn5.setToolTipText("Esta opción inyectará 10 personas random extraidas de un fichero, en el banco, y automaticamente seran procesadas si hay un ventanilla libre. ");
		jbtn5.addActionListener(this);
		jbtn6 = new JButton(" Finalizar Programa ");
		jbtn6.setToolTipText("Esta opción finalizará el programa principal. Si cierras la ventana, también finalizará el programa. ");
		jbtn6.addActionListener(this);
		marco2.add(jbtn2);
		marco2.add(jbtn3);
		marco2.add(jbtn4);
		marco2.add(jbtn5);	
		marco2.add(jbtn6);
		
	}
	//Metodo de sobreescritura de oyentes.
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case " Inciar programa " :
			this.dispose();
			GestorMain otro = new GestorMain(gestor, 2);
			otro.setVisible(true);
			una = new SalaDeEspera(gestor);			
			PuestoInfo nuevo = new PuestoInfo(gestor);
			nuevo.setVisible(true);			
			una.setVisible(true);		
			break;
			
		case " Ver atendidos por ventanilla " :
			gestor.generarFicheroVentanillas();
			break;
		
			
		case " Ver reservas generadas " :
			
			gestor.mostrarReservas();
			
			break;
			
		case " Inyectar 10 personas " :		
			
			gestor.inyectarPersonas();
			
			break;		
			
		case " Liberar Ventanillas " :
			
			gestor.liberarTodas();
		
			break;							
			
		case " Finalizar Programa " :
			JOptionPane.showMessageDialog(null,"Gracias por usar mis servicios.\n           Hasta pronto!!");
			System.exit(0);
			
			break;	
		
		}
	}
	
	
	
	
	
}
