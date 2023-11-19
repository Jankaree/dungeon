package com.martin.dungeon;

import java.util.List;
import java.util.Scanner;

public class Player implements ICombat{

    List<IItems> inventory;

    private String name;
    private int str;
    private int intelect;
    private int agi;
    private int hp;
    private int xp;
    private int lv;
    private double dmg;
    private int baseHp;

    public void setBaseStats(){
        this.str = 1;
        this.intelect = 1;
        this.agi = 1;
        this.hp = 10;
        this.xp = 0;
        this.lv = 1;
        this.baseHp = 10;

    }

    public int getBaseHp() {
        return baseHp;
    }

    public void setBaseHp(int baseHp) {
        this.baseHp = baseHp;
    }

    public Player(List<IItems> inventory) {
        this.inventory = inventory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public void setIntelect(int intelect) {
        this.intelect = intelect;
    }

    public void setAgi(int agi) {
        this.agi = agi;
    }


    public void setLv(int lv) {
        this.lv += lv;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setXp(int xp) {
        System.out.println("you gained " + xp);
        this.xp += xp;

        if(this.xp >= 100){
            System.out.println("=================");
            System.out.println("level up!");
            setLv(1);
            System.out.println("You are now level: " + getLv());
            System.out.println("=================");

            this.xp = this.xp % 100;
        }
    }

    public void setPv(int lv) {
        this.lv += lv;
    }

    public void setDmg(double dmg) {
        this.dmg = dmg;
    }

    public String getName() {
        return name;
    }

    public int getStr() {
        return str;
    }

    public int getIntelect() {
        return intelect;
    }

    public int getAgi() {
        return agi;
    }

    public int getHp() {
        return hp;
    }

    public int getXp() {
        return xp;
    }

    public int getLv() {
        return lv;
    }

    public double getDmg() {
        return dmg;
    }

    public void addToInventory(IItems items){
        if(this.inventory.contains(items)){
            this.inventory.remove(items);
            items.addCapacity();

            this.inventory.add(items);
        }
        else {
            this.inventory.add(items);
        }
    }

    public void removeFromInventory(IItems items){
        this.inventory.remove(items);
    }

    public void checkInventory(){
        for (int i = 0; i < this.inventory.size(); i++) {
            this.inventory.get(i).nameAndCap();
        }
    }

    public void useItem(int i) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Would you like to use your: " + this.inventory.get(i).name());

        switch (sc.nextLine()) {
            case "y" -> this.inventory.get(i).use(this);

            case "n" -> System.out.println(this.inventory.get(i).name() + " was not used");

            default -> System.out.println("type 'y' or 'n' ");


        }
    }

    public void getReward(IItems items)
    {
        addToInventory(items);
    }

    @Override
    public void attackmonster(Monster target) {

        System.out.println("you attack the " + target.getName());
        target.setHp(target.getHp() - this.getStr());
        System.out.println("you dealt " + this.getStr() + " damage");
        System.out.println(target.getName() + " current hp: " + target.getHp());

    }

    @Override
    public void attackplayer(Player player) {

    }

    @Override
    public int flee(Monster target) {
        if(this.agi > target.getAgi()){
            return 1;
        }
        if(this.agi < target.getAgi()){
            return -1;
        }
        if(this.agi == target.getAgi()){
            return 0;
        }
        return 0;
    }

    @Override
    public void bag() {

    }

    @Override
    public void status() {

    }
}
