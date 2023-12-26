package ApartmanTemizlik;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class AdminSecenekGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSecenekGUI frame = new AdminSecenekGUI();
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
	public AdminSecenekGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton admin_giris_geri_button = new JButton("Geri");
		admin_giris_geri_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminGirisGUI desingAdmin1 = new AdminGirisGUI();
				desingAdmin1.setVisible(true);
				setVisible(false);
			}
		});
		admin_giris_geri_button.setBounds(591, 432, 85, 21);
		contentPane.add(admin_giris_geri_button);
		
		JButton btnNewButton_1 = new JButton("Temizlik Görevlisi Yönetim Paneli");
		btnNewButton_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TGYonetimGUI tgYonetimGUI1 = new TGYonetimGUI();
				tgYonetimGUI1.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(158, 46, 370, 70);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Apartman Sakinleri Yönetim Paneli");
		btnNewButton_2.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 16));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ASYonetimGUI asYonetimGUI1 = new ASYonetimGUI();
				asYonetimGUI1.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(145, 133, 370, 70);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("Yorum ve Görüşler");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				YorumGUI yorumGUI1 = new YorumGUI();
				yorumGUI1.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 16));
		btnNewButton.setBounds(158, 226, 370, 70);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("Mali İşler");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuncellemeGUI guncellemeGUI1 = new GuncellemeGUI();
				guncellemeGUI1.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_3.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 16));
		btnNewButton_3.setBounds(145, 317, 370, 70);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(getClass().getResource("admin_secenek.jpg")));
		lblNewLabel.setBounds(0, 0, 686, 463);
		contentPane.add(lblNewLabel);
	}
}
