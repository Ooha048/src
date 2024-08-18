package service;

import model.User;

public class NotificationObserver implements Observer {
	
	private User user;

	@Override
	public void Notify() {
		System.out.println("Notify User about leave status");
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
