package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import Juego.Logica;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;

public class GAME extends JFrame {

	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GAME window = new GAME();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public GAME() {
		initialize_logica();
		initialize();
		
	}
	Logica Logic = new Logica();
	private void initialize_logica() {
		
		Logic.agregarPregunta("una guitarra", "un bajo", "tiene 4 cuerdas");
		Logic.agregarPregunta("una guitarra", "una flauta", "es de aire");
		Logic.agregarPregunta("una flauta", "una trompeta","es de metal");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	JTextPane txtpnIstrucciones= new JTextPane();
	JLabel lblNombrejuego = new JLabel("ADIVINADOR");
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNuevoJuego = new JButton("Nuevo Juego");
		btnNuevoJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Start second = new Start();
				second.setVisible(true);
			}
		});
		btnNuevoJuego.setBounds(402, 156, 125, 23);
		frame.getContentPane().add(btnNuevoJuego);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 332, 291);
		frame.getContentPane().add(scrollPane);
		
		
		txtpnIstrucciones.setEditable(false);
		scrollPane.setViewportView(txtpnIstrucciones);
		txtpnIstrucciones.setText(Logic.imprimirTodos());
		
		
		lblNombrejuego.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblNombrejuego.setBounds(371, 63, 196, 71);
		frame.getContentPane().add(lblNombrejuego);
		
		JLabel lblInstrucciones = new JLabel("Instrumentos");
		lblInstrucciones.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblInstrucciones.setBounds(128, 11, 107, 23);
		frame.getContentPane().add(lblInstrucciones);
		
		JTextPane txtpnInfo = new JTextPane();
		txtpnInfo.setEditable(false);
		txtpnInfo.setText("Altura Arbol: \n\n"
						+ "Cantidad de Objetos: \n\n"
						+ "Cantidad de Preguntas: ");
		txtpnInfo.setBounds(381, 230, 186, 97);
		frame.getContentPane().add(txtpnInfo);
		
	}
}
