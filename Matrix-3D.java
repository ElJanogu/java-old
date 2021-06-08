import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class M3D1 extends JFrame {

	private JPanel contentPane;
	int matrixSize;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					M3D1 frame = new M3D1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public M3D1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 762, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 740, 367);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("   Verschluesselung   ", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblKlartext = new JLabel("Klartext :");
		lblKlartext.setBounds(15, 16, 69, 20);
		panel.add(lblKlartext);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 52, 695, 88);
		panel.add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(25, 208, 691, 109);
		panel.add(scrollPane_1);
		
		JTextPane textPane_1 = new JTextPane();
		scrollPane_1.setViewportView(textPane_1);
		
		JButton btnVerschluesseln = new JButton("verschluesseln");
		btnVerschluesseln.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String klartext = textPane.getText();
				klartext = filtern(klartext);
				
				char[] k = klartext.toCharArray();
				
				matrixSize = (int) Math.cbrt(k.length) + 1;
		
				char[][][] m = schreibeMatrix(k);
				
				String chiffre = matrixLesen(m);
				
				textPane_1.setText(chiffre);
			
			}			
		});
		btnVerschluesseln.setBounds(270, 163, 161, 29);
		panel.add(btnVerschluesseln);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("   Entschluesselung   ", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblChiffre = new JLabel("Chiffre :");
		lblChiffre.setBounds(15, 16, 84, 20);
		panel_1.add(lblChiffre);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(15, 39, 710, 95);
		panel_1.add(scrollPane_2);
		
		JTextPane textPane_2 = new JTextPane();
		scrollPane_2.setViewportView(textPane_2);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(15, 232, 705, 101);
		panel_1.add(scrollPane_3);
		
		JTextPane textPane_3 = new JTextPane();
		scrollPane_3.setViewportView(textPane_3);
		
		JLabel lblKlartext_1 = new JLabel("Klartext :");
		lblKlartext_1.setBounds(15, 208, 111, 20);
		panel_1.add(lblKlartext_1);
		
		JButton btnEntschluesseln = new JButton("Entschluesseln");
		btnEntschluesseln.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String chiffre = textPane_2.getText();
				chiffre = filtern(chiffre);
				
				char[] c = chiffre.toCharArray();
				
				matrixSize = (int) Math.cbrt(c.length);
		
				char[][][] m = schreibeMatrixReverse(c);
				
				String klartext = matrixLesenReverse(m);
				
				textPane_3.setText(klartext);
		
			}
		});
		btnEntschluesseln.setBounds(263, 162, 152, 29);
		panel_1.add(btnEntschluesseln);
	}

	String filtern(String input)
	{
		String text = "";
		
		text = input.trim()
				.replaceAll(" ", "")
				.replaceAll("[^A-Za-z]+", "")
				.toUpperCase();
		
		return text;
	}
		
	char[][][] schreibeMatrix(char[] input)
	{
		char[][][] matrix = new char[matrixSize][matrixSize][matrixSize];
		
		Random r = new Random(); // erstelle zufalls objekt
		int index = 0;  // zaehlvariable fuer den klartext
		
		for(int e = 0; e < matrixSize ; e++)
		{
			for(int z = 0; z < matrixSize ; z++) // zeile
			{ 
				for(int s = 0 ;  s < matrixSize ; s++) // spalte
				{
					if(index < input.length) //solange text vorhanden ist
					{
						matrix[e][z][s] = input[index]; // uebergebe buchstaben
						index++; // erhoehe index
					}
					else //ansonsten wird ine zufaelliger buchstabe erstellt
					{
						int zahl = r.nextInt(26); // zufaellige zahl von 0 bis 25
						zahl += 65; // erhoehe um 65 um einen Grossbuchstaben zu erhalten
						char buchstabe = (char) zahl; // uebertrage in einen char
						
						matrix[e][z][s] = buchstabe;
					}
				}
			}		
		}
	
		return matrix;
	}
		
	String matrixLesen(char[][][] input)
	{
		String text  = "";
		
		for(int s = 0; s <matrixSize ; s++)
		{
			for(int z = 0; z < matrixSize ; z++)
			{
				for(int e = 0; e < matrixSize ; e++){
				text += input[e][z][s];
				}
			}
		}
		
		return text;
	}
	
	char[][][] schreibeMatrixReverse(char[] input)
	{
		char[][][] matrix = new char[matrixSize][matrixSize][matrixSize];
		
		int index = 0;  // zaehlvariable fuer den klartext
		
		for(int s = 0; s < matrixSize ; s++) // zeile
		{ 
			for(int z = 0 ;  z < matrixSize ; z++) // spalte
			{
				for(int e = 0; e < matrixSize ; e++){
					matrix[e][z][s] = input[index]; // uebergebe buchstaben
					index++; // erhoehe index
				}
			}
		}
		
		return matrix;
	}

	String matrixLesenReverse(char[][][] input)
	{
		String text  = "";
		
		for(int e = 0; e < matrixSize ; e++)
		{
			for(int z = 0; z <matrixSize ; z++)
			{
				for(int s = 0; s < matrixSize ; s++)
				{
					text += input[e][z][s];
				}
			}	
		}
				
		return text;
	}
	
}

