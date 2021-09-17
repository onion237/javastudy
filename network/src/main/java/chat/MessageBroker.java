package chat;

import java.util.ArrayList;
import java.util.List;

public class MessageBroker {
	private List<User> userList = new ArrayList<>();

	public MessageBroker() {}
	
	public MessageBroker(List<User> userList) {
		this.userList = userList;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	public void broadCast(Message msg) {
		for(User u : userList) {
			System.out.println("보내기");
			u.getWriter().println(msg);
		}
	}
	public boolean isExist(User user) {
		return userList.contains(user);
	}
	public void addUser(User user) {
		userList.add(user);
	}

	public boolean removeUser(User user) {
		return userList.remove(user);
	}

	public void sendTo(User user, Message message) {
		for(User u : userList) {
			if(u.getUserName().equals(user.getUserName())) {
				u.getWriter().println(message);
			}
		}
		
	}
}
