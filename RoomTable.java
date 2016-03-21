import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
 
public class RoomTable extends JFrame implements ActionListener {
	Container c= getContentPane(); 
    JFrame frame1,frame2;
    JButton b1, b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15;
	JButton b16,b17,b18,b19,b20,b21,b22,b23,b24,b25,b26,b27,b28,b29;
	JLabel l1;
    Connection con;
    ResultSet rs, rs1;
    Statement st, st1;
    PreparedStatement pst;
    String ids;
    static JTable table,table1;
    String[] columnNames = {"roomno", "roomtype", "cost", "people", "availability"};
	String[] columnNames1 = {"roomno", "roomtype", "name","pno","people","cin", "cout","phno", "email","address"};
	String from;
	static String status;
 
   public RoomTable() {
	c.setBackground(Color.white);
		setIconImage(new ImageIcon("team13.jpg").getImage());
        l1 = new JLabel("CLICK ON THE IMAGE FOR ROOM AVAILABILITY");
        l1.setForeground(Color.black);
        l1.setFont(new Font("Serif", Font.BOLD, 17));
		b1 = new JButton("single");
		b2 = new JButton("singlewithbed");
		b3 = new JButton("singlewithbalcony");
		b4 = new JButton("double");
		b5 = new JButton("doublewithbed");
		b6 = new JButton("doublewithbalcony");
		b7 = new JButton("family");
		b8 = new JButton("deluxe");
		b9 = new JButton("suite");
		b10 = new JButton("dormatory");
		b13= new JButton("LOGOUT");
		b13.setBackground(new Color(255,51,153));
		b13.setForeground(Color.black);
		b14= new JButton("CHECKOUT");
		b14.setBackground(new Color(255,51,153));
b14.setForeground(Color.black);
		b15=new JButton("MODIFY STAFF");
		b15.setBackground(new Color(255,51,153));
b15.setForeground(Color.black);
		b16= new JButton("single");
		b16.setBackground(Color.white);
b16.setForeground(Color.black);
		b17= new JButton("singlewithbed");
		b17.setBackground(Color.white);
b17.setForeground(Color.black);
		b18= new JButton("singlewithbalcony");
		b18.setBackground(Color.white);
b18.setForeground(Color.black);
		b19= new JButton("double");
		b19.setBackground(Color.white);
b19.setForeground(Color.black);
		b20= new JButton("doublewithbed");
		b20.setBackground(Color.white);
b20.setForeground(Color.black);
		b21= new JButton("doublewithbalcony");
		b21.setBackground(Color.white);
b21.setForeground(Color.black);
		b22= new JButton("family");
		b22.setBackground(Color.white);
b22.setForeground(Color.black);
		b23= new JButton("deluxe");
		b23.setBackground(Color.white);
b23.setForeground(Color.black);
		b24= new JButton("suite");
		b24.setBackground(Color.white);
b24.setForeground(Color.black);
		b25= new JButton("dormatory");
		b25.setBackground(Color.white);
b25.setForeground(Color.black);
		b26= new JButton("CHECK STATUS");
		b26.setBackground(new Color(255,51,153));
b26.setForeground(Color.black);
		b27= new JButton("UPDATE DETAILS");
b27.setBackground(new Color(255,51,153));
b27.setForeground(Color.black);	
	b28=new JButton("CANCEL BOOKING");
	b28.setBackground(new Color(255,51,153));
b28.setForeground(Color.black);
b29=new JButton("HISTORY");
	b29.setBackground(new Color(255,51,153));
b29.setForeground(Color.black);
		b16.setBounds(100,360,200,20);
		b17.setBounds(350,360,200,20);
		b18.setBounds(600,360,200,20);
		b19.setBounds(850,360,200,20);
		b20.setBounds(1100,360,200,20);
		b21.setBounds(100,600,200,20);
		b22.setBounds(350,600,200,20);
		b23.setBounds(600,600,200,20);
		b24.setBounds(850,600,200,20);
		b25.setBounds(1100,600,200,20);
        //l0.setBounds(100, 50, 350, 40);
        l1.setBounds(450, 120, 500, 120);
        b1.setBounds(100, 200, 200, 150);
		b13.setBounds(1200,120,150,30);
		b14.setBounds(1000,120,150,30);
		b15.setBounds(800,120,150,30);
		b26.setBounds(600,120,150,30);
		b27.setBounds(400,120,150,30);
		b28.setBounds(200,120,150,30);
		b29.setBounds(10,120,150,30);
//button-bottom
b11 = new JButton("Email: support@team13.bth.se");
b11.setBackground(Color.black);
b11.setForeground(Color.white);
b11.setBorderPainted(false);
b11.setBounds(0,650,1370,100);
b11.setHorizontalAlignment(SwingConstants.RIGHT);
b11.setEnabled(false);
//button-top
b12 = new JButton("TEAM THIRTEEN HOTELS");
b12.setFont(new Font("Calibri", Font.BOLD,30));
b12.setHorizontalAlignment(SwingConstants.CENTER);
b12.setBackground(Color.black);
b12.setForeground(Color.black);
b12.setBorderPainted(false);
b12.setEnabled(false);
b12.setBounds(0,0,1370,120); 
		ImageIcon img1 = new ImageIcon("single.jpg");
		b1.setIcon(img1);
		b2.setBounds(350, 200, 200, 150);
		ImageIcon img2 = new ImageIcon("single_bed.jpg");
		b2.setIcon(img2);
		b3.setBounds(600, 200, 200, 150);
		ImageIcon img3 = new ImageIcon("single_balcony.jpg");
		b3.setIcon(img3);
		b4.setBounds(850, 200, 200, 150);
		ImageIcon img4 = new ImageIcon("double_room.jpg");
		b4.setIcon(img4);
		b5.setBounds(1100, 200, 200, 150);
		ImageIcon img5 = new ImageIcon("double_bed.jpg");
		b5.setIcon(img5);
		b6.setBounds(100, 440, 200, 150);
		ImageIcon img6 = new ImageIcon("double_balcony.jpg");
		b6.setIcon(img6);
		b7.setBounds(350, 440, 200, 150);
		ImageIcon img7 = new ImageIcon("family_room.jpg");
		b7.setIcon(img7);
		b8.setBounds(600, 440, 200, 150);
		ImageIcon img8 = new ImageIcon("deluxe_room.jpg");
		b8.setIcon(img8);
		b9.setBounds(850, 440, 200, 150);
		ImageIcon img9 = new ImageIcon("suite.jpg");
		b9.setIcon(img9);
		b10.setBounds(1100, 440, 200, 150);
		ImageIcon img10 = new ImageIcon("dormitory.jpg");
		b10.setIcon(img10);
        b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b10.addActionListener(this);
		b13.addActionListener(this);
		b14.addActionListener(this);
		b15.addActionListener(this);
		b16.addActionListener(this);
		b17.addActionListener(this);
		b18.addActionListener(this);
		b19.addActionListener(this);
		b20.addActionListener(this);
		b21.addActionListener(this);
		b22.addActionListener(this);
		b23.addActionListener(this);
		b24.addActionListener(this);
		b25.addActionListener(this);
		b26.addActionListener(this);
		b27.addActionListener(this);
		b28.addActionListener(this);
		b29.addActionListener(this);
        setTitle("Team Thirteen LTD.");
        setLayout(null);
        setVisible(true);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
 
        add(l1);add(b16);add(b17);add(b18);add(b19);add(b20);
        add(b21);add(b22);add(b23);add(b24);add(b25);add(b29);
        add(b1);add(b2);add(b3);add(b4);add(b5);add(b6);add(b7);add(b8);add(b9);
		add(b10);add(b11);add(b12);add(b13);add(b14);add(b15);add(b26);add(b27);add(b28);
        
    }
 
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1||ae.getSource() == b2||ae.getSource() == b3||ae.getSource() == b4||ae.getSource() == b5||ae.getSource() == b6||ae.getSource() == b7||ae.getSource() == b8||ae.getSource() == b9||ae.getSource() == b10) {
            from = ae.getActionCommand().toString().trim();
			System.out.println(ae.getActionCommand());
			showTableData();
        }
		if (ae.getSource() == b16||ae.getSource() == b17||ae.getSource() == b18||ae.getSource() == b19||ae.getSource() == b20||ae.getSource() == b21||ae.getSource() == b22||ae.getSource() == b23||ae.getSource() == b24||ae.getSource() == b25) {
            status = ae.getActionCommand().toString().trim();
			System.out.println(ae.getActionCommand());
			Booking d =new Booking();
		 d.setVisible(true);
		 d.setExtendedState(MAXIMIZED_BOTH);
		 this.setVisible(false);
			//showTableData();
        }
		 if(ae.getSource()==b13)
		 {
		 JOptionPane.showMessageDialog(null,"Logout Successful!");
		 Demo1 d =new Demo1();
		 d.setVisible(true);
		 d.setExtendedState(MAXIMIZED_BOTH);
		 this.setVisible(false);
		 }
		 if(ae.getSource()==b14)
		 {
		 //JOptionPane.showMessageDialog(null,"Logout Successful!");
		 CheckOut d1 =new CheckOut();
		 d1.setVisible(true);
		 d1.setExtendedState(MAXIMIZED_BOTH);
		 this.setVisible(false);
		 }
		 if(ae.getSource()==b15)
		 {
		 //JOptionPane.showMessageDialog(null,"Logout Successful!");
		 Register d2 =new Register();
		 d2.setVisible(true);
		 d2.setExtendedState(MAXIMIZED_BOTH);
		 this.setVisible(false);
		 }
		 if(ae.getSource()==b26)
		 {
		 //JOptionPane.showMessageDialog(null,"Logout Successful!");
		 CheckStatus d3 =new CheckStatus();
		 d3.setVisible(true);
		 d3.setExtendedState(MAXIMIZED_BOTH);
		 this.setVisible(false);
		 }
		 if(ae.getSource()==b27)
		 {
		 //JOptionPane.showMessageDialog(null,"Logout Successful!");
		 UpdateDetails d4 =new UpdateDetails();
		 d4.setVisible(true);
		 d4.setExtendedState(MAXIMIZED_BOTH);
		 this.setVisible(false);
		 }
		if(ae.getSource()==b28)
		 {
		 //JOptionPane.showMessageDialog(null,"Logout Successful!");
		 CancelBooking d5 =new CancelBooking();
		 d5.setVisible(true);
		 d5.setExtendedState(MAXIMIZED_BOTH);
		 this.setVisible(false);
		 }
		 if(ae.getSource()==b29)
		 {
		 showHistoryTable();
		 }
    }
	public void showHistoryTable() {
 
        frame2 = new JFrame("Booking History");
        //frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setLayout(new BorderLayout());
        DefaultTableModel model1 = new DefaultTableModel();
        model1.setColumnIdentifiers(columnNames1);
        table1 = new JTable();
        table1.setModel(model1);
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table1.setFillsViewportHeight(true);
        JScrollPane scroll1 = new JScrollPane(table1);
        scroll1.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll1.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	//String[] columnNames1 = {"roomno", "roomtype", "name","pno","people","cin", "cout","phno", "email","address"};
        String rn = "";
        String rt = "";
        String n = "";
        String pn = "";
		String ppl= "";
		String ci= "";
		String co= "";
		String ph= "";
		String em= "";
		String add= "";
        try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@jitendra:1521:XE","system","1234");
            pst = con.prepareStatement("select * from booking");
				          
		   ResultSet rs = pst.executeQuery();
            int i = 0; int count =0;
            while (rs.next()) {
				rn= rs.getString("roomno");
                rt = rs.getString("roomtype");
                n = rs.getString("name");
                pn = rs.getString("pno");
                ppl = rs.getString("people");
				ci = rs.getString("cin");
				co = rs.getString("cout");
				ph = rs.getString("phno");
				em = rs.getString("email");
				add = rs.getString("address");
                model1.addRow(new Object[]{rn, rt, n,pn,ppl,ci,co,ph,em,add});
				count++;
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
        frame2.add(scroll1);
        frame2.setVisible(true);
        frame2.setSize(400, 300);
    }
 
    public void showTableData() {
 
        frame1 = new JFrame("Room Availability");
        //frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new BorderLayout());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        String r = "";
        String c = "";
        String p = "";
        String a = "";
		String rm= "";
 
        try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@jitendra:1521:XE","system","1234");
            pst = con.prepareStatement("select * from rooms where roomtype='" + from + "'");
				          
		   ResultSet rs = pst.executeQuery();
            int i = 0; int count =0;
            while (rs.next()) {
				rm= rs.getString("roomno");
                r = rs.getString("roomtype");
                c = rs.getString("cost");
                p = rs.getString("people");
                a = rs.getString("availability");
                model.addRow(new Object[]{rm, r, c, p, a});
				count++;
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
        frame1.add(scroll);
        frame1.setVisible(true);
        frame1.setSize(400, 300);
    }
 
    public static void main(String args[]) {
        new RoomTable();
    }
}