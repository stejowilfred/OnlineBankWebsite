package com.deposit;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Deposit() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		HttpSession hs = request.getSession();

		String bank = request.getParameter("bank");
		int accountNumber = Integer.parseInt(request.getParameter("account"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		int accNumber = (int) hs.getAttribute("accNumber");
		String password = request.getParameter("password");

		String dburl = "jdbc:mysql://localhost:3306/OnlineBanking?autoReconnect=true&useSSL=false";
		String dbuser = "root";
		String dbpass = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dburl, dbuser, dbpass);
			// To fetch the details from database through the get the data from Webpage
			String q = "update accounts set amount=?+(select sub.amount from(select amount from accounts where accountnumber=?) as sub)where accountnumber=?";
			String q1 = "update accounts set amount=(select sub.amount from(select amount from accounts where accountnumber=?) as sub)-? where accountnumber=(select accountnumber from bank_customer where password=?)";
			PreparedStatement pst = con.prepareStatement(q);
			PreparedStatement pst1 = con.prepareStatement(q1);
			if (bank.equals("self")) {
				pst.setInt(1, amount);
				pst.setInt(2, accountNumber);
				pst.setInt(3, accountNumber);
				pst1.setInt(1, accNumber);
				pst1.setInt(2, amount);
				// pst1.setInt(3, accNumber);
				pst1.setString(3, password);
				pw.write("Money Transfer successful");
			}
			pst.execute();
			pst1.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
