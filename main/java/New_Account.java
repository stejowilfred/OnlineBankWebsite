
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/New_Account")
public class New_Account extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public New_Account() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		//HttpSession hs = request.getSession();
		int u = 1102209999;
		int l = 1102200000;
		int ran = (u - l) + 1;

		String bank_name = request.getParameter("uname");
		String branch_name = request.getParameter("bname");
		String first_name = request.getParameter("fname");
		String last_name = request.getParameter("lname");
		String address = request.getParameter("addr");
		String acc_type = request.getParameter("atype");
		String password = request.getParameter("pass");
		String con_password = request.getParameter("cpass");
		int accountNo = (int) (Math.random() * ran) + l;
		String gmail = request.getParameter("gmail");
		String ifsc_kollemcode = "STEJO110220";
		String ifsc_thoorthoor = "STEJO110221";
		String ifsc_nadaikavu = "STEJO110222";
		String ifsc_kuzhithurai = "STEJO110223";
		// hs.setAttribute("holderName",first_name);
		// hs.setAttribute("accnumber", accountNo);
		String dburl = "jdbc:mysql://localhost:3306/OnlineBanking?autoReconnect=true&useSSL=false";
		String dbuser = "root";
		String dbpass = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dburl, dbuser, dbpass);
			String q = "Select * from bank_customer where accountNumber=? OR firstname=? OR gmail=?";
			String q1 = "insert into bank_customer values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst1 = con.prepareStatement(q1);
			PreparedStatement pst = con.prepareStatement(q);
			pst.setInt(1, accountNo);
			pst.setString(2, first_name);
			pst.setString(3, gmail);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				pw.write("Account Details is already here");
				pw.write("\nRedircting Register Page......");
				response.setHeader("Refresh", "3;URL=http://localhost:8080/Online_Banking/newaccount.html");
			} else {
				pst1.setString(1, bank_name);
				pst1.setString(2, branch_name);
				pst1.setString(3, first_name);
				pst1.setString(4, last_name);
				pst1.setString(5, address);
				pst1.setString(6, acc_type);
				if (password.equals(con_password)) {
					pst1.setString(7, password);
					pst1.setString(8, con_password);
					pst1.setInt(9, accountNo);
					pst1.setString(10, gmail);
					if (branch_name.equals("Kollencode"))
						pst1.setString(11, ifsc_kollemcode);
					else if (branch_name.equals("Thoorthoor"))
						pst1.setString(11, ifsc_thoorthoor);
					else if (branch_name.equals("Nadaikavu"))
						pst1.setString(11, ifsc_nadaikavu);
					else if (branch_name.equals("Kuzhithurai"))
						pst1.setString(11, ifsc_kuzhithurai);
					pw.write("New Accound Opened Successfully....");
					pw.write("\nPlease take screen short Your account Details");
					pw.write("\nYour account number :" + accountNo);
					pw.write("\nYour Account Holder's name :" + first_name);
					response.setHeader("Refresh", "10;URL=http://localhost:8080/Online_Banking/login.html");
				} else {
					pw.write("Password mismatch");
					response.setHeader("Refresh", "3;URL=http://localhost:8080/Online_Banking/newaccount.html");
				}
				// response.setHeader("Refresh","3;URL=http://localhost:8080/Online_Banking/login.html");
			}
			pst1.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
