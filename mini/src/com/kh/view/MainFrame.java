package com.kh.view;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	public MainFrame() {
		this.setTitle("KHmart");
		this.setBounds(350,50,1100,900);
		
		//�������� ���� �����̳� ȣ���ؼ� �̵��ϰ��� �ϴ� �г� �߰�
		//frame �Ű����� �����ϸ鼭
//		this.getContentPane().add(new Login(this));
		this.getContentPane().add(new ProductPage(this));
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
