package com.kh.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.kh.model.vo.User;

public class UserDao {

//	private ArrayList<User> userList = new ArrayList<>();

	/*{
		userList.add(new User("�Ǽ���", 25, "ii1425", "tpals0322@", "0322", "������ �ȴޱ� �츸��", 1234));
	}*/


	// �� ����
	public ArrayList<User> openUserListFile() {

		ArrayList<User> list = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("userList.dat"))) {

			list = (ArrayList<User>) ois.readObject();

		} catch (FileNotFoundException e) {
			System.out.println("userList.dat ������ �ε����� ���߽��ϴ�.");
		} catch (IOException e) {
			System.out.println("userList.dat ������ �ε����� ���߽��ϴ�.");
		} catch (ClassNotFoundException e) {
			System.out.println("ArrayList<User>���� ĳ���� �� �� �����ϴ�.");
		}

		return list;

	}
	
	// �� ����
		public void saveUserListFile(ArrayList<User> list) {
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("userList.dat"))) {

				oos.writeObject(list);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		//�α��� �� ȸ�� ����
		public void saveLoginListFile(User list) {
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("loginList.dat"))) {

				oos.writeObject(list);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		//�α��� ���� ��������public ArrayList<User> openUserListFile() {
		public User openLoginFile() {
		User loginUser = new User();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("loginList.dat"))) {

			loginUser = (User) ois.readObject();

		} /*catch (FileNotFoundException e) {
			System.out.println("userList.dat ������ �ε����� ���߽��ϴ�.");
		} */catch (IOException e) {
			System.out.println("loginList.dat ������ �ε����� ���߽��ϴ�.");
		} catch (ClassNotFoundException e) {
			System.out.println("ArrayList<User>���� ĳ���� �� �� �����ϴ�.");
		}

		return loginUser;

	}
		//�α׾ƿ�
		public void logoutFile(User list) {
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("loginList.dat"))) {

				oos.writeObject(list);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
}
