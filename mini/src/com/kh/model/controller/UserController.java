package com.kh.model.controller;

import java.util.ArrayList;

import com.kh.model.dao.UserDao;
import com.kh.model.vo.User;

public class UserController {
	private UserDao ud = new UserDao();
	//
	private ArrayList<User> list = new ArrayList<>();
	
	/*public ArrayList<User>getUserList(){
		ud.saveUserListFile();
		return ud.openUserListFile();
	}*/
	
	// ����Ʈ �ȿ� �ֱ�
	public void addList(User user) {
		list.add(user);
	}
	
	
	// ����
	public ArrayList<User> openList() {
		list = ud.openUserListFile();
		return list;
	}
	// ����
	public void saveList() {
		ud.saveUserListFile(list);
	}
}
