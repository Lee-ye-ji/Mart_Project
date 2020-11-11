package com.kh.recipe.model.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.kh.recipe.model.vo.Category;

public class CategoryDao {
	
	public ArrayList<Category> fileOpen(){
		
		ArrayList<Category>  cateList = new ArrayList<>();
		
		try(ObjectInputStream ois =  new ObjectInputStream(new FileInputStream("file/category.txt"))){
			cateList = (ArrayList<Category>)ois.readObject();
		
		} catch (IOException e) {
			System.out.println("category.txt ������ �ε����� ���߽��ϴ�.");
		} catch (ClassNotFoundException e) {
			System.out.println("ArrayList<Categoty>���� ĳ���� �� �� �����ϴ�.");
		}
		return cateList;
	}
	
	public void fileSave(ArrayList<Category> CateList) {
//		ArrayList<Category>  cateList = new ArrayList<>();
//		String[] indi = {"����", "����", "û�����", "������", "��ġ", "ȫ����", "������"};
//		cateList.add(new Category("�����ġ������", "image/recipe/category/�����ġ������.jpg", indi, "������"));
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file/category.txt"))){
			oos.writeObject(CateList);
		} catch (IOException e) {
			System.out.println("category.txt ���� ���忡 �����Ͽ����ϴ�.");
		}
	}
	

}
