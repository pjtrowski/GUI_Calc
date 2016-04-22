import javax.swing.*;

import java.awt.event.*;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.text.NumberFormat;

import javax.swing.border.*;
import javax.swing.JRadioButton;

public class JavaLesson22 extends JFrame{
	
	JButton button1;
	JLabel label1,label2,label3;
	JTextField textField1,textField2;
	JCheckBox dollarSign,commaSeparrator;
	JRadioButton addNums,subNums,multNums,divNums;
	JSlider howManyTimes;
	
	double number1,number2,totalCalc;

	public static void main(String[]args)
	{
		new JavaLesson22();
		
	}
	
	public JavaLesson22(){
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("My 3rd Frame");
		JPanel thePanel=new JPanel();
		button1=new JButton("Calculate");
		
		ListenForButton lButton=new ListenForButton();
		button1.addActionListener(lButton);
		thePanel.add(button1);
		label1=new JLabel("Number 1");
		thePanel.add(label1);
		textField1=new JTextField("",5);
		thePanel.add(textField1);
		
		label2=new JLabel("Number 2");
		thePanel.add(label2);
		textField2=new JTextField("",5);
		thePanel.add(textField2);
		
		dollarSign = new JCheckBox("Dollar");
		commaSeparrator=new JCheckBox("Commas");
		
		thePanel.add(dollarSign);
		thePanel.add(commaSeparrator);
		
		addNums=new JRadioButton("Add");
		subNums=new JRadioButton("Substract");
		divNums=new JRadioButton("Divide");
		multNums=new JRadioButton("Multipy");

		GroupButtons operations=new GroupButtons();
		
		operations.add(addNums);
		operations.add(subNums);
		operations.add(divNums);
		operations.add(multNums);
		
		JPanel openPanel=new JPanel();
		Border openBorder=BorderFactory.createTitledBorder("Operations");
		openPanel.setBorder(openBorder);
		
		openPanel.add(addNums);
		openPanel.add(subNums);
		openPanel.add(divNums);
		openPanel.add(multNums);
		
		addNums.setSelected(true);
		
		thePanel.add(openPanel);
		
		label3=new JLabel("Perform How many times");
		thePanel.add(label3);
		howManyTimes=new JSlider(0,90,1);
		howManyTimes.setMinorTickSpacing(1);
		howManyTimes.setMajorTickSpacing(10);
		howManyTimes.setPaintTicks(true);
		howManyTimes.setPaintLabels(true);
		ListenForSlider lForSlider=new ListenForSlider();
		howManyTimes.addChangeListener(lForSlider);
		thePanel.add(howManyTimes);
		this.add(thePanel);
		this.setVisible(true);
		textField1.requestFocus(true);
	}
	
	
	private class ListenForButton implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==button1){
				try{
					number1=Double.parseDouble(textField1.getText());
					number2=Double.parseDouble(textField2.getText());
				}
				
			catch(NumberFormatException excep){
				JOptionPane.showMessageDialog(JavaLesson22.this, "Please select right number", "Errro", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
				if (addNums.isSelected()){totalCalc=addNumbers(number1,number2,howManyTimes.getValue());
					
				} else if (subNums.isSelected()) {totalCalc=subtractNumbers(number1,number2,howManyTimes.getValue());
				} else if (divNums.isSelected()) {totalCalc=divideNumbers(number1,number2,howManyTimes.getValue());
				} else {totalCalc=multipyNumbers(number1,number2,howManyTimes.getValue());
				} 
				
			if (dollar.isSelected()){
				NumberFormat numFormat=NumberFormat.getCurrencyInstance();
			JOptionPane.showInputDialog(JavaLesson22.this,numFormat.format(totalCalc),"Solution",JOptionPane.INFORMATION_MESSAGE);
				}
	
	}
	}
	}
	
	private class ListenForSlider implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
		
			if(e.getSource()==howManyTimes){
				
				label3.setText("How many times "+ howManyTimes.getValue());
			}
			
		}
		
	}
	
	public static double addNumbers(double number1,double number2,int howMany)
	{
		double total=0;
		int i=1;
		while (i<= howMany){total=total+(number1+number2);
			i++;} 
		return total;
		
	}
	public static double subtractNumbers(double number1,double number2,int howMany)
	{
		double total=0;
		int i=1;
		while (i<= howMany){total=total+(number1+number2);
			i++;} 
		return total;
	}
	public static double divideNumbers(double number1,double number2,int howMany)
	{
		double total=0;
		int i=1;
		while (i<= howMany){total=total+(number1+number2);
			i++;} 
		return total;
	}

	public static double multipyNumbers(double number1,double number2,int howMany)
	{
		double total=0;
		int i=1;
		while (i<= howMany){total=total+(number1+number2);
			i++;} 
		return total;

}
