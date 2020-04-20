package Ficheros;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Pedro Camacho
 */
public class Vista extends JFrame {

	private JPanel contentPane;
	private JTextField txtBillete, txtPremio;
	private JLabel lblInfo;
	private JButton btnGuardar;
	private JButton btnBorrar;
	private JButton btnComprobar;
	
	private Controlador miControlador;
	private Modelo miModelo;

	public Vista() {

		setTitle("Ficheros Configuracion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 275);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBillete = new JLabel("Billete:");
		lblBillete.setBounds(10, 75, 75, 14);
		contentPane.add(lblBillete);

		JLabel lblPremio = new JLabel("Premio:");
		lblPremio.setBounds(10, 117, 75, 14);
		contentPane.add(lblPremio);

		txtBillete = new JTextField();
		txtBillete.setBounds(95, 72, 86, 20);
		contentPane.add(txtBillete);
		txtBillete.setColumns(10);

		txtPremio = new JTextField();
		txtPremio.setBounds(95, 114, 86, 20);
		contentPane.add(txtPremio);
		txtPremio.setColumns(10);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				miControlador.guardar();
			}
		});
		btnGuardar.setBounds(255, 71, 104, 23);
		contentPane.add(btnGuardar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.borrar();
			}
		});
		btnBorrar.setBounds(255, 113, 104, 23);
		contentPane.add(btnBorrar);

		btnComprobar = new JButton("Comprobar");
		btnComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.comprobar();
			}
		});
		btnComprobar.setBounds(255, 155, 104, 23);
		contentPane.add(btnComprobar);
		
		JLabel lblRes3 = new JLabel("Resultado:");
		lblRes3.setBounds(10, 197, 75, 14);
		contentPane.add(lblRes3);
		
		// Etiqueta para mostrar los resultados
		lblInfo = new JLabel("");
		lblInfo.setBounds(95, 197, 159, 14);
		contentPane.add(lblInfo);

	}

	public void setControlador(Controlador miControlador) {
		this.miControlador=miControlador;
	}
	public void setModelo (Modelo miModelo){
		this.miModelo = miModelo;
	}

	public String getBillete (){
		return txtBillete.getText();
	}
	
	public String getPremio (){
		return txtPremio.getText();
	}
	
	public void actualizar () {
		lblInfo.setText(miModelo.getRespuesta());
	}
	
}
