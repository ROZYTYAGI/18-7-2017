
package com.airport;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.sql.Wrapper;

public class JDBCTest {
	public static String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	public static String DATABASE_URL = "jdbc:mysql://172.17.174.105:3306/prashant";
	public static String USER_NAME = "root";
	public static String PASSWORD = "root";

	public static void main(String arg[]) {
		//insert(new Person());
		// delete("Rozy");
		//update(new Airport("IXM","" , ""), "abcd");
		//insert(65,76);
		/*
		  *try { Class.forName(DRIVER_CLASS); Connection
		 *con=DriverManager.getConnection(DATABASE_URL,"root","root");
		 * //con.createStatement(); System.out.println(con);
		 * }catch(ClassNotFoundException e) { e.printStackTrace(); } catch (SQLException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		*/ 
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER_CLASS);
		Connection connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
		return connection;
	}

	public static void insert(final Airport p) {
		Connection connection = null;

	PreparedStatement statement = null;
		try {
			connection = getConnection();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// String insert="INSERT INTO PERSON
		// VALUE(\\\"\"+p.getName()+\"\\\",\"+p.getAge()+\"\\\",\"+p.getGender())";
		try {

			/*
			 * connection=getConnection(); statement=connection.createStatement();
			 * statement.executeQuery(insert);
			 */
			statement = connection.prepareStatement("insert into Airport values(?,?,?)");
			statement.setString(1, p.getIata());
			statement.setString(2, p.getAirportname());
			statement.setString(3, p.getCity());
			statement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void delete(String name) {
		Connection connection1 = null;
		PreparedStatement state = null;
		try {
			connection1 = getConnection();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			state = connection1.prepareStatement("delete from PERSON where name=?");
			state.setString(1, name);
			state.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			try {
				connection1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void update(final Airport p, String name) {
		Connection con = null;
		Statement statement=null;
		PreparedStatement st = null;
		try {
			con = getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			st = con.prepareStatement("update PERSON set name=?,Age=?,Gender=? where name=?");
			 st.setString(1, p.getIata());
			st.setString(2, p.getAirportname());
			st.setString(3, p.getCity());
			st.setString(4,name);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void insert(int i, int j) {
		Connection con=null;
		CallableStatement stat=null;
		try {
			con=getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stat=con.prepareCall(" call Sum4(?,?)");
			stat.setInt(1, i);
			stat.setInt(2, j);
			stat.executeQuery();
		}catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
