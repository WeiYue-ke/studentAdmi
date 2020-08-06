package com.studentAdmi;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;


public class FoundWin extends JFrame{
	private MyLabel nameLabel;
    private MyTextFiled nameText;

    private MyLabel sexLabel;
    private MyTextFiled sexText;

    private MyLabel placeLabel;
    private MyTextFiled placeText;

    private MyLabel codeLabel;
    private MyTextFiled codeText;

    private MyLabel deptLabel;
    private MyTextFiled deptText;

    private MyLabel banLabel;
    private MyTextFiled banText;
    
    private MyButton OKButton;            //确认按钮
	
	public FoundWin(String name, String sex, String place, String code, String dept, String ban) {
		super();
		this.setIconImage(Main.icon.getImage());
        this.setSize(500,600);
        this.setLayout(null);                    //清空布局器
        this.setResizable(false);               //不可改变大小
        this.setVisible(true);
        this.setLocation(450,200);    //设置窗口生成位置
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("查看学生信息");
        this.getContentPane().setBackground(Color.pink);
        
        this.addPart();
        
        this.nameText.setText(name);
        this.sexText.setText(sex);
        this.placeText.setText(place);
        this.codeText.setText(code);
        this.deptText.setText(dept);
        this.banText.setText(ban);
        
        OKButton = new MyButton(200, 400, 80, 40, "确认");
        this.add(OKButton);
        OKButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FoundWin.this.dispose();            //这个可以实现内部类调用外部类
			}
		});
	}
	
	private void addPart(){                            //添加组件
        nameLabel = new MyLabel(80, 15, 80, 40, "姓名");
        this.add(nameLabel);
        nameText = new MyTextFiled(140, 20, 200, 30);
        nameText.setEditable(false);                         //不可编辑
        this.add(nameText);

        sexLabel = new MyLabel(80, 75, 80, 40, "性别");
        this.add(sexLabel);
        sexText = new MyTextFiled(140, 80, 200,30);
        sexText.setEditable(false);
        this.add(sexText);

        placeLabel = new MyLabel(80, 135, 80, 40, "籍贯");
        this.add(placeLabel);
        placeText = new MyTextFiled(140, 140, 200, 30);
        placeText.setEditable(false);
        this.add(placeText);

        codeLabel = new MyLabel(80, 195, 80, 40, "学号");
        this.add(codeLabel);
        codeText = new MyTextFiled(140, 200, 200, 30);
        codeText.setEditable(false);
        this.add(codeText);

        deptLabel = new MyLabel(80, 255, 80, 40, "系别");
        this.add(deptLabel);
        deptText = new MyTextFiled(140, 260, 200,30);
        deptText.setEditable(false);
        this.add(deptText);

        banLabel = new MyLabel(80, 315, 80, 40, "班级");
        this.add(banLabel);
        banText = new MyTextFiled(140, 320, 200, 30);
        banText.setEditable(false);
        this.add(banText);
        }
	
}
