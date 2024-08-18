package service;

//import java.sql.*;
import db.*;
import model.Employee;
import repository.EmployeeRepo;

public class EmployeeService extends UserService {
	private EmployeeRepo employeeRepo;
	
	public EmployeeRepo getEmployeeRepo() {
		return employeeRepo;
	}

	public void setEmployeeRepo(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}

	public EmployeeService() {
		super();
	}
	
	public EmployeeService(EmployeeRepo eR) {
		super();
		this.setEmployeeRepo(eR);
	}

}
