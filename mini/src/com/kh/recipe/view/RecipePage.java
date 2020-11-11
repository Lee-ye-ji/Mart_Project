package com.kh.recipe.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class RecipePage extends JPanel implements ActionListener{
	private JFrame mainFrame;
	public RecipePage(JFrame mf) {
		mainFrame = mf;
		
		Font fontEng = new Font("Comic Sans MS", Font.BOLD, 30);
		Font fontKor = new Font("���� ���� B", Font.TRUETYPE_FONT, 30);
		
		this.setBackground(new Color(106, 168, 79));
		this.setLayout(new GridLayout(4,0,0,20));
		this.setBorder(new EmptyBorder(0,50,0,50)); //��, ����, �Ʒ�, ������
		
		JLabel title = new JLabel("RECIPE PAGE");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setForeground(Color.WHITE);
		title.setFont(fontEng);
		
		JButton bToday = new JButton("������ ��õ �޴�");
		bToday.setFont(fontKor);
		bToday.setBackground(new Color(241, 194, 50));
		JButton bIngre = new JButton("��� ī�װ�");
		bIngre.setFont(fontKor);
		bIngre.setBackground(new Color(241, 194, 50));
		
		bToday.addActionListener(this);
		bIngre.addActionListener(this);
		
		this.add(title);
		this.add(bToday);
		this.add(bIngre);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel changePanel = null;
		if(e.getSource() instanceof JButton) {
			JButton btn = (JButton)e.getSource();
			switch(btn.getText()) {
			case "������ ��õ �޴�":
				changePanel = new TodayPanel(mainFrame);
				break;
			case "��� ī�װ�":
				changePanel = new CatePanel(mainFrame);
				break;
			}
			mainFrame.getContentPane().removeAll();
			mainFrame.getContentPane().add(changePanel);
			mainFrame.repaint();
			mainFrame.setVisible(true);
		}
		
	}


}
