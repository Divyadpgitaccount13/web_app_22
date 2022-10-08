

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//read the data from database
//print on browser 
//form of table

@WebServlet("/read")
public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReadServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        try {
        	
         Class.forName("com.mysql.cj.jdbc.Driver");
			
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_reg_demo_1", "root", "test");
        	
        	Statement stmnt = con.createStatement();
        	
        	ResultSet result = stmnt.executeQuery("select * from register");
        	
        	//read the data
        	
        	PrintWriter out = response.getWriter();
        	
        	response.setContentType("text/html");
        	
    		out.println("<table border ='1'>");
    		out.println("<tr>");
    		out.println("<th>");
    		out.println("name");
            out.println("</th>");
            out.println("<th>");
    		out.println("gender");
            out.println("</th>"); 
            out.println("<th>");
    		out.println("email");
            out.println("</th>");
            out.println("<th>");
    		out.println("city");
            out.println("</th>");
            out.println("<th>");
    		out.println("mobile");
            out.println("</th>");
            out.println("<th>");
    		out.println("age");
            out.println("</th>"); 
            out.println("</tr>");
            
            while(result.next()) {
            	out.println("<tr>");
        		out.println("<td>");
        		out.println(result.getString(1));//record read by column .read all the record present in first column
                out.println("</td>");
                out.println("<td>");
        		out.println(result.getString(2));
                out.println("</td>");
                out.println("<td>");
        		out.println(result.getString(3));
                out.println("</td>");
                out.println("<td>");
        		out.println(result.getString(4));
                out.println("</td>");
                out.println("<td>");
        		out.println(result.getString(5));
                out.println("</td>");
                out.println("<td>");
        		out.println(result.getString(6));
                out.println("</td>");
                out.println("</tr>");
                
            }
                out.println("</table>");
            	
           
            
        	con.close();
        	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
