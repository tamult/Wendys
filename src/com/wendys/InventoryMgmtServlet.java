package com.wendys;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;


@WebServlet("/InventoryFashionServlet")
public class InventoryFashionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InventoryFashionServlet() {
        super();   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("application/json");
		    PrintWriter out = response.getWriter();
		    List<Item> itemList = new ArrayList<Item>();	
		
		    MySQLDAO dB = new MySQLDAO();
			if (!dB.isPatent()) {
				System.out.println("Cannot access DB...");
				return;
			}
			try {
				ResultSet rS;
				String qStr;
				qStr = "use Wendy";
				dB.executeUpdate(qStr);

				qStr = "select type, season, style, "
						+ "color, length, size, designer, "
						+ "locale, inventoryid "
						+ "from inventory where archive='no' " 
						+ "order by 2 ";

				rS = dB.executeQuery(qStr);	
				while (rS.next())  {
					Item iM = new Item();
					iM.setType(rS.getString("type"));
					iM.setSeason(rS.getString("season"));
					iM.setStyle(rS.getString("style"));
					iM.setColor(rS.getString("color"));
					iM.setLength(rS.getString("length"));
					iM.setSize(rS.getString("size"));
					iM.setDesigner(rS.getString("designer"));
					iM.setLocale(rS.getString("locale"));
					iM.setInventoryid(rS.getInt("inventoryid"));
					itemList.add(iM);
				}
		    ItemJsonObject itemJsonObject = new ItemJsonObject();
		    itemJsonObject.setiTotalDisplayRecords(itemList.size());
		    itemJsonObject.setiTotalRecords(itemList.size());
		    itemJsonObject.setAaData(itemList);

		    Gson gson = new GsonBuilder().setPrettyPrinting().create();
		    String json2 = gson.toJson(itemJsonObject);
		    out.print(json2);	
		    
			} catch (JsonIOException e) {
				e.printStackTrace();
				response.setContentType("text/html");
				response.getWriter().print(e.getMessage());
			} catch (SQLException e) {
				e.printStackTrace();
				response.setContentType("text/html");
				response.getWriter().print(e.getMessage());
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
