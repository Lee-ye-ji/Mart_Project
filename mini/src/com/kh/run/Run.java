package com.kh.run;

import com.kh.view.CateInput;
import com.kh.view.MainFrame;

public class Run {

	public static void main(String[] args) {
		new MainFrame();
//		CateInput ci = new CateInput();
//	      ci.mainMenu();
	}

}




/*

package com.kh.pay;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.kh.model.controller.ProductController;
import com.kh.model.controller.UserController;
import com.kh.model.vo.Product;
import com.kh.model.vo.User;

public class Payment extends JPanel {
	
	private JFrame mainFrame;
	
	// ��ٱ��� �ֹ��ϱ� ��ư Ŭ���� --> �̺�Ʈ�߻� --> ���� â���� �Ѿ���鼭 ���� ���� �ݾ� ����ϱ�
	// ȸ�� �� ���� ����Ʈ�� �̺�Ʈ �߻��ؾ��ϳ� ? 
	// ���� �� ���� ����Ʈ : �� ���� �ݾ� - ȸ�� �� ���� ����Ʈ 
	
	ProductController pc = new ProductController();
	UserController uc = new UserController();
	ArrayList<User> userList = uc.getUserList();
	ArrayList<Product> productList = pc.getProductList();
	int pointSum = 0;
	int priceSum = 0;
	JTextField remainPointText = new JTextField(15);
	
	public Payment() {}
	
	public Payment(JFrame mf) {
		
		mainFrame = mf;
		
		//this.setBounds(50,50,1200,1200);
		//this.setPreferredSize(new Dimension(1200,1200));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		//this.setBackground(new Color(106, 168, 79));

		JPanel titlePanel = new JPanel();	
		JLabel title = new JLabel("KHMart Payment");
		title.setFont(new Font("�������",Font.BOLD,50));
		titlePanel.setBackground(new Color(106, 168, 79));
		titlePanel.add(title);
		title.setBorder(new EmptyBorder(100,0,0,0)); //��, ����, �Ʒ�, ������
		
		JPanel userPanel = new JPanel(); 
		
		userPanel.setBackground(new Color(241, 194, 50));
		userPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK,2),"User's info"));
		userPanel.setLayout(new GridLayout(2,2,1,1));
		userPanel.setSize(1200,1200);
		
			
		JLabel name = new JLabel("ȸ�� ���� :");
		name.setHorizontalAlignment(JLabel.RIGHT);
		name.setFont(new Font("�������",Font.BOLD,25));
		userPanel.add(name);
		
		JTextField nameText = new JTextField(15);
		nameText.setEditable(false);
		nameText.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		nameText.setFont(new Font("�������",Font.BOLD,25));
		nameText.setHorizontalAlignment(JTextField.LEFT);
		nameText.setBackground(new Color(241, 194, 50));
		userPanel.add(nameText);
		
		for(int i = 0; i < userList.size(); i++) {
			nameText.setText(userList.get(i).getName() +" ");
		}
		
		JLabel address = new JLabel("ȸ�� �ּ� :");
		address.setHorizontalAlignment(JLabel.RIGHT);
		address.setFont(new Font("�������",Font.BOLD,25));
		userPanel.add(address);
		
		JTextField addressText = new JTextField(15);
		addressText.setEditable(false);
		addressText.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		addressText.setFont(new Font("�������",Font.BOLD,25));
		addressText.setHorizontalAlignment(JTextField.LEFT);
		addressText.setBackground(new Color(241, 194, 50));
		userPanel.add(addressText);
		
		for(int i = 0; i < userList.size(); i++) {
			addressText.setText(userList.get(i).getAddress() +" ");
		}
		
		// 1. ���� ���� �ݾ� :  0000����Ʈ   / ��ٱ��Ͽ��� �� �� �������� / ���� ���ϰ�
		JPanel payPanel = new JPanel(); 
		
		payPanel.setBackground(new Color(241, 194, 50));
		payPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK,2),"Payment"));
		payPanel.setLayout(new GridLayout(1,2,1,1));
		payPanel.setSize(500,500);
		
		JLabel totalPay = new JLabel("�� ���� �ݾ�  :");
		totalPay.setHorizontalAlignment(JLabel.RIGHT);
		totalPay.setFont(new Font("�������",Font.BOLD,25));
		payPanel.add(totalPay);
		
		JTextField totalPayText = new JTextField(15);
		totalPayText.setEditable(false);
		totalPayText.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		totalPayText.setFont(new Font("�������",Font.BOLD,25));
		totalPayText.setHorizontalAlignment(JTextField.LEFT);
		totalPayText.setBackground(new Color(241, 194, 50));
		payPanel.add(totalPayText);
		
		for(int i = 0; i < productList.size(); i++) {
			priceSum += productList.get(i).getPrice();
			totalPayText.setText(priceSum +"  point");
		}
		
		
		// 2. ȸ�� �� ���� ����Ʈ : 0000 ����Ʈ / ȸ���������� ��������Ʈ �������� / ���� ���ϰ�
		JPanel pointPanel = new JPanel(); 
		
		pointPanel.setBackground(new Color(241, 194, 50));
		pointPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK,2),"Point"));
		pointPanel.setLayout(new GridLayout(2,2,1,1));
		pointPanel.setSize(500,500);
		
		JLabel point = new JLabel("�� ���� ����Ʈ  :");
		point.setHorizontalAlignment(JLabel.RIGHT);
		point.setFont(new Font("�������",Font.BOLD,25));
		pointPanel.add(point);
		
		JTextField pointText = new JTextField(15);
		pointText.setEditable(false);
		pointText.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		pointText.setFont(new Font("�������",Font.BOLD,25));
		pointPanel.add(pointText);
		pointText.setHorizontalAlignment(JTextField.LEFT);
		pointText.setBackground(new Color(241, 194, 50));
		pointPanel.add(pointText);
		
		
		for(int i = 0; i < userList.size(); i++) {
			pointSum = userList.get(i).getPoint();
			pointText.setText(pointSum +"  point");
		}
		
		
		// 3. ���� �� ����Ʈ : 00000 ����Ʈ  / ���� �� ����Ʈ�� �������������� ���������ϰ� / ���� ���ϰ� 
		
		JLabel remainPoint = new JLabel("���� �� ����Ʈ  :");
		remainPoint.setFont(new Font("�������",Font.BOLD,25));
		remainPoint.setHorizontalAlignment(JLabel.RIGHT);
		pointPanel.add(remainPoint);
	
		
		remainPointText.setEditable(false);
		remainPointText.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		remainPointText.setFont(new Font("�������",Font.BOLD,25));
		pointPanel.add(remainPointText);
		remainPointText.setHorizontalAlignment(JTextField.LEFT);
		remainPointText.setBackground(new Color(241, 194, 50));
		pointPanel.add(remainPointText);

		afterPoint();
		

		JPanel pnlCenter = new JPanel(new GridLayout(3,1));
		pnlCenter.setBackground(new Color(241, 194, 50));
		pnlCenter.add(userPanel);
		pnlCenter.add(pointPanel);
		pnlCenter.add(payPanel);

		
		// 4. ��� ��ư (��ٱ��Ϸ� back) , ���� ��ư (Ŭ���� --> �̺�Ʈ ó��) 
		// [���� Ŭ����] 
		// 1. ���� �Ǵ� ���: ���� ��й�ȣ ġ�� â �߰� --> userPWD �Է� --> Ʋ���� �ٽ� �Է� --> ���� ��� ���� �Ϸ� â �߰�
		// 2. ���� ����Ʈ < �� ���� �ݾ� : ���� ����Ʈ�� �����մϴ�. â ���� ���� ���ϰ� --> ��� ��ư ������ ��ٱ���â���� back
		JPanel buttonPanel = new JPanel();
		
		buttonPanel.setBackground(new Color(106, 168, 79));
		
		JButton btn1 = new JButton("���");
		JButton btn2 = new JButton("����");
		buttonPanel.add(btn1);
		buttonPanel.add(btn2);
		btn1.setFont(new Font("�������", Font.BOLD, 25));
		btn1.setBackground(Color.BLACK);
		btn1.setForeground(Color.WHITE);
		btn2.setFont(new Font("�������", Font.BOLD, 25));
		btn2.setBackground(Color.BLACK);
		btn2.setForeground(Color.WHITE);
		buttonPanel.setBorder(new EmptyBorder(100,0,0,0)); //��, ����, �Ʒ�, ������
		
		
		// paypwd �Է½� **** ������ ... 
		
		String pwd = userPwd() + "";
		
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (pointSum < priceSum) {
					JOptionPane.showMessageDialog(null, "���� ����Ʈ�� �����մϴ�.");
				} else {
					JPanel paypwdPanel = new JPanel();
					JLabel pwdLabel = new JLabel("���� ��й�ȣ�� �Է��ϼ���.");
					JPasswordField pass = new JPasswordField(10);
					paypwdPanel.add(pwdLabel);
					paypwdPanel.add(pass);
					String[] options = new String[] { "Ȯ��", "���" };
					int option = JOptionPane.showOptionDialog(null, paypwdPanel, "The title", JOptionPane.NO_OPTION,
							JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
					if (option == 0) { // Ȯ�� ��ư ���� ��
						if (pass.equals(pwd)) {
							char[] password = pass.getPassword();
							System.out.println("���� ��й�ȣ : " + new String(password));
							JOptionPane.showMessageDialog(null, "���� �Ϸ� �Դϴ�.");
						}
					} else {
						JOptionPane.showMessageDialog(null, "��й�ȣ�� �ٽ� �Է����ּ���.", "��й�ȣ ����", JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		});
		
		// ���÷� ��� ���� (����, user Ŭ�������� ���� paypwd �����;��� )
		//String paypwd = "1234";
		String pwd = userPwd() + "";
		
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// if, ���� ����Ʈ > �� ���� �ݾ� --> ���� ��й�ȣ �Է� â (�߸� �Է� ���� ��� �ٽ� �Է��ϰ�) 
				//JPasswordField pwd = new JPasswordField(30);
				if (pointSum < priceSum) {
					JOptionPane.showMessageDialog(null, "���� ����Ʈ�� �����մϴ�.");
				} else {
					String pass = JOptionPane.showInputDialog("���� ��й�ȣ�� �Է��ϼ���.");
					if (pass.equals(pwd)) {
						JOptionPane.showMessageDialog(null, "���� �Ϸ� �Դϴ�.");
						// â ���ϰ�,,
						// System.out.println(pass);
					} else {
						JOptionPane.showMessageDialog(null, "��й�ȣ�� �ٽ� �Է����ּ���.", "��й�ȣ ����", JOptionPane.ERROR_MESSAGE);
					}
				}
				// else, ���� ����Ʈ�� < �� ���� �ݾ� --> ���� ����Ʈ�� �����մϴ� â �߰� --> ��� ��ư ���� �� ��ٱ��Ϸ� �̵�
			}
			
			
		});
		
	
		this.add(titlePanel);
		this.add(pnlCenter);
		this.add(buttonPanel);
		
		this.setVisible(true);
		
	}
	
	
	public int afterPoint() {
		//���� �� ����Ʈ : 00000 ����Ʈ 
		//������ ����Ʈ�� �������������� ���������ϰ�
		int remainPoint = pointSum - priceSum;
		remainPointText.setText(remainPoint +"  point");
		
		return remainPoint;
	}	
	
	public String userPwd() { //210
		String pwd = " ";
		
		for (int i = 0; i < userList.size(); i++) {
			pwd = userList.get(i).getPaypwd();
			System.out.println(pwd);
		}
		return pwd;
	}
	
}*/
