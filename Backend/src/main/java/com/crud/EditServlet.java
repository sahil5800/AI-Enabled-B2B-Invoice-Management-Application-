package com.crud;

import java.util.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			HashMap<Object,Object>Response = new HashMap<Object,Object>();
			String fld=request.getParameter("sl_no");
			int sl_no = Integer.parseInt(fld);
			String newinvoice_currency=request.getParameter("invoice_currency");
			String newcust_payment=request.getParameter("cust_payment_terms");
			
			Connection conn = JDBC.getConnection();
			String query = "UPDATE winter_internship SET invoice_currency = ?, cust_payment_terms = ? WHERE sl_no = ?";
			
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setString(1, newinvoice_currency);
			pst.setString(2, newcust_payment);
			pst.setInt(3, sl_no);
			if(pst.executeUpdate()>0) {
				Response.put("status", true);
			}
			else {
				Response.put("status", false);
			}
			Gson gson = new Gson();
			String ResponseJSON = gson.toJson(Response);
			try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.getWriter().append(ResponseJSON);
			System.out.println(ResponseJSON);
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("exception occur");
			}
			conn.close();
		} catch(Exception e) {
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
