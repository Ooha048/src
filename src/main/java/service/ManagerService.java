package service;

import java.sql.SQLException;

import Exception.UserAlreadyExist;
import model.Employee;
import model.User;
import repository.ManagerRepo;

public class ManagerService extends UserService implements EmployeeManagementService, SignUp {
	private ManagerRepo managerRepo = null;
	
	public ManagerRepo getManagerRepo() {
		return managerRepo;
	}

	public void setManagerRepo(ManagerRepo managerRepo) {
		this.managerRepo = managerRepo;
	}

	public ManagerService() {
		super();
	}
	
	public ManagerService(ManagerRepo mR) {
		super();
		this.setManagerRepo(mR);
	}
	
	@Override
	public User AddEmployee(Employee emp) throws SQLException {
		return this.managerRepo.Add(emp);
	}
	
	@Override
	public void DeleteEmployee(Integer id) throws SQLException {
		this.managerRepo.Delete(id);
	}
	
	@Override
	public void UpdateEmployee(Integer id, String name) throws SQLException {
		this.managerRepo.Update(id, name);
	}
	
	@Override
	public User CreateUser(User user) throws SQLException, UserAlreadyExist {
		if (this.IsUserPresent(user.getName())) {
			throw new UserAlreadyExist("User already present");
		}
		return this.managerRepo.Create(user);
	}

}
