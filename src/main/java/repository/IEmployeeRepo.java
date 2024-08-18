package repository;

import java.sql.SQLException;

import model.Employee;

public interface IEmployeeRepo {
	abstract public Employee Get(String email) throws SQLException;
}
