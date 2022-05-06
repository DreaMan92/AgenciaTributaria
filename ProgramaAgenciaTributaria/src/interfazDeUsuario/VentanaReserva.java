package interfazDeUsuario;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import entidades.EPrioridad;
import entidades.Persona;
import entidades.Reserva;
import gestorSys.Gestor;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

@SuppressWarnings("serial")
public class VentanaReserva extends JFrame implements ActionListener{
	private Gestor gestor;
	public Container contenedor;
	private JPanel marco;//panel principal
	private JPanel panel2;//panel inputs
	private JPanel panelPrior;
	private JRadioButton jrb1,jrb2,jrb3;
	private JLabel etqT,etq1,etq2,etq3,etq4,etq5;
	private JTextField text1,text2;
	private ButtonGroup grupoBtn;
	private JButton btn1,btn2;
	private JDateChooser dateChooser;
	private JTextFieldDateEditor editorFecha;
	private JComboBox<String> comboHoras ;
	private String[] horasArray = new String[]{"09:00","09:15","09:30","09:45","10:00","10:15","10:30","10:45","11:00","11:15","11:30","11:45",
			"12:00","12:15","12:30","12:45","13:00","13:15","13:30","13:45","14:00","14:15","14:30","16:00","16:15","16:30","16:45","17:00",
			"17:15","17:30","17:45","18:00","18:15","18:30","18:45","19:00","19:15","19:30","19:45","20:00"};
	
	//Constructor
	public VentanaReserva(Gestor gestor) {
		setResizable(false);
		this.gestor=gestor;
		setTitle("   Realice su reserva - Agencia Tributaria");
		setBounds(215, 200, 600, 500);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PuestoInfo.class.getResource("/Recursos/icono.png")));
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		contenedor = getContentPane();
		contenedor.setLayout(new BorderLayout());
		
		etqT = new JLabel("Realice aqui su reserva. ");
		etqT.setHorizontalAlignment(SwingConstants.CENTER);
		etqT.setFont(new Font("Verdana", Font.BOLD, 18));
		contenedor.add(etqT,BorderLayout.NORTH);
		marco = new JPanel();
		marco.setLayout(new BorderLayout());
		contenedor.add(marco, BorderLayout.CENTER);
		iniciarComp(marco);
		
	}
	
	//Metodo que inicia todos los componentes de la ventana;
	public void iniciarComp(JPanel panel) {
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(6, 2, 0, 23));
		etq1 = new JLabel("Introduzca su Nombre: ");
		etq1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		etq1.setHorizontalAlignment(SwingConstants.CENTER);		
		text1 = new JTextField(20);
		text1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		etq2 = new JLabel("Introduzca su DNI: ");
		etq2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		etq2.setHorizontalAlignment(SwingConstants.CENTER);
		etq2.setSize(14, 4);
		text2 = new JTextField(20);
		text2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		etq3 = new JLabel(" Prioridad: ");
		etq3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		etq3.setHorizontalAlignment(SwingConstants.CENTER);
		grupoBtn = new ButtonGroup();
		panelPrior = new JPanel();
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
		
		etq4 = new JLabel("Seleccione una fecha: ");
		etq4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		etq4.setHorizontalAlignment(SwingConstants.CENTER);
		etq4.setSize(14, 4);		
		panel2.add(etq4);		
		dateChooser = new JDateChooser();
		dateChooser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		editorFecha = (JTextFieldDateEditor) dateChooser.getDateEditor();
		editorFecha.setEditable(false);
		panel2.add(dateChooser);
		
		etq5 = new JLabel("Seleccione una hora: ");
		etq5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		etq5.setHorizontalAlignment(SwingConstants.CENTER);
		etq5.setSize(14, 4); 
		panel2.add(etq5);		
		comboHoras = new JComboBox<String>();
		comboHoras.setModel(new DefaultComboBoxModel<>(horasArray));
		comboHoras.setSelectedIndex(8);
		comboHoras.addActionListener(this);
		panel2.add(comboHoras);
		
		
		
		marco.add(panel2, BorderLayout.CENTER);
		
		btn1 = new JButton("Cancelar");
		btn1.setBounds(30,63,116,33);
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn1.setToolTipText("Esta opcion cancelará la operación y te devolvera a la venta de puesto de información.");
		btn1.addActionListener(this);
		panel2.add(btn1);
		btn2 = new JButton("Reservar");
		btn2.setBounds(292,63,116,33);
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn2.setToolTipText("Esta ocpión añadirá tu reserva al sistema.");
		btn2.addActionListener(this);
		panel2.add(btn2);

	}

	//Metodo de sobreescritura de oyentes.
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Cancelar":
			this.dispose();
			break;

		case "Reservar":	
			if(text1.getText()==null || text2.getText()==null || validarJRButton()==null) {
				JOptionPane.showMessageDialog(null, "Tienes que rellenar todos los parametros!!");
			}else {
			
			Persona nueva = new Persona(text1.getText(),text2.getText(),validarJRButton());
			text1.setText("");
			text2.setText("");
			grupoBtn.clearSelection();
			
			Reserva una = new Reserva(nueva, editorFecha.getText(),comboHoras.getSelectedItem().toString());
			JOptionPane.showMessageDialog(null,"Su operacion se ha llevado acabo con éxito\n"+ una.toString()+"\nMuchas gracias,\nHasta pronto. ");
			gestor.guardarReserva(una);
			this.dispose();	}		
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
