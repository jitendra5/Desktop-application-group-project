import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class LoginDemo extends Frame implements ActionListener
{
    Label l1,l2,l3;
    TextField t1,t2;
    Button b1,b2;
    Connection con;
    Statement st;
    ResultSet rs;
    LoginDemo()
    {
        setLayout(null);
        l1=new Label(" Login Form ");
        l2=new Label(" Enter your User Name :");
        l3=new Label(" Enter your Password :");
        t1=new TextField(40);
        t2=new TextField(40);
        t2.setEchoChar('*');
        b1=new Button("Login");
        b2=new Button("Cancel");
        l1.setBounds(100,40,160,40);
        add(l1);
        l2.setBounds(30,100,160,20);
        l3.setBounds(30,140,160,20);
        add(l2);
        add(l3);
        t1.setBounds(200,100,160,20);
        t2.setBounds(200,140,160,20);
        add(t1);
        add(t2);
        b1.setBounds(50,200,80,40);
        b2.setBounds(220,200,80,40);
        add(b1);
        add(b2);
        setSize(500,400);
        setVisible(true);
        setTitle("Kamlesh Project Demo");
        setBackground(Color.pink);
        setForeground(Color.red);
        Font f=new Font("Arial",Font.BOLD+Font.ITALIC,24);
        l1.setFont(f);
        b1.addActionListener(this);
        b2.addActionListener(this);
        //Close the frame
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent we)
            {
                System.exit(0);
            }
        });
        getDBConnection();
    }
    void getDBConnection()
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
        new LoginDemo();        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            try{String str1=t1.getText();
            String str2=t2.getText();
            st=con.createStatement();
            rs=st.executeQuery("select pwd from login where uname=('"+str1+"')");
            rs.next();
            String s=rs.getString("pwd");
            //Boolean flag=str1.equals(str2);
        if(s.equals(str2))
        JOptionPane.showMessageDialog(null,"Cong. ! match the password","Kamlesh Program Demo",JOptionPane.INFORMATION_MESSAGE);
        else{
        JOptionPane.showMessageDialog(null,"Sorry ! Please  try again."," Kamlesh Program Demo",JOptionPane.WARNING_MESSAGE);
               t1.setText(null);
                                       t2.setText(null);
               }
            }catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource()==b2)
        {
            JOptionPane.showMessageDialog(null,"Thanks for Contacting"," Kamlesh Program Demo",JOptionPane.WARNING_MESSAGE);
            t1.setText(null);
                                           t2.setText(null);
            System.exit(0);
        }
    }
}