package service;

import java.sql.SQLException;

import model.Leave;
import repository.ILeaveRepo;

public class LeaveRequestService implements LeaveRequestHandler {
	private ILeaveRepo leaveRepo;
	private Leave leave;
	private NotificationObserver observer;

	public Leave getLeave() {
		return leave;
	}


	public void setLeave(Leave leave) {
		this.leave = leave;
	}


	public NotificationObserver getObserver() {
		return observer;
	}


	public void setObserver(NotificationObserver observer) {
		this.observer = observer;
	}


	public void setLeaveRepo(ILeaveRepo leaveRepo) {
		this.leaveRepo = leaveRepo;
	}


	@Override
	public void RequestLeave(Leave leave) throws SQLException {
		leaveRepo.Add(leave);
		observer.Notify();
	}
	
	@Override
	public void UpdateLeave(Leave leave) throws SQLException {
		leaveRepo.Update(leave);
		observer.Notify();
	}


	@Override
	public void DeleteLeave(Integer id) throws SQLException {
		leaveRepo.Delete(id);
		observer.Notify();
	}
}
