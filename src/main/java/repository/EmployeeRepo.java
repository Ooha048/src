package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBConnectionPool;
import model.Employee;

public class EmployeeRepo implements IEmployeeRepo {
	private DBConnectionPool connpool;

	public DBConnectionPool getConnpool() {
		return connpool;
	}

	public void setConnpool(DBConnectionPool connpool) {
		this.connpool = connpool;
	}
	
	private static final String GET_USER = "SELECT * FROM `rims`.`user` WHERE email = ?;";
	
	public EmployeeRepo() {
		super();
	}
	
	public EmployeeRepo(DBConnectionPool connpool) {
		super();
		this.connpool = connpool;
	}
	
	@Override
	public Employee Get(String email) throws SQLException {
		System.out.println(GET_USER);
		Connection dbConn = null;
		PreparedStatement preparedStatement = null;
		try {
			dbConn = connpool.create();
			preparedStatement = dbConn.prepareStatement(GET_USER);
			preparedStatement.setString(1, email);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				Employee emp = new Employee() {};
				emp.setEmail(rs.getString("email"));
				emp.setEmail(rs.getString("name"));
				emp.setEmail(rs.getString("role"));
				return emp;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			preparedStatement.close();
			connpool.dead(dbConn);
		}
		return null;
	}

}
