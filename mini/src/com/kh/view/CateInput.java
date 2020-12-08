package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.model.controller.CateController;
import com.kh.model.vo.Category;

public class CateInput {
	private CateController cc = new CateController();
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		cc.loadList();
		
		while(true) {
			System.out.println("******* ���� �޴� *******");
			System.out.println("1. �߰�");
			System.out.println("2. ��ü ��ȸ");
			System.out.println("3. �� ����");
			System.out.println("0. ����");
			System.out.print("�޴� ��ȣ ���� :");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1: 
				addList();
				break;
			case 2:
				selectList();
				break;
			case 3:
				cc.saveList();
				System.out.println("���� ����Ǿ����ϴ�!");
				break;
			case 0:
				System.out.println("���α׷� ����");
				return;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				break;
			}
		}
	}
	
	public void addList() {
		System.out.println("----��� ī�װ�----");
	
		System.out.print("�����̸� : ");
		String fName = sc.nextLine();
		
		System.out.print("���� �̹��� ��� : ");
		String fImagePath = sc.nextLine();
		
		System.out.print("���� ��(�κ�) : ");
		String amount = sc.nextLine();
		
		System.out.print("���� �ð� : ");
		String time = sc.nextLine();
		
		System.out.print("��� ���� ���� �Է� : ");
		int ingreCount = sc.nextInt();
		sc.nextLine();
		String[] ingre = new String[ingreCount];
		for(int i = 0; i < ingreCount; i++) {
			System.out.print("��� : ");
			ingre[i] = sc.nextLine();
		}
		
		System.out.print("������ ���� ���� �Է� :");
		int recipeCount = sc.nextInt();
		sc.nextLine();
		String[] recipe = new String[recipeCount];
		for(int j = 0; j < recipeCount; j++) {
			System.out.print("������ : ");
			recipe[j] = sc.nextLine();
		}
		Category category = new Category(fName, fImagePath, amount, time, ingre, recipe);
		cc.addCateList(category);	
	}

	public void selectList() {
		System.out.println("-------- ��ü ��ȸ --------");
		ArrayList<Category> list = cc.selectList();
		
		if(!list.isEmpty()) {
			for(int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}else {
			System.out.println("����� �������� �ʽ��ϴ�.");
		}
	}
}
