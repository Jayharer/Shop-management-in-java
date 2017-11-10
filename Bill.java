import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.*;


//making bill of items

class Bill extends JFrame{
	JLabel lbl1,lbl2;
	JTextField jtx1,jtx2;
	JButton add,show,back;
	
	JTextField text1;
	JTextField text2;
	
	
	JLabel label3;
	JLabel label4;
	
	JLabel label5;
	JButton enter;
	

	
	
	JPanel p1;
	int no_of_item=0;
	int i;
	
	int i_code[]=new int[20];
	double qty[]= new double[20];
	
	RandomAccessFile raf=null;
	
	RandomAccessFile rfile=null;
	
	RandomAccessFile fcash=null;
	
	String cs[]=new String[100];
	double crate[]=new double[100];
	double cqty[]=new double[100];
	double camount[]=new double[100];
	double ctamount=0;
	
	int no_bill;
	
	JFrame jf;
	
	double dcash,mcash,ycash;
	
	Bill(){
		p1=new JPanel();
		p1.setLayout(new GridLayout(3,2));
		
		lbl1=new JLabel("ENTER ITEM CODE ");
	    lbl2=new JLabel("ENTER QUANTITY");
	    
	    jtx1=new JTextField(15);
	    jtx2=new JTextField(15); 
	    
	    add=new JButton("ADD");
	    show=new JButton("SHOW BILL");
	    
	    addClass listener1=new addClass();
	    add.addActionListener(listener1);
	    
	    showClass listener2=new showClass();
	   show.addActionListener(listener2);
	    
	    p1.add(lbl1);
	    p1.add(jtx1);
	    p1.add(lbl2);
	    p1.add(jtx2);
	    p1.add(add);
	    p1.add(show);
	    add(p1);
	    
	    try{
	    	fcash=new RandomAccessFile("cash.txt","rw");
	    }
	    
	    catch(FileNotFoundException e){  System.out.println("error in opening");}
	   
		
	}
	
	
	class  showClass implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			
			jf=new JFrame();
			  
			int item_code[]=new int[100];
			String s[]=new String[100];
			double p_rate[]=new double[100];
			double s_rate[]=new double[100];
			double quantity[]=new double[100];
			double tamount=0;
			
			JTextField name;
			 JTextField rate;
			 JTextField qtyx;
			 JTextField amount;
			 JTextField jtxamount;
			JLabel l1;
			JLabel l2;
			JLabel l3;
			JLabel l4;
		    
		  RandomAccessFile rf=null;
		  
		  l1=new JLabel("NAME");
	    	 
	    	 l2=new JLabel("RATE");
	    	
	    	 l3=new JLabel("QUANTITY");
	    	 
	    	 l4=new JLabel("AMOUNT");
	    	
	    	 
	   
	        
	        jf.add(l1);
	       
	       jf.add(l2);
	       
	       jf.add(l3);
	       jf.add(l4);
	       
	      
	       try{ 
	  	         rf=new RandomAccessFile("data9.txt","rw");
	  	       raf=new RandomAccessFile("customer.txt","rw");
	  	       
	  	       rfile=new RandomAccessFile("profit.txt","rw");
	  	       }
	  	       catch (FileNotFoundException ex){
	  	    	  System.out.println("error in opening file");
	  	    	  
	  	       }
	       
  		  int x;
	       try{
	    	   
	    	   for( i=0;;i++){
	    		   
	    		   if(rf.length()==rf.getFilePointer())   break;
	    		   
	    		  x= rf.readInt();
	    		   item_code[i]=x;
	    		   s[i]=rf.readUTF();
	    		   p_rate[i]=rf.readDouble();
	    		   s_rate[i]=rf.readDouble();
	    		   quantity[i]=rf.readDouble();
	    		   
	    		  
	    	   }
	    	   
	       } 
	       catch (ArrayIndexOutOfBoundsException ez){
	    	   System.out.println("array index out");
	       }

	       catch (NumberFormatException ey){
	    	   System.out.println("error in numfe");
	       }
	       catch (IOException ew){
	    	   System.out.println("error in IO here"); 
	       } 
	   
		    	   System.out.println("no fo item " +no_of_item);
		    	   
		    	   no_bill=0;  int code; long fpointer;
		    	   
		    	   double profit,pqty;
		    	try{   
		    	  for(int j=0;j<no_of_item;j++){
		    		  
		    		 
		    	  for(int k=0;k<i;k++){ 
		    		 
		    		  if(i_code[j]==item_code[k]){
		    		 
		    	  name=new JTextField(15);
		    	  name.setText(s[k]);
		    	  
		    	  cs[no_bill]=s[k];
		    	  
		    	
		    	  
		    	   rate=new JTextField(15);
		    	 
		    	 
		    	   rate.setText(String.valueOf(s_rate[k]));
		    	   
		    	   crate[no_bill]=s_rate[k];
		    	   
		          
		    	  qtyx=new JTextField(15);
		    	 
		            qtyx.setText(String.valueOf(qty[j]));
		            
		            cqty[no_bill]=qty[j];
		            
		          double am=s_rate[k]*qty[j] ;
		          try{
		          while(true){
		        	  
		        	 if( rfile.length()==rfile.getFilePointer())  break;
		        	 
		        	code= rfile.readInt();
		        	 rfile.readUTF();
		        	 
		        	 fpointer=rfile.getFilePointer();
		        	 
		        	pqty= rfile.readDouble();
		        	
		        	pqty=pqty+qty[j];
		        	 
		        	 profit=rfile.readDouble();
		        	 
		        	 profit=profit+(s_rate[k]-p_rate[k])*qty[j];
		        	 
		        	 if(code==i_code[j]){
		        		 
		        		 rfile.seek(fpointer);
		        		 rfile.writeDouble(pqty );
		        		 rfile.writeDouble(profit );
		        		 
		        		 break;
		        	 }
		        	 
		          }
		          
		          }
		          
		          catch (IOException et) {};
		          
		          camount[no_bill]=am;
		          
		          quantity[k]=quantity[k]-qty[j];
		          
		          tamount=tamount+am;
		          amount=new JTextField(15);
		          amount.setText(String.valueOf(am));
		            jf.add(name);
		           jf.add(rate);
		            jf.add(qtyx);
		           jf.add(amount);
		           
		       
		            no_bill++;
		    		  } //if end
		    	  }  //i loop end
		    	  
		    	  
		    	
		         
		       } // j loop end
		   }
		    	catch (ArrayIndexOutOfBoundsException eg){
		    		System.out.println("array bounds");
		    	}
		    	
		    
		    	
		    	try{
        fcash.seek(4);
		    		 
        
		    		 dcash= fcash.readDouble();
		    		 
			    		
			    		dcash=dcash+tamount;
			    		
			    		fcash.seek(4);
			    		
			    		fcash.writeDouble(dcash);
		    		
		    		
		    		
         fcash.seek(16);
		    		
		    		mcash=fcash.readDouble();
		    		
		    		mcash=mcash+tamount;
		    		
		    		fcash.seek(16);
		    		
		    		fcash.writeDouble(mcash);
		    		
        fcash.seek(28);
		    		
		    		ycash=fcash.readDouble();
		    		
		    		ycash=ycash+tamount;
		    		
		    		fcash.seek(28);
		    		
		    		fcash.writeDouble(ycash);
		    		
		    		fcash.close();
		    	}
		    	
		    	catch(IOException eu){ System.out.println("error in IO");}
		       
		      JLabel amou=new JLabel("TOTAL AMOUNT");
		       jtxamount=new JTextField(15);
		       ctamount=tamount;
		   jtxamount.setText(String.valueOf(tamount));
		   jf.add(amou);
		   label3=new JLabel("");
		   label4=new JLabel("");
		   jf.add(label3);
		   jf.add(label4);
		   jf.add(jtxamount);
		   
		   
		   back=new JButton("Back");
		   
		   label5=new JLabel("Save Bill To Customer Record");
		   enter =new JButton("ENTER");
		   
		   jf.add(label5);
		   jf.add(enter);
		   jf.add(back);
		   
	      
			
			
		       jf.setTitle(" BILL");
				  jf.setSize(700,400);
				  jf.setLocationRelativeTo(null);
			 jf.setLayout(new GridLayout(0,4));
			  jf.setVisible(true);
			  
			  
			  Backclass backlistener =new Backclass();
			  back.addActionListener(backlistener);
			  
			  
			  
			  
			  Custclass obj=new Custclass();
			   enter.addActionListener(obj);
		try{
			rf.seek(0);
		}
		catch (IOException ed){
			System.out.println("error in rf seek");
		}
			  for(int l=0;l<i;l++){
				  
				  try{
				  rf.writeInt(item_code[l]);
				  rf.writeUTF(s[l]);
				  rf.writeDouble(p_rate[l]);
				  rf.writeDouble(s_rate[l]);
				  rf.writeDouble(quantity[l]);
				  
				  
				  }
				  
				  catch(IOException ex){
					  System.out.println("error io occure");
				  }
			  }
			  
			   try{ 
			       rf.close();
			      }
			      catch (IOException em){}
		}
		
	}
	
	
    class	Backclass  implements ActionListener{
		
		public void actionPerformed(ActionEvent e){ 
			
			jf.setVisible(false);
			
		}
 }
	
	class  addClass implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			try{
			
		i_code[no_of_item]=Integer.parseInt(jtx1.getText());
		
		qty[no_of_item]=Double.parseDouble(jtx2.getText());
		
		System.out.println(i_code[no_of_item]+"  "+qty[no_of_item]);
		
		jtx1.setText("");
		jtx2.setText("");
		no_of_item++;
			}
			
			catch (NumberFormatException ee){
				System.out.println("error in number format");	
			}
			
		
		}
		
	}
	
	class Custclass implements ActionListener {
		
		public void actionPerformed(ActionEvent e){
			
			JLabel label6=new JLabel("Enter Name");
			JLabel label7=new JLabel("Enter Mobile Number");
			JLabel label8=new JLabel("Save Bill To Customer Record "); 
			
			 text1=new JTextField(15);
			 text2=new JTextField(15);
			
			JButton save=new JButton("SAVE");
			
			JPanel jp=new JPanel();
			jp.setLayout(new GridLayout(0,2));
			
			jp.add(label6);
			jp.add(text1);
			jp.add(label7);
			jp.add(text2);
			jp.add(label8);
			jp.add(save);
			
			JFrame frame=new JFrame();
			frame.setTitle("Customer Record");
			frame.setSize(700,400);
			frame.setLocationRelativeTo(null);
			
			frame.add(jp);
			frame.setVisible(true);
			
			Classsave obj=new Classsave();
			save.addActionListener(obj);
			
		}
	}
	
	
	class Classsave implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			String s1=null,s2=null;
			try{
			s1=text1.getText();
			s2=text2.getText();
			}
			
			catch (NumberFormatException er){
				System.out.println("number format error in customer");
				System.exit(0);
			}
			
			try{
				raf.seek(raf.length());
				
				raf.writeInt(no_bill);
			raf.writeUTF(s1);
			raf.writeUTF(s2);
			
			 for(int l=0;l<no_bill;l++){
				  
				  
				 
				  raf.writeUTF(cs[l]);
				  raf.writeDouble(crate[l]);
				  raf.writeDouble(cqty[l]);
				  raf.writeDouble(camount[l]);
				  
				 
				   
				  
			  }
			 
			 raf.writeDouble(ctamount);
			  
			}
			
			catch (IOException eq){
				System.out.println("error in writing customer file");
				
			}
			
			
			try{
				raf.close();
				System.out.println("wrintin to customer file successful");
			}
			
			catch (IOException eq){
				System.out.println("error in closing customer file");
				
			}
			
		}
	}
	
	
}


public class java53 {
	

	public static void main(String[] args) {
		
   JFrame jf=new Bill();
   jf.setTitle("MAKE BILL");
  jf.setSize(700,400);
  jf.setLocationRelativeTo(null);
  jf.setVisible(true);
 
		
	}

}




