import java.sql.*;
import java.lang.*;
public class Conthin
{
 public static void main(String[] args) throws Exception
 {
 Connection conn = null;
 ResultSet rs;
Statement stmt;
String a="jitedra";
String b="555";
String c,d;
 //int i;
 // register jdbc driver
 Class.forName("oracle.jdbc.driver.OracleDriver");
 // in order to use Oracle thin/oci driver
 conn = DriverManager.getConnection("jdbc:oracle:thin:@jitendra:1521:XE", "system","1234");
 stmt =conn.createStatement();
 rs= stmt.executeQuery("select * from login");
 while(rs.next())
 {
 c= rs.getString(1); d= rs.getString(2);
System.out.println(c+" "+d);
 if(a.equals(c))
 System.out.println("login Success");
 else
System.out.println("login failed"); 

 }
 conn.close();
 } 
 }