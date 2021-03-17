package com.SwingExamples;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;


public class OnlineTest implements ActionListener {
	JFrame f;
	JLabel l;
	JButton b1,b2;
	ButtonGroup bg;
	JRadioButton r[]=new JRadioButton[5];
	int[] m=new int[10];
	int current=0; //for qn
	int count=0 ;//for score
	int x=1;
	int y=1;
	int now=0;
	
	OnlineTest(){
		GUI();
		addComponents();
		setLabel(); //questions and options
	}
	
	public void GUI() {
		f=new JFrame();
		f.setTitle("Online Java Test");
		f.setLayout(null);
		f.setSize(500,400);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void addComponents() {
		l=new JLabel();
		l.setBounds(30,40,450,20);
		f.add(l);
		
		b1=new JButton("Next");
		b1.setBounds(100,260, 100, 30);
		f.add(b1);
		
		b2=new JButton("Result");
		b2.setBounds(270,260,100,30);
		b2.setEnabled(false);
		f.add(b2);
		
		bg=new ButtonGroup();
		
		for(int i=0;i<5;i++) {
			r[i]=new JRadioButton();
			f.add(r[i]);
			bg.add(r[i]);
			}
		r[0].setBounds(50,90,150,20);  
        r[1].setBounds(50,120,150,20);  
        r[2].setBounds(50,150,150,20);  
        r[3].setBounds(50,180,150,20); 
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
	}
	
	public void setLabel() {
		
		if(current==0) {
			l.setText("1. Which among the following is not a primitive data type? ");
			r[0].setText("int");
			r[1].setText("boolean");
			r[2].setText("Float");
			r[3].setText("char");
		}
		
		if(current==1) {
			l.setText("2. Which class is available to all the classes by default? ");
			r[0].setText("Applet");
			r[1].setText("Object");
			r[2].setText("Swing");
			r[3].setText("Actionevent");
		}
		
		if(current==2) {
			l.setText("3. Which package is by default available without importing it? ");
			r[0].setText("net");
			r[1].setText("lang");
			r[2].setText("swing");
			r[3].setText("applet");
		}
		
		if(current==3) {
			l.setText("4. String class is defined in which package? ");
			r[0].setText("lang");
			r[1].setText("swing");
			r[2].setText("string");
			r[3].setText("awt");
		}
		
		if(current==4) {
			l.setText("5. Which among the following is not a primitive data type? ");
			r[0].setText("int");
			r[1].setText("boolean");
			r[2].setText("Float");
			r[3].setText("char");
		}
		
		if(current==5) {
			l.setText("6. Which of these is not a keyword? ");
			r[0].setText("int");
			r[1].setText("class");
			r[2].setText("if");
			r[3].setText("get");
		}
		
		if(current==6) {
			l.setText("7. Which of these is not a class? ");
			r[0].setText("Swing");
			r[1].setText("Actionevent");
			r[2].setText("ActionPerformed");
			r[3].setText("Button");
		}
		
		if(current==7) {
			l.setText("8. Which of these is not a function of Object class? ");
			r[0].setText("toString");
			r[1].setText("finalize");
			r[2].setText("equals");
			r[3].setText("getDocumentBase");
		}
		if(current==8) {
			l.setText("9. Which of these methods with invoke run method of thread? ");
			r[0].setText("run()");
			r[1].setText("start()");
			r[2].setText("begin()");
			r[3].setText("thread()");
		}
		if(current==9) {
			l.setText("10. Which of these is not a valid component? ");
			r[0].setText("JButton");
			r[1].setText("JTextarea");
			r[2].setText("JList");
			r[3].setText("JButtongroup");
		}
	}
	
	//returns boolean value of right answer
	public boolean check() {
		if(current==0)
			return r[2].isSelected();
		if(current==1)
			return r[1].isSelected();
		if(current==2)
			return r[1].isSelected();
		if(current==3)
			return r[0].isSelected();
		if(current==4)
			return r[2].isSelected();
		if(current==5)
			return r[3].isSelected();
		if(current==6)
			return r[2].isSelected();
		if(current==7)
			return r[3].isSelected();
		if(current==8)
			return r[1].isSelected();
		if(current==9)
			return r[3].isSelected();
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			if(check())
				count+=1; //if answer is right , score+1
			current++;
			setLabel(); //move to next question
			
			if(current==9) {          //if reached last question
				b1.setEnabled(false);
				b2.setText("Result");
				b2.setEnabled(true);
			}
			
		}
		
		if(e.getActionCommand().equals("Result")) {
			if(check())
				count+=1;
			current++;
			if(count==10)
				JOptionPane.showMessageDialog(f, "Congrats !!!! Your score: "+count);
			else
				JOptionPane.showMessageDialog(f, "Your score: "+count);
		}
		}
	
	public static void main(String[] args) {
		new OnlineTest();
	}

}
