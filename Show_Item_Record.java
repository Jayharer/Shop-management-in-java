


import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;


public class Show_Item_Record extends JFrame {

	
	JTextField item_code;
	 JTextField name;
	 JTextField p_rate;
	 JTextField s_rate;
	 JTextField qty;
	JLabel l1;
	JLabel l2;
	JLabel l3;
	JLabel l4;
	JLabel l5;
   JButton b1;
   
    
  
   
  RandomAccessFile rf;

  JPanel panel=new JPanel();

    
  
    
    
	public   Show_Item_Record(){
		
		panel.setLayout(new GridLayout(0,5));
    	
		l1=new JLabel("ITEM CODE");
    	
    	 l2=new JLabel("NAME");
    	
    	 l3=new JLabel("PURCHASE RATE");
    	
    	 l4=new JLabel("SELLING RATE");
    	
    	 l5=new JLabel("QUANTITY");
    	
    	 
    	 
        b1=new JButton("Back");
       
      
       
        
        panel.add(l1);
      
        
        panel.add(l2);
       
        
        panel.add(l3);
       
        
        panel.add(l4);
       
        
        panel.add(l5);
       
        
       
        
        b1listenerClass listener1=new b1listenerClass();
	       b1.addActionListener(listener1);
	       
	       
	       File f=new File("data9.txt");
	       
	       try{ 
	  	         rf=new RandomAccessFile(f,"r");
	  	       
	  	       }
	  	       catch (FileNotFoundException ex){
	  	    	  System.out.println("error in opening file");
	  	    	  
	  	       }
	        
	        
	        try{
		    	 
		    	 while((true) ){ 
		    		 
		    		 System.out.println("rf.length "+rf.length());
		    	   
		    		  if(rf.length()==rf.getFilePointer())   break;
		    		  
		    		 item_code=new JTextField(15);
		    	   item_code.setText(String.valueOf(rf.readInt()));
		  
		    	   
		    	   name=new JTextField(15);
		    	   name.setText(rf.readUTF());
		          
		    	   p_rate=new JTextField(15);
		            p_rate.setText(String.valueOf(rf.readDouble()));
		            
		            
		            s_rate=new JTextField(15);
		            s_rate.setText(String.valueOf(rf.readDouble()));
		            
		            
		            qty=new JTextField(15);
		           qty.setText(String.valueOf(rf.readDouble()));
		           
		           
		           panel.add(item_code);
		           panel.add(name);
		           panel.add(p_rate);
		           panel.add(s_rate);
		           panel.add(qty);
		           
		        
		           
		    	 }
		         
		       }
		       catch (NumberFormatException ey){
		    	   System.out.println("error in numfe");
		       }
		       catch (IOException ew){
		    	   System.out.println("error in IO here"); 
		       }
		       
		       panel. add(b1);
		     
		     
		        
		        int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		        int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		        
		   JScrollPane jsp=new JScrollPane(panel,v,h);
	        
	        add(jsp);
	        
	        try{
			     rf.close();
			    
			     }
			     catch (IOException y){
			    	 System.out.println("error in closing");
			     }
       
	}   
	
	
	   
	class b1listenerClass implements ActionListener {
		

		public void actionPerformed(ActionEvent e){
			
			
			setVisible(false);
		       
		}
	}


	

		
	
		public static void main(String[] args) {
	
			JFrame myframe=new Show_Item_Record();
			myframe.setTitle("Show Item Record");
			myframe.setSize(700,400);
			
		
			myframe.setLocationRelativeTo(null);
			
			myframe.setVisible(true);
			
			
	  
	   
	  
	}

}


