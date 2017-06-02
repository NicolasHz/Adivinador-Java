package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Window;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Start extends GAME {

	private JPanel contentPane;
	public int suma=0;
	/**
	 * Create the frame.
	 */
	private JLabel lblPregunta = new JLabel("Es "+ Logic.Primer() +"?");
	private final JButton btnSi = new JButton("SI");	
	private final JButton btnNo = new JButton("NO");
	private JTextField txtNuevoInstrumento;
	private JTextField txtDiferencia;
	private JLabel lblDiferencia = new JLabel("Diferencia");
	private JLabel lblNuevoinstrumento = new JLabel("Nuevo Instrumento");
	private final JButton btnAgregar = new JButton("Agregar");
	private final JLabel lblGanador = new JLabel("");
	private JButton btnReiniciar = new JButton("Reiniciar Partida");
	private JLabel lblErrorCompletar2 = new JLabel("Debe completar este campo");
	private JLabel lblErrorCompletar1 = new JLabel("Debe completar este campo");
	
	public Start() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 200, 451, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SI();
			}
		});
		btnSi.setBounds(182, 66, 89, 23);
		contentPane.add(btnSi);
		
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NO();
			}
		});
		btnNo.setBounds(302, 66, 89, 23);
		contentPane.add(btnNo);
		
		
		lblPregunta.setBounds(45, 70, 289, 14);
		contentPane.add(lblPregunta);
		
		txtNuevoInstrumento = new JTextField();
		txtNuevoInstrumento.setBounds(45, 158, 346, 20);
		contentPane.add(txtNuevoInstrumento);
		txtNuevoInstrumento.setColumns(10);
		txtNuevoInstrumento.setVisible(false);
		

		lblNuevoinstrumento.setBounds(45, 133, 207, 14);
		contentPane.add(lblNuevoinstrumento);
		lblNuevoinstrumento.setVisible(false);

		lblDiferencia.setBounds(45, 201, 207, 14);
		contentPane.add(lblDiferencia);
		lblDiferencia.setVisible(false);
		
		txtDiferencia = new JTextField();
		txtDiferencia.setBounds(45, 230, 346, 20);
		contentPane.add(txtDiferencia);
		txtDiferencia.setColumns(10);
		txtDiferencia.setVisible(false);
		btnReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reiniciar();
			}
		});
		
		
		btnReiniciar.setBounds(45, 317, 141, 23);
		
		contentPane.add(btnReiniciar);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Agregar();
			}
		});
		btnAgregar.setBounds(302, 261, 89, 23);
		contentPane.add(btnAgregar);
		btnAgregar.setVisible(false);
		
		lblGanador.setHorizontalAlignment(SwingConstants.CENTER);
		lblGanador.setFont(new Font("Serif", Font.BOLD, 20));
		lblGanador.setBounds(45, 66, 358, 136);
		
		contentPane.add(lblGanador);
		
		
		lblErrorCompletar1.setBounds(262, 133, 141, 14);
		contentPane.add(lblErrorCompletar1);
		lblErrorCompletar1.setVisible(false);
		
		
		lblErrorCompletar2.setBounds(262, 201, 141, 14);
		contentPane.add(lblErrorCompletar2);
		lblErrorCompletar2.setVisible(false);
		lblGanador.setVisible(false);

		
	}



	protected void Agregar() {
		try {
			String instru = txtNuevoInstrumento.getText();
			String dif =txtDiferencia.getText();
			if(instru.length()==0){
				
			}
			if(dif.length()==0){
				
			}
			if(dif.length()!=0 && instru.length()!=0){
				Logic.agregarPregunta(Logic.Actual(), instru, dif);
				lblErrorCompletar1.setVisible(true);
				lblErrorCompletar2.setVisible(true);
			}
			
			Reiniciar();
		} catch (Exception e) {}
		
	}
	protected void Reiniciar() {
		Logic.setActual(Logic.getPrimer());
		lblPregunta.setText("Es "+Logic.Actual()+"?");
		txtNuevoInstrumento.setVisible(false);
		lblNuevoinstrumento.setVisible(false);
		lblDiferencia.setVisible(false);
		txtDiferencia.setVisible(false);
		lblPregunta.setVisible(false);
		lblGanador.setVisible(false);
		btnSi.setEnabled(true);
		btnNo.setEnabled(true);
		btnNo.setVisible(true);
		btnSi.setVisible(true);
		lblPregunta.setVisible(true);
		btnAgregar.setVisible(false);
	}
	private void SI(){
		if (Logic.SiguienteSi()) {
			lblPregunta.setText("Es "+Logic.Actual()+"?");
		}else{
			txtNuevoInstrumento.setVisible(false);
			lblNuevoinstrumento.setVisible(false);
			lblDiferencia.setVisible(false);
			txtDiferencia.setVisible(false);
			lblPregunta.setVisible(false);
			btnNo.setVisible(false);
			btnSi.setVisible(false);
			lblGanador.setVisible(true);
			lblGanador.setText("Adivine el insrumento");
		}
		
	} 
	private void NO(){
		if (Logic.SiguienteNo()) {
			lblPregunta.setText("Es "+Logic.Actual()+"?");
		}else{
			txtNuevoInstrumento.setVisible(true);
			lblNuevoinstrumento.setVisible(true);
			lblDiferencia.setVisible(true);
			txtDiferencia.setVisible(true);
			btnAgregar.setVisible(true);
			btnSi.setEnabled(false);
			btnNo.setEnabled(false);
						
		}
	}
}
