import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import java.io.FileOutputStream;
import java.io.*;
import java.util.*;
import java.util.Date;
import com.itextpdf.text.*;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.*;
import javax.swing.table.DefaultTableModel;
 
public class Booking extends JFrame implements ActionListener, ItemListener{
 
	Container c= getContentPane();
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l11,l12,l13,l14,l15;
	JComboBox roomno,ch1,ch2,ch3,ch4,ch5,ch6;
	JTextField t2,t3,t6,t7,t8,t11,t12,t13,t14,t15;
	JCheckBox c1,c2;
	JButton b1,b2,b3,b4,b5,b6; 
	Connection con;
    ResultSet rs;
    Statement st;
    PreparedStatement pst,pstmt; 
	String a= RoomTable.status;
	int j,abc,bd;
	String ca,s;

public Booking()
{
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
b3.setBounds(1200,120,120,30);
b4.setBounds(1000,120,120,30);
b5=new JButton("BOOK");
b5.setBounds(1000,580,180,30);
b5.setBackground(new Color(255,51,153));
b5.setForeground(Color.black);
b6=new JButton("GET-PDF");
b6.setBounds(1000,500,180,30);
b6.setBackground(new Color(255,51,153));
b6.setForeground(Color.black);
System.out.println(a);
l13=new JLabel("Phone No.");
        l13.setForeground(Color.black);
        l13.setFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 14));
		l13.setBounds(700,140,100,30);
l14=new JLabel("email");
        l14.setForeground(Color.black);
        l14.setFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 14));
		l14.setBounds(700,360,100,30);
l15=new JLabel("Address");
        l15.setForeground(Color.black);
        l15.setFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 14));
		l15.setBounds(700,580,100,30);
l1 = new JLabel("Room Number");
        l1.setForeground(Color.black);
        l1.setFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 14));
		l1.setBounds(150,140,100,30);
l2 = new JLabel("Room Type");
        l2.setForeground(Color.black);
        l2.setFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 14));
		l2.setBounds(150,200,100,30);
l3 = new JLabel("Name");
        l3.setForeground(Color.black);
        l3.setFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 14));
		l3.setBounds(150,280,100,30);
l4 = new JLabel("Check-In");
        l4.setForeground(Color.black);
        l4.setFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 14));
		l4.setBounds(150,360,100,30);
l5 = new JLabel("Check-Out");
        l5.setForeground(Color.black);
        l5.setFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 14));
		l5.setBounds(150,430,100,30);
l6 = new JLabel("No. of days");
        l6.setForeground(Color.black);
        l6.setFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 14));
		l6.setBounds(150,500,100,30);
l7 = new JLabel("Number of people");
        l7.setForeground(Color.black);
        l7.setFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 14));
		l7.setBounds(150,580,130,30);
l8 = new JLabel("Price");
        l8.setForeground(Color.black);
        l8.setFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 14));
		l8.setBounds(700,200,130,30);
l9 = new JLabel("Other Services");
        l9.setForeground(Color.black);
        l9.setFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 14));
		l9.setBounds(700,280,130,30);
l11 = new JLabel("Service Charges");
        l11.setForeground(Color.black);
        l11.setFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 14));
		l11.setBounds(700,430,130,30);
l12 = new JLabel("Personal Number");
        l12.setForeground(Color.black);
        l12.setFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 14));
		l12.setBounds(700,500,130,30);		
		roomno =new JComboBox();
		roomno.setBackground(Color.white);
roomno.setForeground(Color.black);
		addRoomNo();
roomno.setBounds(300,140,100,30);
t2= new JTextField();
t2.setBounds(300,200,100,30);
t3= new JTextField();
t3.setBounds(300,280,100,30);
ch1=new JComboBox();
ch1.setBackground(Color.white);
ch1.setForeground(Color.black);
for(j=1;j<31;j++)
ch1.addItem(Integer.toString(j));
ch2=new JComboBox();
ch2.setBackground(Color.white);
ch2.setForeground(Color.black);
for(j=1;j<=12;j++)
ch2.addItem(Integer.toString(j));
ch3=new JComboBox();
ch3.setBackground(Color.white);
ch3.setForeground(Color.black);
for(j=2015;j<=2020;j++)
ch3.addItem(Integer.toString(j));
//t4= new JTextField();
ch1.setBounds(300,360,70,20);
ch2.setBounds(400,360,70,20);
ch3.setBounds(500,360,70,20);
ch4=new JComboBox();
ch4.setBackground(Color.white);
ch4.setForeground(Color.black);
for(j=1;j<31;j++)
ch4.addItem(Integer.toString(j));
ch5=new JComboBox();
ch5.setBackground(Color.white);
ch5.setForeground(Color.black);
for(j=1;j<=12;j++)
ch5.addItem(Integer.toString(j));
ch6=new JComboBox();
ch6.setBackground(Color.white);
ch6.setForeground(Color.black);
for(j=2015;j<=2020;j++)
ch6.addItem(Integer.toString(j));
ch4.setBounds(300,430,70,20);
ch5.setBounds(400,430,70,20);
ch6.setBounds(500,430,70,20);
//t5= new JTextField();
//t5.setBounds(300,430,100,30);
t6= new JTextField();
t6.setBounds(300,500,100,30);
t7= new JTextField();
t7.setBounds(300,580,100,30);
t8= new JTextField();
t8.setBounds(850,200,100,30);
c1=new JCheckBox("SPA");
c1.setBackground(Color.white);
c1.setForeground(Color.black);
c2=new JCheckBox("FOOD");
c2.setBackground(Color.white);
c2.setForeground(Color.black);
c1.setBounds(850,280,100,30);
c2.setBounds(950,280,100,30);
t11= new JTextField();
t11.setBounds(850,430,100,30);
t12= new JTextField();
t12.setBounds(850,500,100,30);
t13= new JTextField();
t13.setBounds(850,140,100,30);
t14= new JTextField();
t14.setBounds(850,360,100,30);
t15= new JTextField();
t15.setBounds(850,580,100,30);
	//date
//button-top
b2 = new JButton("TEAM THIRTEEN HOTELS");
b2.setFont(new java.awt.Font("Calibri", java.awt.Font.BOLD,30));
b2.setHorizontalAlignment(SwingConstants.CENTER);
b2.setBackground(Color.black);
b2.setForeground(Color.white);
b2.setBorderPainted(false);
b2.setEnabled(false);
b2.setBounds(0,0,1370,120); 
//BT 
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);
b6.addActionListener(this);
roomno.addItemListener(this);
ch1.addItemListener(this);ch4.addItemListener(this);
c1.addItemListener(this);c2.addItemListener(this);
add(roomno);add(ch1);add(ch2);add(ch3);add(ch4);add(ch5);add(ch6);
add(b1); add(b2); add(b3);add(b4);add(b5);add(b6);
add(l1);add(l2);add(l3);add(l4);add(l5);add(l6);add(l7);add(l8);add(l9);add(l11);add(l12);add(l13);add(l14);add(l15);
add(t2);add(t3);add(t6);add(t7);add(t8);add(t11);add(t12); add(c1);add(c2);add(t12);add(t13);add(t15);add(t14);
}
public void pdf()
{ 
try{/* Create Connection objects */
                //Class.forName ("oracle.jdbc.driver.OracleDriver"); 
                //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@jitendra:1521:XE","system","1234");
                //Statement stmt = conn.createStatement();
                /* Define the SQL query */
				//String abc= CancelBooking.s;
				//System.out.println(abc);
                //ResultSet query_set = stmt.executeQuery("select roomno,roomtype,name,pno,people,service,cin,cout,price from bookings where roomno='" + s + "'");
                /* Step-2: Initialize PDF documents - logical objects */
                Document my_pdf_report = new Document();
                PdfWriter.getInstance(my_pdf_report, new FileOutputStream("pdf_Reservation_report.pdf"));
                my_pdf_report.open();            
                //we have four columns in our table
                PdfPTable my_report_table = new PdfPTable(9);
                //create a cell object
				Image image1 = Image.getInstance("team13S.jpg");
				my_pdf_report.add(image1);			
				my_pdf_report.add(new Paragraph("TEAM THIRTEEN HOTELS"));
				my_pdf_report.add(Chunk.NEWLINE);
				my_pdf_report.add(Chunk.NEWLINE);
				my_pdf_report.add(new Paragraph("Dear customer"));
				my_pdf_report.add(new Paragraph("The room with the below details is reserved!!"));	 
					my_pdf_report.add(Chunk.NEWLINE);   //Something like in HTML :-)
	                my_pdf_report.add(new Paragraph("Document Generated On - "+new Date().toString()));	
					my_pdf_report.add(Chunk.NEWLINE); 
					my_pdf_report.add(Chunk.NEWLINE); 
				PdfPCell table_cell;
				my_report_table.setSpacingBefore(30.0f);       
				      my_report_table.setSpacingAfter(30.0f); 
				my_report_table.addCell("Room No.");
				my_report_table.addCell("Room Type");
			   my_report_table.addCell("Name");
			   my_report_table.addCell("P.No.");
			   my_report_table.addCell("People");
			   my_report_table.addCell("Service");
			   my_report_table.addCell("Check-in date");
			   my_report_table.addCell("Checkout date");
			   my_report_table.addCell("Price");
			   
                //while (query_set.next()) {                
                                table_cell=new PdfPCell(new Phrase(s));
                                my_report_table.addCell(table_cell);
                                String rt=t2.getText();
                                table_cell=new PdfPCell(new Phrase(rt));
                                my_report_table.addCell(table_cell);
                                String n=t3.getText();
                                table_cell=new PdfPCell(new Phrase(n));
                                my_report_table.addCell(table_cell);
                                String pn=t12.getText();
                                table_cell=new PdfPCell(new Phrase(pn));
                                my_report_table.addCell(table_cell);
								String ppl=t7.getText();
                                table_cell=new PdfPCell(new Phrase(ppl));
                                my_report_table.addCell(table_cell);
								String ser=t11.getText();
                                table_cell=new PdfPCell(new Phrase(ser));
                                my_report_table.addCell(table_cell);
								String chi=ch1.getSelectedItem().toString()+"/"+ch2.getSelectedItem().toString()+"/"+ch3.getSelectedItem().toString();
                                table_cell=new PdfPCell(new Phrase(chi));
                                my_report_table.addCell(table_cell);
								String cho=ch4.getSelectedItem().toString()+"/"+ch5.getSelectedItem().toString()+"/"+ch6.getSelectedItem().toString();
                                table_cell=new PdfPCell(new Phrase(cho));
                                my_report_table.addCell(table_cell);
								String pri=t8.getText();
                                table_cell=new PdfPCell(new Phrase(pri));
                                my_report_table.addCell(table_cell);
                                
                /* Attach report table to PDF */
                my_pdf_report.add(my_report_table);        
				my_pdf_report.newPage(); 
                my_pdf_report.close();
				             
                /* Close all DB related objects */
                //query_set.close();
                //stmt.close(); 
                //conn.close();               
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
            pst = con.prepareStatement("select roomno from rooms where roomtype='" + a + "' and availability= 'yes'");
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
public void itemStateChanged(ItemEvent ie)
{
try{
int i=0;
 s= roomno.getSelectedItem().toString();

if(c1.isSelected()&&c2.isSelected()) {
  t11.setText("SPA,FOOD");
  System.out.println("c1 is selected");
}  else if(c1.isSelected()){
  t11.setText("SPA");
  System.out.println("c1 and c2 are selected");
}else if(c2.isSelected())
 t11.setText("FOOD");
else
t11.setText("No Services Selected");

//date
abc=Integer.parseInt(ch1.getSelectedItem().toString());
		bd=Integer.parseInt(ch4.getSelectedItem().toString());
		ca=Integer.toString(bd-abc);
		System.out.println(abc+bd);
		t6.setText(ca);	
	String rn = "";
        String rt = "";
        String c = "";
        String p = "";
		String a = "";
Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@jitendra:1521:XE","system","1234");
            //pst = con.prepareStatement("select roomno from rooms where roomtype='" + a + "' and availability= 'yes'");
			pst=con.prepareStatement("select roomtype,cost,people, availability from rooms where roomno='" + s + "'");	          
		   rs = pst.executeQuery();
		   while(rs.next())
		   {
            	rt = rs.getString("roomtype");
                c = rs.getString("cost");
                p = rs.getString("people");
                a = rs.getString("availability");
				System.out.println(rt+c+p+a);
			i++;
			}	
			t2.setText(rt);
			t7.setText(p);
			t8.setText(c);
			}
			catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println(ex);
        }
		//date
		
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
	JOptionPane.showMessageDialog(null,"Redirecting to main Menu!");
	RoomTable d =new RoomTable();
		 d.setVisible(true);
		 d.setExtendedState(MAXIMIZED_BOTH);
		 this.setVisible(false);
	}
	if(ae.getSource() == b5)
	{
	if(t3.getText().equals("")||t13.getText().equals("")||t14.getText().equals("")||t12.getText().equals("")||t15.getText().equals(""))
	{
	JOptionPane.showMessageDialog(null,"Please fill all the details!");
	}
	else{
	try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@jitendra:1521:XE","system","1234");
            pstmt = con.prepareStatement("insert into booking(roomno,roomtype,name,pno,people,service,cin,cout,price,phno,email,address) values(?,?,?,?,?,?,?,?,?,?,?,?)");
			String rtyp= t2.getText().trim();
			String nme= t3.getText().trim();
			String pn= t12.getText().trim();
			String ppl= t7.getText().trim();
			String ser= t11.getText().trim();
			String pric= t8.getText().trim();
			String ph=t13.getText().trim();
			String em=t14.getText().trim();
			String add=t15.getText().trim();
			String ci=ch1.getSelectedItem().toString()+"/"+ch2.getSelectedItem().toString()+"/"+ch3.getSelectedItem().toString();
			String co= ch4.getSelectedItem().toString()+"/"+ch5.getSelectedItem().toString()+"/"+ch6.getSelectedItem().toString();
			pstmt.setString(1,s);
			pstmt.setString(2,rtyp);
			pstmt.setString(3,nme);
			pstmt.setString(4,pn);
			pstmt.setString(5,ppl);
			pstmt.setString(6,ser);
			pstmt.setString(7,ci);
			pstmt.setString(8,co);	
			pstmt.setString(9,pric);
			pstmt.setString(10,ph);
			pstmt.setString(11,em);
			pstmt.setString(12,add);
			int k= pstmt.executeUpdate();
			if(k>0)
		   System.out.println("record inserted into booking!!!");
	//JOptionPane.showMessageDialog(null,"Booking Successful!!Redirecting to Menu!");
			 }
		 catch (Exception e)
		 {
		 System.out.println(e);
		 }
	try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@jitendra:1521:XE","system","1234");
            pstmt = con.prepareStatement("insert into bookings(roomno,roomtype,name,pno,people,service,cin,cout,price,phno,email,address) values(?,?,?,?,?,?,?,?,?,?,?,?)");
			String rtyp= t2.getText().trim();
			String nme= t3.getText().trim();
			String pn= t12.getText().trim();
			String ppl= t7.getText().trim();
			String ser= t11.getText().trim();
			String pric= t8.getText().trim();
			String ph=t13.getText().trim();
			String em=t14.getText().trim();
			String add=t15.getText().trim();
			String ci=ch1.getSelectedItem().toString()+"/"+ch2.getSelectedItem().toString()+"/"+ch3.getSelectedItem().toString();
			String co= ch4.getSelectedItem().toString()+"/"+ch5.getSelectedItem().toString()+"/"+ch6.getSelectedItem().toString();
			pstmt.setString(1,s);
			pstmt.setString(2,rtyp);
			pstmt.setString(3,nme);
			pstmt.setString(4,pn);
			pstmt.setString(5,ppl);
			pstmt.setString(6,ser);
			pstmt.setString(7,ci);
			pstmt.setString(8,co);	
			pstmt.setString(9,pric);
			pstmt.setString(10,ph);
			pstmt.setString(11,em);
			pstmt.setString(12,add);
			int k= pstmt.executeUpdate();
			Statement stmt=con.createStatement();
			String sql="update rooms set availability='no' where roomno='" + s + "'";
			stmt.executeUpdate(sql);
		   if(k>0)
		   System.out.println("record inserted");
	JOptionPane.showMessageDialog(null,"Booking Successful!!Redirecting to Menu!");
	RoomTable d =new RoomTable();
		 d.setVisible(true);
		 d.setExtendedState(MAXIMIZED_BOTH);
		 this.setVisible(false);
		 }
		 catch (Exception e)
		 {
		 System.out.println(e);
		 }
	}
	}
	if(ae.getSource()==b6)
	{
	//PDF
		pdf();
		 JOptionPane.showMessageDialog(null,"PDF created!! check the home directory for pdf!!");
	}
}
public static void main(String [] args)
{
Booking d=new Booking();
d.setVisible(true);
d.setExtendedState(MAXIMIZED_BOTH);
d.setTitle("Team Thirteen Ltd.");
}
}