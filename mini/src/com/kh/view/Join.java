package com.kh.view;

import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.kh.model.controller.ProductController;
import com.kh.model.controller.UserController;
import com.kh.model.vo.Product;
import com.kh.model.vo.User;

public class Join extends JPanel {
	private JFrame mainFrame;
	private UserController uc = new UserController();
//	private ProductController pc = new ProductController();
	//��� ����Ʈ
	private ArrayList<User> list = uc.openList();


	public Join(JFrame mf) {
		mainFrame = mf;
		this.setLayout(null);
		JPanel p = new JPanel();
		Label l_id = new Label("���̵�");
		JButton idCheck = new JButton("�ߺ�Ȯ��");
		Label l_pwd = new Label("��й�ȣ ");
		Label l_pwdcheck = new Label("���� ��ҹ��� , Ư������ ���� 8���� �̻�");
		JButton pwdCheck = new JButton("Ȯ��");
		Label l_name = new Label("�̸�");
		Label l_age = new Label("����");
		Label l_address = new Label("�ּ�");
		Label l_cardNum = new Label("ī���ȣ");
		Label l_payNum = new Label("������й�ȣ");

		add(l_id);
		add(idCheck);
		add(pwdCheck);
		add(l_pwd);
		add(l_pwdcheck);
		add(l_name);
		add(l_age);
		add(l_address);
		add(l_cardNum);
		add(l_payNum);
		TextField t_id = new TextField();
		TextField pwd = new TextField();
		TextField name = new TextField();
		TextField age = new TextField();
		TextField address = new TextField();
		TextField cardNum = new TextField();
		TextField paypwd = new TextField();

		add(t_id);
		add(pwd);
		add(name);
		add(age);
		add(address);
		add(cardNum);
		add(paypwd);
		pwd.setEchoChar('*');
		paypwd.setEchoChar('*');
		JButton save = new JButton("����");
		JButton cancel = new JButton("���");
		add(save);
		add(cancel);
		l_id.setBounds(110, 10, 40, 40);
		l_pwd.setBounds(100, 50, 50, 40);
		l_name.setBounds(110, 125, 60, 40);

		l_age.setBounds(110, 170, 40, 40);
		l_address.setBounds(100, 220, 60, 40);
		l_cardNum.setBounds(90, 260, 90, 40);
		l_payNum.setBounds(90, 300, 90, 40);

		t_id.setBounds(180, 10, 200, 30);
		pwd.setBounds(180, 50, 200, 30);
		name.setBounds(180, 130, 200, 30);

		age.setBounds(180, 170, 50, 30);
		address.setBounds(180, 220, 200, 30);
		cardNum.setBounds(180, 270, 200, 30);
		paypwd.setBounds(180, 320, 200, 30);

		save.setBounds(145, 400, 80, 30);
		cancel.setBounds(260, 400, 80, 30);
		idCheck.setBounds(390, 10, 90, 30);
		pwdCheck.setBounds(390, 50, 90, 30);
		l_pwdcheck.setBounds(180, 80, 300, 40);
		pwdCheck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String pwPattern = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,20}$";

				String a = pwd.getText().toString();

				Boolean tt = Pattern.matches(pwPattern, a);

				if (tt == true) {
					l_pwdcheck.setText("��� ������ ��й�ȣ �Դϴ�.");
					return;
				} else {
					l_pwdcheck.setText("��� �Ұ����� ��й�ȣ �Դϴ�.");
					return;
				}
			}

		});

		setVisible(true);
		
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent T) {// ȸ������ ������ ����
				
				try { 
				
					if (t_id.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "���̵� �Է��ϼ���");
					} else if (pwd.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "��й�ȣ�� �Է��ϼ���");
					} else if (name.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "�̸��� �Է��ϼ���");
					} else if (age.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "���̸� �Է��ϼ���");
					} else if (address.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "�ּҸ� �Է��ϼ���");
					} else if (cardNum.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "ī���ȣ�� �Է��ϼ���");
					} else if (paypwd.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "������й�ȣ�� �Է��ϼ���");
					} else {
						String name1 = name.getText();
						String pwd1 = pwd.getText();
						String t_id1 = t_id.getText();
						int age1 = Integer.parseInt(age.getText());
						String address1 = address.getText();
			
						int cardNum1 = Integer.parseInt(cardNum.getText());
						String paypwd1 = paypwd.getText();
						

						User user = new User(name1, age1, t_id1, pwd1, paypwd1, address1, cardNum1);
						uc.addList(user);
						uc.saveList();

						JOptionPane.showMessageDialog(null, "ȸ�������� �����մϴ�!!");
						mf.getContentPane().removeAll();
						mf.getContentPane().add(new Login(mf));
						mf.repaint();
						mf.setVisible(true);
					}
				
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "ȸ�����Կ� �����Ͽ����ϴ�.");
				}

			}

		});
		// ------------------------------------------------------------------

		cancel.addActionListener(new ActionListener() { // ���

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mf.getContentPane().removeAll();
				mf.getContentPane().add(new Login(mf));
				mf.repaint();
				mf.setVisible(true);
			}

		});

		idCheck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
				
					for(int i = 0; i < list.size(); i++) {
						if (t_id.getText().equals(list.get(i).getId())) {
							JOptionPane.showMessageDialog(null, "�ߺ��� ���̵��Դϴ�.");
//							break;
							return;
						}/*else {
							JOptionPane.showMessageDialog(null, "���̵� ��� ����");
						}*/
					}
					JOptionPane.showMessageDialog(null, "���̵� ��� ����");
					
					
					

				}
				catch (Exception ex) {
		               JOptionPane.showMessageDialog(null, "ȸ�����Կ� �����Ͽ����ϴ�.");
		            }
				
			}

		});
	}
}