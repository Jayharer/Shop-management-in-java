
import java.awt.*;

import java.awt.event.*;
import java.io.*;

import javax.swing.*;

//change record
public class Change_Rate extends JFrame {

	JLabel label1;
	JTextField jtx;
	
	JLabel label2;
	JTextField jtx1;
	
	JLabel label3;
	
	JButton jbt;
	JPanel panel;
	
	int i_code;
	
	 double newrate;
	 int j;
	 
	 RandomAccessFile rf=null;
	
	  
	  int item_code[]=new int[100];
		String s[]=new String[100];
		double p_rate[]=new double[100];
		double s_rate[]=new double[100];
		double quantity[]=new double[100];
		
		long rlength;
		int stringlength;
		
	Change_Rate(){
		panel=new JPanel();
		panel.setLayout(new GridLayout(0,2));
		
		label1=new JLabel("Enter  Item  Code");
		jtx=new JTextField(15);
		
		label2=new JLabel("Enter  New  Rate ");
		jtx1=new JTextField(15);
		
		label3=new JLabel("Enter The Button");
		jbt=new JButton("Done");
		
		panel.add(label1);
		panel.add(jtx);
		
		panel.add(label2);
		panel.add(jtx1);
		
		panel.add(label3);
		panel.add(jbt);
		
		add(panel);
		
		 try{ 
  	         rf=new RandomAccessFile("data9.txt","rw");
  	       
  	       }
  	       catch (FileNotFoundException ex){
  	    	  System.out.println("error in opening file");
  	    	  
  	       }
        try{
      	
        	rlength=rf.length();
        	System.out.println(rlength);
      	
        } 
        catch (IOException eg){
      	  System.out.println("error in seek");
        }
		  int xy;
       try{
    	   
    	   for( j=0;;j++){
    		   
    		   if(rf.length()==rf.getFilePointer()) break;
    		   
    		   xy=rf.readInt();
    		   item_code[j]=xy;
    		   s[j]=rf.readUTF();
    		   p_rate[j]=rf.readDouble();
    		   s_rate[j]=rf.readDouble();
    		   quantity[j]=rf.readDouble();
    		   
    		   System.out.println(item_code[j]+" "+ s[j]+" "+ p_rate[j]+" "+s_rate[j]+" "+quantity[j]);
    		   
    		   
    	   }
    	   
       } 
       catch (ArrayIndexOutOfBoundsException ez){
    	   System.out.println("array index out");
       }

      
       catch (IOException ew){
    	   System.out.println("error in IO here here is"); 
       }
       
       jbtlistenerClass l=new jbtlistenerClass();
       jbt.addActionListener(l);
       
	}
	
	class jbtlistenerClass implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			try{
			i_code=Integer.parseInt(jtx.getText());
			newrate=Double.parseDouble(jtx1.getText());
			
			System.out.println(i_code+" i_code");
			System.out.println(newrate+" newrate");
			
			}
			
			catch (NumberFormatException ea){
				System.out.println("error in num format");
				System.exit(0);
			}
			
			System.out.println("control is here 11");
			
			for(int i=0;i<j;i++){
				System.out.println("control is here 12");
				if(i_code==item_code[i]){
					
					
					s_rate[i]=newrate;
					System.out.println("item rate change correctly");
					break;
					
				} //if end
			} //for loop end
			try{
				rf.seek(0);
			}
			
			catch (IOException ed){
				System.out.println("erro in rf seek");
			}
			 for(int i=0;i<j;i++){
				
				 
				  try{
					  System.out.println(item_code[i]+" "+ s[i]+" "+ p_rate[i]+" "+s_rate[i]+" "+quantity[i]);
					  
				  rf.writeInt(item_code[i]);
				  rf.writeUTF(s[i]);
				  rf.writeDouble(p_rate[i]);
				  rf.writeDouble(s_rate[i]);
				  rf.writeDouble(quantity[i]);
				  
				  
				  }
				  
				  catch(IOException ex){
					  System.out.println("error io occure");
				  }
			  }
			 
			 
			  
			   try{ 
				  
				  
				  
				
				   
				   System.out.println("rf length "+rf.length());
				  
		
			       rf.close();
			     setVisible(false);
			      }
			      catch (IOException em){}
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 JFrame fram=new Change_Rate();
		   fram.setTitle("Change Rate");
		  fram.setSize(700,400);
		  fram.setLocationRelativeTo(null);
		  fram.setVisible(true);
		
	}

}
