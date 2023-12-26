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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TGYonetimGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_2;
	
	DefaultTableModel modelim= new DefaultTableModel(); //DefaultTableModel, tabloyu kontrol etmek için kullanılan bir Swing sınıfıdır.

	Object[] kolonlar= {"No","Ad","Soyad","Apartman","Gün","Tel No","Şifre"}; 
	Object[] satirlar = new Object[7];
	private JTextField txt_isim;
	private JTextField txt_soyisim;
	private JTextField txt_apartman;
	private JTextField txt_tel;
	private JTextField txt_id;
	private JButton btnNewButton_1;
	private JTextField txt_sorgu;
	private JTextField txt_sifre;
	private JTextField txt_gun;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TGYonetimGUI frame = new TGYonetimGUI();
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
	public TGYonetimGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 398, 284);
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
						satirlar[5]=myRs.getString("tel_no_tg");
						satirlar[6]=myRs.getString("sifre_tg");
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
		btn_listele.setBounds(154, 317, 98, 34);
		contentPane.add(btn_listele);
		
		txt_isim = new JTextField();
		txt_isim.setBounds(511, 124, 96, 19);
		contentPane.add(txt_isim);
		txt_isim.setColumns(10);
		
		txt_soyisim = new JTextField();
		txt_soyisim.setColumns(10);
		txt_soyisim.setBounds(511, 153, 96, 19);
		contentPane.add(txt_soyisim);
		
		txt_apartman = new JTextField();
		txt_apartman.setColumns(10);
		txt_apartman.setBounds(511, 211, 96, 19);
		contentPane.add(txt_apartman);
		
		txt_tel = new JTextField();
		txt_tel.setColumns(10);
		txt_tel.setBounds(511, 240, 96, 19);
		contentPane.add(txt_tel);
		
		JButton btnNewButton = new JButton("Kaydet");
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String isim,soyisim,apartman,gun,tel,sifre,sql_sorgu;
				Integer id;
				
				id = Integer.parseInt(txt_id.getText()); // string'ten alınan değeri integer'a çevirir.
				isim=txt_isim.getText();
				soyisim=txt_soyisim.getText();
				apartman=txt_apartman.getText();
				gun=txt_gun.getText();
				tel=txt_tel.getText();
				sifre = txt_sifre.getText();
				
				sql_sorgu="INSERT INTO temizlik_gorevli (id_tg,isim_tg,soyisim_tg,apartman_tg,gun_tg,tel_no_tg,sifre_tg) VALUES ('"+id+"','"+isim+"','"+soyisim+"','"+gun+"','"+apartman+"','"+tel+"','"+sifre+"')";
				System.out.println(sql_sorgu);
				
				try {
					sqlSakinleriBaglama.ekle(sql_sorgu);
					System.out.println("Kayıt başarılı");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(418, 295, 80, 21);
		contentPane.add(btnNewButton);
		
		txt_id = new JTextField();
		txt_id.setColumns(10);
		txt_id.setBounds(511, 95, 96, 19);
		contentPane.add(txt_id);
		
		JLabel lblNewLabel = new JLabel("İd:");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		lblNewLabel.setBounds(418, 97, 45, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("İsim:");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		lblNewLabel_1.setBounds(418, 126, 45, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Soyisim:");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		lblNewLabel_2.setBounds(418, 155, 45, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Apartman Adı:");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		lblNewLabel_3.setBounds(418, 185, 89, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Telefon No:");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		lblNewLabel_4.setBounds(418, 243, 80, 15);
		contentPane.add(lblNewLabel_4);
		
		JButton btnGncelle = new JButton("Güncelle");
		btnGncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String isim,soyisim,apartman,gun,tel,sifre,sql_sorgu;
				Integer id;
				
				id = Integer.parseInt(txt_id.getText()); // string'ten alınan değeri integer'a çevirir.
				isim=txt_isim.getText();
				soyisim=txt_soyisim.getText();
				apartman=txt_apartman.getText();
				gun=txt_gun.getText();
				tel=txt_tel.getText();
				sifre = txt_sifre.getText();
				
				sql_sorgu="UPDATE temizlik_gorevli SET id_tg ='"+id+"',"+
						  "isim_tg='"+isim+"',soyisim_tg='"+soyisim+"',apartman_tg='"+apartman+"',gun_tg='"+gun+"',tel_no_tg='"+tel+"',sifre_tg='"+sifre+"' WHERE id_tg="+id;
				System.out.println(sql_sorgu);
				
				try {
					sqlSakinleriBaglama.update(sql_sorgu);
					System.out.println("Düzenleme başarılı");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
		});
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_id.setText(modelim.getValueAt(table_2.getSelectedRow(), 0).toString());
				txt_isim.setText(modelim.getValueAt(table_2.getSelectedRow(), 1).toString());
				txt_soyisim.setText(modelim.getValueAt(table_2.getSelectedRow(), 2).toString());
				txt_apartman.setText(modelim.getValueAt(table_2.getSelectedRow(), 3).toString());
				txt_gun.setText(modelim.getValueAt(table_2.getSelectedRow(), 4).toString());
				txt_tel.setText(modelim.getValueAt(table_2.getSelectedRow(), 5).toString());
				txt_sifre.setText(modelim.getValueAt(table_2.getSelectedRow(), 6).toString());
			}
			//"Güncelle" düğmesine tıklandığında, seçilen satırın verileri bu metin alanlarına yerleştirilir,
			//böylece kullanıcı bu verileri güncelleyebilir.
		});
		btnGncelle.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btnGncelle.setBounds(504, 296, 90, 21);
		contentPane.add(btnGncelle);
		
		btnNewButton_1 = new JButton("Sil");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql_sorgu;
				Integer id; //sadece id'yi tanımlasak yeterli çünkü primarykey o numaradan başka kimsede yok.
				
				id = Integer.parseInt(txt_id.getText());
				sql_sorgu="DELETE FROM temizlik_gorevli WHERE id_tg="+id;
				
				try {
					sqlSakinleriBaglama.sil(sql_sorgu);
					System.out.println("Silme başarılı");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btnNewButton_1.setBounds(600, 296, 80, 21);
		contentPane.add(btnNewButton_1);
		
		txt_sorgu = new JTextField();
		txt_sorgu.setBounds(418, 49, 96, 19);
		contentPane.add(txt_sorgu);
		txt_sorgu.setColumns(10);
		
		JLabel lblIsim = new JLabel("Alan:");
		lblIsim.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		lblIsim.setBounds(418, 22, 51, 19);
		contentPane.add(lblIsim);
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"No", "İsim", "Soyisim", "Apartman Adı", "Gün", "Tel No", "Şifre"}));
		comboBox.setBounds(455, 21, 53, 21);
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
				else if(secilen==4) {
					sql_sorgu = "SELECT * FROM temizlik_gorevli WHERE gun_tg like '"+alan+"%'"; 
				}
				else if(secilen==5) {
					sql_sorgu = "SELECT * FROM temizlik_gorevli WHERE tel_no_tg like '"+alan+"%'"; 
				}
				else {
					sql_sorgu = "SELECT * FROM temizlik_gorevli WHERE sifre_tg like '"+alan+"%'";
				}
				
				try {
					myRs=sqlSakinleriBaglama.bul(sql_sorgu);
					while(myRs.next()){
						satirlar[0]=myRs.getString("id_tg");
						satirlar[1]=myRs.getString("isim_tg");
						satirlar[2]=myRs.getString("soyisim_tg");
						satirlar[3]=myRs.getString("apartman_tg");
						satirlar[4]=myRs.getString("gun_tg");
						satirlar[5]=myRs.getString("tel_no_tg");
						satirlar[6]=myRs.getString("sifre_tg");
						modelim.addRow(satirlar);
						
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				System.out.println("Sorgu başarılı");
			}
		});
		btnNewButton_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btnNewButton_1_1.setBounds(527, 47, 80, 21);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Şifre:");
		lblNewLabel_2_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(418, 269, 45, 15);
		contentPane.add(lblNewLabel_2_1);
		
		txt_sifre = new JTextField();
		txt_sifre.setColumns(10);
		txt_sifre.setBounds(511, 267, 96, 19);
		contentPane.add(txt_sifre);
		
		JLabel lblNewLabel_4_1 = new JLabel("Gün:");
		lblNewLabel_4_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		lblNewLabel_4_1.setBounds(418, 214, 80, 15);
		contentPane.add(lblNewLabel_4_1);
		
		txt_gun = new JTextField();
		txt_gun.setColumns(10);
		txt_gun.setBounds(511, 182, 96, 19);
		contentPane.add(txt_gun);
		
		
		//bileşenin boyutlarına sığmayan içeriği görüntülemeye izin veren bir Swing bileşenidir.
		//contentPane.add(table_2);
		
		
		
		
		
		
		
		JButton geri_adminsecenek_button = new JButton("Geri");
		geri_adminsecenek_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSecenekGUI adminSecenekGUI1 = new AdminSecenekGUI();
				adminSecenekGUI1.setVisible(true);
				setVisible(false);		
			}
		});
		geri_adminsecenek_button.setBounds(591, 432, 85, 21);
		contentPane.add(geri_adminsecenek_button);
		
		JLabel lblNewLabel_5 = new JLabel(new ImageIcon(getClass().getResource("tablo.jpg")));
		lblNewLabel_5.setBounds(0, 0, 686, 463);
		contentPane.add(lblNewLabel_5);
	}
}
