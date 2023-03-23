package com.crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pojo.pojo;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setHeader("Access-Control-Allow-Origin", "*");	
		try {
				PrintWriter outPrintWriter = response.getWriter();
				Connection conn = JDBC.getConnection();
				response.setContentType("application/json");
				String doc_id = request.getParameter("doc_id");
				String cust_number = request.getParameter("cust_number");
				String invoice_id = request.getParameter("invoice_id");
				String buisness_year = request.getParameter("buisness_year");
				PreparedStatement st=conn.prepareStatement("SELECT * FROM winter_internship WHERE doc_id= ? AND cust_number= ? AND invoice_id= ? AND buisness_year= ?");
				st.setString(1, doc_id);
				st.setString(2, cust_number);
				st.setString(3, invoice_id);
				st.setString(4, buisness_year);
				ResultSet rs = st.executeQuery();
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
				Gson gson = new Gson();
				String dat=gson.toJson(ALLData);
				response.getWriter().append(dat); //getWriter() returns a PrintWriter object that can send character text to the client. 
			}catch(IOException e) {
					e.printStackTrace();
					System.out.println("exception occur");
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
		doGet(request, response);
	}

}
