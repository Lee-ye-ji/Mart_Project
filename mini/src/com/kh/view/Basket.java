package com.kh.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
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
import javax.swing.JScrollPane;

import com.kh.model.controller.ProductController;
import com.kh.model.dao.ProductDao;
import com.kh.model.vo.Product;

public class Basket extends JPanel {
	private ProductController pc = new ProductController();
	private int sum;
	private int value;
	private int sum1;
	private int count = 0;
	private String show = "";
	private int totalSum;
	private ProductDao pd = new ProductDao();
	private ArrayList<Product> list = pc.getBasketList();
	private ArrayList<Product> productList = pc.getProductList();
	private Product pr = new Product();
	
	public Basket(JFrame mf) {

		this.setLayout(new BorderLayout());


		   Font ttfBase = null;
	         Font ttfReal = null;
	         try {
	            BufferedInputStream myStream = new BufferedInputStream(new FileInputStream("BMJUA_ttf.ttf"));
	            ttfBase = Font.createFont(Font.TRUETYPE_FONT, myStream);
	            ttfReal = ttfBase.deriveFont(Font.PLAIN, 15);
	            System.out.println(ttfReal);
	         } catch (FileNotFoundException e1) {
	            
	            e1.printStackTrace();
	         } catch (FontFormatException e1) {
	            
	            e1.printStackTrace();
	         } catch (IOException e1) {
	            
	            e1.printStackTrace();
	         }
	      
	      

	   

	      JLabel label = new JLabel(new ImageIcon("image/KHmart_logo.jpeg"));
	      label.setBounds(0, 0, 700, 255);

	   
	      JPanel top = new JPanel();
	      top.setBackground(new Color(241, 194, 50));
	      
	      
	      
	      Image logo = new ImageIcon("image/logo.png").getImage().getScaledInstance(150, 150, 0);
	         // ������� �̹��� ��ü�� JLabel�� �ֱ�
	         JLabel logo1 = new JLabel(new ImageIcon(logo));top.add(logo1, BorderLayout.WEST);
	      
	        JLabel text = new JLabel("��ٱ���");
	      top.add(text);
	      text.setFont(ttfReal.deriveFont(50f));
	      
	    
	      
	      
	      
	   
		
		
		
		
		
		
		
		
		// ��Ʈ
		Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
		Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 25);

		// ����
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new BorderLayout());
		JPanel pNorth = new JPanel();	
		pNorth.setBackground(new Color(106, 168, 79));
		pNorth.setLayout(null);
		
		pNorth.setFont(font);
		
		

		// �迭 ���� �κ�
		for (int i = 0; i < list.size(); i++) {
			String[] name = { list.get(i).getpName() };
			int price[] = { list.get(i).getPrice() };

		}
		JButton bt[] = new JButton[list.size()];
		TextField suja[] = new TextField[list.size()];
		Button minus[] = new Button[list.size()];
		Button plus[] = new Button[list.size()];
		JButton ok[] = new JButton[list.size()];
		JLabel l[] = new JLabel[list.size()];
		JLabel s[] = new JLabel[list.size()];

		

		System.out.println("cnt ������: " + list);
		// ��ư ���� �κ�
		for (int i = 0; i < list.size(); i++) {

			// �޴� ��ư
			
			bt[i] = new JButton();
			bt[i].setBackground(new Color(106,168,79));
			bt[i].setBorderPainted(false);
			
			if (i < 7) {
				bt[i].setBounds(25 + i * 150, 50, 100, 100);
			} else {
				bt[i].setBounds(25 + (i - 7) * 150, 300, 100, 100);
			}

			Image icon = new ImageIcon(list.get(i).getImg()).getImage().getScaledInstance(80, 80, 0);
			bt[i].add(new JLabel(new ImageIcon(icon)));

			// ���� txt ��ư
			suja[i] = new TextField("0");
			suja[i].setBackground(Color.white);
			suja[i].setEditable(false);
			suja[i].setBounds(bt[i].getX() + 30, bt[i].getY() + 140, 40, 20);

			// "-" ��ư

			minus[i] = new Button("-");
			minus[i].setBackground(Color.WHITE);
			
			//minus[i].setBackground(new Color(241,194,50));
			minus[i].setBounds(bt[i].getX(), suja[i].getY(), 20, 20);
			minus[i].setEnabled(true);

			// "+" ��ư
			plus[i] = new Button("+");
			
			plus[i].setBackground(Color.WHITE);
			plus[i].setBounds(bt[i].getX() + (100 - 20), suja[i].getY(), 20, 20);
			plus[i].setEnabled(true);
			
			// ��ǰ�� 
			s[i] = new JLabel(list.get(i).getpName()+"");
			s[i].setFont(ttfReal);
			s[i].setBounds(bt[i].getX() + 35, suja[i].getY() - 40, 100, 20);

			// ����
			l[i] = new JLabel(list.get(i).getPrice() + "��");
			l[i].setFont(ttfReal);
			l[i].setBounds(bt[i].getX() + 30, suja[i].getY() - 25, 100, 20);

			// Ȯ�� ��ư
			ok[i] = new JButton("Ȯ��");
			ok[i].setFont(ttfReal);
			ok[i].setBorderPainted(false);
			ok[i].setBackground(new Color(241,194,50));
			ok[i].setBounds(bt[i].getX(), suja[i].getY() + 30, 100, 20);
			ok[i].setEnabled(false);
			
			pNorth.add(bt[i]);
			pNorth.add(suja[i]);
			pNorth.add(minus[i]);
			pNorth.add(plus[i]);
			pNorth.add(s[i]);
			pNorth.add(l[i]);
			pNorth.add(ok[i]);
		}
		// �߾�
		TextArea ta = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
		//ta.setFont(ttfReal);
		
		ta.setText("   ��ǰ��        �ܰ�        ����        �հ�\n\n");
		ta.setFont(font1);
		ta.setBackground(Color.white);
		ta.setEditable(false);
		

		// ����
		Panel pSouth = new Panel();
		pSouth.setFont(font);
		pSouth.setBackground(new Color(106, 168, 79));

		JButton bt1 = new JButton("����");
		bt1.setBorderPainted(false);
		bt1.setBackground(new Color(241,194,50));
		bt1.setFont(ttfReal);
		JButton bt2 = new JButton("�ʱ�ȭ");
		bt2.setBorderPainted(false);
		bt2.setBackground(new Color(241,194,50));
		bt2.setFont(ttfReal);
		JButton bt3 = new JButton("����");
		bt3.setBorderPainted(false);
		bt3.setBackground(new Color(241,194,50));
		bt3.setFont(ttfReal);
		pSouth.add(bt1);
		pSouth.add(bt2);
		pSouth.add(bt3);
		

		bt3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mf.getContentPane().removeAll();
				mf.getContentPane().add(new ProductPage(mf));
				mf.repaint();
				mf.setVisible(true);

			}

		});

		// ���Ź�ư
		bt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(ta.getText().equals("   ��ǰ��        �ܰ�        ����        �հ�\n\n")) {
					   JOptionPane.showMessageDialog(null, "��ǰ�� ���õ����ʾҽ��ϴ�.\n�ٽü������ּ���.");
				}else {
				int result = JOptionPane.showConfirmDialog(null, ta.getText() + " ����â���� �̵��մϴ�. \n�̿����ּż� �����մϴ�.");
				for (int i = 0; i < list.size(); i++) {
					
					bt[i].setEnabled(true);
					minus[i].setEnabled(false);
					plus[i].setEnabled(false);
					suja[i].setText("0");
					ta.setText("   ��ǰ��        �ܰ�        ����        �հ�\n\n");

					if (result == JOptionPane.CLOSED_OPTION) {
						totalSum = 0;
					} else if (result == JOptionPane.YES_OPTION) {

						totalSum += list.get(i).getPrice() * count;

						mf.getContentPane().removeAll();
						mf.getContentPane().add(new Payment(mf, totalSum));
						mf.repaint();
						mf.setVisible(true);
					} else {
						totalSum = 0;
					}

				}
			}
			}

		});

		// �ʱ�ȭ ��ư
		bt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < list.size(); i++) {
					bt[i].setEnabled(true);
					minus[i].setEnabled(true);
					plus[i].setEnabled(true);
					ok[i].setEnabled(true);
					
					suja[i].setText("0");
					ta.setText("   ��ǰ��        �ܰ�        ����        �հ�\n\n");
					totalSum = 0;

				}

			}
		});

		// �̺�Ʈ��
		for (int i = 0; i < list.size(); i++) {
			int j = i;

			// �޴� ��ư �̺�Ʈ
			bt[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					minus[j].setEnabled(true);
					plus[j].setEnabled(true);
					bt[j].setEnabled(false);
					ok[j].setEnabled(true);

					count = 0;
				}
			});

			// "-" ��ư �̺�Ʈ
			minus[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (count > 0) {
						count = count - 1;
						suja[j].setText(count + "");
						ok[j].setEnabled(true);
					} else {
						minus[j].setEnabled(false);
					}
				}
			});

			// "+" ��ư �̺�Ʈ

			plus[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (count < list.get(j).getCnt()) {
						count = count + 1;
						suja[j].setText(count + "");
						ok[j].setEnabled(true);
					} else {
						ok[j].setEnabled(true);
					}
					if (count > 0) {
						minus[j].setEnabled(true);
					}

				}
			});

			// Ȯ�� ��ư �̺�Ʈ
			ok[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					show = bt[j].getActionCommand();
					ta.append("   " + list.get(j).getpName() + "       " + list.get(j).getPrice() + "        " + count + "         "
							+ list.get(j).getPrice() * count + "��" + "\n");
					
					list.get(j).setCnt(count);
					pc.saveBasketFile(list);

					System.out.println("��ǰ��:" + show + " ," + " �ٽ��� : " + list.get(j).getCnt());
					System.out.println("cnt ������: " + list);

					ok[j].setEnabled(false);
				}
			});

		}
		
		//pNorth.add(top, BorderLayout.NORTH);
		//pNorth.add(btnPanel,BorderLayout.CENTER);
		//this.add(top, BorderLayout.NORTH);
		
		
		
		this.add(top, BorderLayout.NORTH);
		this.add(pNorth, BorderLayout.CENTER);
		btnPanel.add(ta,BorderLayout.NORTH);
		btnPanel.add(pSouth,BorderLayout.SOUTH);
		this.add(btnPanel, BorderLayout.SOUTH);

	}

}