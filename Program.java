import java.sql.*;
import java.io.*;
   class Program  {
                               public static void main(String[] args)throws Exception  {
                               Connection conn;
                               Statement stmt;
                               ResultSet rs;
                               Class.forName("oracle.jdbc.OracleDriver");
                               conn=DriverManager.getConnection("jdbc:oracle:oci:@XE","system","1234");
                      stmt=conn.createStatement();
                      rs=stmt.executeQuery("select * from login");
while(rs.next())
       {                                        
          System.out.println(rs.getString(1)+"  "+rs.getString(2));
       }   
                                                                                             }
                       } 
