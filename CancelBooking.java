import java.io.FileOutputStream;
import java.io.*;
import java.util.*;
import java.util.Date;
import java.sql.*; 
import com.itextpdf.text.*;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
 
public class CancelBooking extends JFrame implements ActionListener, ItemListener{
 
	JLabel l1,l2,l3,l4,l5,l7,l8,l9,l10;
	JTextField t2,t3,t4,t5,t7,t8,t9;
	JButton b1,b2,b3,b4,b5,b7; 
	JComboBox roomno;
    Connection con;
    ResultSet rs;
    Statement st;
    PreparedStatement pst;
	Container c= getContentPane(); 
	static String s;
public CancelBooking()
{
//c.setBackground(new Color(220,220,220));
c.setBackground(Color.white);
c.setLayout(null);
setIconImage(new ImageIcon("team13.jpg").getImage());
setTitle("Team Thirteen LTD.");
//button-bottom
b1 = new JButton("Email: support@team13.bth.se");
b1.setBackground(Color.black);
b1.setBorderPainted(false);
b1.setBounds(0,650,1370,100);
b1.setHorizontalAlignment(SwingConstants.RIGHT);
b1.setEnabled(false);
b3=new JButton("LOGOUT");
b4=new JButton("BACK");
b3.setBackground(new Color(255,51,153));
b3.setForeground(Color.black);
b4.setBackground(new Color(255,51,153));
b4.setForeground(Color.black);
b3.setBounds(1100,120,180,30);
b4.setBounds(900,120,180,30);
b5=new JButton("CANCEL BOOKING");
b5.setBounds(850,510,180,30);
b5.setBackground(new Color(255,51,153));
b5.setForeground(Color.black);
b7=new JButton("GET-PDF");
b7.setBounds(650,510,180,30);
b7.setBackground(new Color(255,51,153));
b7.setForeground(Color.black);
		roomno =new JComboBox();
		addRoomNo();
		roomno.insertItemAt("", 0);
		roomno.setBackground(Color.white);
		roomno.setForeground(Color.black);
		pdf();
		roomno.setBounds(400,200,100,30);
		l10 = new JLabel("SELECT THE ROOM NO. TO CANCEL BOOKING!!");
        l10.setForeground(Color.black);
        l10.setFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 17));
		l10.setBounds(450,150,500,30);
l1 = new JLabel("Room Number");
        l1.setForeground(Color.black);
        l1.setFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 14));
		l1.setBounds(250,200,100,30);
l2 = new JLabel("Room Type");
        l2.setForeground(Color.black);
        l2.setFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 14));
		l2.setBounds(250,280,100,30);
l3 = new JLabel("Name");
        l3.setForeground(Color.black);
        l3.setFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 14));
		l3.setBounds(250,360,100,30);
l4 = new JLabel("Check-In");
        l4.setForeground(Color.black);
        l4.setFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 14));
		l4.setBounds(250,430,100,30);
l5 = new JLabel("Check-Out");
        l5.setForeground(Color.black);
        l5.setFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 14));
		l5.setBounds(700,430,100,30);
l7 = new JLabel("Number of people");
        l7.setForeground(Color.black);
        l7.setFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 14));
		l7.setBounds(700,360,130,30);
l8 = new JLabel("Price");
        l8.setForeground(Color.black);
        l8.setFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 14));
		l8.setBounds(700,200,130,30);
l9 = new JLabel("Services");
        l9.setForeground(Color.black);
        l9.setFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 14));
		l9.setBounds(700,280,130,30);
		
t2= new JTextField();
t2.setBounds(400,280,100,30);
t3= new JTextField();
t3.setBounds(400,360,100,30);
t4= new JTextField();
t4.setBounds(400,430,100,30);
t5= new JTextField();
t5.setBounds(850,430,100,30);
t7= new JTextField();
t7.setBounds(850,360,100,30);
t8= new JTextField();
t8.setBounds(850,200,100,30);
t9= new JTextField();
t9.setBounds(850,280,100,30);

//button-top
b2 = new JButton("TEAM THIRTEEN HOTELS");
b2.setFont(new java.awt.Font("Calibri", java.awt.Font.BOLD,30));
b2.setHorizontalAlignment(SwingConstants.CENTER);
b2.setBackground(Color.black);
b2.setForeground(Color.black);
b2.setBorderPainted(false);
b2.setEnabled(false);
b2.setBounds(0,0,1370,120); 
//bt
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);
b7.addActionListener(this);
roomno.addItemListener(this);
add(b1); add(b2); add(t2);add(t3);add(t4);add(t5);add(l1);add(l2);add(l3);add(l4);add(l10);
add(l5);add(t7);add(l7);add(l8);
add(l9);add(t7);add(t8);add(t9);add(b3);add(b4);add(b5);add(roomno);add(b7);
}
public void pdf()
{ 
try{/* Create Connection objects */
                Class.forName ("oracle.jdbc.driver.OracleDriver"); 
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@jitendra:1521:XE","system","1234");
                Statement stmt = conn.createStatement();
                /* Define the SQL query */
				//String abc= CancelBooking.s;
				//System.out.println(abc);
                ResultSet query_set = stmt.executeQuery("select roomtype,name,people,service,cin,cout,price from bookings where roomno='" + s + "'");
                /* Step-2: Initialize PDF documents - logical objects */
                Document my_pdf_report = new Document();
                PdfWriter.getInstance(my_pdf_report, new FileOutputStream("pdf_Cancel_report.pdf"));
                my_pdf_report.open();            
                //we have four columns in our table
                PdfPTable my_report_table = new PdfPTable(7);
                //create a cell object
				Image image1 = Image.getInstance("team13S.jpg");
				my_pdf_report.add(image1);			
				my_pdf_report.add(new Paragraph("TEAM THIRTEEN HOTELS"));
				my_pdf_report.add(Chunk.NEWLINE);
				my_pdf_report.add(Chunk.NEWLINE);
				my_pdf_report.add(new Paragraph("Dear customer"));
				my_pdf_report.add(new Paragraph("The room reservation with the below details is cancelled!!"));	 
					my_pdf_report.add(Chunk.NEWLINE);   //Something like in HTML :-)
	                my_pdf_report.add(new Paragraph("Document Generated On - "+new Date().toString()));	
					my_pdf_report.add(Chunk.NEWLINE); 
					my_pdf_report.add(Chunk.NEWLINE); 
				PdfPCell table_cell;
				my_report_table.setSpacingBefore(30.0f);       
				      my_report_table.setSpacingAfter(30.0f); 
				my_report_table.addCell("Room Type");
			   my_report_table.addCell("Name");
			   my_report_table.addCell("People");
			   my_report_table.addCell("Service");
			   my_report_table.addCell("Check-in date");
			   my_report_table.addCell("Checkout date");
			   my_report_table.addCell("Price");
			   
                while (query_set.next()) {                
                                String rt = query_set.getString("roomtype");
                                table_cell=new PdfPCell(new Phrase(rt));
                                my_report_table.addCell(table_cell);
                                String n=query_set.getString("name");
                                table_cell=new PdfPCell(new Phrase(n));
                                my_report_table.addCell(table_cell);
                                String ppl=query_set.getString("people");
                                table_cell=new PdfPCell(new Phrase(ppl));
                                my_report_table.addCell(table_cell);
                                String ser=query_set.getString("service");
                                table_cell=new PdfPCell(new Phrase(ser));
                                my_report_table.addCell(table_cell);
								String chi=query_set.getString("cin");
                                table_cell=new PdfPCell(new Phrase(chi));
                                my_report_table.addCell(table_cell);
								String cho=query_set.getString("cout");
                                table_cell=new PdfPCell(new Phrase(cho));
                                my_report_table.addCell(table_cell);
								String pri=query_set.getString("price");
                                table_cell=new PdfPCell(new Phrase(pri));
                                my_report_table.addCell(table_cell);
                                }
                /* Attach report table to PDF */
                my_pdf_report.add(my_report_table);        
				my_pdf_report.newPage(); 
                my_pdf_report.close();
				             
                /* Close all DB related objects */
                query_set.close();
                stmt.close(); 
                conn.close();               
				}
				catch(Exception e)
				{
				System.out.println(e);
				}
}
public void addRoomNo()
{
try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@jitendra:1521:XE","system","1234");
            pst = con.prepareStatement("select roomno from bookings");
			//pst=con.prepareStatement("select roomno from rooms where roomtype='single' and availability= 'yes'");	          
		   rs = pst.executeQuery();
            int i = 0; int count =0;
            while (rs.next()) {
				String no = rs.getString("roomno");
				roomno.addItem(no);
                i++;
            }
            if (i < 1) {
                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (i == 1) {
                System.out.println(i + " Record Found");
            } else {
                System.out.println(i + " Records Found");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println(ex);
        }
}
public void actionPerformed(ActionEvent ae)
{
	if(ae.getSource() == b3)
	{
	//logout
	JOptionPane.showMessageDialog(null,"Logout Successful!");
		 Demo1 d =new Demo1();
		 d.setVisible(true);
		 d.setExtendedState(MAXIMIZED_BOTH);
		 this.setVisible(false);
	}

	if(ae.getSource() == b4)
	{
	//back
	JOptionPane.showMessageDialog(null,"Redirecting to Menu!");
	RoomTable d =new RoomTable();
		 d.setVisible(true);
		 d.setExtendedState(MAXIMIZED_BOTH);
		 this.setVisible(false);
	}
	if(ae.getSource() == b5)
	{
	//Checkout
	try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@jitendra:1521:XE","system","1234");
			 st=con.createStatement();
			 //s= roomno.getSelectedItem().toString().trim();
			String sql="update rooms set availability='yes' where roomno='" + s + "'";
			st.executeUpdate(sql);
			 pst = con.prepareStatement("delete from bookings where roomno='" + s + "'");
			 int a =pst.executeUpdate();
			   if(a>0)
			   {
			   JOptionPane.showMessageDialog(null,"Checkout successful!Redirecting to Menu!");
			   RoomTable d =new RoomTable();
		 d.setVisible(true);
		 d.setExtendedState(MAXIMIZED_BOTH);
		 this.setVisible(false);
			   }
	}
	catch(Exception e)
	{
	System.out.println(e);
	}
	
	}
	if(ae.getSource() == b7)
	{
	//PDF
		pdf();
		 JOptionPane.showMessageDialog(null,"PDF created!! check the home directory for pdf!!");
	}
}
public void itemStateChanged(ItemEvent ie)
{
try{
int i=0;
 s= roomno.getSelectedItem().toString().trim();
		String n = "";
        String rt = "";
		String pn = "";
		String ppl = "";
        String ser = "";
        String ci = "";
		String co = "";
		String pr="";
Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@jitendra:1521:XE","system","1234");
            //pst = con.prepareStatement("select roomno from rooms where roomtype='" + a + "' and availability= 'yes'");
			pst=con.prepareStatement("select roomtype,name,people,service,cin,cout,price from bookings where roomno='" + s + "'");	          
		   rs = pst.executeQuery();
		   while(rs.next())
		   {
            	rt = rs.getString("roomtype");
				n=rs.getString("name");
                ppl = rs.getString("people");
                ser = rs.getString("service");
                ci = rs.getString("cin");
				co =rs.getString("cout");
				pr=rs.getString("price");
				System.out.println(rt+n+ppl+ser+ci+co);
			i++;
			}	
			t2.setText(rt);
			t3.setText(n);
			t7.setText(ppl);
			t9.setText(ser);
			t4.setText(ci);
			t5.setText(co);
			t8.setText(pr);
			}
			catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println(ex);
        }
		}
public static void main(String [] args)
{
CancelBooking d=new CancelBooking();
d.setVisible(true);
d.setExtendedState(MAXIMIZED_BOTH);
d.setTitle("Team Thirteen Ltd.");
}
}