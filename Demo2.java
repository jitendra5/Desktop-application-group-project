import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Demo2 extends JFrame implements ActionListener
{
Container c= getContentPane(); 
JLabel l1,l2,l3,l4;
int Count=0;
JTextField t1;
JPasswordField p1;
JButton b1,b2,b3,b4;
String u,p,a,b;
Connection con;
Statement stmt;
ResultSet rs;
public Demo2()
{
c.setBackground(new Color(39,33,210));
c.setLayout(null);
setVisible(true);
setTitle("Team Thirteen Ltd.");
setExtendedState(MAXIMIZED_BOTH);
setIconImage(new ImageIcon("hotelicon.png").getImage());
//label1
l1 = new JLabel("Username");
l1.setForeground(Color.white);
l1.setBounds(500,350,100,20);
//label2
l2 = new JLabel("Password");
l2.setForeground(Color.white);
l2.setBounds(500,410,100,20);
//textfield1
t1=new JTextField(20);
t1.setBounds(600,350,150,20);
//Jpasswordfield1
p1 = new JPasswordField(20);
p1.setBounds(600,410,150,20);
//button1
b1 = new JButton("Login");
b1.setBackground(Color.white);
b1.setForeground(Color.black);
b1.setBounds(600,450,100,20);
//button-bottom
b2 = new JButton("Email: support@team13.bth.se");
b2.setBackground(Color.black);
b2.setForeground(Color.white);
b2.setBorderPainted(false);
b2.setBounds(0,650,1370,100);
b2.setHorizontalAlignment(SwingConstants.RIGHT);
b2.setEnabled(false);
//button-top
b3 = new JButton("BLEKINGE HOTEL");
b3.setFont(new Font("Calibri", Font.BOLD,30));
b3.setHorizontalAlignment(SwingConstants.CENTER);
b3.setBackground(Color.black);
b3.setForeground(Color.red);
b3.setBorderPainted(false);
b3.setEnabled(false);
b3.setBounds(0,0,1370,120); 
//button image
b4 = new JButton();
ImageIcon img = new ImageIcon("image.png");
b4.setIcon(img);
b4.setBorderPainted(false);
b4.setBounds(400,150,150,150); 
b4.setBackground(new Color(39,33,210));
//image label
l3 = new JLabel("Team Thirteen Ltd.");
l3.setFont(new Font("Calibri", Font.BOLD,30));
l3.setForeground(Color.white);
l3.setBounds(600,200,300,30);
//image label
l4 = new JLabel("Customer Login");
l4.setFont(new Font("Calibri", Font.BOLD,20));
l4.setForeground(Color.white);
l4.setBounds(600,300,300,30);
add(l1);add(t1);add(l2);add(p1);add(b1); add(b2); add(b3); add(b4); add(l3); add(l4);
b1.addActionListener(this);
DBConnection();
}
void DBConnection()
    {
        try{
            String url="jdbc:oracle:thin:@jitendra:1521:XE";
            String u="system";
            String p="1234";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection(url,u,p);
            System.out.println("Thanks Connected to Oracle");
        }catch(Exception e)
        {    
            System.out.println(e);
        }
    }
	 public static void main(String args[])
    {
        new Demo2();        
    }
	    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
			try
			{
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from first");
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
			}else
			JOptionPane.showMessageDialog(null,"Login Successful!");
	
			}catch(Exception e)
            {
                System.out.println(e);
            }
	}
	}
	}