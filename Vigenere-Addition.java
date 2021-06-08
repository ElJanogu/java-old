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
import java.awt.event.ActionEvent;

public class VA1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VA1 frame = new VA1();
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
	public VA1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 771, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 749, 344);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("   Verschluesseln   ", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblKlartext = new JLabel("Klartext :");
		lblKlartext.setBounds(15, 16, 69, 20);
		panel.add(lblKlartext);
		
		JLabel lblChiffre = new JLabel("Schluessel :");
		lblChiffre.setBounds(377, 16, 115, 20);
		panel.add(lblChiffre);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 52, 347, 90);
		panel.add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(377, 52, 352, 90);
		panel.add(scrollPane_1);
		
		JTextPane textPane_1 = new JTextPane();
		scrollPane_1.setViewportView(textPane_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(15, 198, 714, 96);
		panel.add(scrollPane_2);
		
		JTextPane textPane_2 = new JTextPane();
		scrollPane_2.setViewportView(textPane_2);
		
		JLabel lblChiffre_1 = new JLabel("Chiffre : ");
		lblChiffre_1.setBounds(15, 173, 69, 20);
		panel.add(lblChiffre_1);
		
		JButton btnNewButton = new JButton("   Verschluesseln   ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				//lade texte
				char[] klar = filtern(textPane.getText()).toCharArray();
				char[] sch = filtern(textPane_1.getText()).toCharArray();
				//char[] fuer chiffre
				char[] chiffre = new char[klar.length];
				
				//rechne um
				int[] k = new int[klar.length];
				int[] s = new int[sch.length];
				int[] c = new int[chiffre.length];
				
				for(int a = 0; a < klar.length; a++)//gehe den klartext durch
				{
					k[a] = klar[a]; //uebertrage
					k[a] -= 65; //rechner herunter
				}
				
				for(int b = 0; b < sch.length ; b++)//gehe den schluessel durch
				{
					s[b] = sch[b]; //uebertrage
					s[b] -= 65;//rechner herunter
				}
				
				//verschluesselung
				int index = 0; //zaehler fuer den schluessel
				for(int i = 0; i < k.length ; i++)
				{
					c[i] = k[i] + s[index];
					index++;
					
					if(index == s.length)
					{
						index = 0;
					}
					
					while(c[i] > 25)
					{
						c[i] -= 26;
					}
					
					//rechne um
					c[i] += 65;
					chiffre[i] = (char) c[i];
				}
				
				//erstelle String
				String neuerText = new String(chiffre);
				textPane_2.setText(neuerText);
				
			}
		});
		btnNewButton.setBounds(15, 139, 714, 29);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("   Entschluesseln   ", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblChiffre_2 = new JLabel("Chiffre : ");
		lblChiffre_2.setBounds(15, 16, 69, 20);
		panel_1.add(lblChiffre_2);
		
		JLabel lblSchluessel = new JLabel("Schluessel : ");
		lblSchluessel.setBounds(374, 16, 130, 20);
		panel_1.add(lblSchluessel);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(15, 45, 355, 85);
		panel_1.add(scrollPane_3);
		
		JTextPane textPane_3 = new JTextPane();
		scrollPane_3.setViewportView(textPane_3);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(374, 45, 355, 85);
		panel_1.add(scrollPane_4);
		
		JTextPane textPane_4 = new JTextPane();
		scrollPane_4.setViewportView(textPane_4);
		
		JLabel lblKlartext_1 = new JLabel("Klartext : ");
		lblKlartext_1.setBounds(15, 168, 69, 20);
		panel_1.add(lblKlartext_1);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(15, 204, 714, 90);
		panel_1.add(scrollPane_5);
		
		JTextPane textPane_5 = new JTextPane();
		scrollPane_5.setViewportView(textPane_5);
		
		JButton btnNewButton_1 = new JButton("   Entschluesseln   ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				//lade texte
				char[] chiffre = filtern(textPane_3.getText()).toCharArray();
				char[] sch = filtern(textPane_4.getText()).toCharArray();
				//char[] fuer chiffre
				char[] klar = new char[chiffre.length];
				
				//rechne um
				int[] k = new int[klar.length];
				int[] s = new int[sch.length];
				int[] c = new int[chiffre.length];
				
				for(int a = 0; a < chiffre.length; a++)//gehe den klartext durch
				{
					c[a] = chiffre[a]; //uebertrage
					c[a] -= 65; //rechner herunter
				}
				
				for(int b = 0; b < sch.length ; b++)//gehe den schluessel durch
				{
					s[b] = sch[b]; //uebertrage
					s[b] -= 65;//rechner herunter
				}
				
				//verschluesselung
				int index = 0; //zaehler fuer den schluessel
				for(int i = 0; i < c.length ; i++)
				{
					k[i] = c[i] - s[index];
					index++;
					
					if(index == s.length)
					{
						index = 0;
					}
					
					while(k[i] < 0)
					{
						k[i] += 26;
					}
					
					//rechne um
					k[i] += 65;
					klar[i] = (char) k[i];
				}
				
				//erstelle String
				String neuerText = new String(klar);
				textPane_5.setText(neuerText);
				
			}
		});
		btnNewButton_1.setBounds(15, 135, 714, 29);
		panel_1.add(btnNewButton_1);
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
	
}
