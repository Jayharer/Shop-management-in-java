
import java.awt.*;

import java.awt.event.*;
import java.io.*;

import javax.swing.*;

//delete record
public class Delete_Record extends JFrame {

	JLabel label1;
	JTextField jtx;
	JButton jbt;
	JPanel panel;
	int i_code,item_code;
	
	 int i;
	 
	 RandomAccessFile rf=null;
	
	  
	 String str;
	 double p_rate,s_rate,qty;
		
		long filelength;
		int stringlength;
		
	Delete_Record(){
		panel=new JPanel();
		panel.setLayout(new GridLayout(2,2));
		
		label1=new JLabel("Enter  Item  Code");
		jtx=new JTextField(15);
		jbt=new JButton("Done");
		panel.add(jtx);
		panel.add(label1);
		
		panel.add(jbt);
		
		add(panel);
		
		 try{ 
  	         rf=new RandomAccessFile("data9.txt","rw");
  	        
  	      
  	       }
  	       catch (FileNotFoundException ex){
  	    	  System.out.println("error in opening file");
  	    	  
  	       }
        try{
      	
        	filelength=rf.length();
        	System.out.println(filelength);
        	
      	
      
        } 
        catch (IOException eg){
      	  System.out.println("error in seek");
        }
		 
       
       jbtlistenerClass l=new jbtlistenerClass();
       jbt.addActionListener(l);
       
	}
	
	class jbtlistenerClass implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			setVisible(false);
			try{
			i_code=Integer.parseInt(jtx.getText());
			
			System.out.println(i_code+" i_code");
			
			
			}
			
			catch (NumberFormatException ea){
				System.out.println("error in num format");
				System.exit(0);
			}
			
			long writefilepointer=0,readfilepointer=0,stringbyte,temp;
			
			boolean flag=false;
			
			try{
			while(true){
				
				
				
				writefilepointer=rf.getFilePointer();
				
				
				System.out.println("writefilepointer "+writefilepointer);
				
				item_code=rf.readInt();
				
				System.out.println("item_code "+item_code);
				
				if(i_code==item_code){
					
					str=rf.readUTF();
					
					System.out.println("name "+str);
					
					stringlength=str.length();
					
					System.out.println("name length "+stringlength);
					
					stringbyte=(stringlength-1)+3;
					
					System.out.println("stringbyte "+stringbyte);
					
					p_rate=rf.readDouble();
					s_rate=rf.readDouble();
					qty=rf.readDouble();
					
					temp=rf.getFilePointer();
					
					System.out.println("temp "+temp);
					
					if(filelength==temp) {
						
						rf.setLength(filelength-(28+stringbyte));
						
						System.out.println("last record deleted ........break ");
						break;
						}
					
					while(true){
						
						   item_code=rf.readInt();
						
							str=rf.readUTF();
							
							p_rate=rf.readDouble();
							s_rate=rf.readDouble();
							qty=rf.readDouble();
						
						readfilepointer=rf.getFilePointer();
						
						System.out.println("readfilepointer "+readfilepointer);
						
						rf.seek(writefilepointer);
						
						rf.writeInt(item_code);
						rf.writeUTF(str);
						rf.writeDouble(p_rate);
						rf.writeDouble(s_rate);
						rf.writeDouble(qty);
						
					writefilepointer=rf.getFilePointer();
					
					System.out.println("writefilepointer "+writefilepointer);
					
					rf.seek(readfilepointer);
					
					if(filelength==readfilepointer){
						
                        rf.seek(writefilepointer);
						
						rf.writeInt(item_code);
						rf.writeUTF(str);
						rf.writeDouble(p_rate);
						rf.writeDouble(s_rate);
						rf.writeDouble(qty);
						
						
						
						rf.setLength(filelength-(stringbyte+28));
						
						System.out.println("new file length "+ (filelength-(stringbyte+28)));
						
						flag=true;
						break;
						
					}
						
						
					}
					
					
					
				} //if end
				
				
				if(flag)
				 break;
				
				rf.readUTF();
				rf.readDouble();
				rf.readDouble();
				rf.readDouble();
				
				if(filelength==readfilepointer) {
					
					System.out.println("filelength==readfilepointer");
					break;}
				
				
				System.out.println("good bye");
				
			} // while block end
			
			}
			
			catch (IOException es){
				
				System.out.println("error in IO");
			}
			
			
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 JFrame jf=new Delete_Record();
		   jf.setTitle("Delete REcord");
		  jf.setSize(700,400);
		  jf.setLocationRelativeTo(null);
		  jf.setVisible(true);
		
	}

}

