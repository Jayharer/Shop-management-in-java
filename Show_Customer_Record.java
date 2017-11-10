
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.*;


//making bill of items

class Show_Customer_Record extends JFrame{
	
	JPanel jp=new JPanel();
	
    JButton back;
  

	Show_Customer_Record(){
		
		JLabel l1;
		JLabel l2;
		JLabel l3;
		JLabel l4;
		
		l1=new JLabel(" ITEM ");
		 
		 l2=new JLabel("RATE");
		
		 l3=new JLabel("QUANTITY");
		 
		 l4=new JLabel("AMOUNT");
		

	   jp.add(l1);
	  
	  jp.add(l2);
	  
	  jp.add(l3);
	  jp.add(l4);
		
		 RandomAccessFile rf=null;
			int no_bill;
			try{ 
	  	         
		  	       rf=new RandomAccessFile("customer.txt","r");
		  	       }
		  	       catch (FileNotFoundException ex){
		  	    	  System.out.println("error in opening file");
		  	    	  
		  	       }
			
		
			jp.setLayout(new GridLayout(0,4));
			
		
			
			JTextField txname;
			 JTextField txrate;
			 JTextField txqty;
			 JTextField txamount;
			 JTextField txtamount;
			 
			
			JLabel l5;
			JLabel l6;
			
			
	try{		
			
		while(true)	
			
		{	
			if(rf.length()==rf.getFilePointer())  break;
			
			no_bill=rf.readInt();
			
			 l5=new JLabel(" Customer Name"); 
		l6=new JLabel("Mobile Number"); 
		
		JTextField jtx1=new JTextField(15);
		JTextField jtx2=new JTextField(15);
		
		jtx1.setText(rf.readUTF());
		jtx2.setText(rf.readUTF());

		jp.add(l5);
		jp.add(jtx1);
		jp.add(l6);
		jp.add(jtx2);
			
		
	  
	   
		    	   System.out.println("no fo item " +no_bill);
		    	   
		    	   
		    	  
		    	  for(int j=0;j<no_bill;j++){
		    		   
		    	  txname=new JTextField(15);
		    	  txname.setText(rf.readUTF());
		    	  
		    	
		    	  
		    	
		    	  
		    	  txrate=new JTextField(15);
		    	 
		    	 
		    	   txrate.setText(String.valueOf(rf.readDouble()));
		    	   
		    	   
		    	   
		          
		    	 txqty=new JTextField(15);
		    	 
		            txqty.setText(String.valueOf(rf.readDouble()));
		            
		        
		          
		       
		          txamount=new JTextField(15);
		          txamount.setText(String.valueOf(rf.readDouble()));
		            jp.add(txname);
		           jp.add(txrate);
		            jp.add(txqty);
		           jp.add(txamount);
		           
		       
		           
		    		 
		    	  }  //for loop end
		    	  
		    	  
		    	
		   
		    	
		       
		       
		      JLabel amou=new JLabel("Total");
		       txtamount=new JTextField(15);
		     
		   txtamount.setText(String.valueOf(rf.readDouble()));
		   jp.add(amou);
		   
		JLabel   label3=new JLabel("");
		JLabel   label4=new JLabel("");
		   jp.add(label3);
		   jp.add(label4);
		   
		   jp.add(txtamount);
		   
		  
		   
		   
	      
			
		}
		
		
		}
	
	 catch (IOException e){
		 System.out.println("error in readin customer File");
	 }
	
	back=new JButton("Back");
	
	jp.add(back);
	
	Backclass listener=new Backclass();
	back.addActionListener(listener);
	
	 int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
     int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
JScrollPane jsp=new JScrollPane(jp,v,h);
 
 add(jsp);
     
		
	} // constructor end
	
	class 	Backclass implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 JFrame fram=new Show_Customer_Record();
		   fram.setTitle("Show customer Record");
		  fram.setSize(700,400);
		  fram.setLocationRelativeTo(null);
		  fram.setVisible(true);
		
	}
	
	
	
}
	