import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextArea;

public class MovieMain {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPanel panel10;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovieMain window = new MovieMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MovieMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 11, 414, 239);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel1 = new JPanel();
		layeredPane.add(panel1, "name_178963854710400");
		panel1.setLayout(null);
		
		JButton btnNewButton = new JButton(" GO BACK");
		btnNewButton.setBounds(325, 0, 89, 23);
		btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
		panel1.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("PAY MEMBERSHIP FEE");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(142, 23, 146, 14);
		panel1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ENTER EMAIL:");
		lblNewLabel_1.setBounds(24, 62, 79, 14);
		panel1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(155, 59, 179, 20);
		panel1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ENTER PASSWORD:");
		lblNewLabel_2.setBounds(24, 117, 146, 14);
		panel1.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(155, 114, 179, 20);
		panel1.add(textField_1);
		textField_1.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(24, 160, 146, 68);
		panel1.add(textArea);
		
		JLabel lblNewLabel_3 = new JLabel("Message:");
		lblNewLabel_3.setBounds(24, 142, 57, 14);
		panel1.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("PAY");
		btnNewButton_1.setBounds(277, 138, 57, 23);
		panel1.add(btnNewButton_1);
		
		JPanel panel2 = new JPanel();
		layeredPane.add(panel2, "name_178967445969400");
		panel2.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("MOVIE RESERVATION APP");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(127, 11, 151, 14);
		panel2.add(lblNewLabel_4);
		
		JButton btnNewButton_2 = new JButton("LOGIN");
		btnNewButton_2.setBounds(149, 55, 129, 23);
		panel2.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("PAY MEMBERSHIP");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_3.setBounds(149, 92, 129, 23);
		panel2.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("NOT A MEMBER");
		btnNewButton_4.setBounds(149, 126, 129, 23);
		panel2.add(btnNewButton_4);
		
		JPanel panel3 = new JPanel();
		layeredPane.add(panel3, "name_178971056131000");
		panel3.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("SYSTEM LOGIN");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(166, 31, 87, 14);
		panel3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Username:");
		lblNewLabel_6.setBounds(96, 65, 73, 14);
		panel3.add(lblNewLabel_6);
		
		textField_2 = new JTextField();
		textField_2.setBounds(167, 62, 123, 20);
		panel3.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Password:");
		lblNewLabel_7.setBounds(96, 134, 61, 14);
		panel3.add(lblNewLabel_7);
		
		textField_3 = new JTextField();
		textField_3.setBounds(167, 131, 123, 20);
		panel3.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("LOGIN");
		btnNewButton_5.setBounds(217, 162, 73, 23);
		panel3.add(btnNewButton_5);
		
		JPanel panel4 = new JPanel();
		layeredPane.add(panel4, "name_178973664158500");
		panel4.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("MOVIE RESERVATION APP");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(119, 28, 170, 14);
		panel4.add(lblNewLabel_8);
		
		JButton btnNewButton_6 = new JButton("CANCEL TICKET");
		btnNewButton_6.setBounds(147, 72, 116, 23);
		panel4.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("RESERVE TICKET");
		btnNewButton_7.setBounds(147, 125, 116, 23);
		panel4.add(btnNewButton_7);
		
		JPanel panel5 = new JPanel();
		layeredPane.add(panel5, "name_178976900746100");
		panel5.setLayout(null);
		
		JButton btnNewButton_8 = new JButton("LOGOUT");
		btnNewButton_8.setBounds(341, 0, 73, 23);
		panel5.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("BACK");
		btnNewButton_9.setBounds(341, 27, 73, 23);
		panel5.add(btnNewButton_9);
		
		JLabel lblNewLabel_9 = new JLabel("SELECT MOVIE");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_9.setBounds(145, 9, 95, 14);
		panel5.add(lblNewLabel_9);
		
		JButton btnNewButton_10 = new JButton("MOVIE 1");
		btnNewButton_10.setBounds(145, 34, 89, 23);
		panel5.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("MOVIE 2");
		btnNewButton_11.setBounds(145, 68, 89, 23);
		panel5.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("MOVIE 3");
		btnNewButton_12.setBounds(145, 102, 89, 23);
		panel5.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("MOVIE 4");
		btnNewButton_13.setBounds(145, 136, 89, 23);
		panel5.add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("MOVIE 5");
		btnNewButton_14.setBounds(145, 170, 89, 23);
		panel5.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("MOVIE 6");
		btnNewButton_15.setBounds(145, 204, 89, 23);
		panel5.add(btnNewButton_15);
		
		JPanel panel6 = new JPanel();
		layeredPane.add(panel6, "name_178979374483000");
		panel6.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("SELECT TIME");
		lblNewLabel_10.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblNewLabel_10.setBounds(160, 11, 117, 14);
		panel6.add(lblNewLabel_10);
		
		JButton btnNewButton_16 = new JButton("LOGOUT");
		btnNewButton_16.setBounds(341, 0, 73, 23);
		panel6.add(btnNewButton_16);
		
		JButton btnNewButton_17 = new JButton("BACK");
		btnNewButton_17.setBounds(341, 34, 73, 23);
		panel6.add(btnNewButton_17);
		
		JButton btnNewButton_18 = new JButton("1:00");
		btnNewButton_18.setBounds(160, 45, 89, 23);
		panel6.add(btnNewButton_18);
		
		JButton btnNewButton_19 = new JButton("2:00");
		btnNewButton_19.setBounds(160, 79, 89, 23);
		panel6.add(btnNewButton_19);
		
		JButton btnNewButton_20 = new JButton("3:00");
		btnNewButton_20.setBounds(160, 113, 89, 23);
		panel6.add(btnNewButton_20);
		
		JButton btnNewButton_21 = new JButton("4:00");
		btnNewButton_21.setBounds(160, 150, 89, 23);
		panel6.add(btnNewButton_21);
		
		JButton btnNewButton_22 = new JButton("5:00");
		btnNewButton_22.setBounds(160, 184, 89, 23);
		panel6.add(btnNewButton_22);
		
		JButton btnNewButton_23 = new JButton("6:00");
		btnNewButton_23.setBounds(160, 216, 89, 23);
		panel6.add(btnNewButton_23);
		
		JPanel panel7 = new JPanel();
		layeredPane.add(panel7, "name_178982156476300");
		panel7.setLayout(null);
		
		JButton btnNewButton_24 = new JButton("LOGOUT");
		btnNewButton_24.setBounds(325, 0, 89, 23);
		panel7.add(btnNewButton_24);
		
		JButton btnNewButton_25 = new JButton("BACK");
		btnNewButton_25.setBounds(325, 34, 89, 23);
		panel7.add(btnNewButton_25);
		
		JLabel lblNewLabel_11 = new JLabel("SELECT SEAT");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_11.setBounds(163, 11, 89, 14);
		panel7.add(lblNewLabel_11);
		
		JButton btnNewButton_26 = new JButton("0-0");
		btnNewButton_26.setBounds(10, 62, 57, 23);
		panel7.add(btnNewButton_26);
		
		JButton btnNewButton_27 = new JButton("0-1");
		btnNewButton_27.setBounds(77, 62, 57, 23);
		panel7.add(btnNewButton_27);
		
		JButton btnNewButton_28 = new JButton("0-3");
		btnNewButton_28.setBounds(144, 62, 57, 23);
		panel7.add(btnNewButton_28);
		
		JButton btnNewButton_29 = new JButton("0-4");
		btnNewButton_29.setBounds(211, 62, 57, 23);
		panel7.add(btnNewButton_29);
		
		JButton btnNewButton_30 = new JButton("0-5");
		btnNewButton_30.setBounds(278, 62, 57, 23);
		panel7.add(btnNewButton_30);
		
		JButton btnNewButton_31 = new JButton("0-6");
		btnNewButton_31.setBounds(345, 62, 57, 23);
		panel7.add(btnNewButton_31);
		
		JButton btnNewButton_32 = new JButton("1-0");
		btnNewButton_32.setBounds(10, 96, 57, 23);
		panel7.add(btnNewButton_32);
		
		JButton btnNewButton_33 = new JButton("1-1");
		btnNewButton_33.setBounds(77, 96, 57, 23);
		panel7.add(btnNewButton_33);
		
		JButton btnNewButton_34 = new JButton("1-3");
		btnNewButton_34.setBounds(144, 96, 57, 23);
		panel7.add(btnNewButton_34);
		
		JButton btnNewButton_35 = new JButton("1-4");
		btnNewButton_35.setBounds(211, 96, 57, 23);
		panel7.add(btnNewButton_35);
		
		JButton btnNewButton_36 = new JButton("1-5");
		btnNewButton_36.setBounds(278, 96, 57, 23);
		panel7.add(btnNewButton_36);
		
		JButton btnNewButton_37 = new JButton("1-6");
		btnNewButton_37.setBounds(345, 96, 57, 23);
		panel7.add(btnNewButton_37);
		
		JButton btnNewButton_38 = new JButton("2-0");
		btnNewButton_38.setBounds(10, 130, 57, 23);
		panel7.add(btnNewButton_38);
		
		JButton btnNewButton_39 = new JButton("2-1");
		btnNewButton_39.setBounds(77, 130, 57, 23);
		panel7.add(btnNewButton_39);
		
		JButton btnNewButton_40 = new JButton("2-3");
		btnNewButton_40.setBounds(144, 130, 57, 23);
		panel7.add(btnNewButton_40);
		
		JButton btnNewButton_41 = new JButton("2-4");
		btnNewButton_41.setBounds(211, 130, 57, 23);
		panel7.add(btnNewButton_41);
		
		JButton btnNewButton_42 = new JButton(" 2-5");
		btnNewButton_42.setBounds(278, 130, 57, 23);
		panel7.add(btnNewButton_42);
		
		JButton btnNewButton_43 = new JButton("2-6");
		btnNewButton_43.setBounds(345, 130, 59, 23);
		panel7.add(btnNewButton_43);
		
		JButton btnNewButton_44 = new JButton("3-0");
		btnNewButton_44.setBounds(10, 164, 57, 23);
		panel7.add(btnNewButton_44);
		
		JButton btnNewButton_45 = new JButton("3-1");
		btnNewButton_45.setBounds(77, 164, 57, 23);
		panel7.add(btnNewButton_45);
		
		JButton btnNewButton_46 = new JButton("3-3");
		btnNewButton_46.setBounds(144, 164, 57, 23);
		panel7.add(btnNewButton_46);
		
		JButton btnNewButton_47 = new JButton("3-4");
		btnNewButton_47.setBounds(211, 164, 57, 23);
		panel7.add(btnNewButton_47);
		
		JButton btnNewButton_48 = new JButton("3-5");
		btnNewButton_48.setBounds(278, 164, 57, 23);
		panel7.add(btnNewButton_48);
		
		JButton btnNewButton_49 = new JButton("3-6");
		btnNewButton_49.setBounds(345, 164, 57, 23);
		panel7.add(btnNewButton_49);
		
		JPanel panel8 = new JPanel();
		layeredPane.add(panel8, "name_178985089159300");
		panel8.setLayout(null);
		
		JButton btnNewButton_50 = new JButton("LOGOUT");
		btnNewButton_50.setBounds(334, 0, 80, 23);
		panel8.add(btnNewButton_50);
		
		JButton btnNewButton_51 = new JButton("PAY");
		btnNewButton_51.setBounds(110, 89, 68, 23);
		panel8.add(btnNewButton_51);
		
		JButton btnNewButton_52 = new JButton("CANCEL");
		btnNewButton_52.setBounds(197, 89, 80, 23);
		panel8.add(btnNewButton_52);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(37, 127, 337, 101);
		panel8.add(textArea_1);
		
		JLabel lblNewLabel_12 = new JLabel("Message:");
		lblNewLabel_12.setBounds(37, 107, 46, 14);
		panel8.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("PAYMENT CONFIRM");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_13.setBounds(110, 3, 151, 14);
		panel8.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("TICKET ID:");
		lblNewLabel_14.setBounds(110, 41, 79, 14);
		panel8.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("PRICE");
		lblNewLabel_15.setBounds(208, 41, 46, 14);
		panel8.add(lblNewLabel_15);
		
		JPanel panel9 = new JPanel();
		layeredPane.add(panel9, "name_186341101901700");
		panel9.setLayout(null);
		
		JButton btnNewButton_53 = new JButton("LOGOUT");
		btnNewButton_53.setBounds(341, 0, 73, 23);
		panel9.add(btnNewButton_53);
		
		JButton btnNewButton_54 = new JButton("BACK");
		btnNewButton_54.setBounds(341, 34, 73, 23);
		panel9.add(btnNewButton_54);
		
		JLabel lblNewLabel_16 = new JLabel("ENTER INFORMATION");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_16.setBounds(37, 38, 148, 14);
		panel9.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("ENTER BANK INFO:");
		lblNewLabel_17.setBounds(37, 88, 148, 14);
		panel9.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("ENTER VOUCHER:");
		lblNewLabel_18.setBounds(37, 133, 100, 14);
		panel9.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("ENTER EMAIL INFO:");
		lblNewLabel_19.setBounds(37, 179, 100, 14);
		panel9.add(lblNewLabel_19);
		
		textField_4 = new JTextField();
		textField_4.setBounds(157, 85, 148, 20);
		panel9.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(157, 130, 148, 20);
		panel9.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(157, 176, 148, 20);
		panel9.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton_55 = new JButton("SUBMIT");
		btnNewButton_55.setBounds(216, 207, 89, 23);
		panel9.add(btnNewButton_55);
		
		panel10 = new JPanel();
		layeredPane.add(panel10, "name_186355392009800");
		panel10.setLayout(null);
		
		JButton btnNewButton_56 = new JButton("LOGOUT");
		btnNewButton_56.setBounds(333, 0, 81, 23);
		panel10.add(btnNewButton_56);
		
		JLabel lblNewLabel_20 = new JLabel("CANCEL TICKET");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_20.setBounds(44, 34, 106, 14);
		panel10.add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("ENTER RECEIPT ID:");
		lblNewLabel_21.setBounds(44, 82, 119, 14);
		panel10.add(lblNewLabel_21);
		
		textField_7 = new JTextField();
		textField_7.setBounds(167, 79, 161, 20);
		panel10.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnNewButton_57 = new JButton("SUBMIT");
		btnNewButton_57.setBounds(167, 110, 89, 23);
		panel10.add(btnNewButton_57);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(62, 148, 325, 80);
		panel10.add(textArea_2);
		
		JLabel lblNewLabel_22 = new JLabel("Message:");
		lblNewLabel_22.setBounds(61, 131, 46, 14);
		panel10.add(lblNewLabel_22);
	}
}
