package service;

import model.User;

public class LeaveApprovalObserver implements Observer {
	
	private User user;

	@Override
	public void Notify() {
		System.out.println("Notify Employee");
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
