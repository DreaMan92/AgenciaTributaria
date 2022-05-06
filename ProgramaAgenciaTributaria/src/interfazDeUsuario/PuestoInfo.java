package interfazDeUsuario;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import entidades.EPrioridad;
import entidades.Persona;
import gestorSys.Gestor;
import java.awt.Font;
import java.awt.FlowLayout;


@SuppressWarnings("serial")
public class PuestoInfo extends JFrame implements ActionListener{
	
	private Gestor gestor;
	
	public Container contenedor;
	private JPanel marco;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panelPrior;
	private JRadioButton jrb1,jrb2,jrb3;
	private JLabel etqT,etqT2,etq1,etq2,etq3;
	private JTextField text1,text2;
	private ButtonGroup grupoBtn;
	private JButton btn1,btn2;

	//Cosntructor
	public PuestoInfo(Gestor gestor) {
		setResizable(false);
		this.gestor = gestor;
		setTitle("   Puesto de Información - Agencia Tributaria");
		setBounds(240, 250, 500, 400);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PuestoInfo.class.getResource("/Recursos/icono.png")));
		contenedor = getContentPane();
		contenedor.setLayout(new BorderLayout());
		
		panel1= new JPanel();
		panel1.setLayout(new GridLayout(2,1));

		etqT = new JLabel("Bienvenido a la Agencia Tributaria");
		etqT.setHorizontalAlignment(SwingConstants.CENTER);
		etqT.setFont(new Font("Verdana", Font.BOLD, 18));
		panel1.add(etqT);
		etqT2 = new JLabel("Rellena la siguiente información");
		etqT2.setHorizontalAlignment(SwingConstants.CENTER);
		etqT2.setFont(new Font("Verdana", Font.BOLD, 15));
		panel1.add(etqT2);
		
		contenedor.add(panel1, BorderLayout.NORTH);
		marco = new JPanel();
		marco.setLayout(new BorderLayout());
		contenedor.add(marco, BorderLayout.CENTER);
		iniciarComp(marco);
		
	}

	//Metodo que inicia todos los componentes de la ventana;
	public void iniciarComp(JPanel panel) {
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(4, 2, 0, 23));
		etq1 = new JLabel("Introduzca su Nombre: ");
		etq1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		etq1.setHorizontalAlignment(SwingConstants.CENTER);		
		text1 = new JTextField(20);
		
		etq2 = new JLabel("Introduzca su DNI: ");
		etq2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		etq2.setHorizontalAlignment(SwingConstants.CENTER);
		etq2.setSize(14, 4);
		text2 = new JTextField(20);
		
		etq3 = new JLabel(" Prioridad: ");
		etq3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		etq3.setHorizontalAlignment(SwingConstants.CENTER);
		grupoBtn = new ButtonGroup();
		panelPrior = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelPrior.getLayout();
		flowLayout.setHgap(20);
		flowLayout.setVgap(20);
		jrb1 = new JRadioButton("1", false);
		jrb2 = new JRadioButton("2", false);
		jrb3 = new JRadioButton("3", false);
		panelPrior.add(jrb1);
		panelPrior.add(jrb2);
		panelPrior.add(jrb3);
		grupoBtn.add(jrb3);
		grupoBtn.add(jrb2);
		grupoBtn.add(jrb1);

		panel2.add(etq1);
		panel2.add(text1);
		panel2.add(etq2);
		panel2.add(text2);
		panel2.add(etq3);
		panel2.add(panelPrior);
				
		btn1 = new JButton("Reservar");
		btn1.setBounds(30,63,116,33);
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn1.setToolTipText("Esta opción te redigira a una ventana de reservas. ");
		btn1.addActionListener(this);
		btn2 = new JButton("Aceptar");
		btn2.setBounds(292,63,116,33);
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn2.setToolTipText("Esta opción te añadira a la sala de espera. ");
		btn2.addActionListener(this);
		panel2.add(btn1);
		panel2.add(btn2);
		
		marco.add(panel2, BorderLayout.CENTER);
		
		

	}
	//Metodo de sobreescritura de oyentes.
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Reservar":
			VentanaReserva nuevaReserva = new VentanaReserva(gestor);
			nuevaReserva.setVisible(true);
			break;

		case "Aceptar":
			
			if (text1.getText() == null || text2.getText() == null || validarJRButton() == null) {
				JOptionPane.showMessageDialog(null, "Tienes que rellenar todos los campos para poder ser atendido!!");
			} else if(text1.getText().toString().equals("") || text2.getText().toString().equals("")){
				JOptionPane.showMessageDialog(null, "Tienes que rellenar todos los campos para poder ser atendido!!");
			}else {

				Persona nueva = new Persona(text1.getText(), text2.getText(), validarJRButton());
				text1.setText("");
				text2.setText("");
				grupoBtn.clearSelection();

				gestor.meterSalaDeEspera(nueva);
				JOptionPane.showMessageDialog(null,
						"Sus datos han sido recogidos con éxito\nPorfavor pase a la sala de espera\nenseguida le atenderán. ");
				
			
				gestor.gestionVentanilla();
				
			}
			break;
		}

	}

	//Metodo para validar los JRadioButtons.
	public EPrioridad validarJRButton() {
		EPrioridad prio = null;
		if (jrb1.isSelected()) {
			prio = EPrioridad.uno;
		}
		if (jrb2.isSelected()) {
			prio = EPrioridad.dos;
		}
		if (jrb3.isSelected()) {
			prio = EPrioridad.tres;
		}
		return prio;
	}

}
