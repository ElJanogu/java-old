import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class M2D1 extends JFrame {

	private JPanel contentPane;
	int matrixSize;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					M2D1 frame = new M2D1();
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
	public M2D1() {
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
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(25, 177, 146, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnGroesseBerechenen = new JButton("groesse berechenen");
		btnGroesseBerechenen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String text = textPane.getText(); // lade text
				text = filtern(text); // filtere text
				
				char[] zeichen = text.toCharArray(); // convertiere zu char[]
				
				int buchstaben = zeichen.length; // anzahl der buchstaben
				
				matrixSize = (int) Math.sqrt(buchstaben) + 1;
				
				textField.setText("matrixsize = "+matrixSize);
			
			}
		});
		btnGroesseBerechenen.setBounds(15, 144, 173, 29);
		panel.add(btnGroesseBerechenen);
		
		JLabel lblEigeneAuslesereihenfolge = new JLabel("eigene Auslesereihenfolge :");
		lblEigeneAuslesereihenfolge.setBounds(203, 148, 195, 20);
		panel.add(lblEigeneAuslesereihenfolge);
		
		textField_1 = new JTextField();
		textField_1.setBounds(213, 177, 146, 26);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JCheckBox chckbxNutzen = new JCheckBox("nutzen");
		chckbxNutzen.setBounds(409, 144, 139, 29);
		panel.add(chckbxNutzen);
		
		JButton btnVerschluesseln = new JButton("verschluesseln");
		btnVerschluesseln.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			   
				String klartext = filtern(textPane.getText());
				
				char[] zeichen = klartext.toCharArray();
				char[][] m = schreibeMatrixNormal(zeichen);
				
				String chiffre;
				
				if( !chckbxNutzen.isSelected())
				{
					chiffre = matrixLesenNormal(m);
				}
				else 
				{
				   chiffre = matrixLesenReihe(m);	
				}
				
				textPane_1.setText(chiffre);
			
			}

			
		});
		btnVerschluesseln.setBounds(555, 176, 161, 29);
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
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(15, 180, 189, 26);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnGroesseBerechnen = new JButton("groesse berechnen");
		btnGroesseBerechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String text = textPane_2.getText(); // lade text
				text = filtern(text); // filtere text
				
				char[] zeichen = text.toCharArray(); // convertiere zu char[]
				
				int buchstaben = zeichen.length; // anzahl der buchstaben
				
				matrixSize = (int) Math.sqrt(buchstaben);
				
				textField_2.setText("matrixsize = "+matrixSize);
				
			}
		});
		btnGroesseBerechnen.setBounds(15, 145, 189, 29);
		panel_1.add(btnGroesseBerechnen);
		
		JLabel lblEigeneReihenfolge = new JLabel("eigene Reihenfolge :");
		lblEigeneReihenfolge.setBounds(211, 149, 166, 20);
		panel_1.add(lblEigeneReihenfolge);
		
		textField_3 = new JTextField();
		textField_3.setBounds(211, 180, 146, 26);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JCheckBox chckbxNutzen_1 = new JCheckBox("nutzen");
		chckbxNutzen_1.setBounds(366, 146, 139, 29);
		panel_1.add(chckbxNutzen_1);
		
		JButton btnEntschluesseln = new JButton("Entschluesseln");
		btnEntschluesseln.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String chiffre = filtern(textPane_2.getText());
				
				char[] zeichen = chiffre.toCharArray();
				char[][] m;
				
				if(!chckbxNutzen_1.isSelected())
				{
					m = schreibeMatrixReverseNormal(zeichen);
				}
				else
				{
					  m = schreibeMatrixReverseReihe(zeichen);
				}
								       
				String klartext = matrixLesenReverseNormal(m);
				
				textPane_3.setText(klartext);
		
			}
		});
		btnEntschluesseln.setBounds(557, 191, 152, 29);
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
	
	int[] reihenfolge(String reihe)
	{
		//String reihe = input;
		int[] r = new int[reihe.length()];
		
		for(int i = 0; i < r.length ; i++)
		{
			r[i] = Integer.parseInt(reihe.substring(i, i+1));
		}
		
		return r;
	}
	
	
	char[][] schreibeMatrixNormal(char[] input)
	{
		char[][] matrix = new char[matrixSize][matrixSize];
		
		Random r = new Random(); // erstelle zufalls objekt
		int index = 0;  // zaehlvariable fuer den klartext
		
		for(int z = 0; z < matrixSize ; z++) // zeile
		{ 
			for(int s = 0 ;  s < matrixSize ; s++) // spalte
			{
				if(index < input.length) //solange text vorhanden ist
				{
					matrix[z][s] = input[index]; // uebergebe buchstaben
					index++; // erhoehe index
				}
				else //ansonsten wird ine zufaelliger buchstabe erstellt
				{
					int zahl = r.nextInt(26); // zufaellige zahl von 0 bis 25
					zahl += 65; // erhoehe um 65 um einen Grossbuchstaben zu erhalten
					char buchstabe = (char) zahl; // uebertrage in einen char
					
					matrix[z][s] = buchstabe;
				}
			}
		}
		
		return matrix;
	}
		
	String matrixLesenNormal(char[][] input)
	{
		String text  = "";
		
		for(int s = 0; s <matrixSize ; s++)
		{
			for(int z = 0; z < matrixSize ; z++)
			{
				text += input[z][s];
			}
		}
		
		return text;
	}
	
	String matrixLesenReihe(char[][] input)
	{
		String text  = "";
		
		for(int i = 0; i <matrixSize ; i++)
		{
			
			int[] reihenfolge = reihenfolge(textField_1.getText());
			int s = reihenfolge[i];
			
			for(int z = 0; z < matrixSize ; z++)
			{
				text += input[z][s];
			}
		}
		
		return text;
	}
	
	char[][] schreibeMatrixReverseNormal(char[] input)
	{
		char[][] matrix = new char[matrixSize][matrixSize];
		
		int index = 0;  // zaehlvariable fuer den klartext
		
		for(int s = 0; s < matrixSize ; s++) // zeile
		{ 
			for(int z = 0 ;  z < matrixSize ; z++) // spalte
			{
				
					matrix[z][s] = input[index]; // uebergebe buchstaben
					index++; // erhoehe index
						
			}
		}
		
		return matrix;
	}

	char[][] schreibeMatrixReverseReihe(char[] input)
	{
		   char[][] matrix = new char[matrixSize][matrixSize];
			
			int index = 0;
			int[] reihenfolge = reihenfolge(textField_3.getText());
			
			for (int i = 0; i < matrixSize; i++) {
				
				int s = reihenfolge[i]; // vor dem Zeilendurchlauf in der for schleife wird in der übergeordneten vorschleife nach und nach die Codierungsreihenforge durchgegangen
				
				for (int z = 0; z < matrixSize; z++) {
						matrix[z][s] = input[index];
						index++;
					
					
				}
			}
			
			return matrix;
	}
	
	String matrixLesenReverseNormal(char[][] input)
	{
		String text  = "";
		
		for(int z = 0; z < matrixSize ; z++) // zeile
		{ 
			for(int s = 0 ;  s < matrixSize ; s++) // spalte
			{
				text += input[z][s];
			}
		}
		
		return text;
	}
	
}
