package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DBConnectionPool;
import model.Leave;

public class LeaveRepo implements ILeaveRepo {
	private DBConnectionPool connpool;

	public DBConnectionPool getConnpool() {
		return connpool;
	}

	public void setConnpool(DBConnectionPool connpool) {
		this.connpool = connpool;
	}
	
	private static final String ADD_LEAVE = "INSERT INTO `rims`.`leave` (`user_id`, `start`, `end`, `status`) VALUES (?, ?, ?, ?);";
	private static final String UPDATE_LEAVE = "UPDATE `rims`.`leave` SET `start` = ?, `end` = ? WHERE `user_id` = ?;";
	private static final String DELETE_LEAVE = "DELETE FROM `rims`.`leave` WHERE `id` = ?;";

	@Override
	public void Add(Leave leave) throws SQLException {
		System.out.println(ADD_LEAVE);
		Connection dbConn = null;
		PreparedStatement preparedStatement = null;
		try {
			dbConn = connpool.create();
			preparedStatement = dbConn.prepareStatement(ADD_LEAVE);
			preparedStatement.setInt(1, leave.getEmpId());
			preparedStatement.setDate(2, leave.getStartDate());
			preparedStatement.setDate(3, leave.getEndDate());
			preparedStatement.setString(4, leave.getStatus().name());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			preparedStatement.close();
			connpool.dead(dbConn);
		}
	}

	@Override
	public void Update(Leave leave) throws SQLException {
		System.out.println(UPDATE_LEAVE);
		Connection dbConn = null;
		PreparedStatement preparedStatement = null;
		try {
			dbConn = connpool.create();
			preparedStatement = dbConn.prepareStatement(UPDATE_LEAVE);
			preparedStatement.setDate(1, leave.getStartDate());
			preparedStatement.setDate(2, leave.getEndDate());
			preparedStatement.setInt(3, leave.getEmpId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			preparedStatement.close();
			connpool.dead(dbConn);
		}
		return;
	}

	@Override
	public void Delete(Integer id) throws SQLException {
		System.out.println(DELETE_LEAVE);
		Connection dbConn = null;
		PreparedStatement preparedStatement = null;
		try {
			dbConn = connpool.create();
			preparedStatement = dbConn.prepareStatement(DELETE_LEAVE);
			preparedStatement.setInt(1, id);
			preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			preparedStatement.close();
			connpool.dead(dbConn);
		}		
	}

}
