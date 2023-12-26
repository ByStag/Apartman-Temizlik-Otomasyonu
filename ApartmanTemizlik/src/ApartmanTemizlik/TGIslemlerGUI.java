package ApartmanTemizlik;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TGIslemlerGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_2;

	DefaultTableModel modelim= new DefaultTableModel(); //DefaultTableModel, tabloyu kontrol etmek için kullanılan bir Swing sınıfıdır.

	Object[] kolonlar= {"No","Ad","Soyad","Apartman","Görev Günü"}; 
	Object[] satirlar = new Object[5];
	private JTextField txt_sorgu;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TGIslemlerGUI frame = new TGIslemlerGUI();
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
	public TGIslemlerGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 666, 284);
		contentPane.add(scrollPane);
		
		table_2 = new JTable();
		modelim.setColumnIdentifiers(kolonlar);
		modelim.addRow(satirlar);
		table_2.setModel(modelim);
		//Bu satır, table_1 adlı JTable nesnesine modelim adlı DefaultTableModel nesnesini atar. Bu, tablonun içeriğini ve görüntülenen verileri kontrol etmek için kullanılan bir model sağlar.
		//Dolayısıyla, tablonun içeriğini güncellediğinizde veya değiştirdiğinizde, bu değişiklikler otomatik olarak tablo üzerinde yansıtılacaktır.
		
		table_2.setBounds(35, 23, 293, 160);
		scrollPane.setViewportView(table_2); //JScrollPane, içine eklenen bileşeni (burada table_1) bir kaydırma çubuğu ekleyerek, 
		
		JButton btn_listele = new JButton("Listele");
		btn_listele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelim.setRowCount(0); //satır sayısını sıfırlar
				ResultSet myRs = sqlSakinleriBaglama.gorevli_yap();
				
				try {
					while(myRs.next()){
						satirlar[0]=myRs.getString("id_tg");
						satirlar[1]=myRs.getString("isim_tg");
						satirlar[2]=myRs.getString("soyisim_tg");
						satirlar[3]=myRs.getString("apartman_tg");
						satirlar[4]=myRs.getString("gun_tg");
						modelim.addRow(satirlar);
						System.out.println("Düzenleme başarılı");
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				table_2.setModel(modelim);
			}
				
		});
		btn_listele.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		btn_listele.setBounds(288, 317, 98, 34);
		contentPane.add(btn_listele);
		
		txt_sorgu = new JTextField();
		txt_sorgu.setBounds(31, 355, 96, 19);
		contentPane.add(txt_sorgu);
		txt_sorgu.setColumns(10);
		
		JLabel lblIsim = new JLabel("Alan:");
		lblIsim.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		lblIsim.setBounds(31, 326, 51, 19);
		contentPane.add(lblIsim);
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"No", "İsim", "Soyisim", "Apartman Adı", "Görev Günü"}));
		comboBox.setBounds(74, 325, 53, 21);
		contentPane.add(comboBox);
		
		JButton btnNewButton_1_1 = new JButton("Ara");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelim.setRowCount(0);
				String sql_sorgu;
				String alan= txt_sorgu.getText();
				
				ResultSet myRs= null;
				
				int secilen=comboBox.getSelectedIndex();
				
				if(secilen==0) {
					sql_sorgu = "SELECT * FROM temizlik_gorevli WHERE id_tg=" +Integer.parseInt(alan); 
					//% işareti ve eşittir yerine like gelmesi a harfi girince bile dönüş yapar.
				}
				else if(secilen==1) {
					sql_sorgu = "SELECT * FROM temizlik_gorevli WHERE isim_tg like '"+alan+"%'"; 
				}
				else if(secilen==2) {
					sql_sorgu = "SELECT * FROM temizlik_gorevli WHERE soyisim_tg like '"+alan+"%'"; 
				}
				else if(secilen==3) {
					sql_sorgu = "SELECT * FROM temizlik_gorevli WHERE apartman_tg like '"+alan+"%'"; 
				}
				else {
					sql_sorgu = "SELECT * FROM temizlik_gorevli WHERE gun_tg like '"+alan+"%'"; 
				}				
				
				
				try {
					myRs=sqlSakinleriBaglama.bul(sql_sorgu);
					while(myRs.next()){
						satirlar[0]=myRs.getString("id_tg");
						satirlar[1]=myRs.getString("isim_tg");
						satirlar[2]=myRs.getString("soyisim_tg");
						satirlar[3]=myRs.getString("apartman_tg");
						satirlar[4]=myRs.getString("gun_tg");
						modelim.addRow(satirlar);
						System.out.println("Sorgu başarılı");
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btnNewButton_1_1.setBounds(135, 353, 80, 21);
		contentPane.add(btnNewButton_1_1);
		
		//bileşenin boyutlarına sığmayan içeriği görüntülemeye izin veren bir Swing bileşenidir.
		//contentPane.add(table_2);

		JButton geri_tg_giris_button = new JButton("Geri");
		geri_tg_giris_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TGGirisGUI tgGirisGUI1 = new TGGirisGUI();
				tgGirisGUI1.setVisible(true);
				setVisible(false);
			}
		});
		geri_tg_giris_button.setBounds(591, 432, 85, 21);
		contentPane.add(geri_tg_giris_button);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(getClass().getResource("tg_islemler.jpg")));
		lblNewLabel.setBounds(0, 0, 686, 463);
		contentPane.add(lblNewLabel);
	}

}
