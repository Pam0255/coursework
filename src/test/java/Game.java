package com.hogwarts.java;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
       // String temp = scanner.nextLine();
       // System.out.println("1111"+temp);
        while (true){
            mainDisplay();
        }

    }

    public static void mainDisplay() {
        System.out.println("---欢迎来到回合制游戏---");
        System.out.println("1.创建英雄");
        System.out.println("2.查看英雄信息");
        System.out.println("3.查看攻击力小于100的英雄姓名");
        System.out.println("4.打斗");
        System.out.println("5.修改英雄信息");
        System.out.println("6.删除英雄");
        System.out.println("7.退出系统");

        //

        //接收键盘输入参数
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入您的选择:");
//        int choice= Integer.parseInt(scanner.nextLine());
        int choice = 0;
        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
            System.out.println("用户输入为:" + choice);
        } else {
            System.out.println("输入错误！");
            System.exit(0);  // 清除错误输入
        }

        switch (choice) {
            case 1:
                Hero.CreateHero();
                break;
            case 2:
                Hero.showAllHero();
                break;
            case 3:
                Hero.showWeakHero();
                break;
            case 4:
                Scanner scannerPlayerOne = new Scanner(System.in);
                System.out.print("请输入英雄1号的Id:");
                String IdOne = scannerPlayerOne.nextLine();
                Scanner scannerPlayerTwo = new Scanner(System.in);
                System.out.print("请输入英雄2号的Id:");
                String IdTwo = scannerPlayerOne.nextLine();
                Hero.fightHero(IdOne,IdTwo);
                break;
            case 5:
                Hero.changeHeroDetail();
                break;

            case 6:
                Scanner scanner6 = new Scanner(System.in);
                System.out.print("请输入想要删除的英雄序号:");
                String deleteId = scanner6.nextLine();
                Hero.deleteHero(deleteId);
                System.out.print("删除成功!");
                break;

            case 7:
                System.out.println("退出系统");
                System.exit(0);
        }

    }


}
