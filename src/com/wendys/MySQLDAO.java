package com.wendys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
/**
 * 
 * Utility and accessor class for JDBC MySQL using connection pool
 */
public class MySQLDAO {
	private static ConnectionPool pool = null;  
	private Connection conn = null;  

	public MySQLDAO() {
		this.conn = openDB();
	}

	public boolean isPatent() {
		return this.conn != null;
	}
	// BEGIN QUERIES //
	
	// NO PARAMETERS FOR THE QUERY
	public ResultSet executeQuery(String query) throws SQLException {
		PreparedStatement statement = prepSQL(query);
		System.out.println(new Date()+ " Query: " + statement.toString());
		ResultSet inventory = statement.executeQuery();
		return inventory;
	}
	
	
	//  QUERY WITH STRING PARAMETERS
	public ResultSet executeQuery(String query, String[] params) 
			throws SQLException {
		PreparedStatement statement = prepSQL(query, params);
		//System.out.println(new Date()+ " Query: " + statement.toString());
		ResultSet inventory = statement.executeQuery();
		return inventory;
	}
	// 	QUERY WITH INTEGER PARAMS
	public ResultSet executeQuery(String query, int[] params) 
			throws SQLException {
		PreparedStatement statement = prepSQL(query, params);
		System.out.println(new Date()+ " Query with Integer params: " + statement.toString());
		ResultSet inventory = statement.executeQuery();
		System.out.println(new Date()+ "AFTER!!!!! Query with Integer params: " + statement.toString());
		
		return inventory;
	}
	// END QUERIES //

	// UPDATE NO PARAMS
	public int executeUpdate(String query) 
			throws SQLException {
		PreparedStatement statement = prepSQL(query);
		//System.out.println(new Date()+ " Update single parameter: " + statement.toString());
		int count = statement.executeUpdate();
		//System.out.println(new Date()+ " Update single parameter after execute: " + count);
		return count;
	}
	// UPDATE WITH STRING PARAMS
	public int executeUpdate(String query, String[] params) 
			throws SQLException {
		PreparedStatement statement = prepSQL(query, params);
		//System.out.println(new Date()+ " Update string params: " + statement.toString());
		int count = statement.executeUpdate();
		return count;
	}
	// UPDATE WITH INTEGER PARAMS
	public int executeUpdate(String query, int[] params) 
			throws SQLException {
		PreparedStatement statement = prepSQL(query, params);
		//System.out.println(new Date()+ " Update integer params: " + statement.toString());
		int count = statement.executeUpdate();
		return count;
	}
	// BEGIN PREPARED STATEMENTS
	// Prepare statement 
	private PreparedStatement prepSQL(String query)
			throws SQLException {
		PreparedStatement statement = this.conn.prepareStatement(query);
		//System.out.println(new Date()+ " no parameters PrepSQL: " + statement.toString());
		return statement;
	}
	
	// Prepare statement with INTEGER params
	private PreparedStatement prepSQL(String query, int[] params)
			throws SQLException {
		PreparedStatement statement = this.conn.prepareStatement(query);
		if (params != null) {
			int i = 1;
			for (int param : params) {
				statement.setInt(i, param);
				i++;
			}
		}
		System.out.println(new Date()+ "integer params for PrepSQL: " + statement.toString());
		return statement;
	}
	// Prepare statement with STRING params
	private PreparedStatement prepSQL(String query, String[] params)
			throws SQLException {
		PreparedStatement statement = this.conn.prepareStatement(query);
		if (params != null) {
			int i = 1;
			for (String parm : params) {
				statement.setString(i, parm);
				i++;
			}
		}
		return statement;
	}
	// BEGIN PREPARED STATEMENTS
	public Connection openDB() {
		pool = ConnectionPool.getInstance();
		if (pool != null) {
			this.conn = pool.getConnection();  
		}
		//System.out.println(new Date()+ " My openDB: " + conn.toString());
		return conn;
	}
	public void closeDB() {
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException ex) {
				printTrace(ex);
			}
		}
	}
	public void printTrace(SQLException ex) {
		for (Throwable t : ex) {
			t.printStackTrace(System.out);  // stack trace to console
		}
	}
}

