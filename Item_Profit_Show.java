import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

import java.io.*;

public class Item_Profit_Show extends JFrame {

	JLabel l1;
	JLabel l2;
	JLabel l3;
	
	JLabel ilabel;
	
  JFrame jf;
	
	JTextField text1,text2,text3,itext;
	
	JButton back;
	
	RandomAccessFile	rf=null;
	
	JPanel panel;
	
	Item_Profit_Show(){
		
		panel=new JPanel();
		
	panel.setLayout(new GridLayout(0,4));
		
	l1=new JLabel("ITEM");
	l2=new JLabel("QUANTITY");
	l3=new JLabel("PROFIT");
	ilabel=new JLabel("ITEM Code");
	
	panel.add(ilabel);
	panel.add(l1);
	panel.add(l2);
	panel.add(l3);
	
	try{
		 rf=new RandomAccessFile("profit.txt","r");
		
		
}

catch (IOException e){}
	

		
	while(true){
		
		try{
			
			
		if(rf.length()==rf.getFilePointer())  break;
		
		text1=new JTextField(15);
		text2=new JTextField(15);
		text3=new JTextField(15);
		itext=new JTextField(15);
		
		
		itext.setText(String.valueOf(rf.readInt()));
		
			
		text1.setText((rf.readUTF()));
			
			
	
		text2.setText(String.valueOf(rf.readDouble()));
		text3.setText(String.valueOf(rf.readDouble()));
		
		
		
		
		
		panel.add(itext);
		panel.add(text1);
		panel.add(text2);
		panel.add(text3);
		
		}
		
		catch(IOException ew){}
		
	}  // while loop end
	
	

	

	back=new JButton("Back");
	
	panel.add(back);
	
	int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
	int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
	
	JScrollPane jsp=new JScrollPane(panel,v,h);
	
	add(jsp);
	
	Backclass obj=new Backclass();
	
	back.addActionListener(obj);
	
	try{
	rf.close();
	
	}
	
	catch(IOException ew){}
	
	
	
	} // java65() constructor end
	
	class Backclass implements ActionListener{
		public void actionPerformed(ActionEvent ed){
			
			setVisible(false);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame jf=new Item_Profit_Show();
		 
		  jf.setTitle("Show Item Profit");
		  jf.setSize(700,400);
		 jf.setLocationRelativeTo(null);
		 jf.setVisible(true);
	}

}









