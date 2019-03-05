package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Modelo.ModeloLogica;
import Modelo.Ticket;
import Vista.CrearTicket;
import Vista.GenerarTicket;
import Vista.LeerTicketReserva;
/**
 * Clase que controla las listas del los tickets, admin y casos abiertos 
 * 
 * @author Alberto Serrano y Antonio Ramayo
 *
 */
public class LeerTickerRControlador extends MouseAdapter implements ActionListener{
	
		ModeloLogica modelo;
		LeerTicketReserva ltr;
		CrearTicket ct;
		int idCaso;
		/**
		 * Metodo que que le da funcionalidad a los botones
		 * @param modelo
		 * @param ltr
		 */
		public LeerTickerRControlador(ModeloLogica modelo, LeerTicketReserva ltr){
			this.modelo = modelo;
			this.ltr = ltr;
		}
		/**
		 * Metodo que controla cuando clickas en un elemento de la lista
		 */
		 @Override
		    public void mouseClicked(MouseEvent me) {
		           String idcaso = ltr.ObtenerIDCaso();
		           idCaso = Integer.parseInt(idcaso);
		           ltr.elementosJLIST2(idCaso);	         
		    }
		 /**
		  * metodo que da funcion a los botones
		  */
		@Override
		public void actionPerformed(ActionEvent eve) {
			
			String nombre = eve.getActionCommand();
			if (nombre.equals("Aceptar")) {
				ct = new CrearTicket(modelo);
				ct.setVisible(true);
				ct.getTextField_1().setText(ltr.ObtenerIDCaso());	
				for (Ticket t : modelo.CargarDatosTicketsPendientes(Integer.parseInt(ltr.ObtenerIDCaso()))) {
					ct.getTextField().setText(Integer.toString(t.getId()));
					ct.getTextField_2().setText(Integer.toString(t.getId_Admin()));
					ct.getTextField_3().setText(t.getAsunto());
					ct.getTextField_5().setText(t.getFecha());
					ct.getTextField_4().setText(t.getDesc());
					
				}
				ct.getTextField().setEditable(false);
				ct.getTextField_1().setEditable(false);
			}
		}
		/**
		 * metodo que obtine la lista de casos abiertos
		 * @return
		 */
		  public ArrayList<Ticket> getListaCasosAbiertos() {
		        return modelo.CargarDatosTicketsPendientes(); 
		    }
		  /**
			 * metodo que obtine la lista de tickets abiertos
			 * @return
			 */
		  public ArrayList<Ticket> getListaCasos(int idCaso) { 
			  return modelo.CargarDatosTicketsPendientes(idCaso);
		        
		    }
}
