package com.smt.kata.database;

// JDK 11.x
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

/****************************************************************************
 * <b>Title</b>: DatabaseIntro.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Database Intro
 * This kata is designed to provide a basic understanding of database connections 
 * and queries in java.  This class has 2 methods that must be configured.  The first
 * is designed to teach you how to load meta data information form the database.
 * The second method is designed to help you pull data from the database using 
 * SQL packages
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jul 26, 2021
 * @updates:
 ****************************************************************************/
public class DatabaseIntro {
	
	// Members
	protected Connection conn;

	/**
	 * Initializes the class with the database connection
	 * @param dbConn
	 */
	public DatabaseIntro(Connection conn) throws SQLException {
		super();
		this.conn = conn;
	}

	/**
	 * Retrieves the metadata for the provided column
	 * @param tableName Table to retrieve metadata
	 * @return Map with the column name as the key and ther java data type as the value
	 * @throws SQLException 
	 */
	public Map<String, String> getTableMetaData(String tableName) throws SQLException {
		Map<String, String> meta = new HashedMap();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select * from ").append(tableName).append(" Limit 1");

		try (PreparedStatement ps = conn.prepareStatement(sql.toString())){
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int colCount = rs.getMetaData().getColumnCount();
				for(int i =1; i<= colCount; i++) {
					meta.put(rs.getMetaData().getColumnName(i), rs.getMetaData().getColumnClassName(i));
				}
			}
		} catch (Exception e) {
			System.out.println("Error getting results");
			e.printStackTrace();
		}
		
		return meta;
	}
	
	/**
	 * Loads a the data elements from the provided table
	 * @param tableName Table to retrieve it's data
	 * @return Collection of key values for each row.  The map has the column name
	 * as the key and the value for each row as the value
	 */
	public List<Map<String, Object>> retrieveDataFromTable(String tableName) throws SQLException {
		List<Map<String, Object>> data = new ArrayList();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select * from ").append(tableName);

		try (PreparedStatement ps = conn.prepareStatement(sql.toString())){
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int colCount = rs.getMetaData().getColumnCount();
				Map<String, Object> row = new HashMap<>();
				for(int i =1; i<= colCount; i++) {
					row.put(rs.getMetaData().getColumnName(i), rs.getObject(i));
				}
				data.add(row);
			}
		} catch (Exception e) {
			System.err.println("Error getting results");
			e.printStackTrace();
		}
		
		return data;
	}
	
	/**
	 * Retrieves the primary key for the provided table
	 * @param tableName Table's primary key to locate
	 * @return Column name of the primary key
	 * @throws SQLException
	 */
	public String getPrimaryKeyColumn(String tableName) throws SQLException {
		ResultSet rs = conn.getMetaData().getPrimaryKeys(null, null, tableName);
		String ret = null;
		if(rs.next()) {
			ret = rs.getString("COLUMN_NAME");
		}
		return ret;
	}
	
	/**
	 * Retrieves the names of all of the tables
	 * @param schema Schema to filer.  All schemas if null
	 * @return Collection of table names
	 * @throws SQLException
	 */
	public List<String> listDatabaseTables(String schema) throws SQLException {
		List<String> ret = new ArrayList<>();
	
		ResultSet rs = conn.getMetaData().getTables(null, schema, "%", null);
		while (rs.next()) {
			ret.add(rs.getString("TABLE_NAME"));
		}
	
	
		return ret;
	}
}
