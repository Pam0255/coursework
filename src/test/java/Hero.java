package com.hogwarts.java;

import javax.swing.*;
import java.util.*;

public class Hero {

    //英雄编号
    private String id;
    //英雄姓名
    private String name;
    //血量
    private int hp;
    //攻击力
    private int power;
    private static Scanner scanner = new Scanner(System.in);
    public static Set<Hero> heroSet = new HashSet<Hero>();
    public static void CreateHero() {
        try{
        Hero hero = new Hero();
        Hero.heroSet.add(hero);
        }catch (Exception e){
            System.out.println("发生错误，创建失败");
        }
        System.out.println("添加英雄成功！");
    }
    public Hero() {
        this.id = inputId();
        this.name = inputName();
        this.hp = inputHp();
        this.power = inputPower();
    }

    //获取输入的英雄Id
    private String inputId() {
        System.out.print("请输入您的英雄序号：");
        String checkId=null;
        boolean flag = true;
        while (flag) {
            checkId = scanner.nextLine();
            if(checkId.equals("")){
                System.out.println("您输入的名字为空字符串，请重新输入!");
            }
            //首次输入判断
            else if (heroSet.size()==0)
            {
                break;
            }
            else
            {
                for (Hero hero : heroSet) {
                    if (hero.getId().equals(checkId)) {
                        System.out.println("提示:已经存在相同的id的英雄，请重写输入");
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            //break;
        }
        return checkId;
    }
    private String inputName() {
        System.out.print("请输入新增/修改您的英雄名字：");
        return scanner.nextLine();
    }
    private Integer inputHp() {
        System.out.print("请输入您的英雄HP：");
//        boolean flag = true;
        int Hp = 0;
        while (true) {
            try {
                Hp = Integer.parseInt(scanner.nextLine());
                if (Hp > 0) {
                    break;
                }
            } catch (InputMismatchException  e) {
                System.out.println("输入的英雄hp不是有效值");
                scanner.nextLine();
            }
        }
        return Hp;
    }
    private Integer inputPower() {
        System.out.print("请输入您的英雄武力值：");
//        boolean flag = true;
        int Power = 0;
        while (true) {
            try {
                Power =  Integer.parseInt(scanner.nextLine());
                if (Power > 0) {
                    break;
                } else {
                    System.out.println("输入的英雄hp为负值！！");
                }
            } catch (InputMismatchException  e) {
                System.out.println("输入的英雄hp不是有效值！！");
                scanner.nextLine();
            }
        }
        return Power;
    }
    //展示所有的hero
    public static void showAllHero(){
        System.out.println("---当前存在的英雄如下---");
       // for (int i =0;i<this.heroSet.size();i++); {
            for(Hero hero:heroSet){
            System.out.println(hero);
        }
        System.out.println(""); //输出每个元素的
    }
    //展示弱小的Hero
    public static void showWeakHero(){
        System.out.println("---攻击小于100的英雄如下---");
        // for (int i =0;i<this.heroSet.size();i++); {
        for(Hero hero:heroSet){
            if(hero.power - 100< 0){
            System.out.println(hero.getName());
            }
        }
    }
    //修改hero
    public static boolean changeHeroDetail() {
        if (heroSet.isEmpty()) {
            System.out.println("英雄列表中不存在可修改的英雄！");
            return false;
        }else{
        String modifyId;
        System.out.println("请输入需要修改的英雄序号:");
        modifyId = scanner.nextLine();//注意：使用nextint 后再使用nextline \n会被吸收掉。
        Hero temp = null;
        for (Hero hero : heroSet) {
            if (hero.getId().equals(modifyId)) {
                temp = hero;
                System.out.print("请输入您的修改英雄HP值：");
                int modifyHp=Integer.parseInt(scanner.nextLine());
                temp.setHp(modifyHp);

                System.out.print("请输入您的修改英雄武力值：");
                int modifyPower=Integer.parseInt(scanner.nextLine());
                temp.setPower(modifyPower);
            }
        }
            return true;
        }

    }

    public static void fightHero(String heroOneId, String HeroTwoId){
        //new hp = oldhp - pow
        int heroOneHp = 0,heroOnePower=0, heroOneNewHp=0;
        int heroTwoHp=0,heroTwoPower = 0, heroTwoNewHp=0;
        Hero heroTwo = null;
        Hero heroOne = null;
        for (Hero hero : heroSet) {
            if (hero.getId().equals(heroOneId)){
                heroOnePower = hero.getPower();
                heroOneHp=hero.getHp();
//                System.out.println(hero);
                heroOne = hero;
            }

            if (hero.getId().equals(HeroTwoId)){
                heroTwoPower=hero.getPower();
                heroTwoHp=hero.getHp();
//                System.out.println(hero);
                heroTwo = hero;
            }
        }
        heroOneNewHp = heroOneHp - heroTwoPower;
        heroTwoNewHp = heroTwoHp - heroOnePower;

        if (heroOneNewHp <= 0){
            heroOne.setHp(0);
        }else {
//            System.out.println(heroOneNewHp);
            heroOne.setHp(heroOneNewHp);
        }
        if (heroTwoNewHp <= 0){
            heroTwo.setHp(0);
        }else {
            heroTwo.setHp(heroTwoNewHp);
        }



    }
    //删除hero
    public static void deleteHero(String deleteId) {
        Hero temp = null;
        for (Hero hero : heroSet) {
            if (hero.getId().equals(deleteId)) {
                temp = hero;
            }
        }
        heroSet.remove(temp);
    }
    @Override
    public String toString() {
        return "-----------\n" +
                ">英雄序号:" + id +
                "\n>英雄姓名:" + name +
                "\n>英雄血量:" + hp +
                "\n>英雄攻击力=" + power
                ;
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getPower() {
        return power;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return hp == hero.hp && power == hero.power && Objects.equals(id, hero.id) && Objects.equals(name, hero.name) && Objects.equals(heroSet, hero.heroSet);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, hp, power, heroSet);
//    }
}
