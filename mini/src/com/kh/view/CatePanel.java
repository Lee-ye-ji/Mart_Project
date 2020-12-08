package com.kh.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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

import com.kh.model.controller.CateController;
import com.kh.model.vo.Category;

public class CatePanel extends JPanel{
   private JFrame mainFrame;
   private CateController cc = new CateController();
   private ArrayList<Category> cateList = cc.getCateList();
   private int count = 0;
//   Font ttfBase = null;
public CatePanel(JFrame mf) {
   this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
   
   Font ttfBase = null;
   Font ttfReal = null;
   try {
      BufferedInputStream myStream = new BufferedInputStream(new FileInputStream("BMJUA_ttf.ttf"));
      ttfBase = Font.createFont(Font.TRUETYPE_FONT, myStream);
      ttfReal = ttfBase.deriveFont(Font.PLAIN, 15);
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

   
   JPanel panel1 = new JPanel();
   panel1.setBackground(new Color(106, 168, 79));
   panel1.setLayout(new BorderLayout());
   
   JButton backTo = new JButton("<-");
   backTo.setFont(ttfReal.deriveFont(30.f));
   backTo.setBorderPainted(false);
   backTo.setBackground(new Color(241, 194, 50));

//   backTo.setHorizontalAlignment(JLabel.LEFT);
   
   backTo.addMouseListener(new MouseAdapter() {

         @Override
         public void mouseClicked(MouseEvent e) {

            mf.getContentPane().removeAll();
            mf.getContentPane().add(new RecipePage(mf));
            mf.repaint();
            mf.setVisible(true);

         }
      });

   panel1.add(backTo, "West");
   
   JPanel logoPanel = new JPanel();
   
   Image logo = new ImageIcon("image/logo.png").getImage().getScaledInstance(150, 150, 0);
    // ������� �̹��� ��ü�� JLabel�� �ֱ�
    JLabel logo1 = new JLabel(new ImageIcon(logo));
//    logo1.setHorizontalAlignment(JLabel.CENTER);
    logoPanel.add(logo1);
   
   JLabel title = new JLabel("��� ī�װ�");
//   title.setBorder(new EmptyBorder(20,0,20,40)); //��, ����, �Ʒ�, ������
   title.setHorizontalAlignment(JLabel.CENTER);
   title.setFont(ttfReal.deriveFont(40.0f));

   logoPanel.add(title);
   logoPanel.setBorder(new EmptyBorder(0,0,0,120));
   logoPanel.setBackground(new Color(241, 194, 50));
   panel1.add(logoPanel);
   
   JPanel panel2 = new JPanel();
   panel2.setBackground(new Color(106, 168, 79));

   // ��� �Է� â
   JTextField input = new JTextField("��Ḧ �Է����ּ���", 20);
   input.setFont(ttfReal .deriveFont(20.0f));
   
   input.addMouseListener(new MouseAdapter() {
      @Override
        public void mouseClicked(MouseEvent e){
         input.setText("");
         input.requestFocus();
        }
      
   });
   
   JButton search = new JButton("�˻�");
   search.setFont(ttfReal.deriveFont(20.0f));
   search.setBackground(Color.WHITE);
   search.setBorderPainted(false);
   panel2.add(input);
   panel2.add(search);
   
   JPanel panel3 = new JPanel();
   panel3.setPreferredSize(new Dimension(10,800));
   panel3.setBackground(Color.WHITE);
//   panel3.setLayout(null);


   
   JTextArea ta = new JTextArea(0, 0); // ��¿� �ؽ�Ʈ ����
   panel3.add(ta);
   
//   JPanel resultPanel = new JPanel();
//   JButton resultButton = new JButton();
   JLabel fNameL = new JLabel();
   
   // ��� �� 
//   int count = 0;

   // �˻� ��ư Ŭ���� �̺�Ʈ
   search.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
         
         
         Font ttfBase = null;
         Font ttfReal = null;
         try {
            BufferedInputStream myStream = new BufferedInputStream(new FileInputStream("BMJUA_ttf.ttf"));
            ttfBase = Font.createFont(Font.TRUETYPE_FONT, myStream);
            ttfReal = ttfBase.deriveFont(Font.PLAIN, 15);
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
         
         String text = input.getText();
//         ta.append(text);
//         panel3.add(ta);
      
         
         if(cateList.isEmpty()) {
            panel3.add(new JLabel("����� �������� �ʽ��ϴ�."));
         }else {
            ta.append(" ");
            ta.setBackground(Color.WHITE);
            
            JButton backTo = new JButton("���");
            backTo.setFont(ttfReal.deriveFont(20.f));
            backTo.setBorderPainted(false);
            backTo.setBackground(new Color(241, 194, 50));
            
            backTo.addMouseListener(new MouseAdapter() {

                  @Override
                  public void mouseClicked(MouseEvent e) {

                     mf.getContentPane().removeAll();
                     mf.getContentPane().add(new CatePanel(mf));
                     mf.repaint();
                     mf.setVisible(true);

                  }
               });
            
            for(Category c : cateList) {
               String[] ingreArr = c.getIngre();
               for(int i = 0; i < ingreArr.length; i++) {
                  if(ingreArr[i].equals(text)) {
//                     if(ingreArr[i].contains(text)) {
                     count++;
                     JButton resultButton = new JButton();
                     JPanel resultPanel = new JPanel();
                     resultPanel.setLayout(new BorderLayout());
                     Image icon = new ImageIcon(c.getfImagePath()).getImage().getScaledInstance(250, 250, 0);
                     resultPanel.add(new JLabel(new ImageIcon(icon)),  BorderLayout.NORTH);
                     JLabel fNameL = new JLabel(c.getfName());
                     fNameL.setFont(ttfReal.deriveFont(20f));
                     resultButton.add(fNameL);
                     
                     resultButton.setBackground(Color.WHITE);
                     resultButton.setBorderPainted(false);
                     resultPanel.setBackground(Color.WHITE);
                     resultPanel.add(resultButton, BorderLayout.CENTER);
//                     resultPanel.setPreferredSize(new Dimension(1040,700));
                     
//                     pp .setLayout(new FlowLayout());
//                     pp .add(resultPanel);
                     JPanel cancel = new JPanel();
                     cancel.setBackground(Color.blue);
                     cancel.add(backTo);
                     
                     panel3.add(resultPanel);
                     
               
                     JPanel recipePanel = new JPanel();
                     recipePanel.setPreferredSize(new Dimension(1040,650));
                     
                     // ��ư Ŭ�� ��  �ش� ������ ���
                     resultButton.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                           
                           Font ttfBase = null;
                           Font ttfReal = null;
                           try {
                              BufferedInputStream myStream = new BufferedInputStream(new FileInputStream("BMJUA_ttf.ttf"));
                              ttfBase = Font.createFont(Font.TRUETYPE_FONT, myStream);
                              ttfReal = ttfBase.deriveFont(Font.PLAIN, 15);
                           } catch (FileNotFoundException e1) {
                              e1.printStackTrace();
                           } catch (FontFormatException e1) {
                              e1.printStackTrace();
                           } catch (IOException e1) {
                              e1.printStackTrace();
                           }
                           
                           panel3.removeAll();
                           panel3.revalidate();
                           panel3.add(recipePanel);
                     
                           recipePanel.setBackground(Color.white);

//                           recipePanel.setLayout(null);
                           
                           String title = null;
                           for(int i = 0; i < cateList.size(); i++) {
                              title = cateList.get(i).getfName();
                              if(fNameL.getText().equals(title)) {
                                 // �丮 ����
                                 Image icon = new ImageIcon(c.getfImagePath()).getImage().getScaledInstance(300, 300, 0);
                                 JLabel image = new JLabel(new ImageIcon(icon));
//                                 image.setBorder(new EmptyBorder(0,50,250,0)); //��, ����, �Ʒ�, ������
//                                 image.setLocation(50, 500);
                                 recipePanel.add(image);
                                 // �丮 �̸�
                                 JLabel name = new JLabel(cateList.get(i).getfName());
                                 name.setHorizontalAlignment(JLabel.CENTER);
//                                 name.setBorder(new EmptyBorder(0,50,450,0)); //��, ����, �Ʒ�, ������
//                                 name.setBounds(10, 20, 10, 10);
                                 name.setFont(ttfReal.deriveFont(45.0f));
                                 recipePanel.add(name);
                                 JPanel ptext = new JPanel();
                                 ptext.setBackground(new Color(255, 50, 50));
                                 
                                 // �κ�
                                 JLabel amount = new JLabel(cateList.get(i).getAmount());
//                                 amount.setBorder(new EmptyBorder(0,0,300,500)); //��, ����, �Ʒ�, ������
                                 amount.setFont(ttfReal.deriveFont(20.0f));
                                 amount.setForeground(Color.white);
                                 ptext.add(amount);
                                 // �丮 �ð�
                                 JLabel time = new JLabel(cateList.get(i).getTime());
//                                 time.setBorder(new EmptyBorder(0,0,500,100)); //��, ����, �Ʒ�, ������
                                 time.setFont(ttfReal.deriveFont(20.0f));
                                 time.setForeground(Color.WHITE);
                                 ptext.add(time);
                                 
                                 JPanel pRecipe = new JPanel();
                                 pRecipe.setLayout(new BoxLayout(pRecipe, BoxLayout.Y_AXIS));
                                 pRecipe.setBackground(Color.WHITE);
                                 pRecipe.setPreferredSize(new Dimension(1020,290));

                                 // ������
                                 String recipeArr[] = c.getRecipe();
                                 for(int j = 0; j < recipeArr.length; j++) {
                                    JLabel recipe = new JLabel(recipeArr[j]);
                                    
                                    recipe.setFont(ttfReal.deriveFont(20.0f));
                                    recipe.setBorder(new EmptyBorder(20,0,0,0));
                                    pRecipe.add(recipe);
                                 }
                                 recipePanel.add(ptext);
                                 recipePanel.add(pRecipe);
                                 recipePanel.add(backTo, BorderLayout.SOUTH);
                              }
                           }
                           panel3.repaint();
//                           panel3.add(backTo, BorderLayout.SOUTH);
                        }
                        
                     });   
                     panel3.add(backTo);
                  }
                  
               }   
               
            } // Category ArrayList �ݺ���
            if(count == 0) {
               System.out.println(count);
               JLabel noRecipe = new JLabel("�˻��� ��ῡ �˸��� �����ǰ� �����ϴ�.");
               noRecipe.setFont(ttfReal);
               panel3.add(noRecipe);
               panel3.add(backTo);
               return;
            }
         } // ���Ͽ� ���� ������� ������
         
      }
   }); // �˻� �̺�Ʈ ��
   
   
      this.add(panel1);
      this.add(panel2);
      this.add(panel3);
   }




}