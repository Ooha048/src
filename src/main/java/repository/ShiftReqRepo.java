package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DBConnectionPool;
import model.ShiftRequest;

public class ShiftReqRepo implements IShiftReqRepo {
	private DBConnectionPool connpool;

	public DBConnectionPool getConnpool() {
		return connpool;
	}

	public void setConnpool(DBConnectionPool connpool) {
		this.connpool = connpool;
	}
	
	private static final String ADD_SHIFT_REQ = "INSERT INTO `rims`.`shift_req` (`user_id`, `start`, `end`, `status`) VALUES (?, ?, ?, ?);";
	private static final String UPDATE_SHIFT_REQ = "UPDATE `rims`.`shift_req` SET `newShift` = ? WHERE `user_id` = ?;";
	private static final String DELETE_SHIFT_REQ = "DELETE FROM `rims`.`shift_req` WHERE `id` = ?;";

	@Override
	public void Add(ShiftRequest sr) throws SQLException {
		System.out.println(ADD_SHIFT_REQ);
		Connection dbConn = null;
		PreparedStatement preparedStatement = null;
		try {
			dbConn = connpool.create();
			preparedStatement = dbConn.prepareStatement(ADD_SHIFT_REQ);
			preparedStatement.setInt(1, sr.getEmpId());
			preparedStatement.setString(2, sr.getNewShift().name());
			preparedStatement.setString(3, sr.getStatus().name());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			preparedStatement.close();
			connpool.dead(dbConn);
		}		
	}

	@Override
	public void Update(ShiftRequest sr) throws SQLException {
		System.out.println(UPDATE_SHIFT_REQ);
		Connection dbConn = null;
		PreparedStatement preparedStatement = null;
		try {
			dbConn = connpool.create();
			preparedStatement = dbConn.prepareStatement(UPDATE_SHIFT_REQ);
			preparedStatement.setString(1, sr.getNewShift().name());
			preparedStatement.setInt(2, sr.getEmpId());
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
		System.out.println(DELETE_SHIFT_REQ);
		Connection dbConn = null;
		PreparedStatement preparedStatement = null;
		try {
			dbConn = connpool.create();
			preparedStatement = dbConn.prepareStatement(DELETE_SHIFT_REQ);
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
