package Sockets;

import javax.swing.*;

import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoServidor mimarco=new MarcoServidor();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}	
}

class MarcoServidor extends JFrame implements Runnable{
	
	public MarcoServidor(){
		
		setBounds(1200,300,280,350);				
			
		JPanel milamina= new JPanel();
		
		milamina.setLayout(new BorderLayout());
		
		areatexto=new JTextArea();
		
		milamina.add(areatexto,BorderLayout.CENTER);
		
		add(milamina);
		
		setVisible(true);
		
		Thread pasaTexto = new Thread(this);
		pasaTexto.start();
		
		}
	
	private	JTextArea areatexto;
	
	@Override
	public void run() {
		// TODO Apéndice de método generado automáticamente
		//System.out.println("Funciono");
		
		 try {
			ServerSocket servidor = new ServerSocket(9999);
			
			while(true) {
			
			Socket miSocket = servidor.accept();

			DataInputStream flujo_entrada = new DataInputStream(miSocket.getInputStream());
			String mensaje_texto = flujo_entrada.readUTF();
			
			areatexto.append("\n" + mensaje_texto);
			
			miSocket.close();
			
			}
			
		} catch (IOException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		
	}
}
