package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Writer;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.spec.InvalidKeySpecException;
import java.util.Properties;

import javax.mail.Session;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLException;

import org.apache.commons.net.smtp.AuthenticatingSMTPClient;
import org.apache.commons.net.smtp.SMTPReply;
import org.apache.commons.net.smtp.SimpleSMTPHeader;

import Modelo.ModeloLogica;
import Vista.GenerarTicket;
import Vista.ListaTickets;
import Vista.VistaEnviar;
import Vista.VistaTickets;
/**
 * Clase que controla la vista principal del admin reserva
 * 
 * @author Alberto Serrano y Antonio Ramayo
 *
 */
public class VistaTicketControlador implements ActionListener {
	VistaTickets vt;
	GenerarTicket gt;
	ListaTickets lt;
	ModeloLogica modelo;

	// DATOS DEL SERVIDOR al que enviar mensaje
	
    private static DatagramSocket clientSocket;

    
    public void abrirSocket() throws SocketException{   	
    	 clientSocket = new DatagramSocket();
    } 
    
    public DatagramSocket getDatagramSocket(){
    	return clientSocket;
    }
    
	public VistaTicketControlador(ModeloLogica m,VistaTickets vt){
		this.modelo =m;
		this.vt=vt;
	}
	@Override
	public void actionPerformed(ActionEvent eve) {
		
		String nombre = eve.getActionCommand();
		if (nombre.equals("Generar Ticket")) {
			gt = new GenerarTicket(modelo);
			vt.setVisible(false);
			gt.setVisible(true);
		}
		if (nombre.equals("Leer Ticket")) {
			lt =  new ListaTickets();
			vt.setVisible(false);
			lt.setVisible(true);
			lt.elementosJLIST();
		}
		if (nombre.equals("Enviar Email")) {
			VistaEnviar ve = new VistaEnviar();
			ve.setVisible(true);
			 
	/*		 AuthenticatingSMTPClient client = new AuthenticatingSMTPClient();
		  try {
				startTls(client);
			} catch (UnrecoverableKeyException | InvalidKeyException | KeyStoreException | NoSuchAlgorithmException
					| InvalidKeySpecException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} */
			   // String smtpHostServer = "smtp.gmail.com";
			  //  String emailID = "pruebaalbertotono@gmail.com";
			    
			//    Properties props = System.getProperties();
			   // props.put("mail.smtp.host", "smtp.gmail.com");
			  //  props.put("mail.smtp.auth", "false");  
			 //   props.setProperty("mail.transport.protocol", "smtp");     
			//    props.setProperty("mail.smtp.host", "smtp.gmail.com");
			   // props.put("mail.smtp.starttls.enable", "true");
			  
			  //  props.put("mail.smtp.port", "465");  
			//    props.put("mail.debug", "true");  
			 /*   props.put("mail.smtp.socketFactory.port", "465");  
			  	props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
			  	props.put("mail.smtp.socketFactory.fallback", "true");  */

			/*    Session session = Session.getInstance(props, null);
			    
			    EmailUtil.sendEmail(session, emailID,"SimpleEmail Testing Subject", "SimpleEmail Testing Body");*/
			    
			}

			
		}
		
	
}