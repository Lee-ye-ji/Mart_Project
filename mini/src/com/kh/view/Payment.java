package com.kh.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.model.controller.ProductController;
import com.kh.model.controller.UserController;
import com.kh.model.dao.ProductDao;
import com.kh.model.vo.Product;
import com.kh.model.vo.User;

public class Payment extends JPanel {

   private JFrame mainFrame;

   // ��ٱ��� �ֹ��ϱ� ��ư Ŭ���� --> �̺�Ʈ�߻� --> ���� â���� �Ѿ���鼭 ���� ���� �ݾ� ����ϱ�
   // ȸ�� �� ���� ����Ʈ�� �̺�Ʈ �߻��ؾ��ϳ� ?
   // ���� �� ���� ����Ʈ : �� ���� �ݾ� - ȸ�� �� ���� ����Ʈ

   ProductController pc = new ProductController();
   ProductDao pd = new ProductDao();
   UserController uc = new UserController();
   User loginUser = uc.getLogin();
   ArrayList<Product> productList = pc.getProductList();
   ArrayList<Product> list = pc.getBasketList();
   ArrayList<User> userlist = uc.openList();
   int pointSum = 0;
   int priceSum;
   int remainpoint;
   JTextField rpText = new JTextField(15);

   public Payment() {
   }

   public Payment(JFrame mf, int totalSum) {

      mainFrame = mf;

      // ��Ʈ
      Font ttfBase = null;
      Font ttfReal = null;
      try {
         BufferedInputStream myStream = new BufferedInputStream(new FileInputStream("BMJUA_ttf.ttf"));
         ttfBase = Font.createFont(Font.TRUETYPE_FONT, myStream);
         ttfReal = ttfBase.deriveFont(Font.PLAIN, 15);
         System.out.println(ttfReal);
      } catch (FileNotFoundException e1) {
         // TODO Auto-generated catch block
         e1.printStackTrace();
      } catch (FontFormatException e1) {
         // TODO Auto-generated catch block
         e1.printStackTrace();
      } catch (IOException e1) {
         // TODO Auto-generated catch block
         e1.printStackTrace();
      }
      this.setLayout(new BorderLayout());
      this.setBackground(Color.white);

      // this.setLayout(null);
      // this.setBackground(Color.red);
      JLabel label = new JLabel(new ImageIcon("image/KHmart_logo.jpeg"));
      label.setBounds(0, 0, 700, 255);
//         this.add(label);

      JPanel top = new JPanel();
      top.setBackground(new Color(241, 194, 50)); // �����
      // top.setPreferredSize(new Dimension(150, 50));
      this.add(top, "North");

      Image logo = new ImageIcon("image/logo.png").getImage().getScaledInstance(150, 150, 0);
      // ������� �̹��� ��ü�� JLabel�� �ֱ�
      JLabel logo1 = new JLabel(new ImageIcon(logo));
      top.add(logo1, BorderLayout.WEST);

      JLabel text = new JLabel("�����ϱ�");
      top.add(text);
      text.setFont(ttfReal.deriveFont(50f));

      JLabel title = new JLabel("MYPAGE");
      title.setFont(new Font("�������", Font.BOLD, 20));
      title.setBounds(310, 220, 100, 30);
//         this.add(title);

      // this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      // this.setBorder(new EmptyBorder(0, 150, 0, 150));
      // this.setBackground(new Color(106, 168, 79));

      /*
       * JPanel titlePanel = new JPanel(); JLabel title1 = new
       * JLabel("KHMart Payment"); title1.setFont(ttfReal.deriveFont(40.0f));
       * //title.setFont(new Font("�������", Font.BOLD, 50));
       * titlePanel.setBackground(new Color(106, 168, 79)); title.setBorder(new
       * EmptyBorder(50, 0, 50, 0)); titlePanel.add(title1);
       */

      JPanel main = new JPanel();
      main.setBackground(new Color(106, 168, 79)); // �ʷϻ�
      main.setLayout(null);

      this.add(main, BorderLayout.CENTER);

      JLabel t1 = new JLabel("�ֹ��� ����");
      t1.setFont(ttfReal.deriveFont(30f));
      t1.setForeground(Color.WHITE);
      main.add(t1);

      JLabel name = new JLabel("�̸�:");
      name.setBackground(new Color(106, 168, 79));
      name.setFont(ttfReal.deriveFont(30f));
      name.setForeground(Color.WHITE);
      name.setBounds(190, 80, 145, 200);
      main.add(name);

      JTextField nameText = new JTextField(15);
      nameText.setEditable(false);
      nameText.setFont(ttfReal.deriveFont(25f));
      nameText.setBackground(new Color(106, 168, 79));
      nameText.setBounds(270, 165, 200, 30);
      main.add(nameText);

      // �̸� �� ��������
      nameText.setText(loginUser.getName() + " ");

      JLabel add = new JLabel("�ּ�:");
      add.setBackground(new Color(106, 168, 79));
      add.setFont(ttfReal.deriveFont(30f));
      add.setForeground(Color.WHITE);
      add.setBounds(name.getX(), name.getY() + 80, 145, 200);
      main.add(add);

      JTextField addText = new JTextField(15);
      addText.setEditable(false);
      addText.setFont(ttfReal.deriveFont(25f));
      addText.setBackground(new Color(106, 168, 79));
      addText.setBounds(nameText.getX(), nameText.getY() + 80, 200, 30);
      main.add(addText);

      // �ּҰ� ��������
      addText.setText(loginUser.getAddress() + " ");

      JLabel point = new JLabel("����Ʈ:");
      point.setBackground(new Color(106, 168, 79));
      point.setFont(ttfReal.deriveFont(30f));
      point.setForeground(Color.WHITE);
      point.setBounds(add.getX() - 25, add.getY() + 80, 145, 200);
      main.add(point);

      JTextField pointText = new JTextField(15);
      pointText.setEditable(false);
      pointText.setFont(ttfReal.deriveFont(25f));
      pointText.setBackground(new Color(106, 168, 79));
      pointText.setBounds(addText.getX(), addText.getY() + 80, 200, 30);
      main.add(pointText);

      // �� ����Ʈ ��������

      pointText.setText(loginUser.getPoint() + " point");

      JLabel pSum = new JLabel("�� ���� ����Ʈ:");
      pSum.setBackground(new Color(106, 168, 79));
      pSum.setFont(ttfReal.deriveFont(30f));
      pSum.setForeground(Color.WHITE);
      pSum.setBounds(name.getX() + 400, name.getY(), 200, 200);
      main.add(pSum);

      JTextField pointSumText = new JTextField(15);
      pointSumText.setEditable(false);
      pointSumText.setFont(ttfReal.deriveFont(25f));
      pointSumText.setBackground(new Color(106, 168, 79));
      pointSumText.setBounds(name.getX() + 580, name.getY() + 87, 200, 30);
      main.add(pointSumText);

      // �� ����Ʈ ��������
      pointSum = loginUser.getPoint();
      pointSumText.setText(pointSum + "  point");

      JLabel resultPoint = new JLabel("���� �� ����Ʈ:");
      resultPoint.setBackground(new Color(106, 168, 79));
      resultPoint.setFont(ttfReal.deriveFont(30f));
      resultPoint.setForeground(Color.WHITE);
      resultPoint.setBounds(add.getX() + 400, add.getY(), 200, 200);
      main.add(resultPoint);

      rpText.setEditable(false);
      rpText.setFont(ttfReal.deriveFont(25f));
      rpText.setBackground(new Color(106, 168, 79));
      rpText.setBounds(pointSumText.getX(), addText.getY(), 200, 30);
      main.add(rpText);

      // ���� �� ����Ʈ
      priceSum = totalSum;
      remainpoint = pointSum - priceSum;
      System.out.println(remainpoint);
      rpText.setText(remainpoint + "  point");

      JLabel tSum = new JLabel("�� ���� �ݾ�:");
      tSum.setBackground(new Color(106, 168, 79));
      tSum.setFont(ttfReal.deriveFont(30f));
      tSum.setForeground(Color.WHITE);
      tSum.setBounds(point.getX() + 450, point.getY(), 200, 200);
      main.add(tSum);

      JTextField tSumText = new JTextField(15);
      tSumText.setEditable(false);
      tSumText.setFont(ttfReal.deriveFont(25f));
      tSumText.setBackground(new Color(106, 168, 79));
      tSumText.setBounds(rpText.getX(), pointText.getY(), 200, 30);
      main.add(tSumText);

      // ��ٱ��� ���� ���� ��������


      System.out.println(priceSum + "��");
      tSumText.setText(priceSum + " point");

      JButton payB = new JButton("����");

      payB.setFont(ttfReal.deriveFont(40f));
      payB.setForeground(Color.black);
      payB.setBackground(new Color(241, 194, 50));
      payB.setBounds(770, 470, 200, 120);
      main.add(payB);

      JButton l3 = new JButton("����");
      l3.setForeground(Color.black);
      l3.setFont(ttfReal.deriveFont(40f));
      l3.setBackground(new Color(241, 194, 50));
      l3.setBounds(550, 470, 200, 120);

      main.add(l3);

      ////

      l3.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            mf.getContentPane().removeAll();
            mf.getContentPane().add(new Basket(mf));
            mf.repaint();
            mf.setVisible(true);

         }

      });

      payB.addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) {
             // if, ���� ����Ʈ > �� ���� �ݾ� --> ���� ��й�ȣ �Է� â (�߸� �Է� ���� ��� �ٽ� �Է��ϰ�)
             // JPasswordField pwd = new JPasswordField(30);
             if (pointSum < priceSum) {
                JOptionPane.showMessageDialog(null, "���� ����Ʈ�� �����մϴ�.");
             } else {
                /*
                 * String pass = JOptionPane.showInputDialog("���� ��й�ȣ�� �Է��ϼ���."); if
                 * (pass.equals(pwd)) { JOptionPane.showMessageDialog(null, "���� �Ϸ� �Դϴ�."); //
                 * basket list -> list // productList
                 */
                String userPwd = "";
                userPwd = loginUser.getPaypwd();
                
                Dialog checkPwdDialog = new Dialog(mf, "���� ��й�ȣ Ȯ��");
                checkPwdDialog.setBounds(750, 420, 250, 70);
                checkPwdDialog.setSize(300, 200);
                checkPwdDialog.setLayout(null);

                JLabel pwdText = new JLabel("���� ��й�ȣ�� �Է��ϼ���");
                pwdText.setBounds(30, 30, 200, 20);
                checkPwdDialog.add(pwdText);

                TextField pass = new TextField();
                pass.setBounds(30, 50, 200, 100);
                pass.setEchoChar('*');

                JButton ok = new JButton("Ȯ��");
                checkPwdDialog.add(ok);
                ok.setBounds(30, 150, 70, 25);
                checkPwdDialog.add(pass);

                ok.addActionListener(new ActionListener() {
                   
                   String userPwd = "";

                   @Override
                   public void actionPerformed(ActionEvent e) {

                      if (pass.getText().equals(loginUser.getPaypwd())) {
                         JOptionPane.showMessageDialog(null, "Ȯ�εǾ����ϴ�.");

                         // �ܼ�â Ȯ�� �ڵ�
                         for (int i = 0; i < list.size(); i++) {
                            System.out.println(list);
                            System.out.println("��ٱ��� ���õ� ����:" + list.get(i).getCnt());
                            System.out.println("��ǰ������ ���� : " + productList.get(i).getCnt());
                            System.out.println("��ǰ������ ���� ���� :"
                                  + (productList.get(i).getCnt() - list.get(i).getCnt()) + "");
                         }

                         for (int i = 0; i < list.size(); i++) {
                            for (int j = 0; j < productList.size(); j++) {
                             	System.out.println("product list change");
                               if (productList.get(j).getpName().equals(list.get(i).getpName())) {
                                  productList.get(j).setCnt((productList.get(j).getCnt() - list.get(i).getCnt()));
                                  pc.saveProductFile(productList);
                               }
                         }
                         }
                         // ��ǰ���Ͽ� �����ϱ�
                         
                         loginUser.setPoint(pointSum - priceSum);
                         uc.saveLogin(loginUser);
                         for (int i = 0; i < userlist.size(); i++) {
                            if (userlist.get(i).getId().equals(loginUser.getId())) {
                             	System.out.println("user list change");
                               userlist.get(i).setPoint(pointSum - priceSum);
                               uc.saveList(userlist);
                               System.out.println(userlist.get(i).getPoint());
                            }
                         }

                         // ���� �Ϸ� �� ��ǰ������ �Ѿ��
                         JPanel changePanel = new ProductPage(mainFrame);
                         mainFrame.getContentPane().removeAll();
                         mainFrame.getContentPane().add(changePanel);
                         mainFrame.repaint();
                         mainFrame.setVisible(true);
                         checkPwdDialog.dispose();

                      } else {
                         JOptionPane.showMessageDialog(null, "��й�ȣ�� �ٽ� �Է����ּ���.", "��й�ȣ ����",
                               JOptionPane.ERROR_MESSAGE);
                      }
                   }

                });
                
                JButton cancel = new JButton("���");
                checkPwdDialog.add(cancel);
                cancel.setBounds(103, 150,  70, 25);
                checkPwdDialog.setVisible(true);

                cancel.addActionListener(new ActionListener() {

                   @Override
                   public void actionPerformed(ActionEvent e) {
                      // TODO Auto-generated method stub
                      checkPwdDialog.dispose();

                   }

                });
                checkPwdDialog.add(pass);

             }
          }
       });
      JLabel text1 = new JLabel("�ֹ��� ����");
      text1.setForeground(Color.white);
      text1.setFont(ttfReal.deriveFont(25f));
      text1.setBackground(new Color(106, 168, 79));
      text1.setBounds(270, 80, 200, 30);

      main.add(text1);

      JLabel text2 = new JLabel("���� �� ����Ʈ ����");
      text2.setForeground(Color.white);
      text2.setFont(ttfReal.deriveFont(25f));
      text2.setBackground(new Color(106, 168, 79));
      text2.setBounds(700, 80, 600, 30);

      main.add(text2);

      if (remainpoint < 0) {
         JButton plus = new JButton("����Ʈ����");
         plus.setFont(ttfReal.deriveFont(25f));
         plus.setForeground(Color.black);
         plus.setBackground(new Color(241, 194, 50));
         main.add(plus);
         plus.setBounds(780, 375, 180, 45);
         plus.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               mf.getContentPane().removeAll();
               mf.getContentPane().add(new AddPoint2(mf, totalSum));
               mf.repaint();
               mf.setVisible(true);

            }

         });

      }

   }
}