package service;

import java.sql.SQLException;

import model.Leave;
import repository.ILeaveRepo;

public class LeaveApprovalService implements LeaveApprovalHandler {
	private ILeaveRepo leaveRepo;
	private Leave leave;
	private NotificationObserver observer;
	
	public ILeaveRepo getLeaveRepo() {
		return leaveRepo;
	}
	
	public void setLeaveRepo(ILeaveRepo leaveRepo) {
		this.leaveRepo = leaveRepo;
	}
	
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

	@Override
	public void ApproveLeave() throws SQLException {
		try {
			leaveRepo.Update(leave);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		observer.Notify();
	}
	
}
