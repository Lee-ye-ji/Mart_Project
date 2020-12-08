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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import com.kh.model.controller.UserController;
import com.kh.model.vo.User;

public class AddPoint2 extends JPanel {

   UserController uc = new UserController();
   int point;
   User user = uc.getLogin();
   
   public AddPoint2(JFrame mf, int totalSum) {

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
   
   
      JPanel top = new JPanel();
      top.setBackground(new Color(241, 194, 50));
      //top.setPreferredSize(new Dimension(150, 50));
      this.add(top,"North");
      
      Image logo = new ImageIcon("image/logo.png").getImage().getScaledInstance(150, 150, 0);
         // ������� �̹��� ��ü�� JLabel�� �ֱ�
         JLabel logo1 = new JLabel(new ImageIcon(logo));top.add(logo1, BorderLayout.WEST);
      
        JLabel text = new JLabel("MY PAGE");
      top.add(text);
      text.setFont(ttfReal.deriveFont(50f));
      
      JLabel title = new JLabel("MYPAGE");
      title.setFont(new Font("�������", Font.BOLD, 20));
      title.setBounds(310, 220, 100, 30);
//      this.add(title);
      
      JPanel main = new JPanel();
      main.setBackground(new Color(106, 168, 79));
      main.setLayout(null);
      add(main);
      // Main
      JButton pointT = new JButton("����Ʈ ����");
      pointT.setFont(ttfReal.deriveFont(30f));
      pointT.setBackground(Color.WHITE);
      pointT.setBounds(280,100,520,100);
      main.add(pointT);
      
      TextField box = new TextField();
      box.setFont(ttfReal.deriveFont(50f));
      box.setBackground(new Color(241, 194, 50));
      box.setBounds(280,250,520,70);
      main.add(box);
      
      
      JLabel text1 = new JLabel("�ݾ�");
      text1.setFont(ttfReal.deriveFont(30f));
      text1.setBackground(new Color(106, 168, 79));
      text1.setBounds(180,250,200,70);
      main.add(text1);
      
      

      
      JButton button2 = new JButton("�����ϱ�" );
      button2.setForeground(Color.black);
      button2.setFont(ttfReal.deriveFont(30f));
      button2.setBackground(Color.white);
      button2.setBounds(280,380,240,70);
      main.add(button2);
      
     /* Dialog checkCardPwdDialog = new Dialog(mf, "ī���й�ȣ Ȯ��");
      checkCardPwdDialog.setBounds(150, 250, 200, 200);
      
      JLabel title1 = new JLabel("����Ʈ ����");
      title1.setBackground(Color.white);
      title1.setBounds(310, 220, 100, 30);
   //   this.add(title, "North");

      JLabel howmuch = new JLabel("���� �ݾ�");
      howmuch.setBackground(Color.WHITE);
      howmuch.setBounds(30, 280, 100, 100);
   //   this.add(howmuch);

      TextField amount = new TextField(10);
      amount.setBounds(30, 600, 330, 100);
   //   this.add(amount, "Center");

      JButton confirm = new JButton("Ȯ��");
      confirm.setBounds(350, 600, 150, 100);
   //   this.add(confirm, "South");*/

      button2.addActionListener(new ActionListener() {

  		@Override
  		public void actionPerformed(ActionEvent e) {
  			
  			
  			
  			//JOptionPane.showMessageDialog(null, "�Ʒ� ��й�ȣ�� Ȯ�����ּ���.");
  			  //String pass = JOptionPane.showInputDialog("���� ��й�ȣ�� �Է��ϼ���.");
  			  //pass.setEchoChar('*');
  		      
				Dialog checkPwdDialog = new Dialog(mf, "��й�ȣ Ȯ��");
				checkPwdDialog.setBounds(750, 400, 250, 70);
				checkPwdDialog.setSize(300, 200);
				checkPwdDialog.setLayout(null);

				JLabel text1 = new JLabel("���� ��й�ȣ");
				text1.setBounds(30, 30, 150, 20);
				checkPwdDialog.add(text1);

				TextField pass = new TextField();
				pass.setBounds(30, 50, 200, 100);
				pass.setEchoChar('*');

				JButton ok = new JButton("Ȯ��");
				checkPwdDialog.add(ok);
				ok.setBounds(30, 150, 60, 20);
				checkPwdDialog.add(pass);
				
				ok.addActionListener(new ActionListener() {
					
					

					@Override
					public void actionPerformed(ActionEvent e) {
						
						//User user = uc.getLogin();
						String userPwd="";
						userPwd=user.getPaypwd();
						
						if (pass.getText().equals(userPwd)) {
							JOptionPane.showMessageDialog(null, "Ȯ�εǾ����ϴ�.");

							point = user.getPoint();
							System.out.println(box.getText());
							point += Integer.parseInt(box.getText());
							user.setPoint(point);
							uc.saveLogin(user);
							System.out.println("����" + user.getPoint());

							ArrayList<User> list = uc.openList();
							for (int i = 0; i < list.size(); i++) {
								System.out.println("cnffur3");
								if (list.get(i).getId().equals(user.getId())) {
									System.out.println("cnffur4");
										list.get(i).setPoint(point);
										System.out.println("list�� �ִ� ����Ʈ"+list.get(i).getPoint());
										uc.saveList(list);
									}
								}
		                   
		                   mf.getContentPane().removeAll();
		                   mf.getContentPane().add(new Payment(mf,totalSum));
		                   mf.repaint();
		                   mf.setVisible(true);
		                   checkPwdDialog.dispose();
		                   
		                   
		                   
		                } else {
		                   JOptionPane.showMessageDialog(null, "��й�ȣ�� �ٽ� �Է����ּ���.", "��й�ȣ ����", JOptionPane.ERROR_MESSAGE);
		                }
						
					}
					
				});
				JButton cancel = new JButton("���");
		          checkPwdDialog.add(cancel);
		          cancel.setBounds(90,150,60,20);
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
      	  
        });
      JButton goBack = new JButton("�ڷΰ���");
      goBack.setForeground(Color.black);
      goBack.setFont(ttfReal.deriveFont(30f));
      goBack.setBackground(Color.WHITE);
      goBack.setBounds(560, 380,240, 70);
      main.add(goBack);
      
      goBack.addMouseListener(new MouseAdapter() {

          @Override
          public void mouseClicked(MouseEvent e) {
             mf.getContentPane().removeAll();
             mf.getContentPane().add(new Payment(mf, totalSum));
             mf.repaint();
             mf.setVisible(true);

          }
          

          
       });
      

   }
}