import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class RoomAvailability extends JFrame
{
JButton b1,b2;
JButton b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14;
JTable table;
JScrollPane sp;
Container c= getContentPane(); 
public RoomAvailability()
{
c.setBackground(new Color(39,33,210));
c.setLayout(null);
setIconImage(new ImageIcon("hotelicon.png").getImage());
//button-bottom
b1 = new JButton("Email: support@team13.bth.se");
b1.setBackground(Color.black);
b1.setBorderPainted(false);
b1.setBounds(0,650,1370,100);
b1.setHorizontalAlignment(SwingConstants.RIGHT);
b1.setEnabled(false);
//button-top
b2 = new JButton();
ImageIcon img1 = new ImageIcon("accor1.png");
b2.setIcon(img1);
//b2.setFont(new Font("Calibri", Font.BOLD,30));
//b2.setHorizontalAlignment(SwingConstants.CENTER);
b2.setBackground(Color.black);
b2.setBorderPainted(false);
//b2.setEnabled(false);
b2.setBounds(0,0,1370,120); 
/*//database connection
Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@jitendra:1521:XE", "system","1234");
	Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
	ResultSet rs=stmt.executeQuery("select * from first");*/
//Jtable
//table.setModel(resultSetToTableModel(rs));
//sp= new JScrollPane(table);
//buttons for room pictures
b3 = new JButton();
ImageIcon img3 = new ImageIcon("single.jpg");
b3.setIcon(img3);
b3.setBounds(50,200,200,120); 
b4 = new JButton();
ImageIcon img4 = new ImageIcon("single_bed.jpg");
b4.setIcon(img4);
b4.setBounds(300,200,200,120); 
b5 = new JButton();
ImageIcon img5 = new ImageIcon("single_balcony.jpg");
b5.setIcon(img5);
b5.setBounds(550,200,200,120); 
b6 = new JButton();
ImageIcon img6 = new ImageIcon("double_room.jpg");
b6.setIcon(img6);
b6.setBounds(800,200,200,120); 
b7 = new JButton();
ImageIcon img7 = new ImageIcon("double_bed.jpg");
b7.setBounds(1050,200,200,120); 
b7.setIcon(img7);
b8 = new JButton();
ImageIcon img8 = new ImageIcon("double_balcony.jpg");
b8.setIcon(img8);
b8.setBounds(50,450,200,120); 
b9 = new JButton();
ImageIcon img9 = new ImageIcon("family_room.jpg");
b9.setIcon(img9);
b9.setBounds(300,450,200,120);
b10 = new JButton();
ImageIcon img10 = new ImageIcon("deluxe_room.jpg");
b10.setIcon(img10);
b10.setBounds(550,450,200,120);
b11 = new JButton();
ImageIcon img11 = new ImageIcon("suite.jpg");
b11.setIcon(img11);
b11.setBounds(800,450,200,120);
b12 = new JButton();
ImageIcon img12 = new ImageIcon("dormitory.jpg");
b12.setIcon(img12);
b12.setBounds(1050,450,200,120);
b13 = new JButton();
b14 = new JButton();
add(b1); add(b2); add(b3);add(b4);add(b5);add(b6);add(b7);add(b8);add(b9);add(b10);add(b11);add(b12);add(b13);add(b14);
}
public static void main(String [] args)
{
RoomAvailability d=new RoomAvailability();
d.setVisible(true);
d.setExtendedState(MAXIMIZED_BOTH);
d.setTitle("Team Thirteen Ltd.");
}
}