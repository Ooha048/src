package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DBConnectionPool;
import model.Shift;

public class ShiftRepo implements IShiftRepo {
	private DBConnectionPool connpool;

	public DBConnectionPool getConnpool() {
		return connpool;
	}

	public void setConnpool(DBConnectionPool connpool) {
		this.connpool = connpool;
	}
	
	private static final String ADD_SHIFT= "INSERT INTO `rims`.`shift` (`user_id`, `type`) VALUES (?, ?);";
	private static final String UPDATE_SHIFT= "UPDATE `rims`.`shift` SET `type` = ? WHERE `user_id` = ?;";

	@Override
	public void Add(Shift shift) throws SQLException {
		System.out.println(ADD_SHIFT);
		Connection dbConn = null;
		PreparedStatement preparedStatement = null;
		try {
			dbConn = connpool.create();
			preparedStatement = dbConn.prepareStatement(ADD_SHIFT);
			preparedStatement.setInt(1, shift.getEmpId());
			preparedStatement.setString(2, shift.getType().name());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			preparedStatement.close();
			connpool.dead(dbConn);
		}		
	}

	@Override
	public void Update(Shift shift) throws SQLException {
		System.out.println(UPDATE_SHIFT);
		Connection dbConn = null;
		PreparedStatement preparedStatement = null;
		try {
			dbConn = connpool.create();
			preparedStatement = dbConn.prepareStatement(UPDATE_SHIFT);
			preparedStatement.setString(1, shift.getType().name());
			preparedStatement.setInt(2, shift.getEmpId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			preparedStatement.close();
			connpool.dead(dbConn);
		}
		return;		
	}

}
