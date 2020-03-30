import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class VDatos extends JFrame implements ActionListener{

	
	JLabel info0 = new JLabel ("PROGRMACIÓN DINÁMICA PROBABILÍSTICA");
	JLabel info1 = new JLabel ("Ingrese la cantidad de etapas: ");
	JLabel info2 = new JLabel ("Ingrese cantidad de opciones: ");
	JLabel info3 = new JLabel ("Ingrese la cantidad de inversión por etapa: ");
	
	JTextField txtEtapa = new JTextField();
	JTextField txtOpcion = new JTextField();
	JTextField txtInversion = new JTextField();
	
	Icon ico = new ImageIcon ("./img/info.png");
	JButton btnInfo = new JButton("INFO");
	JButton btnContinuar = new JButton("CONTINUAR");
	
	VDatos(){
		
		java.io.File imageCheck = new java.io.File("/img/info.png");

		if(imageCheck.exists()) {
			System.out.println("Image file found! \n");
		}
		    
		else {
			System.out.println("Image file not found! \n");
		}
		    
		
		Container c = this.getContentPane();
		setLayout(null);
		c.add(info0); info0.setBounds(150, 30, 300, 50);
		c.add(info1); info1.setBounds(30, 60, 200, 50);
		c.add(info2); info2.setBounds(30, 160, 200, 50);
		c.add(info3); info3.setBounds(30, 260, 300, 50);
		
		c.add(txtEtapa); txtEtapa.setBounds(300, 70, 50, 30);
		c.add(txtOpcion); txtOpcion.setBounds(300,170, 50, 30);
		c.add(txtInversion); txtInversion.setBounds(300, 270, 50, 30);
		
		c.add(btnContinuar); btnContinuar.setBounds(200, 310, 200, 40); btnContinuar.addActionListener(this);
		
		c.add(btnInfo); c.add(btnInfo); btnInfo.setBounds(70, 30, 70, 40); btnInfo.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==btnContinuar) {
			this.dispose();
			int etapa = Integer.parseInt(txtEtapa.getText());
			int opcion = Integer.parseInt(txtOpcion.getText());
			int inversion = Integer.parseInt(txtInversion.getText());
			
			vMatriz vMatriz = new vMatriz(etapa,opcion,inversion);
			
			vMatriz.setSize(700, 700);
			vMatriz.setVisible(true);
			
		}
		if(e.getSource()==btnInfo) {
			String info ="ETAPA: puede entenderse cuantas interaciones son necesarias \n"
					+ "OPCIÓN : Cuántas opciones de inversión existen en el problema\n"
					+ "INVERSIÓN: Cuánto dinero es invertido en cada etapa";
			JOptionPane.showMessageDialog(null, info);
		}
		
		
	
	}

}
