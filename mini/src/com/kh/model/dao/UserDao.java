package com.kh.model.dao;

import java.util.ArrayList;

import com.kh.model.vo.User;

public class UserDao {
	public ArrayList<User>openUserListFile(){
		ArrayList<User>list = new ArrayList<>();
		
		list.add(new User("�Ǽ���",25,"tpals0322@",0322,"������ �ȴޱ� �츸��",1234));
		return list;
		
	}
}
