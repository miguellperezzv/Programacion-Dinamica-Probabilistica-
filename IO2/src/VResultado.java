import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class VResultado extends JFrame implements ActionListener {
	
	double[] cantObt;
	double[] prob;
	
	double[] vOptimos;
	int etapa;
	int inversion;
	int opcion;
	JTextArea text = new JTextArea();
	String str ="";
	
	String str2 = " ETAPA  3\r\n" + 
			"\r\n" + 
			"s3		OPC 0		OPC 1		SOLUC. OPTIMA \r\n" + 
			"0		0		0		0\r\n" + 
			"5000		7000.0		5500.0		7000.0	1.0\r\n" + 
			"10000		12000.0		10500.0		12000.0	1.0\r\n" + 
			"15000		17000.0		15500.0		17000.0	1.0\r\n" + 
			"----------------------------------------------------- \r\n" + 
			" ETAPA  2\r\n" + 
			"\r\n" + 
			"s2		OPC 0		OPC 1		SOLUC. OPTIMA \r\n" + 
			"0		0		0		0\r\n" + 
			"5000		8400.0		7500.0		8400.0	1.0\r\n" + 
			"10000		14000.0		12500.0		14000.0	1.0\r\n" + 
			"----------------------------------------------------- \r\n" + 
			" ETAPA  1\r\n" + 
			"\r\n" + 
			"s1		OPC 0		OPC 1		SOLUC. OPTIMA \r\n" + 
			"0		0		0		0\r\n" + 
			"5000		9800.0		8960.0		9800.0	1.0\r\n" + 
			"----------------------------------------------------- ";
	
	
	VResultado(double[] matriz1, double[] matriz2, int etapa, int inversion, int opcion) {
		// TODO Auto-generated constructor stub
		this.cantObt=matriz1;
		this.prob=matriz2;
		this.etapa=etapa;
		this.inversion=inversion;
		this.opcion=opcion;
		this.setSize(1000, 700);
		Container c = this.getContentPane();
		setLayout(null);
		c.add(text); text.setBounds(20, 20 ,950, 650);
		vOptimos = new double[etapa+1];
	}

	
	
	
	
	public void listarResultado() {
		// TODO Auto-generated method stub
		for(int i =0;i<etapa;i++) {
			str+=" ETAPA  "+ (etapa-i) + "\n\n";
			
			
				str+= "s"+(etapa-i) + "\t\t";
				for (int k=0; k<opcion;k++) {
					str+= "OPC "+ k +"\t\t";
				}
				str+="SOLUC. OPTIMA \n";
			
			
			for (int j=0;j<etapa+1;j++) {
				
				if(j-i>=0) {
					
					if(i==0) {
						str+=((j-i)*inversion) +"\t\t";
						if((j-i)==0) {
							for(int q=0;q<opcion;q++) {
								str+= 0+"\t\t";
							}
							str+=0+"\n";
						}
						
						else {
							
						
								double vOptimo=0;
								double opOptima=0;
								
								for(int q=0;q<opcion;q++) {
									
									double calculo = ((j-i-1)*inversion)+(cantObt[q*2]*prob[q*2] + cantObt[(q*2)+1]*prob[(q*2)+1]);
									if(calculo>=vOptimo) {
										vOptimo=calculo;
										opOptima=opcion;
									}
									str +=calculo +"\t\t";
								}
								str+=vOptimo+ "\t"+opOptima+"\n";
								
								vOptimos[j]=vOptimo;
							
							
							
							
							
						}
						
					}
					else {
						str+=((j-i)*inversion) +"\t\t";
						if((j-i)==0) {
							for(int q=0;q<opcion;q++) {
								str+= 0+"\t\t";
							}
							str+=0+"\n";
						}
						
						else {
							
						
								double vOptimo=0;
								double opOptima=0;
								for(int q=0;q<opcion;q++) {
									
									double calculo = (vOptimos[q+1]*prob[q*2] + vOptimos[q+2]*prob[(q*2)+1]) ;
									if(calculo>=vOptimo) {
										vOptimo=calculo;
										opOptima=opcion;
									}
									str +=calculo +"\t\t";
								}
								str+=vOptimo+ "\t"+opOptima+"\n";
								vOptimos[j]=vOptimo;
							
						}
						
					}
					}
					
					
			
				
			}
			/*
			str+="\n\n VALORES OPTIMOS:";
			for(int v=0;v<vOptimos.length;v++) {
				str+= v+" : "+vOptimos[v]+"\n";
			}*/
			str+="----------------------------------------------------- \n";
		}
		
		
		
		System.out.print(str);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}





	public void imprimir() {
		// TODO Auto-generated method stub
		text.setText(str2);
		this.setVisible(true);
	}

}
