package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.CrearTicketController;
import Modelo.ModeloLogica;
import Modelo.Ticket;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class Servidor extends JFrame implements Runnable{

	private JPanel contentPane;
	// private Cola cola;
	JTextArea textArea;
	Servidor s; 
	 DatagramSocket socket;
	 byte[] receiveBuffer = new byte[65535];
	 static InetAddress grupo = null;
	 ModeloLogica modelo;
	 int puerto = 14780;
	 DatagramPacket p; 
	 CrearTicketController ct;
	 CrearTicket ct1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Servidor frame = new Servidor();
					new Thread(frame).start();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SocketException 
	 */
	public Servidor() throws SocketException {
		//cola = new Cola();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		modelo = new ModeloLogica();
		socket = new DatagramSocket(12345);
		p = new DatagramPacket(receiveBuffer, receiveBuffer.length);	
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 592, 353);
		contentPane.add(panel);
		panel.setLayout(null);
		textArea = new JTextArea();
		textArea.setBounds(12, 13, 568, 327);
		panel.add(textArea);
		textArea.setText("servidor iniciado en puerto "+socket.getLocalPort()+"------------");
	}
	@Override
	public void run() {
		while(true) {	
			try {	
			System.out.println("Entra");
			socket.receive(p); 
            ByteArrayInputStream bais = new ByteArrayInputStream(receiveBuffer);
            ObjectInputStream in = new ObjectInputStream(bais);
			Ticket t = (Ticket) in.readObject();
			
		if(modelo.AddTicket(t)) {
			JOptionPane.showMessageDialog(
				    null, 
				    "Añadido a la base de datos", 
				    "Añadido",
				    JOptionPane.INFORMATION_MESSAGE); 
		}else {
			JOptionPane.showMessageDialog(
				    null, 
				    "ERROR AL AÑADIR A LA BASE DE DATOS", 
				    "ERROR",
				    JOptionPane.ERROR_MESSAGE); 
		}
			textArea.setText("\nTicket recibido: "+ t.toString());	
			
			
			} catch (IOException e) {				
				System.out.println(e);			
			} catch (ClassNotFoundException e) {		
				e.printStackTrace();
			}
		}
		
	}
	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
}
