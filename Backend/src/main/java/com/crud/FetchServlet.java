package com.crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pojo.pojo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * Servlet implementation class FetchServlet
 */
@WebServlet("/FetchServlet")
public class FetchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//int row=10;
		response.addHeader("Access-Control-Allow-Origin","*");
		response.setHeader("Access-Control-Allow-Methods","GET");
		try {
			//String pageIn=request.getParameter("page");
			//int page=Integer.parseInt(pageIn)*row;
			Connection conn = JDBC.getConnection();
			Statement s=conn.createStatement();
			String query = "SELECT sl_no,business_code,cust_number,clear_date,buisness_year,doc_id,posting_date,document_create_date,due_in_date,invoice_currency,document_type,posting_id,total_open_amount,baseline_create_date,cust_payment_terms,invoice_id from winter_internship";
			ResultSet rs = s.executeQuery(query);
			ArrayList<pojo> ALLData=new ArrayList<pojo>();
			while(rs.next()) {
				pojo p=new pojo();
				p.setSl_no(rs.getInt("sl_no"));
				p.setBusiness_code(rs.getString("business_code"));
				p.setCust_number(rs.getLong("cust_number"));
				p.setClear_date(rs.getString("clear_date"));
				p.setBuisness_year(rs.getInt("buisness_year"));
				p.setDoc_id(rs.getLong("doc_id"));
				p.setPosting_date(rs.getString("posting_date"));
				p.setDocument_create_date(rs.getString("document_create_date"));
				p.setDue_in_date(rs.getString("due_in_date"));
				p.setInvoice_currency(rs.getString("invoice_currency"));
				p.setDocument_type(rs.getString("document_type"));
				p.setPosting_id(rs.getInt("posting_id"));
				p.setTotal_open_amount(rs.getDouble("total_open_amount"));
				p.setBaseline_create_date(rs.getString("baseline_create_date"));
				p.setCust_payment_terms(rs.getString("cust_payment_terms"));
				p.setInvoice_id(rs.getLong("invoice_id"));
				ALLData.add(p);
			}
			/*for(pojo stud: ALLData)
			 {
				 System.out.println(stud.toString());
			 }*/
			Gson gson = new GsonBuilder().serializeNulls().create();
			String dat=gson.toJson(ALLData);
	
			try {
				response.getWriter().write(dat); //getWriter() returns a PrintWriter object that can send character text to the client. 
			}
			catch(IOException e) {
				e.printStackTrace();
				System.out.println("exception occur");
			}
			rs.close();
			s.close();
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("exception occur");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("exception occur");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.addHeader("Access-Control-Allow-Origin","*");
		response.setHeader("Access-Control-Allow-Methods","GET");
	}

}
