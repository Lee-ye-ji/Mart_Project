package com.kh.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.kh.model.controller.ProductController;
import com.kh.model.controller.UserController;
import com.kh.model.dao.ProductDao;
import com.kh.model.vo.Product;
import com.kh.model.vo.User;

public class pa extends JPanel {

   private JFrame mainFrame;

   // ��ٱ��� �ֹ��ϱ� ��ư Ŭ���� --> �̺�Ʈ�߻� --> ���� â���� �Ѿ���鼭 ���� ���� �ݾ� ����ϱ�
   // ȸ�� �� ���� ����Ʈ�� �̺�Ʈ �߻��ؾ��ϳ� ?
   // ���� �� ���� ����Ʈ : �� ���� �ݾ� - ȸ�� �� ���� ����Ʈ

   ProductController pc = new ProductController();
   ProductDao pd = new ProductDao();
   UserController uc = new UserController();
   User userList = uc.getLogin();
   ArrayList<Product> productList = pc.getProductList();
   ArrayList<Product> list = pc.getBasketList();
   int pointSum = 0;
   int priceSum;
   int remainpoint;
   JTextField remainPointText = new JTextField(15);

   public pa() {
   }

   public pa(JFrame mf, int totalSum) {

      
      mainFrame = mf;
      
      //��Ʈ 
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

      

      //   this.setLayout(null);
      //   this.setBackground(Color.red);
         JLabel label = new JLabel(new ImageIcon("image/KHmart_logo.jpeg"));
         label.setBounds(0, 0, 700, 255);
//         this.add(label);
      
         JPanel top = new JPanel();
         top.setBackground(new Color(241, 194, 50)); // ����� 
         //top.setPreferredSize(new Dimension(150, 50));
         this.add(top,BorderLayout.NORTH);
         
         Image logo = new ImageIcon("image/logo.png").getImage().getScaledInstance(150, 150, 0);
            // ������� �̹��� ��ü�� JLabel�� �ֱ�
            JLabel logo1 = new JLabel(new ImageIcon(logo));top.add(logo1, BorderLayout.WEST);
         
           JLabel text = new JLabel("�����ϱ�");
         top.add(text);
         text.setFont(ttfReal.deriveFont(50f));
         
         JLabel title = new JLabel("MYPAGE");
         title.setFont(new Font("�������", Font.BOLD, 20));
         title.setBounds(310, 220, 100, 30);
//         this.add(title);
         
         

      //this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      //this.setBorder(new EmptyBorder(0, 150, 0, 150));
      //this.setBackground(new Color(106, 168, 79));

      /*JPanel titlePanel = new JPanel();
      JLabel title1 = new JLabel("KHMart Payment");
      title1.setFont(ttfReal.deriveFont(40.0f));
      //title.setFont(new Font("�������", Font.BOLD, 50));
      titlePanel.setBackground(new Color(106, 168, 79));
      title.setBorder(new EmptyBorder(50, 0, 50, 0));
      titlePanel.add(title1);*/
         
         
      JPanel main = new JPanel();
      main.setBackground(new Color(106, 168, 79)); // �ʷϻ�
      main.setLayout(null);
      
      this.add(main,BorderLayout.CENTER);

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
      
      JLabel add = new JLabel("�ּ�:");
      add.setBackground(new Color(106, 168, 79));
      add.setFont(ttfReal.deriveFont(30f));
      add.setForeground(Color.WHITE);
      add.setBounds(name.getX(), name.getY()+80, 145, 200);
      main.add(add);
      
      
      JTextField addText = new JTextField(15);
      addText.setEditable(false);
      addText.setFont(ttfReal.deriveFont(25f));
      addText.setBackground(new Color(106, 168, 79));
      addText.setBounds(nameText.getX(), nameText.getY()+80, 200, 30);
      main.add(addText);
      
      JLabel point = new JLabel("����Ʈ:");
      point.setBackground(new Color(106, 168, 79));
      point.setFont(ttfReal.deriveFont(30f));
      point.setForeground(Color.WHITE);
      point.setBounds(add.getX() -25, add.getY()+80, 145, 200);
      main.add(point);
      
      JTextField pointText = new JTextField(15);
      pointText.setEditable(false);
      pointText.setFont(ttfReal.deriveFont(25f));
      pointText.setBackground(new Color(106, 168, 79));
      pointText.setBounds(addText.getX(), addText.getY()+80, 200, 30);
      main.add(pointText);
      
      JLabel pointSum = new JLabel("�� ���� ����Ʈ:");
      pointSum.setBackground(new Color(106, 168, 79));
      pointSum.setFont(ttfReal.deriveFont(30f));
      pointSum.setForeground(Color.WHITE);
      pointSum.setBounds(name.getX() +400, name.getY(), 200, 200);
      main.add(pointSum);
      
      JTextField pointSumText = new JTextField(15);
      pointSumText.setEditable(false);
      pointSumText.setFont(ttfReal.deriveFont(25f));
      pointSumText.setBackground(new Color(106, 168, 79));
      pointSumText.setBounds(name.getX()+580, name.getY()+87, 200, 30);
      main.add(pointSumText);
      
      JLabel resultPoint = new JLabel("���� �� ����Ʈ:");
      resultPoint.setBackground(new Color(106, 168, 79));
      resultPoint.setFont(ttfReal.deriveFont(30f));
      resultPoint.setForeground(Color.WHITE);
      resultPoint.setBounds(add.getX() +400, add.getY(), 200, 200);
      main.add(resultPoint);
      
      JTextField rpText = new JTextField(15);
      rpText.setEditable(false);
      rpText.setFont(ttfReal.deriveFont(25f));
      rpText.setBackground(new Color(106, 168, 79));
      rpText.setBounds(pointSumText.getX(), addText.getY(), 200, 30);
      main.add(rpText);
      
      JLabel tSum = new JLabel("�� ���� �ݾ�:");
      tSum.setBackground(new Color(106, 168, 79));
      tSum.setFont(ttfReal.deriveFont(30f));
      tSum.setForeground(Color.WHITE);
      tSum.setBounds(point.getX() +450, point.getY(), 200, 200);
      main.add(tSum);
      
      JTextField tSumText = new JTextField(15);
      tSumText.setEditable(false);
      tSumText.setFont(ttfReal.deriveFont(25f));
      tSumText.setBackground(new Color(106, 168, 79));
      tSumText.setBounds(rpText.getX(), pointText.getY(), 200, 30);
      main.add(tSumText);
      
      
      
      
    
      
      //if (remainpoint < 0) {
          JButton plus = new JButton("����Ʈ����");
          plus.setFont(ttfReal.deriveFont(25f));
          plus.setForeground(Color.WHITE);
          plus.setBackground(new Color(241, 194, 50));
          main.add(plus);
          plus.setBounds(800,375, 170, 30);
          plus.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                mf.getContentPane().removeAll();
                mf.getContentPane().add(new AddPoint2(mf, totalSum));
                mf.repaint();
                mf.setVisible(true);

             }

          });
          
          
          

      // }
          
          
          JButton payB = new JButton("����");
          
          
          payB.setFont(ttfReal.deriveFont(40f));
          payB.setForeground(Color.WHITE);
          payB.setBackground(new Color(241, 194, 50));
          payB.setBounds(770,470,200,120);
          main.add(payB);
          
          JButton l3 = new JButton("����");
          l3.setForeground(Color.WHITE);
          l3.setFont(ttfReal.deriveFont(40f));
          l3.setBackground(new Color(241, 194, 50));
          l3.setBounds(550,470, 200, 120);
          
          main.add(l3);
          
          
          JLabel text1 = new JLabel("�ֹ��� ����");
          text1.setForeground(Color.white);
          text1.setFont(ttfReal.deriveFont(25f));
          text1.setBackground(new Color(106, 168, 79));
          text1.setBounds(270,80,200,30);
          
          main.add(text1);
          
          JLabel text2 = new JLabel("���� �� ����Ʈ ����");
          text2.setForeground(Color.white);
          text2.setFont(ttfReal.deriveFont(25f));
          text2.setBackground(new Color(106, 168, 79));
          text2.setBounds(700,80,600,30);
          
          main.add(text2);
          
          
          
          
          
          
          
          JPanel paymentRequest = new JPanel();
          paymentRequest.setBackground(new Color(106, 168, 79));
          paymentRequest.setLayout(new GridLayout(3, 0, 0, 10));
          paymentRequest.setSize(800, 300);

          JPanel t3Panel = new JPanel();
          t3Panel.setBackground(new Color(106, 168, 79));
          JLabel t3 = new JLabel("�ֹ� ��û ���� ");
          t3.setFont(ttfReal.deriveFont(30f));
          t3.setForeground(Color.WHITE);
          t3Panel.add(t3);
          paymentRequest.add(t3Panel);

          String[] request = { "���� ������ �����ּ���.", "���� �� �̸� ���� �ּ���.", "�׳� �� �տ� �����ֽø� �ſ�.", "���ǿ� �ð��ּ���." };

          JComboBox requestList = new JComboBox(request);
          requestList.setSelectedIndex(1);

          JPanel rPanel = new JPanel();
          JLabel requestLabel = new JLabel();
          rPanel.setBackground(new Color(255, 255, 255));
          rPanel.add(requestLabel);

          requestList.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                String tx = (String) cb.getSelectedItem();
                requestLabel.setText(tx);

             }

          });

          
          
          
    }

      
       
       
   }
   
       
       
         
         
         
        ///////////////////////////////////////////////////////// 
      // �ֹ��� ���� userInfo �г� 
         
/*      JPanel userInfo = new JPanel();
      userInfo.setBackground(new Color(106, 168, 79));
      //userInfo.setSize(800, 300);

      //JPanel t1Panel = new JPanel();
      //t1Panel.setBackground(new Color(106, 168, 79));
      
      JPanel panel1 = new JPanel();
      
      JLabel t1 = new JLabel("�ֹ��� ����");
      t1.setFont(ttfReal.deriveFont(30f));
      t1.setForeground(Color.WHITE);
      t1.add(panel1);
      
      //t1Panel.add(t1);
      //userInfo.add(t1);

      //JPanel nPanel = new JPanel();
      //nPanel.setBackground(new Color(106, 168, 79));
      JPanel panel2 = new JPanel(new GridLayout(3,2));
      
      JLabel name = new JLabel("�̸�: ");
      name.setFont(ttfReal.deriveFont(30f));
      name.setForeground(Color.WHITE);
      //nPanel.add(name);
      panel2.add(name);

      JTextField nameText = new JTextField(15);
      nameText.setEditable(false);
      nameText.setFont(ttfReal.deriveFont(25f));
      nameText.setBackground(new Color(106, 168, 79));
      panel2.add(nameText);

      // �̸� �� ��������

      nameText.setText(userList.getName() + " ");

      //JPanel aPanel = new JPanel();
      //aPanel.setBackground(new Color(106, 168, 79));
      JLabel address = new JLabel("�ּ�: ");
      address.setFont(ttfReal.deriveFont(30f));
      address.setForeground(Color.WHITE);
      //aPanel.add(address);
      panel2.add(address);

      JTextField addressText = new JTextField(15);
      addressText.setEditable(false);
      addressText.setFont(ttfReal.deriveFont(25f));
      addressText.setBackground(new Color(106, 168, 79));
      panel2.add(addressText);

      // �ּҰ� ��������

      addressText.setText(userList.getAddress() + " ");

      //JPanel pPanel = new JPanel();
      //pPanel.setBackground(new Color(106, 168, 79));
      JLabel point = new JLabel("����Ʈ: ");
      point.setFont(ttfReal.deriveFont(30f));
      point.setForeground(Color.WHITE);
      panel2.add(point);
      //userInfo.add(pPanel);

      JTextField pointText = new JTextField(15);
      pointText.setEditable(false);
      pointText.setFont(ttfReal.deriveFont(25f));
      pointText.setBackground(new Color(106, 168, 79));
      panel2.add(pointText);

      // �� ����Ʈ ��������

      pointText.setText(userList.getPoint() + " point");

      // �ֹ� ��û ����

      JPanel paymentRequest = new JPanel();
      paymentRequest.setBackground(new Color(106, 168, 79));
      paymentRequest.setLayout(new GridLayout(3, 0, 0, 10));
      paymentRequest.setSize(800, 300);

      JPanel t3Panel = new JPanel();
      t3Panel.setBackground(new Color(106, 168, 79));
      JLabel t3 = new JLabel("�ֹ� ��û ���� ");
      t3.setFont(ttfReal.deriveFont(30f));
      t3.setForeground(Color.WHITE);
      t3Panel.add(t3);
      paymentRequest.add(t3Panel);

      String[] request = { "���� ������ �����ּ���.", "���� �� �̸� ���� �ּ���.", "�׳� �� �տ� �����ֽø� �ſ�.", "���ǿ� �ð��ּ���." };

      JComboBox requestList = new JComboBox(request);
      requestList.setSelectedIndex(1);

      JPanel rPanel = new JPanel();
      JLabel requestLabel = new JLabel();
      rPanel.setBackground(new Color(255, 255, 255));
      rPanel.add(requestLabel);

      requestList.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox) e.getSource();
            String tx = (String) cb.getSelectedItem();
            requestLabel.setText(tx);

         }

      });

      requestLabel.setHorizontalAlignment(JLabel.LEFT);
      paymentRequest.add(requestList);
      paymentRequest.add(rPanel);
      

      // ���� �� ����Ʈ ���� paypointInfo �г� 
      
      JPanel paypointInfo = new JPanel();
      paypointInfo.setBackground(new Color(106, 168, 79));
      paypointInfo.setLayout(new GridLayout(3, 2));
      paypointInfo.setSize(800, 300);

      //JPanel t2Panel = new JPanel();
      //t2Panel.setBackground(new Color(106, 168, 79));
      JLabel t2 = new JLabel("���� �� ����Ʈ ����");
      t2.setFont(ttfReal.deriveFont(30f));
      t2.setForeground(Color.WHITE);
      paypointInfo.add(t2);
      //paypointInfo.add(t2Panel);
      
      //JPanel pointPanel = new JPanel();
      //pointPanel.setBackground(new Color(106, 168, 79));
      JLabel totalPoint = new JLabel("�� ���� ����Ʈ: ");
      totalPoint.setFont(ttfReal.deriveFont(30f));
      totalPoint.setForeground(Color.WHITE);
      totalPoint.setBackground(new Color(106, 168, 79));
      //paypointInfo.add(pointPanel);
      paypointInfo.add(totalPoint);

      JTextField totalText = new JTextField(15);
      totalText.setEditable(false);
      totalText.setFont(new Font("���� ���", Font.BOLD, 25));
      totalText.setBackground(new Color(106, 168, 79));
      paypointInfo.add(totalText);
      
      // �� ����Ʈ ��������
      pointSum = userList.getPoint();
      totalText.setText(pointSum + "  point");

      //JPanel pointafterPanel = new JPanel();
      //pointafterPanel.setBackground(new Color(106, 168, 79));
      JLabel remainPoint = new JLabel("���� �� ����Ʈ: ");
      remainPoint.setFont(ttfReal.deriveFont(30f));
      remainPoint.setForeground(Color.WHITE);
      //paypointInfo.add(paypointInfo);
      paypointInfo.add(remainPoint);

      // JTextField remainPointText = new JTextField(15); // �ʵ忡 ������
      remainPointText.setEditable(false);
      remainPointText.setFont(new Font("���� ���", Font.BOLD, 25));
      remainPointText.setBackground(new Color(106, 168, 79));
      paypointInfo.add(remainPointText);

      //JPanel paymentPanel = new JPanel();
      //paymentPanel.setBackground(new Color(106, 168, 79));
      JLabel pay = new JLabel("��  ����  �ݾ�: ");
      pay.setFont(ttfReal.deriveFont(30f));
      pay.setForeground(Color.WHITE);
      //paypointInfo.add(paymentPanel);
      paypointInfo.add(pay);

      JTextField paymentText = new JTextField(15);
      paymentText.setEditable(false);
      paymentText.setFont(new Font("���� ���", Font.BOLD, 25));
      paymentText.setBackground(new Color(106, 168, 79));
      paypointInfo.add(paymentText);
      
      // pointafterPanel , paypointInfo
      JPanel big = new JPanel(new GridLayout(1,2));
      big.setBackground(new Color(106, 168, 79));
      big.add(userInfo);
      big.add(paypointInfo);

      

      // ��ٱ��� ���� ���� ��������

      priceSum = totalSum;
      System.out.println(priceSum + "��");
      paymentText.setText(priceSum + " point");

      
       * for(int i = 0; i < productList.size(); i++) { priceSum +=
       * productList.get(i).getPrice(); paymentText.setText(priceSum +" point"); }
       

      // ���� �� ����Ʈ ��������
      remainpoint = pointSum - priceSum;
      remainPointText.setText(remainpoint + "  point");

      // �߰� �κ� ���� ū �г�
      //JPanel pnlCenter = new JPanel(new GridLayout(3, 1, 0, 20));
      //pnlCenter.setBackground(new Color(106, 168, 79));
      //pnlCenter.add(userInfo);
      //pnlCenter.add(paymentRequest);
      //pnlCenter.add(paypointInfo);

      // ��ư + �� ���� �� ���̺�

      JPanel buttonPanel = new JPanel();

      buttonPanel.setBackground(new Color(106, 168, 79));

      JButton btn1 = new JButton("����");
      JButton btn2 = new JButton("����");
      
      
      btn2.setFont(ttfReal.deriveFont(30f));
      btn2.setForeground(Color.WHITE);
      btn2.setBackground(new Color(241, 194, 50));
      
      btn1.setFont(new Font("���� ���", Font.BOLD, 25));
      btn1.setBackground(Color.BLACK);
      btn1.setForeground(Color.WHITE);
   
      //buttonPanel.setBorder(new EmptyBorder(10, 0, 10, 0));

      JLabel payL = new JLabel("���� �ݾ�: ");
      payL.setFont(ttfReal.deriveFont(30f));
      payL.setForeground(Color.WHITE);

      JTextField pText = new JTextField(15);
      pText.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      pText.setEditable(false);
      pText.setFont(new Font("���� ���", Font.BOLD, 30));
      pText.setBackground(new Color(106, 168, 79));

      
       * int priceSum1 = 0; for(int i = 0; i < productList.size(); i++) { priceSum1 +=
       * productList.get(i).getPrice(); pText.setText(priceSum1 +" point"); }
       

      //buttonPanel.add(payL);
      //buttonPanel.add(pText);
      buttonPanel.add(btn2);
      buttonPanel.add(btn1);
      
      btn1.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            mf.getContentPane().removeAll();
            mf.getContentPane().add(new Basket(mf));
            mf.repaint();
            mf.setVisible(true);

         }

      });

      String pwd = userList.getPaypwd();

      btn2.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            // if, ���� ����Ʈ > �� ���� �ݾ� --> ���� ��й�ȣ �Է� â (�߸� �Է� ���� ��� �ٽ� �Է��ϰ�)
            // JPasswordField pwd = new JPasswordField(30);
            if (pointSum < priceSum) {
               JOptionPane.showMessageDialog(null, "���� ����Ʈ�� �����մϴ�.");
            } else {
               String pass = JOptionPane.showInputDialog("���� ��й�ȣ�� �Է��ϼ���.");
               if (pass.equals(pwd)) {
                  //JOptionPane.showMessageDialog(null, "���� �Ϸ� �Դϴ�.");
                  // basket list -> list
                  // productList
                  mf.getContentPane().removeAll();
                  mf.getContentPane().add(new ProductPage(mf));
                  mf.repaint();
                  mf.setVisible(true);
                  // �ܼ�â Ȯ�� �ڵ� 
                  for (int i = 0; i < list.size(); i++) {
                     System.out.println(list);
                     System.out.println("��ٱ��� ���õ� ����:" + list.get(i).getCnt());
                     System.out.println("��ǰ������ ���� : " + productList.get(i).getCnt());
                     System.out.println("��ǰ������ ���� ���� :" + (productList.get(i).getCnt() - list.get(i).getCnt()) + "");
                  }
                  
                  for (int i = 0; i < list.size(); i++) {
                     for(int j = 0; j < productList.size(); j ++)
                     if (productList.get(j).getpName().equals(list.get(i).getpName())) {
                        productList.get(j).setCnt((productList.get(j).getCnt() - list.get(i).getCnt()));
                     }
                  }
                  // ��ǰ���Ͽ� �����ϱ� 
                  pc.saveProductFile(productList);
                  
                  // �ٲ� ���� Ȯ���ϱ� 
                  System.out.println(productList);
               } else {
                  JOptionPane.showMessageDialog(null, "��й�ȣ�� �ٽ� �Է����ּ���.", "��й�ȣ ����", JOptionPane.ERROR_MESSAGE);
               }
            }
            // else, ���� ����Ʈ�� < �� ���� �ݾ� --> ���� ����Ʈ�� �����մϴ� â �߰� --> ��� ��ư ���� �� ��ٱ��Ϸ� �̵�
         }

      }); 
      

      JPanel center = new JPanel(new GridLayout(3,1));
      center.add(big);
      center.add(buttonPanel);
      center.add(paymentRequest);
      
      
      main.add(center);
      
     // center.setBorder(new EmptyBorder(100, 0, 100, 0));
      
      //center.setBorder(new EmptyBorder(0, 150, 0, 150));

      
      //this.add(titlePanel);
      //this.add(label);
      //main.add(pnlCenter);
      
      //main.add(big);
      //main.setLayout(new BoxLayout(main, BoxLayout.X_AXIS));
      //main.add(buttonPanel);
      //main.add(paymentRequest);
      

      this.setVisible(true);
      if (remainpoint < 0) {
         JButton plus = new JButton("����Ʈ����");
         plus.setFont(ttfReal.deriveFont(30f));
         plus.setForeground(Color.WHITE);
         plus.setBackground(new Color(241, 194, 50));
         buttonPanel.add(plus);
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

   
    * public int afterPoint() { //���� �� ����Ʈ : 00000 ����Ʈ //������ ����Ʈ�� �������������� ���������ϰ�
    * int remainPoint = pointSum - priceSum; remainPointText.setText(remainPoint
    * +"  point"); System.out.println(remainPoint);
    * 
    * return remainPoint; }
    

}
*/