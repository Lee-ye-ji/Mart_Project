package com.kh.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.model.controller.UserController;
import com.kh.model.vo.User;

public class ProductPage extends JPanel implements ActionListener{
	private JFrame mainFrame;
	private UserController uc = new UserController();
	public ProductPage(JFrame mf) {
		mainFrame = mf;

		this.setLayout(null);
		
		JLabel productpage = new JLabel("PRODUCT PAGE");
		productpage.setBounds(575,0,100,30);
		this.add(productpage);
		
		JPanel top = new JPanel();
		top.setBounds(100,50,1000,500);
		
		//�̹��� ũ�� �����Ͽ� �̹��� ��ü ����
		Image logo = new ImageIcon("image/KHmart_logo.jpeg").getImage().getScaledInstance(500, 250, 0);
		//������� �̹��� ��ü�� JLabel�� �ֱ�
		JLabel logo1 = new JLabel(new ImageIcon(logo));
		
		JButton mypage = new JButton("����������");
		mypage.setPreferredSize(new Dimension(100, 80));
		JButton recipe = new JButton("�����Ǻ���");
		recipe.setPreferredSize(new Dimension(100, 80));
		JButton cart = new JButton("��ٱ���");
		cart.setPreferredSize(new Dimension(100, 80));
	
		mypage.addActionListener(this);
	
		
		//�����̸� ����
		ArrayList<User>list = uc.getUserList();
		JLabel userName = new JLabel(list.get(0).getName());

		top.add(userName);
		top.add(logo1);
		top.add(mypage);
		top.add(recipe);
		top.add(cart);
		top.setBackground(Color.white);
		this.setBackground(Color.white);
		this.add(top,"Center");
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel changePanel = null;
		if(e.getSource() instanceof JButton) {
			JButton btn = (JButton)e.getSource();
			switch(btn.getText()) {
			case "����������":
				changePanel = new myPage(mainFrame);
				break;
			case "�����Ǻ���":
				changePanel = new myPage(mainFrame);
				break;
			case "��ٱ���":
				changePanel = new myPage(mainFrame);
				break;
			}
			mainFrame.getContentPane().removeAll();
			mainFrame.getContentPane().add(changePanel);
			mainFrame.repaint();
			mainFrame.setVisible(true);
		}
		
	}
}