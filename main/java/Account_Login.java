

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/Account_Login")
public class Account_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Account_Login() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		HttpSession hs=request.getSession();
		
		String holderName=request.getParameter("uname");
		int acc_Number=Integer.parseInt(request.getParameter("anum"));
		String ifsc=request.getParameter("ifsc");
		String password=request.getParameter("pass");
		hs.setAttribute("accNumber", acc_Number);
		
		String dburl="jdbc:mysql://localhost:3306/OnlineBanking?autoReconnect=true&useSSL=false";
		String dbuser="root";
		String dbpass="";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(dburl,dbuser,dbpass);
			String q="Select * from bank_customer where firstname=? and AccountNumber=? and IFSC=? and Password=?";
			PreparedStatement pst=con.prepareStatement(q);
			pst.setString(1, holderName);
			pst.setInt(2, acc_Number);
			pst.setString(3, ifsc);
			pst.setString(4, password);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				pw.write("Login success... ");
				request.getRequestDispatcher("/ViewAccDetails").forward(request, response);
				//response.setHeader("Refresh","3;URL=http://localhost:8080/Online_Banking/ViewAccDetails.html");
			}else
				pw.write("Login fail");
			response.setHeader("Refresh","3;URL=http://localhost:8080/Online_Banking/login.html");
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
