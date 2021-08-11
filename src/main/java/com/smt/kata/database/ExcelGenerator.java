package com.smt.kata.database;

// JDK 11.x
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// Apache Commons 3.x
import org.apache.commons.lang3.StringUtils;

/****************************************************************************
 * <b>Title</b>: ExcelGenerator.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> In this kata, we will be querying the WC contact submittal and
 * generating a report for each contact form for a given organization.  
 * 
 * You will be utilizing the ExcelRport class in the spacelibs project
 * (import com.siliconmtn.data.report.ExcelReport) to generate the excel spreadsheet.
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jul 29, 2021
 * @updates:
 ****************************************************************************/
public class ExcelGenerator {
	// Members
	protected Connection conn;
	
	/**
	 * 
	 */
	public ExcelGenerator(Connection conn) {
		super();
		this.conn = conn;
	}
	
	/**
	 * 
	 * @param actionGroupId
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	public byte[] getContactReport(String actionGroupId) throws IOException, SQLException {
		Map<String, String> headerMap = new HashMap<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select *, count(sa.action_id) as num from sb_action sa ");
		sql.append("inner join contact c on sa.action_id = c.action_id ");
		sql.append("inner join contact_submittal cs on c.action_id = cs.action_id ");
		sql.append("group by sa.action_id where action_group_id ");
		sql.append("='").append(actionGroupId).append("'");
		
		try (PreparedStatement ps = conn.prepareStatement(sql.toString())) {
			ResultSet rs = ps.executeQuery();
			
			for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
				
			}
			
			
		} catch (Exception e) {
			System.err.println("Error getting results");
			e.printStackTrace();
		}
		//ExcelReport report = new ExcelReport(headers);
		return new byte[0];
	}
	
	/**
	 * Gets the list of contact forms by action_group_id and the number of records  
	 * submitted per form for all forms that have had at least one submittal
	 * @param orgId Organization ID to filter
	 * @return Map of action_group_id and count(*) of items
	 * @throws SQLException 
	 */
	public Map<String, Integer> getContactCountByOrganization(String orgId) throws SQLException {
		if (StringUtils.isEmpty(orgId)) throw new SQLException("Organization ID is required");
		
		Map<String, Integer> data = new LinkedHashMap<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select sa.action_group_id , count(sa.action_id )  from sb_action sa  ");
		sql.append("inner join contact c ");
		sql.append("on sa.action_id = c.action_id ");
		sql.append("inner join contact_submittal cs ");
		sql.append("on c.action_id = cs.action_id  ");
		sql.append("where sa.organization_id = ? ");
		sql.append("group by sa.action_group_id ");
		
		
		try (PreparedStatement ps = conn.prepareStatement(sql.toString())) {
			ps.setString(1, orgId);
			
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(orgId + "  result group id   " + rs.getString(1) + " count = " + Integer.parseInt(rs.getString(2)));
				data.put(rs.getString(1), Integer.parseInt(rs.getString(2)));
				
			}
			
			
			
		} catch (Exception e) {
			System.err.println("Error getting results");
			e.printStackTrace();
		}
		
		return data;
	}
}
