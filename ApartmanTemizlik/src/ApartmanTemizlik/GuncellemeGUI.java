package ApartmanTemizlik;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuncellemeGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuncellemeGUI frame = new GuncellemeGUI();
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
	public GuncellemeGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon(getClass().getResource("guncelleme.gif")));
		lblNewLabel_1.setBounds(212, 28, 262, 223);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Bakım Devam Ediyor...");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.ITALIC, 25));
		lblNewLabel_2.setBounds(208, 268, 270, 64);
		contentPane.add(lblNewLabel_2);
		
		JButton adminsecenek_geri_button = new JButton("Geri");
		adminsecenek_geri_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSecenekGUI adminSecenekGUI1 = new AdminSecenekGUI();
				adminSecenekGUI1.setVisible(true);
				setVisible(false);
			}
		});
		adminsecenek_geri_button.setBounds(591, 432, 85, 21);
		contentPane.add(adminsecenek_geri_button);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(getClass().getResource("admin_giris.jpg")));
		lblNewLabel.setBounds(0, 0, 686, 463);
		contentPane.add(lblNewLabel);
	}
}
