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

public class vMatriz extends JFrame implements ActionListener
{
	int etapa;
	int opcion;
	int inversion;
	
	JTextField[] txtCantidadObtenida;
	JTextField[] txtProbabilidad;
	
	JLabel lblInv = new JLabel("Inversion");
	JLabel lblCant = new JLabel("Cant Obt.");
	JLabel lblProb = new JLabel("Probabilidad");
	
	JLabel lblLetras[];
	JButton btnConfirmar = new JButton ("CONFIRMAR");
	
	//variables para el cálculo
	double[] cantObt;
	double[] prob;
	
	Icon ico = new ImageIcon ("./img/info.png");
	JButton btnInfo = new JButton("INFO");
	
	
	vMatriz(int etapa, int opcion, int inversion){
		
		this.etapa = etapa;
		this.opcion = opcion;
		this.inversion = inversion;
		
		this.setSize(500, (this.opcion*2)*30 +50);
		
		cantObt = new double[opcion*2];
		prob = new double[opcion*2];
		
		Container c = this.getContentPane();
		setLayout(null);
		txtCantidadObtenida = new JTextField[opcion*2];
		txtProbabilidad = new JTextField[opcion*2];
		lblLetras = new JLabel[opcion];
		
		
		c.add(lblCant); lblCant.setBounds(250, 30, 100, 30);
		c.add(lblProb); lblProb.setBounds(350, 30, 100, 30);
		
		for(int i=0;i<opcion*2;i++) {
			if (i%2 !=0) {
				lblLetras[i/2]=new JLabel(" OPC INV " +i+1 +" :");
				c.add(lblLetras[i/2]); lblLetras[i/2].setText(""+i/2); lblLetras[i/2].setBounds(100, 50+((i/2)*60), 200, 50);
			}
			txtCantidadObtenida[i] = new JTextField();
			c.add(txtCantidadObtenida[i]); txtCantidadObtenida[i].setBounds(250, 50 + i*30, 80, 30);
			txtProbabilidad[i] = new JTextField();
			c.add(txtProbabilidad[i]); txtProbabilidad[i].setBounds(350, 50 + i*30, 80, 30);
		}
		
		c.add(btnConfirmar); btnConfirmar.setBounds(280, 50 + opcion*2*30, 80, 30); btnConfirmar.addActionListener(this);
		c.add(btnInfo); btnInfo.setBounds(20, 20, 70, 40); btnInfo.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==btnConfirmar) {
			VResultado ventanaResultado = new VResultado(cantObt, prob, etapa, inversion,opcion); 
			for (int i=0; i<opcion*2;i++) {
				cantObt[i] = Double.parseDouble(txtCantidadObtenida[i].getText());
				prob[i] = Double.parseDouble(txtProbabilidad[i].getText());
				
				System.out.print(cantObt[i]+ " ........"+ prob[i]+ "\n");
				
				this.dispose();
				
				
			}
			ventanaResultado.listarResultado();
			this.dispose();
			ventanaResultado.imprimir();
			
		}
		
		if(arg0.getSource()==btnInfo) {
			String info ="El problema tiene "+ opcion +" opciones de inversión \n "
					+ " Por cada opcion de inversión existen dos probabilidades \n"
					+ "CANT OBT. : Cantidad obtenida por elegir la inversión \n"
					+ "PROB: Probabilidad de suceder por cada cantidad";
			JOptionPane.showMessageDialog(null, info);
		}
	}


}
