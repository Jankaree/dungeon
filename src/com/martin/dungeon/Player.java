package com.martin.dungeon;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Random;
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

    private int id;

    private int hasleveled;

    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_BLACK = "\u001B[30m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_PURPLE = "\u001B[35m";
    public static final String TEXT_CYAN = "\u001B[36m";
    public static final String TEXT_YELLOW = "\u001B[33m";
    public static final String TEXT_WHITE = "\u001B[37m";

    public int getHasleveled() {
        return hasleveled;
    }

    public void setHasleveled(int hasleveled) {
        this.hasleveled = hasleveled;
    }

    public void setBaseStats(){
        this.str = 1;
        this.intelect = 1;
        this.agi = 1;
        this.hp = 10;
        this.xp = 0;
        this.lv = 1;
        this.baseHp = 10;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBaseHp() {
        return baseHp;
    }

    public void setBaseHp(int baseHp) {
        this.baseHp += baseHp;
    }

    public Player(List<IItems> inventory) {
        this.inventory = inventory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStr(int str) {
        this.str += str;
    }

    public void setIntelect(int intelect) {
        this.intelect = intelect;
    }

    public void setAgi(int agi) {
        this.agi += agi;
    }


    public void setLv(int lv) {
        this.lv += lv;
        setHasleveled(1);
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setXp(int xp) {
        System.out.println( TEXT_PURPLE + "you gained " + xp + " xp" + TEXT_RESET);
        this.xp += xp;

        if(this.xp >= 100){
            System.out.println("=================");
            System.out.println( TEXT_PURPLE +"level up!");
            setLv(1);
            System.out.println("You are now level: " + getLv() + TEXT_RESET);
            System.out.println("=================");

            this.xp = this.xp % 100;
        }
    }
    public void setXp2(int xp){
        this.xp = xp;
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
        System.out.println("Press 'y' or 'n'");
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

        System.out.println(TEXT_GREEN + "you attack the " + TEXT_RESET + TEXT_RED + target.getName() + TEXT_RESET);
        target.setHp(target.getHp() - this.getStr());
        System.out.println(TEXT_GREEN + "you dealt "  + this.getStr() + " damage" + TEXT_RESET);
        System.out.println(TEXT_RED + target.getName()  + " current hp: " + target.getHp() + TEXT_RESET);

    }

    @Override
    public void attackplayer(Player player) {

    }

    @Override
    public int flee(Monster target) {
        Random rand = new Random();

        if(this.agi > target.getAgi()){
            return 1;
        }
        if(this.agi < target.getAgi()){
            return rand.nextInt(4);
        }
        if(this.agi == target.getAgi()){
            return rand.nextInt(2);
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Player{" + "PlayerID=" + id + ", PlayerName='" + name + '\'' + '\'' + '}';
    }

    @Override
    public void bag() {

    }

    @Override
    public void status() {

    }
}
