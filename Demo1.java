import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Demo1 extends JFrame implements ActionListener
{
Container c= getContentPane(); 
JLabel l1,l2,l3,l4;
int Count=0;
JTextField t1;
JPasswordField p1;
JButton b1,b2,b3,b4;
String u,p,a,b;
//Static Connection con;
//Static Statement stmt;
//Static ResultSet rs;
public Demo1()
{
c.setBackground(Color.white);
c.setLayout(null);
setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
setIconImage(new ImageIcon("team13.jpg").getImage());
setTitle("Team Thirteen LTD.");
//label1
l1 = new JLabel("Username");
l1.setForeground(Color.black);
l1.setBounds(600,350,100,20);
//label2
l2 = new JLabel("Password");
l2.setForeground(Color.black);
l2.setBounds(600,410,100,20);
//textfield1
t1=new JTextField(20);
t1.setBounds(700,350,150,20);
//Jpasswordfield1
p1 = new JPasswordField(20);
p1.setBounds(700,410,150,20);
//button1
b1 = new JButton("Login");
b1.setBackground(Color.white);
b1.setForeground(Color.black);
b1.setBounds(700,450,100,20);
//button-bottom
b2 = new JButton("Email: support@team13.bth.se");
b2.setBackground(Color.black);
b2.setForeground(Color.white);
b2.setBorderPainted(false);
b2.setBounds(0,650,1370,100);
b2.setHorizontalAlignment(SwingConstants.RIGHT);
b2.setEnabled(false);
//button-top
b3 = new JButton("TEAM THIRTEEN HOTELS");
b3.setForeground(Color.white);
b3.setFont(new Font("Calibri", Font.BOLD,30));
b3.setHorizontalAlignment(SwingConstants.CENTER);
b3.setBackground(Color.black);
b3.setForeground(Color.black);
b3.setBorderPainted(false);
b3.setEnabled(false);
b3.setBounds(0,0,1370,120); 
//bt
b4 = new JButton();
ImageIcon img = new ImageIcon("team13.jpg");
b4.setIcon(img);
b4.setBorderPainted(false);
b4.setBounds(200,180,300,300); 
//b4.setBackground(new Color(220,220,220));
//image label
l3 = new JLabel("Team Thirteen Ltd.");
l3.setFont(new Font("Calibri", Font.BOLD,30));
l3.setForeground(Color.black);
l3.setBounds(600,200,300,30);
//image label
l4 = new JLabel("Customer Login");
l4.setFont(new Font("Calibri", Font.BOLD,20));
l4.setForeground(Color.black);
l4.setBounds(700,300,300,30);
b1.addActionListener(this);
add(l1);add(t1);add(l2);add(p1);add(b1); add(b2); add(b3); add(b4); add(l3); add(l4);

}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
//u= t1.getText();
//p= p1.getText();
//System.out.println(u+p);
	try
	{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@jitendra:1521:XE", "system","1234");
	Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
	ResultSet rs=stmt.executeQuery("select * from first");
	u= t1.getText().trim();
	p= p1.getText().trim();
	//System.out.println(u+p);
	while(rs.next())
	{
	a=rs.getString(1).trim();
	b=rs.getString(2).trim();
	System.out.println(a+" "+b);
	if(u.equals(a)&&p.equals(b))
		Count++;
		//con.close();
	}//while close
	if(Count==0)
	{
	JOptionPane.showMessageDialog(null,"Login Unsuccessful!");
	t1.setText(null);p1.setText(null);
	}
	else
	{
	JOptionPane.showMessageDialog(null,"Login Successful!");
	new RoomTable();
	this.setVisible(false);
	}
	}
	catch(Exception e){}
}
}
public static void main(String[] args)
{
Demo1 d=new Demo1();
//d.setSize(800,500);
d.setVisible(true);
d.setExtendedState(MAXIMIZED_BOTH);
}
}