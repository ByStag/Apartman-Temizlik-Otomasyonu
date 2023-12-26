package ApartmanTemizlik;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class ASGirisGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ASGirisGUI frame = new ASGirisGUI();
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
	public ASGirisGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(143, 76, 400, 290);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 255, 255));
		tabbedPane.addTab("Giriş", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("İsim");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 12));
		lblNewLabel_1.setBounds(30, 20, 100, 33);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(30, 60, 140, 30);
		panel.add(textField);
		
		JLabel lblNewLabel_2 = new JLabel("Şifre ");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 12));
		lblNewLabel_2.setBounds(30, 100, 69, 33);
		panel.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(30, 140, 140, 30);
		panel.add(passwordField);
		
		JButton kullanici_giris_button = new JButton("Giriş");
		kullanici_giris_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String isim_as = textField.getText();
				String sifre_as = new String(passwordField.getPassword());
				String sql_as = "SELECT * FROM apartman_sakini WHERE isim_as='"+isim_as+"'";
				try {
					ResultSet myResultSet1 = sqlSakinleriBaglama.bul(sql_as);
					while (myResultSet1.next()) {
						if (isim_as.equals(myResultSet1.getString("isim_as")) && sifre_as.equals(myResultSet1.getString("sifre_as"))) {
							ASIslemlerGUI asIslemlerGUI1 = new ASIslemlerGUI();
							asIslemlerGUI1.setVisible(true);
							setVisible(false);
						}
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		kullanici_giris_button.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		kullanici_giris_button.setBounds(135, 200, 125, 35);
		panel.add(kullanici_giris_button);
		
		JLabel lblNewLabel = new JLabel("APARTMAN SAKİNİ PANELİ");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 20));
		lblNewLabel.setBounds(209, 10, 267, 64);
		contentPane.add(lblNewLabel);
		 
		JButton ana_giris_geri_button = new JButton("Geri");
		ana_giris_geri_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnaGirisGUI anaGirisGUI1 = new AnaGirisGUI();
				anaGirisGUI1.setVisible(true);
				setVisible(false);
			}
		});
		ana_giris_geri_button.setBounds(591, 432, 85, 21);
		contentPane.add(ana_giris_geri_button);
		
		JLabel lblNewLabel_3 = new JLabel(new ImageIcon(getClass().getResource("as_giris.jpg")));
		lblNewLabel_3.setBounds(0, 0, 686, 463);
		contentPane.add(lblNewLabel_3);
	}

}
