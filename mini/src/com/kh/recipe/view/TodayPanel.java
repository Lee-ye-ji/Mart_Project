package com.kh.recipe.view;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TodayPanel extends JPanel {
	public TodayPanel(JFrame mf) {
		
		this.setLayout(new GridLayout(5,1));
		
		Font fontKor = new Font("���� ���� B", Font.TRUETYPE_FONT, 30);
		
		JLabel title = new JLabel("������ ��õ �޴�");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(fontKor);
		this.add(title,"North");
		
		// �迭�� �����Ͽ� ���� ���� üũ �ڽ� ������
		String[] foodType = {"�ѽ�", "�Ͻ�", "�߽�", "�н�", "�ѽ�", "���ö�", "Ư����", "����Ʈ"};
		JButton[] btnFood = new JButton[8];
		JPanel btnPanel = new JPanel();
//		btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.Y_AXIS));
		
		for(int i = 0; i < foodType.length; i++) {
			btnFood[i] = new JButton(foodType[i].toString());
			btnPanel.add(btnFood[i]);
			// �� ��ư Ŭ���� ������ ȭ�� �̵� �̺�Ʈ �ۼ��ϱ� 
			
			btnFood[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JPanel changePanel = null;
					
					if(e.getSource() instanceof JButton) {
						JButton btn = (JButton)e.getSource();
					}
					
				}
				
			});
		}
		this.add(btnPanel);
		
		/*JCheckBox[] check = new JCheckBox[8];
		
		for(int i = 0; i < check.length; i++) {
			check[i] = new JCheckBox(foodType[i]);
		}
		
		
		//���� ���� üũ�ڽ��� �ݺ����� ����Ͽ� ����
		JPanel checkPanel = new JPanel();
		for(int i = 0; i< check.length; i++) {
			checkPanel.add(check[i]);
		}
		
		this.add(checkPanel);*/
		
		
		//��� ����
		
	}

}
