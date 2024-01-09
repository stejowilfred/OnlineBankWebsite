
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/ViewAccDetails")
public class ViewAccDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewAccDetails() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//PrintWriter pw = response.getWriter();
		HttpSession hs = request.getSession(false);
		HttpSession hs1 = request.getSession();
		int accNumber = (int) hs.getAttribute("accNumber");
		// int anum=1102206056;
		String dburl = "jdbc:mysql://localhost:3306/OnlineBanking?autoReconnect=true&useSSL=false";
		String dbuser = "root";
		String dbpass = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dburl, dbuser, dbpass);
			String q = "Select *from Bank_Customer where AccountNumber=?";
			PreparedStatement pst = con.prepareStatement(q);
			pst.setInt(1, accNumber);
			ResultSet rs = pst.executeQuery();
			String bankName, branchName, firstName, lastName, address, gmail, ifsc;
			int accountNumber;
			while (rs.next()) {
				bankName = rs.getString("BankName");
				branchName = rs.getString("BranchName");
				firstName = rs.getString("FirstName");
				lastName = rs.getString("LastName");
				address = rs.getString("Address");
				accountNumber = rs.getInt("AccountNumber");
				gmail = rs.getString("Gmail");
				ifsc = rs.getString("IFSC");
				
				hs1.setAttribute("FirstName", firstName);
				hs1.setAttribute("lastName", lastName);
				hs1.setAttribute("BankName", bankName);
				hs1.setAttribute("AccountNumber", accountNumber);
				hs1.setAttribute("BranchName", branchName);
				hs1.setAttribute("IFSC", ifsc);
				hs1.setAttribute("Gmail", gmail);
				hs1.setAttribute("Address", address);
				break;
			}
			request.getRequestDispatcher("/accdetailsview.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
