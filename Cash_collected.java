import java.io.*;
import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Cash_collected extends JFrame {

JLabel l1,l2,l3,datetime;

JTextField text1,text2,text3,text4;

JPanel panel;

JButton back;
RandomAccessFile rf;

 Calendar calendar;
 Cash_collected(){
	 
	 panel=new JPanel();
	 panel.setLayout(new GridLayout(0,2));
	 
	 calendar=new GregorianCalendar();
	 
	 back=new JButton("Back");
	 
	 datetime=new JLabel("Date & Time");
	 
	 l1=new JLabel("Today cash Collected (In Ruppes) ");
	 l2=new JLabel("Monthly cash Collected (In Ruppes) ");
	l3= new JLabel("Yearly cash Collected (In Ruppes) ");
	
	text1=new JTextField(15);
	text2=new JTextField(15);
	text3=new JTextField(15);
	text4=new JTextField(15);
	
	try{
		rf=new RandomAccessFile("cash.txt","rw");
		
	}
	
	catch (FileNotFoundException e){ System.out.println("error in opening file ");}
	
	try{
		
	
		
		String str=String.valueOf(new Date());
		
		
		
		rf.seek(4);
		text2.setText(String.valueOf(rf.readDouble()));
		
		rf.seek(16);
		text3.setText(String.valueOf(rf.readDouble()));
		
		rf.seek(28);
	
		text4.setText(String.valueOf(rf.readDouble()));
		
		text1.setText(str);
	}
	
	catch(NumberFormatException es){System.out.println("error in number format");}
	
	catch(IOException ed){System.out.println("error in io");}
	
	
	panel.add(datetime);
	panel.add(text1);
	panel.add(l1);
	panel.add(text2);
	panel.add(l2);
	panel.add(text3);
	panel.add(l3);
	panel.add(text4);
	
	panel.add(back);
	
	Backclass backlistener =new Backclass();
	back.addActionListener(backlistener);
	
	add(panel);
	
	
	
 }
 
 class Backclass implements ActionListener{
	 
	 public void actionPerformed(ActionEvent e){
		 
		 setVisible(false);
	 }
 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame jf=new Cash_collected();
		jf.setTitle("Cash Collected Show");
		jf.setSize(700,400);
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);

	}

}















