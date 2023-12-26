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

public class YorumGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_2;

	DefaultTableModel modelim= new DefaultTableModel(); //DefaultTableModel, tabloyu kontrol etmek için kullanılan bir Swing sınıfıdır.

	Object[] kolonlar= {"Puan","Yorum"}; 
	Object[] satirlar = new Object[2];
	private JTextField txt_sorgu;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YorumGUI frame = new YorumGUI();
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
	public YorumGUI() {
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
		
		table_2.getColumnModel().getColumn(0).setPreferredWidth(20);  // Puan Kolonu genişlğini ayarlar
		table_2.getColumnModel().getColumn(1).setPreferredWidth(400); // Yorum Kolunu genişliğini ayarlar
		//Bu satır, table_1 adlı JTable nesnesine modelim adlı DefaultTableModel nesnesini atar. Bu, tablonun içeriğini ve görüntülenen verileri kontrol etmek için kullanılan bir model sağlar.
		//Dolayısıyla, tablonun içeriğini güncellediğinizde veya değiştirdiğinizde, bu değişiklikler otomatik olarak tablo üzerinde yansıtılacaktır.
		
		table_2.setBounds(35, 23, 293, 160);
		scrollPane.setViewportView(table_2); //JScrollPane, içine eklenen bileşeni (burada table_1) bir kaydırma çubuğu ekleyerek, 
		
		JButton btn_listele = new JButton("Göster");
		btn_listele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelim.setRowCount(0); //satır sayısını sıfırlar
				ResultSet myRs = sqlSakinleriBaglama.oy_yap();
				
				try {
					while(myRs.next()){
						satirlar[0]=myRs.getString("puan");
						satirlar[1]=myRs.getString("yorum");
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
		btn_listele.setBounds(286, 317, 98, 34);
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
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Puan", "Yorum"}));
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
					sql_sorgu = "select * from oylama_tablosu where puan =" +Integer.parseInt(alan);
				}
				else {
					sql_sorgu = "select * from oylama_tablosu where yorum like '"+alan+"%'"; 
				}				
				
				
				try {
					myRs=sqlSakinleriBaglama.bul(sql_sorgu);
					while(myRs.next()){
						satirlar[0]=myRs.getString("puan");
						satirlar[1]=myRs.getString("yorum");
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
		
		JButton btn_ortalama = new JButton("Ortalama Puan");
		btn_ortalama.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Float toplam = 0.0f; 
				Float rowCount = 0.0f;
			    ResultSet myRs = sqlSakinleriBaglama.oy_yap();

			    try {
			        while (myRs.next()) {
			            kolonlar[1] = myRs.getString("puan");
			            toplam += myRs.getInt("puan");
			            rowCount++;
			        }
			    } catch (SQLException ex) {
			        ex.printStackTrace();  
			    }

			    if (rowCount > 0) {
			        btn_ortalama.setText("Ort Puan: "+String.valueOf(toplam / rowCount));
			    } else {
			        btn_ortalama.setText("Veri Yok!");
			    }
			}
		});
		
		btn_ortalama.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		btn_ortalama.setBounds(474, 317, 144, 34);
		contentPane.add(btn_ortalama);
		
		//bileşenin boyutlarına sığmayan içeriği görüntülemeye izin veren bir Swing bileşenidir.
		//contentPane.add(table_2);
		
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
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(getClass().getResource("yorum.jpg")));
		lblNewLabel.setBounds(0, 0, 686, 463);
		contentPane.add(lblNewLabel);
	}

}
