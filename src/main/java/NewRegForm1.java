

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/newreg")
public class NewRegForm1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public NewRegForm1() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		
	    String gen = request.getParameter("gen");

		String email = request.getParameter("emailid");
		
		String city = request.getParameter("city");

		String mobile = request.getParameter("mobile");
		
		String age = request.getParameter("age");
		
		
        try {
        	
            Class.forName("com.mysql.cj.jdbc.Driver");
			
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_reg_demo_1", "root", "test");
        	
        	Statement stmnt = con.createStatement();
        	
        	stmnt.executeUpdate("insert into register values('"+name+"','"+gen+"','"+email+"','"+city+"','"+mobile+"','"+age+"')");
        	
        	con.close();
        	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
