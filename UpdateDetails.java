import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class UpdateDetails extends JFrame implements ActionListener, ItemListener
{
Container c= getContentPane(); 
JLabel l1,l2,l3,l4,l5,l8,l6;
JTextField t2,t3,t4,t5,t6;
JComboBox c1;
JButton b1,b2,b3,b4,b5;
String u,p,a,b;
Connection con;
    ResultSet rs;
    Statement st;
    PreparedStatement pst;	
	String s;
public UpdateDetails()
{
//c.setBackground(new Color(220,220,220));
c.setBackground(Color.white);
c.setLayout(null);
setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
setIconImage(new ImageIcon("team13.jpg").getImage());
setTitle("Team Thirteen LTD.");
l8=new JLabel("SELECT THE PERSONAL NO. TO UPDATE THE CUSTOMER DETAILS!");
l8.setForeground(Color.black);
l8.setFont(new Font("Serif", Font.BOLD, 17));
l8.setBounds(400,200,700,30);
l1=new JLabel("Personal NO:");
l1.setBounds(250,280,100,30);
l2=new JLabel("Name:");
l2.setBounds(250,360,100,30);
l3=new JLabel("Address:");
l3.setBounds(250,430,100,30);
l4=new JLabel("PhoneNo:");
l4.setBounds(250,510,100,30);
l5=new JLabel("Services:");
l5.setBounds(700,360,100,30);
l6=new JLabel("Email:");
l6.setBounds(700,430,100,30);
t2=new JTextField();
t2.setBounds(400,360,100,30);
t3=new JTextField();
t3.setBounds(400,430,100,30);
t4=new JTextField();
t4.setBounds(400,510,100,30);
t5=new JTextField();
t5.setBounds(850,360,100,30);
t6=new JTextField();
t6.setBounds(850,430,100,30);
		c1 =new JComboBox();
		addPersonalNo();
		c1.insertItemAt("", 0);
		c1.setBackground(Color.white);
c1.setForeground(Color.black);
		c1.setBounds(400,280,100,30);
		//button1
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
b3.setFont(new Font("Calibri", Font.BOLD,30));
b3.setHorizontalAlignment(SwingConstants.CENTER);
b3.setBackground(Color.black);
b3.setForeground(Color.black);
b3.setBorderPainted(false);
b3.setEnabled(false);
b3.setBounds(0,0,1370,120); 
//bt
b4=new JButton("BACK");
b4.setBackground(new Color(255,51,153));
b4.setForeground(Color.black);
b5=new JButton("LOGOUT");
b5.setBackground(new Color(255,51,153));
b5.setForeground(Color.black);
b1=new JButton("UPDATE");
b1.setBackground(new Color(255,51,153));
b1.setForeground(Color.black);
b1.setBounds(700,500,180,30);
b5.setBounds(1100,120,180,30);
b4.setBounds(900,120,180,30);
b4.addActionListener(this);
b1.addActionListener(this);
b5.addActionListener(this);
c1.addItemListener(this);
add(l1);add(l2); add(l3); add(l4);add(l5); add(l6);
add(t2);add(t3); add(t4); add(t5); add(t6);
 add(b1);add(b2); add(b3); add(b4);add(c1);add(b5);add(l8);
}
public void addPersonalNo()
{
try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@jitendra:1521:XE","system","1234");
            pst = con.prepareStatement("select pno from bookings");
			//pst=con.prepareStatement("select roomno from bookings where roomtype='single' and availability= 'yes'");	          
		   rs = pst.executeQuery();
            int i = 0; int count =0;
            while (rs.next()) {
				String no = rs.getString("pno");
				c1.addItem(no);
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
 s= c1.getSelectedItem().toString().trim();
		String n = "";
        String ser = "";
		String add= "";
		String phn="";
		String em="";
        Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@jitendra:1521:XE","system","1234");
            //pst = con.prepareStatement("select roomno from rooms where roomtype='" + a + "' and availability= 'yes'");
			pst=con.prepareStatement("select name,service,address,email,phno from bookings where pno='" + s + "'");	          
		   rs = pst.executeQuery();
		   while(rs.next())
		   {
            	n=rs.getString("name");
                ser = rs.getString("service");
				add = rs.getString("address");
				em = rs.getString("email");
				phn = rs.getString("phno");
                i++;
			}	
			t2.setText(n);
			t5.setText(ser);
			t6.setText(em);
			t3.setText(add);
			t4.setText(phn);
			}
			catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println(ex);
        }
}
public void actionPerformed(ActionEvent ae)
{

if(ae.getSource() == b5)
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
	if(ae.getSource()==b1)
	{
	String nam=t2.getText();
	String ser=t5.getText();
	String add=t3.getText();
	String em=t6.getText();
	String ph=t4.getText();
	try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@jitendra:1521:XE","system","1234");
           
			 st=con.createStatement();
			 String sql="update bookings set name='"+ nam +"',service='"+ ser +"',address='"+ add +"',email='"+ em +"',phno='"+ ph +"' where pno='" + s + "'";
			int a =st.executeUpdate(sql);
			  if(a>0)
			   {
			   JOptionPane.showMessageDialog(null,"Updating successful!Redirecting to Menu!");
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
}
public static void main(String[] args)
{
UpdateDetails d=new UpdateDetails();
//d.setSize(800,500);
d.setVisible(true);
d.setExtendedState(MAXIMIZED_BOTH);
}
}