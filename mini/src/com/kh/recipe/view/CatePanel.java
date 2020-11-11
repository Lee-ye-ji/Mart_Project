package com.kh.recipe.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.kh.recipe.model.controller.CateController;
import com.kh.recipe.model.vo.Category;

public class CatePanel extends JPanel{
	private JFrame mainFrame;
	private CateController cc = new CateController();
	private ArrayList<Category> cateList = cc.getCateList();
	private int count = 0;
public CatePanel(JFrame mf) {
	this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	
	Font fontKor = new Font("���� ���� B", Font.TRUETYPE_FONT, 30);
	
	JPanel panel1 = new JPanel();
	panel1.setBackground(Color.WHITE);
	JLabel title = new JLabel("��� ī�װ�");
	title.setBorder(new EmptyBorder(50,0,0,0)); //��, ����, �Ʒ�, ������
	title.setFont(fontKor);
	panel1.add(title);
	
	JPanel panel2 = new JPanel();
	panel2.setBackground(Color.GRAY);
	// ��� �Է� â
	JTextField input = new JTextField("��Ḧ �Է����ּ���", 15);
	input.setFont(fontKor.deriveFont(20.0f));
	
	input.addMouseListener(new MouseAdapter() {
		@Override
        public void mouseClicked(MouseEvent e){
			input.setText("");
			input.requestFocus();
        }
		
	});
	
	JButton search = new JButton("�˻�");
	search.setFont(fontKor.deriveFont(20.0f));
	panel2.add(input);
	panel2.add(search);
	
	JPanel panel3 = new JPanel();
//	panel3.setBackground(Color.GREEN);
	panel3.setPreferredSize(new Dimension(10,800));

	
	JTextArea ta = new JTextArea(0, 0); // ��¿� �ؽ�Ʈ ����
	panel3.add(ta);
	
	JPanel resultPanel = new JPanel();
	JButton resultButton = new JButton();
	JLabel fNameL = new JLabel();
	
	// ��� �� 
//	int count = 0;

	// �˻� ��ư Ŭ���� �̺�Ʈ
	search.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String text = input.getText();
			panel3.setBackground(Color.LIGHT_GRAY);
//			ta.append(text);
//			panel3.add(ta);
		
			
			if(cateList.isEmpty()) {
				panel3.add(new JLabel("����� �������� �ʽ��ϴ�."));
			}else {
				ta.append("<�˻� ���>");
				for(Category c : cateList) {
					count++;
					String[] ingreArr = c.getIngre();
					for(int i = 0; i < ingreArr.length; i++) {
						if(ingreArr[i].contains(text)) {
							
							resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
							Image icon = new ImageIcon(c.getfImagePath()).getImage().getScaledInstance(150, 150, 0);
							resultPanel.add(new JLabel(new ImageIcon(icon)));
							JLabel fNameL = new JLabel(c.getfName());
							resultButton.add(fNameL);
							resultPanel.add(resultButton);
							panel3.add(resultPanel);
							
							JPanel recipePanel = new JPanel();
							recipePanel.setPreferredSize(new Dimension(1200,600));
							// ��ư Ŭ�� ��  �ش� ������ ���
							resultButton.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									panel3.removeAll();
									panel3.revalidate();
									panel3.add(recipePanel);
									recipePanel.setBackground(Color.white);
									
									String title = null;
									for(int i = 0; i < cateList.size(); i++) {
										title = cateList.get(i).getfName();
										if(fNameL.getText().equals(title)) {
											// �丮 �̸�
											recipePanel.add(new JLabel(cateList.get(i).getfName()));
											// �丮 ����
											Image icon = new ImageIcon(c.getfImagePath()).getImage().getScaledInstance(150, 150, 0);
											recipePanel.add(new JLabel(new ImageIcon(icon)));
											// �κ�
											recipePanel.add(new JLabel(cateList.get(i).getAmount()));
											// �丮 �ð�
											recipePanel.add(new JLabel(cateList.get(i).getTime()));
											// ������
											String recipeArr[] = c.getRecipe();
											for(int j = 0; j < recipeArr.length; j++) {
												recipePanel.add(new JLabel(recipeArr[j]));
											}
										}
									}
									
									
									
									panel3.repaint();
								}
								
							});
							
//							return;
						}
					} // ��� �ݺ���
				} // Category ArrayList �ݺ���
//				ta.append("<�˻� ���>");
				if(count == 0) {
					panel3.add(new JLabel("�˻��� ��ῡ �˸��� �����ǰ� �����ϴ�."));	
				}
				
//				return;

//				panel3.add(new JLabel("�˻��� ��ῡ �˸��� �����ǰ� �����ϴ�."));
			} // ���Ͽ� ���� ������� ������
		}
	}); // �˻� �̺�Ʈ ��
	

	
	
//	resultButton.addActionListener(new ActionListener() {
	/*resultButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			panel3.removeAll();
			panel3.revalidate();
			panel3.add(recipePanel);
			recipePanel.setBackground(Color.GREEN);

			JLabel title2 = new JLabel("��� �ֱ�");
			recipePanel.add(title2);
			
			
			System.out.println(e.getSource() instanceof JButton);
			
			if(e.getSource() instanceof JButton) {
				JButton btn = (JButton)e.getSource();
//				System.out.println(btn.getText());
				String title = null;
				System.out.println("�׽�Ʈ");
				
				System.out.println(btn.getText());
				System.out.println(resultButton.getText());
				
				for(int i = 0; i < cateList.size(); i++) {
					title = cateList.get(i).getfName();
					
					
					
//					if(btn.getText().equals("�����ġ������")) {
//						recipePanel.add(new JLabel("�ȳ�"));
//					}else {
//						recipePanel.add(new JLabel("���� �ʾ�"));
//						System.out.println("�ȳ�");
//						System.out.println(resultButton.getText());
//					}
				}
			}

			panel3.repaint();
		}
		
		
	});*/
	
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
	}
/*@Override
public void actionPerformed(ActionEvent e) {
	JPanel cp = new JPanel();
	if(e.getSource() instanceof JButton) {
		JButton btn = (JButton)e.getSource();

		
		String title = null;
		for(int i = 0; i < cateList.size(); i++) {
			title = cateList.get(i).getfName();
				System.out.println(title);
				System.out.println(btn);
			
		}
		
		this.removeAll();
		this.revalidate();
		this.add(cp);
		cp.setBackground(Color.GREEN);
		this.repaint();
	}
	
	
}*/



}
