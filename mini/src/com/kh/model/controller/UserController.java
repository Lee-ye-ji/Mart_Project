package com.kh.model.controller;

import java.util.ArrayList;

import com.kh.model.dao.UserDao;
import com.kh.model.vo.User;

public class UserController {
	private UserDao ud = new UserDao();
	//
	private ArrayList<User> list = new ArrayList<>();
	private User loginUser;
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
	public void saveList(ArrayList<User> list) {
		ud.saveUserListFile(list);
	}
	//�α��� ȸ�� ���� 
	public void saveLogin(User user) {
		ud.saveLoginListFile(user);
	}
	//�α���
	public User getLogin() {
		loginUser = ud.openLoginFile();
		return loginUser;
	}
	//�α׾ƿ� 
	public void logOut(User user) {
		ud.logoutFile(user);
	}
	//�α��ε� ȸ������ ����
	public void loginEdit(User user) {
		ud.saveLoginListFile(user);
	}
}
