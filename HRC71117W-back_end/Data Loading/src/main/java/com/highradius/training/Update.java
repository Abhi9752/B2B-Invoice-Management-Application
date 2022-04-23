package com.highradius.training;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			
			int sl_no=Integer.parseInt(request.getParameter("sl_no"));
	
			String invoice_currency= request.getParameter("invoice_currency");
	
			String cust_payment_terms= request.getParameter("cust_payment_terms");
				
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/grey_goose","root","Eightapp@123");
			String sql = "UPDATE winter_internship set invoice_currency=?, cust_payment_terms=? where sl_no=?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, invoice_currency);
			preparedStatement.setString(2, cust_payment_terms);
			preparedStatement.setInt(3, sl_no);
			preparedStatement.executeUpdate(); 
			con.close();
			response.addHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Methods", "*");
			response.addHeader("Access-Control-Allow-Headers", "*");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
