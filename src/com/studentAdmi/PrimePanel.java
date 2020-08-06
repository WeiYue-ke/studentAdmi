package com.studentAdmi;

import javax.swing.*;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.chrono.MinguoChronology;

public class PrimePanel extends JPanel {
    private MyButton addButton;            // 增按钮
    private MyButton delButton;            // 删按钮
    private MyButton findButton;               // 查按钮
    private MyButton changeButton;             //改按钮
    private MyButton wholeButton;         //全部按钮
    static File studentsFile = new File("src/com/studentAdmi/students.txt");  //学生文件


    public PrimePanel(int x, int y, int width, int height) {     //构造方法
        super();
        this.setLayout(null);                                         //清空布局器
        this.setBounds(x, y, width, height);
        this.setFont(new Font("serif", Font.BOLD, 23));      //字体
        this.setForeground(Color.pink);                        //字体颜色
        this.addButtons();
        this.addListen();
        this.readStudentFile();
    }
    private void readStudentFile() {              //读取学生信息到集合中
		try (BufferedReader buffere = new BufferedReader(new FileReader(studentsFile))){
			String buffereStr = "";
			boolean hasEmpty = false;                       //没有为空的属性
			while((buffereStr = buffere.readLine()) != null) {
				String[] studentBuffere = buffereStr.split("--");
				for (String field : studentBuffere) {                 //遍历切割出来的数组，看看有没有为空的或null的字符串
					if ((field.equals("")) || (field == null)) {
						hasEmpty = true;  
					}
				}
				if (buffereStr.contains(" ") || (hasEmpty)) {            //判断是否有空格
					 JOptionPane.showMessageDialog(null, "学生文件中有为空的属性或含有空格", "提示", JOptionPane.WARNING_MESSAGE); //弹出提示框
					 break;
				}else if ((studentBuffere[1].equals("男") ) || (studentBuffere[1].equals("女"))) {  //判断性别是否正确
					 Main.students.put(studentBuffere[3], new Student(studentBuffere[0] , studentBuffere[1] ,
						studentBuffere[2] , studentBuffere[3] , studentBuffere[4] , studentBuffere[5]));
					}else {
						JOptionPane.showMessageDialog(null, "学生文件中性别不合法", "提示", JOptionPane.WARNING_MESSAGE); //弹出提示框
						break;
						}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


    
    @Override
    public void paintComponent(Graphics g) {        // 重写paintComponent(Graphics g)方法以图片进行绘制。
        super.paintComponents(g);
        Image backgroundImage = new ImageIcon("src/com/studentAdmi/background.jpg").getImage();   //取得图片并绘制。
        g.drawImage(backgroundImage, 0, 0, Main.mainWindow.getWidth(),
        		Main.mainWindow.getHeight(), Main.mainWindow);
        g.drawString("《Java 程序设计基础》课程实训" , 220, 150);
        g.drawString("软件1901  韦烨" , 320, 190);
    }

    private void addButtons(){                             //加入按钮
        addButton = new MyButton(160,280,80,40, "增加");
        this.add(addButton);

        delButton = new MyButton(260,280,80,40, "删除");
        this.add(delButton);

        findButton = new MyButton(360,280,80,40, "查找");
        this.add(findButton);

        changeButton = new MyButton(460,280,80,40 ,"修改");
        this.add(changeButton);

        wholeButton = new MyButton(560,280,80,40 ,"全部");
        this.add(wholeButton); 
    }

    private void addListen(){                                            //  加入监听
        addButton.addActionListener(new AddListener());
        delButton.addActionListener(new DelListener());
        findButton.addActionListener(new FindListener());
        changeButton.addActionListener(new ChangeListener());
        wholeButton.addActionListener(new WholeListener());
 
    }

    private class AddListener implements ActionListener {               //监听添加按钮
        @Override
        public void actionPerformed(ActionEvent e) {
            new AddWin();
        }
    }

    private class DelListener implements ActionListener {               //监听删除按钮
        @Override
        public void actionPerformed(ActionEvent e) {
            new DelWin();
        }
    }

    private class FindListener implements ActionListener {               //监听查找按钮
        @Override
        public void actionPerformed(ActionEvent e) {
            new FindWin();
        }
    }

    private class ChangeListener implements ActionListener {               //监听修改按钮
        @Override
        public void actionPerformed(ActionEvent e) {
        	new ChangeWin();
        }
    }
    
    private class WholeListener implements ActionListener{
    	@Override
    	public void actionPerformed(ActionEvent e) {
    	    new WholeWin();
    	}
    }
       
    static public void refreshFile() {             //刷新文件中的学生信息，在修改、增加和删除中会被调用
    		// TODO Auto-generated method stub
    		try (FileWriter writer = new FileWriter(studentsFile)){
    			String studentString = "";
				for (String keyString : Main.students.keySet()) {
					studentString = Main.students.get(keyString).getName()  
							+ "--" + Main.students.get(keyString).getSex() +  "--" + Main.students.get(keyString).getPlace() 
							+ "--" + Main.students.get(keyString).getCode() +  "--" + Main.students.get(keyString).getDept() 
							+"--" +  Main.students.get(keyString).getBan() + "\n";
					writer.append(studentString);
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
    	}

}

