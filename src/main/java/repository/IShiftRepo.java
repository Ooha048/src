package repository;

import java.sql.SQLException;

import model.Shift;

public interface IShiftRepo {
	
	abstract public void Add(Shift shift) throws SQLException;
	abstract public void Update(Shift shift) throws SQLException;

}
