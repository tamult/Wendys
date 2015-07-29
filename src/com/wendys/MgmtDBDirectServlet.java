package com.wendys;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InventoryMgmtServlet")
public class InventoryMgmtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public InventoryMgmtServlet() { super();    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// grab my parameters
		String mode = null;
		String iid = null;
		mode = request.getParameter("mode");

		if (mode!=null && mode.equals("edit"))  {
			
			iid = request.getParameter("inventoryid");
		}
		System.out.println("Mode is: "+mode+"   our id param: "+iid);
		// now i am just going to accomplish the three: add, edit, delete
		 response.setContentType("text/plain");  
		 response.setCharacterEncoding("UTF-8"); 
		 response.getWriter().write("Successful update using "+ iid); 
		
		
		
		
		/*
		 * if (mode=="add")  {
			
		}
		if (mode=="edit")  {
			
		}
		if (mode=="del")  {
			
		}
		*/
	}	

}
