package com.studentAdmi;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;


public class Main {
    static MainWindow mainWindow ;
    static ImageIcon icon = new ImageIcon("src/com/studentAdmi/sigh.jpg");
    static Map<String , Student> students = new HashMap<String, Student>();
    private Main(){}
    public static void main(String[] args) {
        mainWindow = new MainWindow();
    }
}

class MainWindow extends JFrame {
    static PrimePanel HomePanel;
    MainWindow(){
        super();
        this.setSize(800, 500);
        this.setIconImage(Main.icon.getImage());
        this.setLayout(null);                    //清空布局器
        HomePanel = new PrimePanel(0, 0, 800, 500);
        this.getContentPane().add(HomePanel);
        this.setResizable(false);               //不可改变大小
        this.setLocation(300,150);         //设置窗口生成位置
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("学生信息管理系统");
        this.setVisible(true);

    }
}


