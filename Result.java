package Mortgage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Result {

	private JFrame Result;
	private JTextField leadingtext;
	private JButton Recompute;

	/**
	 * Launch the application.
	 */
	public void resultScreen(String payment) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Result window = new Result(payment);
					window.Result.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param payment 
	 * @param actionListener 
	 */
	public Result(String payment) {
		initialize(payment);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param payment 
	 */
	private void initialize(String payment) {
		Result = new JFrame();
		Result.setBounds(100, 100, 450, 300);
		Result.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Result.getContentPane().setLayout(null);
		
		leadingtext = new JTextField();
		leadingtext.setEditable(false);
		leadingtext.setText("Payment is");
		leadingtext.setBounds(21, 53, 186, 32);
		Result.getContentPane().add(leadingtext);
		leadingtext.setColumns(10);
		
		JTextField disp = new JTextField();
		disp.setEditable(false);
		disp.setText(payment);
		disp.setBounds(21, 80, 186, 32);
		Result.getContentPane().add(disp);
		
		Recompute = new JButton("Recompute");
		Recompute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MortgageCal.main(null);
			}
		});
		Recompute.setBounds(251, 66, 141, 35);
		Result.getContentPane().add(Recompute);
	}

}
