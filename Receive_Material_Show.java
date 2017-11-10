import java.awt.*;


import java.awt.event.*;
import java.io.*;


import javax.swing.*;

public class Receive_Material_Show extends JFrame {
	
	
	
	

	JLabel label1,lname,lmobno;
	JLabel label2;
	JLabel label3;
	JLabel label4;
	
	JTextField text1,name,mobno;
	JTextField text2;
	JTextField text3;
	JTextField text4;
	
	JTextField text5;
	
	JPanel panel1;
	
	int no_of_item;
	JButton back;
	


	
	RandomAccessFile rf=null;
	
	
	
	
	
	Receive_Material_Show(){
		
		 panel1=new JPanel();
			
			panel1.setLayout(new GridLayout(0,4));
			
		
			
			label1=new JLabel("ITEM CODE");
			label2=new JLabel("PURCHASE  RATE");
			label3=new JLabel("QUANTITY");
			label4=new JLabel("amount");
			
			panel1.add(label1);
			panel1.add(label2);
			panel1.add(label3);
			panel1.add(label4);
		
			
			try{
				rf=new RandomAccessFile("vendor.txt","r");
				
			}
			
			
			catch (FileNotFoundException eq){ }
			
			System.out.println("good");
			
			
			
			
			try{
				
				while(true){
					
					lname=new JLabel("Vendor Name");
					lmobno=new JLabel("Mobile No");
					
					name=new JTextField();
					mobno=new JTextField();
					
					System.out.println("good");
					
					if(rf.length()==rf.getFilePointer())  break;
				
					System.out.println("good");
				no_of_item=rf.readInt();
				
				name.setText(rf.readUTF());
				mobno.setText(rf.readUTF());
				
				panel1.add(lname);
				panel1.add(name);
				
				panel1.add(lmobno);
				panel1.add(mobno);
				
				
				for(int i=0;i<no_of_item;i++){
					
					text1=new JTextField(15);
					text2=new JTextField(15);
					text3=new JTextField(15);
					text4=new JTextField(15);
					
					text1.setText(String.valueOf(rf.readInt())) ;
					text2.setText((rf.readUTF())) ;
					text3.setText(String.valueOf(rf.readDouble())) ;
					text4.setText(String.valueOf(rf.readDouble())) ;
					
					panel1.add(text1);
					panel1.add(text2);
					panel1.add(text3);
					panel1.add(text4);
				}  // for loop end
				
			double temp;
			temp=rf.readDouble();
			System.out.println(temp);
			
			text5=new JTextField(15);
			text5.setText(String.valueOf(temp));
				
				
			JLabel total=new JLabel("Total");
			
			panel1.add(total);
			
			JLabel l=new JLabel("");
			JLabel ll=new JLabel("");
			
			panel1.add(l);
			panel1.add(ll);
			
			panel1.add(text5);
				}      // while loop end
				
				rf.close();
				
				
			}
			
			catch (IOException ee) {}
			
			
		
			
			back=new JButton("Back");
			
			Backclass listener1=new Backclass();
			back.addActionListener(listener1);
			
			panel1.add(back);
			
			int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
			int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
			
			JScrollPane jsp=new JScrollPane(panel1,v,h);
			add(jsp);
		
	}
	
	



class Backclass implements ActionListener{
	
	public void actionPerformed(ActionEvent e){
		
	
		setVisible(false);
		
		
	  }
	}

	public static void main(String[] args) {	
		JFrame frame=new JFrame();
		
		Receive_Material_Show job=new Receive_Material_Show();
	
		  frame.add(job.panel1);
		  frame.setTitle("Receive Material show");
		  frame.setSize(700,400);
		  frame.setLocationRelativeTo(null);
		  frame.setVisible(true);

	}

}



