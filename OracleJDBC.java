import java.sql.*;
   class Program  {
                               public static void main(String[] args)throws Exception  {
                               Connection conn;
                               Statement stmt;
                               ResultSet rs;
                               Class.forName("oracle.jdbc.driver.OracleDriver");
                               conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:8080:Oradsn","system","1234");
                      stmt=conn.createStatement();
                      rs=stmt.executeQuery("select * from login");
while(rs.next())
       {                                        
          System.out.println(rs.getString(1)+"  "+rs.getInt(2));
       }   
                                                                                             }
                       } 
