package com.kh.model.dao;

import java.util.ArrayList;

import com.kh.model.vo.Product;

public class ProductDao {
	public ArrayList<Product>openMemberListFile(){
		ArrayList<Product>list = new ArrayList<>();
		
		list.add(new Product("��ġ���",1500,5,"image/��ġ���.jpeg",false));
		list.add(new Product("����",2500,5,"image/����.jpeg",true));
		return list;
		
	}
}
