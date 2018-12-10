package Sockets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;

import javax.swing.*;
import java.net.*;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoCliente mimarco = new MarcoCliente();

		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoCliente extends JFrame {

	public MarcoCliente() {

		setBounds(600, 300, 280, 350);

		LaminaMarcoCliente milamina = new LaminaMarcoCliente();

		add(milamina);

		setVisible(true);
	}

}

class LaminaMarcoCliente extends JPanel {

	public LaminaMarcoCliente() {

		JLabel texto = new JLabel("CLIENTE");

		add(texto);

		campo1 = new JTextField(20);

		add(campo1);

		miboton = new JButton("Enviar");

		EnviaTexto miEvento = new EnviaTexto();

		miboton.addActionListener(miEvento);

		add(miboton);

	}

	private class EnviaTexto implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Apéndice de método generado automáticamente
			// System.out.println(campo1.getText());

			try {
				Socket cliente = new Socket("192.168.222.1", 9999);
				
				DataOutputStream flujo_salida = new DataOutputStream(cliente.getOutputStream());
				
				flujo_salida.writeUTF(campo1.getText());
				
				flujo_salida.close();
				
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
				System.out.println(e1.getMessage());
			} catch (IOException e1) {
				// TODO Bloque catch generado automáticamente
				e1.printStackTrace();
				System.out.println(e1.getMessage());
			}

		}
	}

	private JTextField campo1;

	private JButton miboton;

}