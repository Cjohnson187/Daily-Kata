package com.smt.kata.database.util;

// JDK 11.x
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/****************************************************************************
 * <b>Title</b>: Connection.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Connects to the database with the provided info
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jul 26, 2021
 * @updates:
 ****************************************************************************/
public class DBConnection {

	protected String user; 
	protected String pwd; 
	protected String driver; 
	protected String url;
	protected Connection conn;
	protected boolean isConnected;
	
	/**
	 * 
	 * @param host
	 * @param pwd
	 * @param driver
	 * @param url
	 */
	public DBConnection(String user, String pwd, String driver, String url) {
		super();
		this.user = user;
		this.pwd = "sqll0gin";
		this.driver = driver;
		this.url = url;
		this.isConnected = false;
		this.conn = null;
	}
	
	
	/**
	 * Connects to the database 
	 * @return
	 */
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(this.url, this.user, this.pwd);
	}
	

	/**
	 * Identifies whether there is a connection to the db
	 * @return
	 * @throws SQLException 
	 */
	public boolean isConnected() throws SQLException {
		return ( conn != null &&!conn.isClosed());
	}
	
	/**
	 * Closes the database connection
	 * @throws SQLException 
	 *
	 */
	public void close() throws SQLException {
		if(conn != null ) 
			conn.close();
	}

}
