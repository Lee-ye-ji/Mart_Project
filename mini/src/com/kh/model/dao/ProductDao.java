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

  
   public ArrayList<Product>openProductListFile(){
	      

	      ArrayList<Product>productList = new ArrayList<>();
	      try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("productList.dat"))){
	   
	         productList = (ArrayList<Product>) ois.readObject();
	         
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
	   
	      return productList;
	      
	   }
   
   public void saveProductListFile(ArrayList<Product> productList){
	 //�̰�ó���� ��ǰ ����Ʈ �־��ٶ�
	 /*  ArrayList<Product>productList = new ArrayList<>();
	   {
		      productList.add(new Product("����",2500,5,"image/����.png",true));
		      productList.add(new Product("��ġ���",1500,5,"image/��ġ���.png",false));
		      productList.add(new Product("��������",3500,5,"image/��������.png",false));
		      productList.add(new Product("����",1500,5,"image/����.png",true));
		      productList.add(new Product("���ɸ�",2000,5,"image/���ɸ�.png",true));
		      productList.add(new Product("����Ĩ",1500,5,"image/����Ĩ.png",false));
		      productList.add(new Product("����Ĩ",3000,5,"image/����Ĩ.png",false));
		      productList.add(new Product("�޹�",1700,5,"image/�޹�.png",false));
		      productList.add(new Product("���",700,5,"image/���.png",false));
		      productList.add(new Product("�������",6000,5,"image/�������.png",false));
		   }*/
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