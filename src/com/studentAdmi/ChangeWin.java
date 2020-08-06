package com.studentAdmi;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class ChangeWin extends JFrame{
	private MyLabel nameLabel;
    private MyTextFiled nameText;

    private MyLabel codeLabel;
    private MyTextFiled codeText;

    private MyButton OKButton;            //确认按钮
    private MyButton clearButton;         //清空按钮

    ChangeWin(){
        super();
        this.setIconImage(Main.icon.getImage());
        this.setSize(500, 300);
        this.setLayout(null);                    //清空布局器
        this.setResizable(false);               //不可改变大小
        this.setLocation(400,200);         //设置窗口生成位置
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("请输入学号和姓名");
        this.getContentPane().setBackground(Color.pink);
        this.setVisible(true);

        this.addPart();
        this.addListen();
    }

    private void addPart(){

        nameLabel = new MyLabel(80, 15, 80, 40, "姓名");
        this.add(nameLabel);
        nameText = new MyTextFiled(140, 20, 200, 30);
        this.add(nameText);

        codeLabel = new MyLabel(80, 65, 80, 40, "学号");
        this.add(codeLabel);
        codeText = new MyTextFiled(140, 70, 200, 30);
        this.add(codeText);

        OKButton =new MyButton(40, 200, 80, 40, "确认");
        this.add(OKButton);
        clearButton =new MyButton(360, 200, 80, 40, "清空");
        this.add(clearButton);
    }

    private void addListen(){
        OKButton.addActionListener(new OKListener());
        clearButton.addActionListener(new ClearListener());
    }
    
    private class OKListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	if ((Main.students.containsKey(codeText.getText())) && (Main.students.get(codeText.getText()).getName().equals(nameText.getText()))){
        		new ChangedWin(Main.students.get(codeText.getText()).getName(), Main.students.get(codeText.getText()).getSex(), Main.students.get(codeText.getText()).getPlace(), Main.students.get(codeText.getText()).getCode(), Main.students.get(codeText.getText()).getDept(), Main.students.get(codeText.getText()).getBan());
        		
        	}else {
                JOptionPane.showMessageDialog(null, "没有该学号信息或名字与学号不匹配", "提示",JOptionPane.WARNING_MESSAGE);   //弹出提示框
			}
        }
    }

    private class ClearListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            nameText.setText("");
            codeText.setText("");
        }
    }
}
