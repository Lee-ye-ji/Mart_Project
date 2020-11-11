package com.kh.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.kh.model.controller.ProductController;
import com.kh.model.controller.UserController;
import com.kh.model.vo.Product;
import com.kh.model.vo.User;
import com.kh.recipe.view.RecipePage;

public class ProductPage extends JPanel implements ActionListener {
	private JFrame mainFrame;
	private UserController uc = new UserController();
	private ProductController pc = new ProductController();
	private int ctn = 0;
	private String result = "";

	public ProductPage(JFrame mf) {
		mainFrame = mf;

		this.setLayout(new BorderLayout());

		JPanel top = new JPanel();
		// top.setBounds(150, 50, 1000, 200);

		JLabel title = new JLabel("PRODUCT PAGE");
//		title.setBounds(575, 0, 100, 30);

		// �̹��� ũ�� �����Ͽ� �̹��� ��ü ����
		Image logo = new ImageIcon("image/KHmart_logo.jpeg").getImage().getScaledInstance(500, 250, 0);
		// ������� �̹��� ��ü�� JLabel�� �ֱ�
		JLabel logo1 = new JLabel(new ImageIcon(logo));

		JButton mypage = new JButton("����������");
		mypage.setPreferredSize(new Dimension(100, 80));
		JButton recipe = new JButton("�����Ǻ���");
		recipe.setPreferredSize(new Dimension(100, 80));
		JButton cart = new JButton("��ٱ���");
		cart.setPreferredSize(new Dimension(100, 80));

		mypage.addActionListener(this);
		recipe.addActionListener(this);

		// �����̸� ����
		ArrayList<User> userl = uc.openList();
		JLabel userName = new JLabel(userl.get(0).getName() + "��");

		top.add(title);
		top.add(userName);
		top.add(logo1);
		top.add(mypage);
		top.add(recipe);
		top.add(cart);
		top.setBackground(Color.white);
		this.add(top, "North");

		this.setBackground(Color.white);
		// this.add(top);

		JPanel showProduct = new JPanel();
		// showProduct.setBounds(150, 300, 1000, 500);
		showProduct.setLayout(new GridLayout(0, 5));

		// üũ�ڽ� �����
		JCheckBox[] buttons = new JCheckBox[100];

		ArrayList<Product> plist = pc.getProductList();

		for (int i = 0; i < plist.size(); i++) {
			JPanel sp = new JPanel();
			sp.setSize(new Dimension(150, 150));
			Image icon = new ImageIcon(plist.get(i).getImg()).getImage().getScaledInstance(150, 150, 0);
			sp.add(new JLabel(new ImageIcon(icon)));
			buttons[i] = new JCheckBox(plist.get(i).getpName());
			sp.add(buttons[i]);

			sp.add(new JLabel(plist.get(i).getPrice() + "��"));
			showProduct.add(sp);

		}
		// üũ�� ��ǰ ��ٱ��Ͽ� ���// �������
		JPanel resultPanel = new JPanel();
		JLabel text = new JLabel("��ٱ��Ͽ� ���� ��ǰ");
		resultPanel.add(text);

		// JButton resultbtn = new JButton("��ٱ��� ���");
		// resultPanel.add(resultbtn);
		// ��ٱ��Ͽ� ������ǰ

		ArrayList<Product> containP = new ArrayList<>();

		JButton cbtn = new JButton("Ȯ��");
		resultPanel.add(cbtn);
		cbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				containP.removeAll(plist);
				for (int i = 0; i < plist.size(); i++) {
					if (buttons[i].isSelected()) {
						if (plist.get(i).isAdult()) {
							if (userl.get(0).getAge() > 20) {
								result += buttons[i].getText() + " ";
								ctn++;
								Product contain = new Product();
								contain = new Product(plist.get(i).getpName(), plist.get(i).getPrice(),
										plist.get(i).getImg(), plist.get(i).isAdult());
								containP.add(contain);
							}
							else {
								JOptionPane.showMessageDialog(null, "û�ҳ� ���� �Ұ� ��ǰ�� ���ԵǾ��ֽ��ϴ�.\n�ٽ� �������ּ���");
							}
						} else {
							result += buttons[i].getText() + " ";
							ctn++;
							Product contain = new Product();
							contain = new Product(plist.get(i).getpName(), plist.get(i).getPrice(),
									plist.get(i).getImg(), plist.get(i).isAdult());
							containP.add(contain);

						}

					}

				}
				if (ctn == 0) {
				//	JOptionPane.showMessageDialog(null, "������ ��ǰ�� �����ϴ�");
			text.setText("������ ��ǰ�� �����ϴ�");
				} else {
					text.setText(result);

					// ���� �� ���Ϸ� ������������
					pc.saveBasketFile(containP);
				}

			}

		});

		JPanel bottom = new JPanel();
		JButton jb = new JButton("��ٱ��� ���");
		bottom.add(jb);
		// bottom.setBackground(Color.red);
		bottom.setPreferredSize(new Dimension(100, 80));

		jb.addActionListener(this);

		showProduct.add(resultPanel);

		// bottom.setBounds(500,400, 100, 100);

		this.add(showProduct, "Center");
		this.add(bottom, "South");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel changePanel = null;

		if (e.getSource() instanceof JButton) {
			JButton btn = (JButton) e.getSource();
			switch (btn.getText()) {
			case "����������":
				changePanel = new MyPage(mainFrame);
				break;
			case "�����Ǻ���":
				changePanel = new RecipePage(mainFrame);
				break;
			case "��ٱ���":
				changePanel = new MyPage(mainFrame);
				break;
			case "��ٱ��� ���":
				if(ctn ==0) {
					JOptionPane.showMessageDialog(null, "������ ��ǰ�� �����ϴ�");
				}
				else {
					changePanel = new Basket(mainFrame);	
				}
				
				break;
		}
			mainFrame.getContentPane().removeAll();
			mainFrame.getContentPane().add(changePanel);
			mainFrame.repaint();
			mainFrame.setVisible(true);
		}

	}
}
