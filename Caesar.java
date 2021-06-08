import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class C1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					C1 frame = new C1();
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
	public C1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 570, 326);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("   Verschluesseln   ", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblKlartext = new JLabel("Klartext :");
		lblKlartext.setBounds(15, 16, 69, 20);
		panel.add(lblKlartext);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 52, 525, 77);
		panel.add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(25, 199, 525, 77);
		panel.add(scrollPane_1);
		
		JTextPane textPane_1 = new JTextPane();
		scrollPane_1.setViewportView(textPane_1);
		
		JLabel lblChiffre = new JLabel("Chiffre :");
		lblChiffre.setBounds(26, 175, 69, 20);
		panel.add(lblChiffre);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(277, 145, 83, 26);
		panel.add(spinner);
		
		JLabel lblGradDerVerschiebung = new JLabel("Grad der Verschiebung :");
		lblGradDerVerschiebung.setBounds(71, 148, 202, 20);
		panel.add(lblGradDerVerschiebung);
		
		JButton btnCaesar = new JButton("Caesar");
		btnCaesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			//lade text
				char[] klartext = textPane.getText().replaceAll(" ", "").toUpperCase().toCharArray();
				
			//erstelle char[] des chiffres
				char[] chiffre = new char[klartext.length];
				
			//lader grad der verschiebung
				int v = (int) spinner.getValue();
				
				for(int i = 0; i < klartext.length ; i++) // gehe alle zeichen durch
				{
					chiffre[i] = (char) (klartext[i] + v);
					
					while(chiffre[i] > 90)
					{
						chiffre[i] -= 26;
					}
				}
				
			//ertselle neuen String
				String neuerText = new String(chiffre);
		   
			//zeige text an
				textPane_1.setText(neuerText);
				
			}
		});
		btnCaesar.setBounds(395, 144, 115, 29);
		panel.add(btnCaesar);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("   Entschluesseln   ", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblChiffre_1 = new JLabel("Chiffre :");
		lblChiffre_1.setBounds(15, 16, 69, 20);
		panel_1.add(lblChiffre_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(25, 52, 525, 77);
		panel_1.add(scrollPane_2);
		
		JTextPane textPane_2 = new JTextPane();
		scrollPane_2.setViewportView(textPane_2);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(25, 208, 525, 84);
		panel_1.add(scrollPane_3);
		
		JTextPane textPane_3 = new JTextPane();
		scrollPane_3.setViewportView(textPane_3);
		
		JLabel lblKlartext_1 = new JLabel("Klartext :");
		lblKlartext_1.setBounds(15, 172, 69, 20);
		panel_1.add(lblKlartext_1);
		
		JLabel lblGradDerVerschiebung_1 = new JLabel("Grad der Verschiebung :");
		lblGradDerVerschiebung_1.setBounds(99, 155, 195, 20);
		panel_1.add(lblGradDerVerschiebung_1);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(287, 152, 77, 26);
		panel_1.add(spinner_1);
		
		JButton btnCaesar_1 = new JButton("Caesar");
		btnCaesar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				//lade chiffre
					char[] chiffre = textPane_2.getText().replaceAll(" ", "").toUpperCase().toCharArray();
					
				//erstelle char[] des chiffres
					char[] klartext = new char[chiffre.length];
					
				//lader grad der verschiebung
					int v = (int) spinner_1.getValue();
					
					for(int i = 0; i < chiffre.length ; i++) // gehe alle zeichen durch
					{
						klartext[i] = (char) (chiffre[i] - v);
						
						while(klartext[i] < 65)
						{
							klartext[i] += 26;
						}
					}
					
				//ertselle neuen String
					String neuerText = new String(klartext);
			   
				//zeige text an
					textPane_3.setText(neuerText);
			
			}
		});
		btnCaesar_1.setBounds(396, 151, 115, 29);
		panel_1.add(btnCaesar_1);
	}
}
