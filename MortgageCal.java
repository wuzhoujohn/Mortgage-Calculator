package Mortgage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ButtonGroup;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.UIManager;

public class MortgageCal {

	private JFrame frame;
	private JTextField prin;
	private JTextField rate;
	private static final int TWENTY = 20;
	private static final int TWENTYFIVE = 25;
	private static final int THIRTY = 30;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MortgageCal window = new MortgageCal();
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
	public MortgageCal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setEnabled(false);
		frame.setFont(null);
		frame.setTitle("Mortgage Calculator");
		frame.setBounds(100, 100, 545, 473);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextPane error = new JTextPane();
		error.setBounds(66, 21, 406, 32);
		error.setBackground(UIManager.getColor("CheckBox.background"));
		error.setEnabled(false);
		error.setEditable(false);
		
		JLabel lblAmortization = new JLabel("Amortization");
		lblAmortization.setBounds(66, 176, 125, 26);
		
		JRadioButton Twenty = new JRadioButton("20");
		Twenty.setBounds(222, 172, 61, 35);
		
		JRadioButton twentyFIve = new JRadioButton("25");
		twentyFIve.setBounds(322, 172, 69, 35);
		
		JRadioButton Thirty = new JRadioButton("30");
		Thirty.setBounds(403, 172, 69, 35);
		
		ButtonGroup group = new ButtonGroup();
		group.add(Twenty);
		group.add(twentyFIve);
		group.add(Thirty);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(66, 346, 406, 35);
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "hello world");
				try{
				//int p = Integer.parseInt(prin.getText());
				int p = parsePriciple(prin.getText());
				double r = parseInterest(rate.getText());
				//double r = Double.parseDouble(rate.getText());
				//int a = Integer.parseInt()
				int a;
				if(Twenty.isSelected()){
					a = TWENTY;
				}else if(twentyFIve.isSelected()){
					a = TWENTYFIVE;
				}else{
					a = THIRTY;
				}
				double pay = compute(p, r, a);
				String payment = Double.toString(pay);
				Result res = new Result(payment);
				res.resultScreen(payment);
				}catch(Exception ex){
					//error.setText(ex.getMessage());
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
				//compute(p, r);
				
			}

			private double parseInterest(String text) throws Exception {
				// TODO Auto-generated method stub
				double res = Double.parseDouble(text);
				if(res < 0){
					throw new Exception("interest rate is negative");
				}
				return res;	
				//return 0;
			}

			private int parsePriciple(String text) throws Exception {
				// TODO Auto-generated method stub
					int res = Integer.parseInt(text);
					if(res < 0){
						throw new Exception("principle is negative");
					}
					return res;	
			}

			public double compute(int p, double r, int a) {
				double realInterest;
				realInterest = (r / 100);
				realInterest = realInterest / 12;
				double nominator = realInterest * p;
				double term = Math.pow(1 + realInterest, (a * 12 * -1));
				double denominator = 1 - term;
				double monthlyPayment = nominator / denominator;
				//System.out.println("before 100 is" + monthlyPayment);
				int result = (int) (monthlyPayment * 100);
				//System.out.println("after 100 is" + result);
				monthlyPayment = (double) result / 100;
				//System.out.println("after round is" + monthlyPayment);
				return monthlyPayment;
				// TODO Auto-generated method stub
				
			}
		});
		
		JLabel lblPrinciple = new JLabel("Principle");
		lblPrinciple.setBounds(66, 99, 92, 26);
		
		prin = new JTextField();
		prin.setBounds(238, 96, 234, 32);
		prin.setColumns(10);
		
		
		
		JLabel lblInterestRate = new JLabel("Interest Rate");
		lblInterestRate.setBounds(66, 256, 125, 26);
		
		rate = new JTextField();
		rate.setBounds(234, 253, 238, 32);
		rate.setColumns(10);
		frame.getContentPane().setLayout(null);
		
		
		frame.getContentPane().add(error);
		frame.getContentPane().add(lblPrinciple);
		frame.getContentPane().add(prin);
		frame.getContentPane().add(lblAmortization);
		frame.getContentPane().add(Twenty);
		frame.getContentPane().add(twentyFIve);
		frame.getContentPane().add(Thirty);
		frame.getContentPane().add(lblInterestRate);
		frame.getContentPane().add(rate);
		frame.getContentPane().add(btnCalculate);
	}
}
