import java.io.FileOutputStream;
import java.io.*;
import java.util.*;
import java.util.Date;
import java.sql.*; 
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
public class pdf {  
        public static void main(String[] args) throws Exception{
                
                /* Create Connection objects */
                Class.forName ("oracle.jdbc.driver.OracleDriver"); 
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@jitendra:1521:XE","system","1234");
                Statement stmt = conn.createStatement();
                /* Define the SQL query */
				String abc= CheckOut.s;
				System.out.println(abc);
                ResultSet query_set = stmt.executeQuery("select roomtype,name,people,service,cin,cout,price from bookings where roomno='" + abc + "'");
                /* Step-2: Initialize PDF documents - logical objects */
                Document my_pdf_report = new Document();
                PdfWriter.getInstance(my_pdf_report, new FileOutputStream("pdf_report.pdf"));
                my_pdf_report.open();            
                //we have four columns in our table
                PdfPTable my_report_table = new PdfPTable(7);
                //create a cell object
							
				my_pdf_report.add(new Paragraph("Blekinge - Accord Hotels"));
				my_pdf_report.add(Chunk.NEWLINE);
					 
					my_pdf_report.add(Chunk.NEWLINE);   //Something like in HTML :-)
 
                    my_pdf_report.add(new Paragraph("Dear customer"));
	                my_pdf_report.add(new Paragraph("Document Generated On - "+new Date().toString()));	
					my_pdf_report.add(Chunk.NEWLINE); 
					my_pdf_report.add(Chunk.NEWLINE); 
				PdfPCell table_cell;
				my_report_table.setSpacingBefore(30.0f);       
				      my_report_table.setSpacingAfter(30.0f); 
				my_report_table.addCell("Room Type");
			   my_report_table.addCell("Name");
			   my_report_table.addCell("People");
			   my_report_table.addCell("Service");
			   my_report_table.addCell("Check-in date");
			   my_report_table.addCell("Checkout date");
			   my_report_table.addCell("Price");
			   
                while (query_set.next()) {                
                                String rt = query_set.getString("roomtype");
                                table_cell=new PdfPCell(new Phrase(rt));
                                my_report_table.addCell(table_cell);
                                String n=query_set.getString("name");
                                table_cell=new PdfPCell(new Phrase(n));
                                my_report_table.addCell(table_cell);
                                String ppl=query_set.getString("people");
                                table_cell=new PdfPCell(new Phrase(ppl));
                                my_report_table.addCell(table_cell);
                                String ser=query_set.getString("service");
                                table_cell=new PdfPCell(new Phrase(ser));
                                my_report_table.addCell(table_cell);
								String chi=query_set.getString("cin");
                                table_cell=new PdfPCell(new Phrase(chi));
                                my_report_table.addCell(table_cell);
								String cho=query_set.getString("cout");
                                table_cell=new PdfPCell(new Phrase(cho));
                                my_report_table.addCell(table_cell);
								String pri=query_set.getString("price");
                                table_cell=new PdfPCell(new Phrase(pri));
                                my_report_table.addCell(table_cell);
                                }
                /* Attach report table to PDF */
                my_pdf_report.add(my_report_table);        
				my_pdf_report.newPage(); 
                my_pdf_report.close();
				             
                /* Close all DB related objects */
                query_set.close();
                stmt.close(); 
                conn.close();               
                
        }
}