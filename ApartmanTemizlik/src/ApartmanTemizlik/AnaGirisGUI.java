package ApartmanTemizlik;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AnaGirisGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application. 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnaGirisGUI frame = new AnaGirisGUI();
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
	public AnaGirisGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Admin Giriş Kayıt Olma");
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminGirisGUI adminGirisGUI1 = new AdminGirisGUI();
				adminGirisGUI1.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(34, 120, 175, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Temizlik Görevlisi Giriş");
		btnNewButton_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TGGirisGUI gorevliGirisGUI1 = new TGGirisGUI();
				gorevliGirisGUI1.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(34, 215, 175, 37);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Apartman Sakini Giriş");
		btnNewButton_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ASGirisGUI kullaniciGirisGUI1 = new ASGirisGUI();
				kullaniciGirisGUI1.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(34, 310, 175, 37);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon(getClass().getResource("girisekrani.jpg")));
		lblNewLabel_1.setBounds(0, 0, 686, 463);
		contentPane.add(lblNewLabel_1);
	}

}
