package com.kh.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.kh.model.vo.Product;

public class ProductDao {

	private ArrayList<Product>productList = new ArrayList<>();
	
	{
		productList.add(new Product("����",2500,5,"image/����.jpeg",true));
		productList.add(new Product("��ġ���",1500,5,"image/��ġ���.jpeg",false));
	}
	//�̰�ó���� ��ǰ ����Ʈ �־��ٶ�
	public void saveProductListFile(){
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("productList.dat"))){

			oos.writeObject(productList);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	//��ٱ��Ͽ� ���� ����Ʈ �ִ� �޼ҵ�
	public void saveBasketList(ArrayList<Product> p){
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("basketList.dat"))){

			oos.writeObject(p);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	public ArrayList<Product>openProductListFile(){
		

		ArrayList<Product>list = new ArrayList<>();
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("productList.dat"))){
	
			list = (ArrayList<Product>) ois.readObject();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return list;
		
	}
	public ArrayList<Product>openBasketListFile(){
		

		ArrayList<Product>list = new ArrayList<>();
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("basketList.dat"))){
	
			list = (ArrayList<Product>) ois.readObject();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return list;
		
	}
}
