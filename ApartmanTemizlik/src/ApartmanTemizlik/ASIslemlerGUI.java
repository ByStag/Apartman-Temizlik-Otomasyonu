package ApartmanTemizlik;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class ASIslemlerGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	DefaultTableModel modelim= new DefaultTableModel(); //DefaultTableModel, tabloyu kontrol etmek için kullanılan bir Swing sınıfıdır.

	private JTextField txt_yorum;
	private JTextField txt_puan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ASIslemlerGUI frame = new ASIslemlerGUI();
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
	public ASIslemlerGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Gönder");
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet myRs = sqlSakinleriBaglama.gorevli_yap();
				String yorum,sql_sorgu;
				Integer puan;
				
				puan= Integer.parseInt(txt_puan.getText());
				yorum=txt_yorum.getText();
				
				sql_sorgu="INSERT INTO oylama_tablosu (puan,yorum) VALUES ('"+puan+"','"+yorum+"')";
				System.out.println(sql_sorgu);
				
				try {
					sqlSakinleriBaglama.ekle(sql_sorgu);
					System.out.println("Kayıt başarılı");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(162, 293, 96, 39);
		contentPane.add(btnNewButton);
		
		txt_yorum = new JTextField();
		txt_yorum.setColumns(10);
		txt_yorum.setBounds(115, 186, 202, 86);
		contentPane.add(txt_yorum);
		
		JLabel lblNewLabel_4_1 = new JLabel("Puan:");
		lblNewLabel_4_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		lblNewLabel_4_1.setBounds(50, 118, 50, 30);
		contentPane.add(lblNewLabel_4_1);
		
		txt_puan = new JTextField();
		txt_puan.setColumns(10);
		txt_puan.setBounds(115, 122, 202, 30);
		contentPane.add(txt_puan);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Yorum:");
		lblNewLabel_4_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		lblNewLabel_4_1_1.setBounds(50, 186, 60, 30);
		contentPane.add(lblNewLabel_4_1_1);
		
		//bileşenin boyutlarına sığmayan içeriği görüntülemeye izin veren bir Swing bileşenidir.
		//contentPane.add(table_2);
		
		JButton geri_as_giris_button = new JButton("Geri");
		geri_as_giris_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ASGirisGUI asGirisGUI1 = new ASGirisGUI();
				asGirisGUI1.setVisible(true);
				setVisible(false);
			}
		});
		geri_as_giris_button.setBounds(591, 432, 85, 21);
		contentPane.add(geri_as_giris_button);
		
		JButton aidat_button = new JButton("Aidatı Öde");
		aidat_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aidat_button.setText("Aidat Ödendi");
			}
		});
		aidat_button.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 16));
		aidat_button.setBounds(492, 122, 151, 39);
		contentPane.add(aidat_button);
		
		JLabel lblNewLabel = new JLabel("Apartman Sakini İşlem Paneli");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 20));
		lblNewLabel.setBounds(208, 24, 270, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("1-5 Arası Puan Veriniz!");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 10));
		lblNewLabel_1.setBounds(115, 109, 133, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Max 100 Karakter Kullanın!");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 10));
		lblNewLabel_2.setBounds(115, 174, 140, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(new ImageIcon(getClass().getResource("as_islemler.jpg")));
		lblNewLabel_3.setBounds(0, 0, 686, 463);
		contentPane.add(lblNewLabel_3);
	}
}
