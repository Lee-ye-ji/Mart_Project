package com.kh.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.kh.model.controller.UserController;
import com.kh.model.vo.User;

public class Login extends JPanel{
   Image img = null;
   private UserController uc = new UserController();
   private ArrayList<User> list = uc.openList();
   
   public Login(JFrame mf) {
     
      this.setLayout(null);
      this.setBackground(Color.white);
      JLabel label = new JLabel(new ImageIcon("image/KHmart_logo.jpeg"));
      add(label);
      Label labelId = new Label("���̵�");
      add(labelId);
      labelId.setBackground(Color.WHITE);
      Label labelPwd = new Label("��й�ȣ");
      add(labelPwd);
      labelPwd.setBackground(Color.WHITE);
      TextField IdF = new TextField();
      add(IdF);
      TextField pwdLabel = new TextField();
      add(pwdLabel);
      pwdLabel.setEchoChar('*');// ��ȣȭ
      JButton login = new JButton("�α���"); // �α��� ��ư
      add(login);
      JButton join = new JButton("ȸ������"); // ȸ������ ��ư
      add(join);
      label.setBounds(0, 0, 700, 255);
      labelId.setBounds(153, 260, 40, 40);
      labelPwd.setBounds(140, 300, 60, 40);
      IdF.setBounds(220, 265, 200, 30);
      pwdLabel.setBounds(220, 305, 200, 30);
      login.setBounds(450, 265, 80, 30);
      join.setBounds(450, 305, 90, 30);
      
      this.setSize(700, 400);
      this.setLocation(550, 300);
      
      setVisible(true);
      join.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            mf.getContentPane().removeAll();
            mf.getContentPane().add(new Join(mf));
            mf.repaint();
            mf.setVisible(true);
         }
      });
      ;
      

      login.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			for(int i = 0; i < list.size(); i++) {
				if (IdF.getText().equals(list.get(i).getId()) && pwdLabel.getText().equals(list.get(i).getPwd())) {
					JOptionPane.showMessageDialog(null, "�α����� �Ǿ����ϴ�!!");
					 mf.getContentPane().removeAll();
                     mf.getContentPane().add(new ProductPage(mf));                                     //���⿡ �α��� ������ ���������� �־��ּ���
                     mf.repaint();
                     mf.setVisible(true);
                     return;  
				}else if(IdF.getText().equals(list.get(i).getId()) && !pwdLabel.getText().equals(list.get(i).getPwd())){
					JOptionPane.showMessageDialog(null, "��й�ȣ�� Ʋ���ϴ�");
					return;
				}
				if(IdF.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "���̵� �Է����ּ���");
                    return;
                 }else if(pwdLabel.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "��й�ȣ�� �Է����ּ���");
                    return;
                 }
			}
			JOptionPane.showMessageDialog(null, "�α����� �����Ͽ����ϴ�.");
		}
    	  
      });
     
   }
}