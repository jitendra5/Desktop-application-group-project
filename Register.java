import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
 
public class Register extends JFrame implements ActionListener{
 
	JLabel l1,l2,l3;
	JTextField t1;
	JPasswordField t2;
	JButton b1,b2,b3,b4,b5,b6;
	String u,p;	
    //Connection con;
    //ResultSet rs, rs1;
    //Statement st, st1;
    //PreparedStatement pst;
	Container c= getContentPane(); 
public Register()
{
//c.setBackground(new Color(220,220,220));
c.setBackground(Color.white);
c.setLayout(null);
setTitle("Team Thirteen LTD.");
setIconImage(new ImageIcon("team13.jpg").getImage());
//button-bottom
b1 = new JButton("Email: support@team13.bth.se");
b1.setBackground(Color.black);
b1.setBorderPainted(false);
b1.setBounds(0,650,1370,100);
b1.setHorizontalAlignment(SwingConstants.RIGHT);
b1.setEnabled(false);
//button-top
b2 = new JButton("TEAM THIRTEEN HOTELS");
b2.setFont(new Font("Calibri", Font.BOLD,30));
b2.setHorizontalAlignment(SwingConstants.CENTER);
b2.setBackground(Color.black);
b2.setForeground(Color.black);
b2.setBorderPainted(false);
b2.setEnabled(false);
b2.setBounds(0,0,1370,120); 
b3=new JButton("LOGOUT");
b4=new JButton("BACK");
b3.setBackground(new Color(255,51,153));
b3.setForeground(Color.black);
b4.setBackground(new Color(255,51,153));
b4.setForeground(Color.black);
b3.setBounds(1100,120,180,30);
b4.setBounds(900,120,180,30);
b5=new JButton("REGISTER");
b5.setBounds(700,500,180,30);
b5.setBackground(new Color(255,51,153));
b5.setForeground(Color.black);
b6=new JButton("UNREGISTER");
b6.setBackground(new Color(255,51,153));
b6.setForeground(Color.black);
b6.setBounds(500,500,180,30);
l1 = new JLabel("User-Name");
        l1.setForeground(Color.black);
        l1.setFont(new Font("Serif", Font.BOLD, 14));
		l1.setBounds(550,300,100,30);
l2 = new JLabel("Password");
        l2.setForeground(Color.black);
        l2.setFont(new Font("Serif", Font.BOLD, 14));
		l2.setBounds(550,400,100,30);
l3 = new JLabel("ADD A NEW EMPLOYEE OR DELETE AN EXISTING EMPLOYEE!");
        l3.setForeground(Color.black);
        l3.setFont(new Font("Serif", Font.BOLD, 17));
		l3.setBounds(400,200,600,30);
t1= new JTextField();
t1.setBounds(700,300,100,30);
t2= new JPasswordField();
t2.setBounds(700,400,100,30);
b5.addActionListener(this);
b3.addActionListener(this);b4.addActionListener(this);b6.addActionListener(this);
add(b1);add(b2);add(b3);add(b4);add(b5);add(l1);add(l2);add(t1);add(t2);add(l3);add(b6);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b3)
{
//logout
JOptionPane.showMessageDialog(null,"Logout Successful!");
		 Demo1 d =new Demo1();
		 d.setVisible(true);
		 d.setExtendedState(MAXIMIZED_BOTH);
		 this.setVisible(false);
}
if(ae.getSource()==b4)
{
//back
JOptionPane.showMessageDialog(null,"Redirecting to Menu!");
	RoomTable d =new RoomTable();
		 d.setVisible(true);
		 d.setExtendedState(MAXIMIZED_BOTH);
		 this.setVisible(false);
}
if(ae.getSource()==b5)
{
if(t1.getText().equals("")||t2.getText().equals(""))
{
JOptionPane.showMessageDialog(null,"Please fill the UserID/password!");
}
else
{
u= t1.getText();
p= t2.getText();
System.out.println(u+p);
//Register
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@jitendra:1521:XE", "system","1234");
	PreparedStatement stmt=con.prepareStatement("insert into first(uname, pwd) values(?, ?)");
	//ResultSet rs=stmt.executeUpdate("insert into first(uname, pwd) values(?, ?)");
	//stmt.setInt(1, id);
stmt.setString(1, u);
stmt.setString(2, p); 
stmt.executeUpdate();
JOptionPane.showMessageDialog(null,"Record Inserted!");
}
catch(Exception e){System.out.println(e);}
}	
}
if(ae.getSource()==b6)
{
u= t1.getText().trim().toString();
p= t2.getText();
System.out.println(u+p);
//Register
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@jitendra:1521:XE", "system","1234");
	PreparedStatement stmt=con.prepareStatement("delete from first where uname='" + u + "'");
	stmt.executeQuery();
JOptionPane.showMessageDialog(null,"Record Deleted!");
t1.setText("");
t2.setText("");
}
catch(Exception e){System.out.println(e);}	
}

}
public static void main(String [] args)
{
Register d=new Register();
d.setVisible(true);
d.setExtendedState(MAXIMIZED_BOTH);
d.setTitle("Team Thirteen Ltd.");
}
}