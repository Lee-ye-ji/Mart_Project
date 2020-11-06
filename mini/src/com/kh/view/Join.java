package com.kh.view;

import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.kh.model.vo.User;

public class Join extends JPanel{
	private JFrame mainFrame;

	public Join(JFrame mf) {
		mainFrame = mf;
		this.setLayout(null);
		JPanel p = new JPanel();
		Label l_id = new Label("���̵�");
		JButton idCheck = new JButton("�ߺ�Ȯ��");
		Label l_pwd = new Label("��й�ȣ ");
		Label l_name = new Label("�̸�");
		Label l_age = new Label("����");
		Label l_cardNum = new Label("ī���ȣ");
		Label l_payNum = new Label("������й�ȣ");
		add(l_id);
		add(idCheck);
		add(l_pwd);
		add(l_name);
		add(l_age);
		add(l_cardNum);
		add(l_payNum);
		TextField t_id = new TextField();
		TextField pwd = new TextField();
		TextField name = new TextField();
		TextField age = new TextField();
		TextField cardNum = new TextField();
		TextField paypwd = new TextField();
		add(t_id);
		add(pwd);
		add(name);
		add(age);
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
		l_name.setBounds(110, 85, 60, 40);

		l_age.setBounds(110, 130, 40, 40);
		l_cardNum.setBounds(100, 180, 60, 40);
		l_payNum.setBounds(90, 220, 90, 40);

		t_id.setBounds(180, 10, 200, 30);
		pwd.setBounds(180, 50, 200, 30);
		name.setBounds(180, 90, 200, 30);

		age.setBounds(180, 130, 50, 30);
		cardNum.setBounds(180, 180, 200, 30);
		paypwd.setBounds(180, 220, 200, 30);

		save.setBounds(145, 270, 80, 30);
		cancel.setBounds(260, 270, 80, 30);
		idCheck.setBounds(390, 10, 90, 30);

		setVisible(true);
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent T) {// ȸ������ ������ ����
				try {
					BufferedWriter bos = new BufferedWriter(new FileWriter("ȸ�����.txt", true));

					if (t_id.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "���̵� �Է��ϼ���");
					} else if (pwd.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "��й�ȣ�� �Է��ϼ���");
					} else if (name.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "�̸��� �Է��ϼ���");
					} else if (age.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "���̸� �Է��ϼ���");
					} else if (cardNum.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "ī���ȣ�� �Է��ϼ���");
					} else if (paypwd.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "������й�ȣ�� �Է��ϼ���");
					} else {
						bos.write(t_id.getText() + "/");
						bos.write(pwd.getText() + "/");
						bos.write(name.getText() + "/");
						bos.write(age.getText() + "/");
						bos.write(cardNum.getText() + "/");
						bos.write(paypwd.getText() + "\r\n");
						bos.close();
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
		cancel.addActionListener(new ActionListener() {						//���

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
					String s;
					String[] array;
					BufferedReader bos = new BufferedReader(new FileReader("ȸ�����.txt"));
					while ((s = bos.readLine()) != null) {
						array = s.split("/");
						if (t_id.getText().equals(array[0])) {
							JOptionPane.showMessageDialog(null, "�ߺ��� ���̵��Դϴ�.");
							return;
						}
					}
					JOptionPane.showMessageDialog(null, "���̵� ��� ����");

				} catch (IOException E10) {
					JOptionPane.showMessageDialog(null, "ȸ������ ����");
				}
			}

		});
	}
}