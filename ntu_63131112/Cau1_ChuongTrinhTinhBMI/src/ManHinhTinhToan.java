import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ManHinhTinhToan extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField edt_hovaten;
	private JTextField edt_cc;
	private JTextField edt_cn;
	private JTextField edt_mota;
	private JTextField txt_bmi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the frame.
	 */
	public double TinhToanBMI() {
		String name = edt_hovaten.getText();
		String cc = edt_cc.getText();
		String cn = edt_cn.getText();
		double db_cc = Double.parseDouble(cc);
		double db_cn = Double.parseDouble(cn);
		double bmi = db_cn/Math.pow(db_cc,2);
		return bmi;
	}
	public void SetKetQua(double bmi) {
		DecimalFormat df = new DecimalFormat("#.##");
	    double chieucao = Double.parseDouble(edt_cc.getText().toString());
	    double cannang = Double.parseDouble(edt_cn.getText().toString());
	    StringBuilder builder = new StringBuilder();
	    builder.append("Họ và tên: ").append(edt_hovaten.getText()).append("\n")
        .append("Chiều cao: ").append(chieucao).append("m").append("\n")
        .append("Cân nặng: ").append(cannang).append(" Kg").append("\n");

	    double chenhlech = 0.0;
	    if (bmi < 18.5) {
	        chenhlech = (18.5 - bmi) * (chieucao * chieucao);
	        builder.append("\nBạn cần tăng cân khoảng ").append(df.format(chenhlech)).append(" Kg để đạt chỉ số BMI bình thường");
	    } else if (bmi >= 25) {
	        chenhlech = (bmi - 24.9) * (chieucao * chieucao);
	        builder.append("\nBạn cần giảm cân khoảng ").append(df.format(chenhlech)).append(" Kg để đạt chỉ số BMI trong phạm vi bình thường");
	    }
	    String formattedBmi = df.format(bmi);

	    txt_bmi.setText(formattedBmi);
	    edt_mota.setText(builder.toString());
	}
	public ManHinhTinhToan() {
		setTitle("Chương trình tính BMI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 911, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHƯƠNG TRÌNH TÍNH BMI");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 24));
		lblNewLabel.setBounds(288, 44, 403, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nhập họ và tên");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 143, 171, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nhập chiều cao (m)");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 214, 171, 35);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nhập cân nặng (kq)");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(10, 287, 186, 44);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Tính BMI");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double bmi = TinhToanBMI();
				SetKetQua(bmi);
			}
		});
		btnNewButton.setBounds(10, 365, 470, 44);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Thông tin chỉ số BMI");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(613, 118, 274, 34);
		contentPane.add(lblNewLabel_4);
		
		edt_hovaten = new JTextField();
		edt_hovaten.setBounds(206, 132, 274, 44);
		contentPane.add(edt_hovaten);
		edt_hovaten.setColumns(10);
		
		edt_cc = new JTextField();
		edt_cc.setBounds(206, 212, 274, 44);
		contentPane.add(edt_cc);
		edt_cc.setColumns(10);
		
		edt_cn = new JTextField();
		edt_cn.setBounds(206, 290, 274, 44);
		contentPane.add(edt_cn);
		edt_cn.setColumns(10);
		
		edt_mota = new JTextField();
		edt_mota.setHorizontalAlignment(SwingConstants.LEFT);
		edt_mota.setText("Thông tin");
		edt_mota.setFont(new Font("Arial", Font.ITALIC, 12));
		edt_mota.setEnabled(false);
		edt_mota.setBounds(10, 454, 849, 50);
		contentPane.add(edt_mota);
		edt_mota.setColumns(10);
		
		txt_bmi = new JTextField();
		txt_bmi.setFont(new Font("Arial", Font.PLAIN, 22));
		txt_bmi.setHorizontalAlignment(SwingConstants.CENTER);
		txt_bmi.setText("0");
		txt_bmi.setBounds(587, 169, 228, 194);
		contentPane.add(txt_bmi);
		txt_bmi.setColumns(10);
	}
}
