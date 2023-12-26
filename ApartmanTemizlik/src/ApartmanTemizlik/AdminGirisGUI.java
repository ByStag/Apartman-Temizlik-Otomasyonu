package ApartmanTemizlik;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import java.awt.Color;

public class AdminGirisGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminGirisGUI frame = new AdminGirisGUI();
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
	public AdminGirisGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null); 
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(143, 76, 400, 290);
		contentPane.add(tabbedPane);
		
		JPanel giris_panel = new JPanel();
		giris_panel.setBackground(new Color(128, 255, 255));
		tabbedPane.addTab("Admin Giriş", null, giris_panel, null);
		giris_panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Kullanıcı Adı");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 12));
		lblNewLabel_1.setBounds(30, 20, 100, 33);
		giris_panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(30, 60, 140, 30);
		giris_panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Şifre ");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 12));
		lblNewLabel_2.setBounds(30, 100, 69, 33);
		giris_panel.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(30, 140, 140, 30);
		giris_panel.add(passwordField);
		
		JButton admin_giris_button = new JButton("Giriş");
		admin_giris_button.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		admin_giris_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kullanici_adi = textField.getText();
				String sifre = new String(passwordField.getPassword());
				String sql = "SELECT * FROM admin WHERE kullanici_adi_admin='"+kullanici_adi+"'";
				try {
					ResultSet myResultSet1 = sqlSakinleriBaglama.bul(sql);
					while (myResultSet1.next()) {
						if (kullanici_adi.equals(myResultSet1.getString("kullanici_adi_admin")) && sifre.equals(myResultSet1.getString("sifre_admin"))) {
							AdminSecenekGUI desingAdmin1 = new AdminSecenekGUI();
							desingAdmin1.setVisible(true);
							setVisible(false);
						}else {admin_giris_button.setText("Haralı Giriş...");}
					}
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		admin_giris_button.setBounds(135, 200, 125, 35);
		giris_panel.add(admin_giris_button);
		
		JPanel kayit_panel = new JPanel();
		kayit_panel.setBackground(new Color(128, 255, 255));
		tabbedPane.addTab("Admin Kayıt", null, kayit_panel, null);
		kayit_panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Kullanıcı Adı");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 12));
		lblNewLabel_3.setBounds(30, 20, 100, 33);
		kayit_panel.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(30, 60, 140, 30);
		kayit_panel.add(textField_1);
		
		JLabel lblNewLabel_4 = new JLabel("Şifre ");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 12));
		lblNewLabel_4.setBounds(30, 100, 69, 33);
		kayit_panel.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(30, 140, 140, 30);
		kayit_panel.add(textField_2);
		
		JButton admin_kayit_button = new JButton("Kayıt");
		admin_kayit_button.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		admin_kayit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ResultSet myResultSet2 = sqlSakinleriBaglama.yap();
				String kayit_adi = textField_1.getText();
				String kayit_sifre = textField_2.getText();
				Integer kayit_id=5;
				
				
				String sql_admin = "INSERT INTO admin (id_admin,kullanici_adi_admin,sifre_admin) VALUES ('"+kayit_id+"','"+kayit_adi+"','"+kayit_sifre+"') ";
				try {
					sqlSakinleriBaglama.ekle(sql_admin);
					System.out.println("Kayit Başarılı");
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		admin_kayit_button.setBounds(135, 200, 125, 35);
		kayit_panel.add(admin_kayit_button);
		
		JLabel lblNewLabel = new JLabel("ADMİN PANELİ");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 20));
		lblNewLabel.setBounds(268, 10, 150, 64);
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
		
		JLabel lblNewLabel_5 = new JLabel(new ImageIcon(getClass().getResource("admin_giris.jpg")));
		lblNewLabel_5.setBounds(0, 0, 686, 463);
		contentPane.add(lblNewLabel_5);
	}
}
