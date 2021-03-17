package com.SwingExamples;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Calculator implements ActionListener {
	JFrame f;
	
	//Components to be added in Frame
	JLabel label=new JLabel();
	JRadioButton on=new JRadioButton("on");
	JRadioButton off=new JRadioButton("off");
	JTextField text=new JTextField();
	JButton Zero=new JButton("0");
	JButton One=new JButton("1");
	JButton Two=new JButton("2");
	JButton Three=new JButton("3");
	JButton Four=new JButton("4");
	JButton Five=new JButton("5");
	JButton Six=new JButton("6");
	JButton Seven=new JButton("7");
	JButton Eight=new JButton("8");
	JButton Nine=new JButton("9");
	JButton Dot=new JButton(".");
	JButton Equal=new JButton("=");
	JButton Plus=new JButton("+");
	JButton Minus=new JButton("-");
	JButton Mul=new JButton("*");
	JButton Div=new JButton("/");
	JButton Clear=new JButton("Clr");
	JButton Del=new JButton("Del");
	JButton Reciprocal=new JButton("1/x");
	JButton Sqrt=new JButton("\u221A");
	JButton Sq=new JButton("x\u00B2");
	
	int id;
	double num,result;
	double num2;
	String res;
	
	public Calculator() {
		GUI();
		addComponents();
		action();
		
	}
	
	//STEP 1 : PREPARE GUI : create frame and set its properties
	public void GUI() {
		f=new JFrame();
		f.setTitle("Calculator");
		f.setLayout(null);
		f.getContentPane().setBackground(Color.black);
		f.setResizable(false); 
		f.setSize(300,500);
		f.setLocationRelativeTo(null); //locating it to the center
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//STEP 2 : ADD COMPONENTS : set properties for the components and add it to the frame object
	public void addComponents() {
		label.setBounds(10, 0, 100, 50);
		label.setForeground(Color.WHITE);
		f.add(label);
		
		text.setBounds(7, 40, 270, 40);
		text.setFont(new Font("Arial", Font.BOLD, 20));
		text.setEditable(false);
		f.add(text);
		
		on.setBounds(7, 90, 50, 50);
		on.setBackground(Color.black);
		on.setForeground(Color.white);
		on.setSelected(true);
		on.setFont(new Font("Arial",Font.BOLD,12));
		f.add(on);
		
		off.setBounds(7, 120, 50, 50);
		off.setBackground(Color.black);
		off.setForeground(Color.white);
		off.setSelected(false);
		off.setFont(new Font("Arial",Font.BOLD,12));
		f.add(off);
		
		ButtonGroup group=new ButtonGroup();
		group.add(on);
		group.add(off);
		
		Seven.setBounds(7,230 , 60, 40);
		Seven.setFont(new Font("Arial", Font.BOLD, 20));
		f.add(Seven);
		
		Eight.setBounds(80, 230, 60, 40);
		Eight.setFont(new Font("Arial", Font.BOLD, 20));
		f.add(Eight);
		
		Nine.setBounds(150, 230, 60, 40);
		Nine.setFont(new Font("Arial", Font.BOLD, 20));
		f.add(Nine);
		
		Eight.setBounds(80, 230, 60, 40);
		Eight.setFont(new Font("Arial", Font.BOLD, 20));
		f.add(Eight);
		
		Four.setBounds(7, 280, 60, 40);
		Four.setFont(new Font("Arial", Font.BOLD, 20));
		f.add(Four);

		Five.setBounds(80, 280, 60, 40);
		Five.setFont(new Font("Arial", Font.BOLD, 20));
		f.add(Five);

		Six.setBounds(150, 280, 60, 40);
		Six.setFont(new Font("Arial", Font.BOLD, 20));
		f.add(Six);

		One.setBounds(7, 330, 60, 40);
		One.setFont(new Font("Arial", Font.BOLD, 20));
		f.add(One);

		Two.setBounds(80, 330, 60, 40);
		Two.setFont(new Font("Arial", Font.BOLD, 20));
		f.add(Two);

		Three.setBounds(150, 330, 60, 40);
		Three.setFont(new Font("Arial", Font.BOLD, 20));
		f.add(Three);

		Dot.setBounds(150, 380, 60, 40);
		Dot.setFont(new Font("Arial", Font.BOLD, 20));
		f.add(Dot);

		Zero.setBounds(7, 380, 130, 40);
		Zero.setFont(new Font("Arial", Font.BOLD, 20));
		f.add(Zero);

		Equal.setBounds(217, 330, 55, 90);
		Equal.setBackground(Color.yellow);
		Equal.setFont(new Font("Arial", Font.BOLD, 20));
		f.add(Equal);
		
		Plus.setBounds(217,280,55, 40);
		Plus.setBackground(Color.yellow);
		Plus.setFont(new Font("Arial", Font.BOLD, 20));
		f.add(Plus);
		
		Mul.setBounds(217, 230, 55, 40);
		Mul.setBackground(Color.yellow);
		Mul.setFont(new Font("Arial", Font.BOLD, 20));
		f.add(Mul);
		
		Minus.setBounds(217, 180, 55, 40);
		Minus.setBackground(Color.yellow);
		Minus.setFont(new Font("Arial", Font.BOLD, 20));
		f.add(Minus);
		
		Sqrt.setBounds(7, 180, 60, 40);
		Sqrt.setFont(new Font("Arial", Font.BOLD, 20));
		f.add(Sqrt);
		
		Sq.setBounds(80, 180, 60, 40);
		Sq.setFont(new Font("Arial", Font.BOLD, 20));
		f.add(Sq);
		
		Reciprocal.setBounds(150, 180, 60, 40);
		Reciprocal.setFont(new Font("Arial", Font.BOLD, 15));
		f.add(Reciprocal);
		
		Div.setBounds(217, 130, 55, 40);
		Div.setBackground(Color.yellow);
		Div.setFont(new Font("Arial", Font.BOLD, 20));
		f.add(Div);
		
		Del.setBounds(150, 130, 55, 40);
		Del.setBackground(Color.red);
		Del.setFont(new Font("Arial", Font.BOLD, 12));
		f.add(Del);
		
		Clear.setBounds(80, 130, 55, 40);
		Clear.setBackground(Color.red);
		Clear.setFont(new Font("Arial", Font.BOLD, 12));
		f.add(Clear);
		}
	
	//STEP 3 : Define Actionlistener
	public void action() {
		Zero.addActionListener(this);
		One.addActionListener(this);
		Two.addActionListener(this);
		Three.addActionListener(this);
		Four.addActionListener(this);
		Five.addActionListener(this);
		Six.addActionListener(this);
		Seven.addActionListener(this);
		Eight.addActionListener(this);
		Nine.addActionListener(this);
		Dot.addActionListener(this);
		Equal.addActionListener(this);
		Plus.addActionListener(this);
		Minus.addActionListener(this);
		Mul.addActionListener(this);
		Div.addActionListener(this);
		Sq.addActionListener(this);
		Sqrt.addActionListener(this);
		Reciprocal.addActionListener(this);
		Clear.addActionListener(this);
		Del.addActionListener(this);
		on.addActionListener(this);
		off.addActionListener(this);
		}
	
	// STEP 4 : write logic for each button's action
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source=e.getSource();
		
		if (source==on)
			enable();
		else if (source==off)
			disable();
		else if (source==Clear) {
			label.setText(" ");
			text.setText(" ");
			id=5;
		}
		else if (source==Del) {
			int length=text.getText().length();
			int lastPosition=length-1;
			
			if(length>0) {
				StringBuilder s=new StringBuilder(text.getText()); //creating a mutable string for text
				s.deleteCharAt(lastPosition);
				text.setText(s.toString());
			}
		}
		else if(source==Zero) {
			if (text.getText().equals("0"))
				return;
			else
				text.setText(text.getText()+"0");
		}
		else if(source==One)
			text.setText(text.getText()+"1");
		else if(source==Two)
			text.setText(text.getText()+"2");
		else if(source==Three)
			text.setText(text.getText()+"3");
		else if(source==Four)
			text.setText(text.getText()+"4");
		else if(source==Five)
			text.setText(text.getText()+"5");
		else if(source==Six)
			text.setText(text.getText()+"6");
		else if(source==Seven)
			text.setText(text.getText()+"7");
		else if(source==Eight)
			text.setText(text.getText()+"8");
		else if(source==Nine)
			text.setText(text.getText()+"9");
		else if(source==Dot) {
			if(text.getText().equals("."))
				return;
			else
				text.setText(text.getText()+".");
		}
		else if(source==Plus) {
			String str=text.getText();
			num=Double.parseDouble(text.getText());
			label.setText(str+"+");
			text.setText(" ");
			id=1;
		}
		else if(source==Minus) {
			String str=text.getText();
			num=Double.parseDouble(text.getText());
			label.setText(str+"-");
			text.setText(" ");
			id=2;
		}
		else if(source==Mul) {
			String str=text.getText();
			num=Double.parseDouble(text.getText());
			label.setText(str+"*");
			text.setText(" ");
			id=3;
		}
		else if(source==Div) {
			String str=text.getText();
			num=Double.parseDouble(text.getText());
			label.setText(str+"/");
			text.setText(" ");
			id=4;
		}
		else if(source==Sqrt) {
			num=Double.parseDouble(text.getText());
			result=Math.sqrt(num);
			text.setText(Double.toString(result));
		}
		else if(source==Sq) {
			String str=text.getText();
			num=Double.parseDouble(text.getText());
			result=Math.pow(num, 2);
			String res=Double.toString(result);
			label.setText("Square of : "+str);
			if (res.endsWith(".0"))
				text.setText(res.replace(".0", ""));
			else
				text.setText(res);
		}
		else if(source==Reciprocal) {
			num=Double.parseDouble(text.getText());
			result=1/num;
			String str=Double.toString(result);
			if (str.endsWith(".0"))
				text.setText(str.replace(".0", ""));
			else
				text.setText(str);
			}
		else if(source==Equal) {
			switch(id) {
			case 1:
				
				num2=Double.parseDouble(text.getText());
				result=num+num2;
				label.setText(num+"+"+num2+"=");
				res=Double.toString(result);
				if (res.endsWith(".0"))
					text.setText(res.replace(".0", ""));
				else
					text.setText(res);
				break;
				
			case 2:
				
				num2=Double.parseDouble(text.getText());
				result=num-num2;
				label.setText(num+"-"+num2+"=");
				res=Double.toString(result);
				if(res.endsWith(".0"))
					text.setText(res.replace(".0", ""));
				else
					text.setText(res);
				break;
			case 3:
				
				num2=Double.parseDouble(text.getText());
				result=num*num2;
				label.setText(num+"*"+num2+"=");
				res=Double.toString(result);
				if(res.endsWith(".0"))
					text.setText(res.replace(".0", ""));
				else
					text.setText(res);
				break;
			case 4:
				
				num2=Double.parseDouble(text.getText());
				result=num/num2;
				label.setText(num+"/"+num2+"=");
				res=Double.toString(result);
				if(res.endsWith(".0"))
					text.setText(res.replace(".0", ""));
				else
					text.setText(res);
				break;
				
			default:
					
					text.setText(text.getText());
				
				
			}
		}
		
	}
	
	private void disable() {
		on.setEnabled(true);
		off.setEnabled(false);
		Zero.setEnabled(false);
		One.setEnabled(false);
		Two.setEnabled(false);
		Three.setEnabled(false);
		Four.setEnabled(false);
		Five.setEnabled(false);
		Six.setEnabled(false);
		Seven.setEnabled(false);
		Eight.setEnabled(false);
		Nine.setEnabled(false);
		Dot.setEnabled(false);
		Equal.setEnabled(false);
		Plus.setEnabled(false);
		Minus.setEnabled(false);
		Div.setEnabled(false);
		Mul.setEnabled(false);
		Sq.setEnabled(false);
		Sqrt.setEnabled(false);
		Reciprocal.setEnabled(false);
		Clear.setEnabled(false);
		Del.setEnabled(false);
		label.setText(" ");;
		text.setText(" ");;
		
	}

	private void enable() {
		on.setEnabled(false);
		off.setEnabled(true);
		Zero.setEnabled(true);
		One.setEnabled(true);
		Two.setEnabled(true);
		Three.setEnabled(true);
		Four.setEnabled(true);
		Five.setEnabled(true);
		Six.setEnabled(true);
		Seven.setEnabled(true);
		Eight.setEnabled(true);
		Nine.setEnabled(true);
		Dot.setEnabled(true);
		Equal.setEnabled(true);
		Plus.setEnabled(true);
		Minus.setEnabled(true);
		Div.setEnabled(true);
		Mul.setEnabled(true);
		Sq.setEnabled(true);
		Sqrt.setEnabled(true);
		Reciprocal.setEnabled(true);
		Clear.setEnabled(true);
		Del.setEnabled(true);
		label.setEnabled(true);
		text.setEnabled(true);
		
	}

	public static void main(String[] args) {
		new Calculator();
	}
}
