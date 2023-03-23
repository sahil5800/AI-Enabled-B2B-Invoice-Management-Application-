package com.crud;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class newinvoice
 */
@WebServlet("/newinvoice")
public class newinvoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newinvoice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.addHeader("Access-Control-Allow-Origin","http://localhost:3000");
		response.setHeader("Access-Control-Allow-Methods","GET");
		try {
			HashMap<Object,Object> Response=new HashMap<Object,Object>();
			SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
			
			String business_code=request.getParameter("business_code");
			int cust_number =Integer.parseInt(request.getParameter("cust_number"));
			String clear_date=request.getParameter("clear_date");
			java.util.Date clear_date_str=format.parse(clear_date);
			java.sql.Date clear_date_f=new java.sql.Date(clear_date_str.getTime());
			int buisness_year=Integer.parseInt(request.getParameter("buisness_year"));
			String doc_id=request.getParameter("doc_id");
			String posting_date=request.getParameter("posting_date");
			java.util.Date posting_date_str=format.parse(posting_date);
			java.sql.Date posting_date_f=new java.sql.Date(posting_date_str.getTime());
			String document_create_date=request.getParameter("document_create_date");
			java.util.Date document_create_date_str=format.parse(document_create_date);
			java.sql.Date document_create_date_f=new java.sql.Date(document_create_date_str.getTime());
			String due_in_date=request.getParameter("due_in_date");
			java.util.Date due_in_date_str=format.parse(due_in_date);
			java.sql.Date due_in_date_f=new java.sql.Date(due_in_date_str.getTime());
			String invoice_currency=request.getParameter("invoice_currency");
			String document_type=request.getParameter("document_type");
			int posting_id=Integer.parseInt(request.getParameter("posting_id"));
			float total_open_amount=Float.parseFloat(request.getParameter("total_open_amount"));
			String baseline_create_date=request.getParameter("baseline_create_date");
			java.util.Date baseline_create_date_str=format.parse(baseline_create_date);
			java.sql.Date baseline_create_date_f=new java.sql.Date(baseline_create_date_str.getTime());
			String cust_payment_terms=request.getParameter("cust_payment_terms");
			int invoice_id=Integer.parseInt(request.getParameter("invoice_id"));
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/grey_goose","root","Sahil.05");
			String sql_query="INSERT INTO winter_internship(business_code,cust_number,clear_date,buisness_year,doc_id,posting_date,document_create_date,due_in_date,invoice_currency,document_type,posting_id,total_open_amount,baseline_create_date,cust_payment_terms,invoice_id) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement pst = conn.prepareStatement(sql_query);
		    	
			pst.setString(1,business_code);
			pst.setInt(2,cust_number);
			pst.setDate(3,clear_date_f);
			pst.setInt(4,buisness_year);
			pst.setString(5,doc_id);
			pst.setDate(6,posting_date_f);
			pst.setDate(7,document_create_date_f);
			pst.setDate(8,due_in_date_f);
			pst.setString(9,invoice_currency);
			pst.setString(10,document_type);
			pst.setInt(11,posting_id);
			pst.setFloat(12,total_open_amount);
			pst.setDate(13,baseline_create_date_f);
			pst.setString(14,cust_payment_terms);
			pst.setInt(15,invoice_id);
		
			
			  if(pst.executeUpdate()>0){
				Response.put("Insert",true);
				
			  }else {
				Response.put("Insert",false);
			  }
			
			Gson gson=new Gson();
			String val=gson.toJson(Response);
			response.getWriter().append(val);
		}
		 catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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