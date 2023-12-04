package com.martin.dungeon;

public class Monster implements ICombat {

    private int str;
    private int intelect;
    private int agi;
    private int hp;
    private int lv;
    private double dmg;

    private String name;

    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_BLACK = "\u001B[30m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_PURPLE = "\u001B[35m";
    public static final String TEXT_CYAN = "\u001B[36m";
    public static final String TEXT_YELLOW = "\u001B[33m";
    public static final String TEXT_WHITE = "\u001B[37m";

    public String getName() {
        return name;
    }



    public Monster(int str, int agi, int hp, int lv, String name) {
        this.str = str;
        this.agi = agi;
        this.hp = hp;
        this.lv = lv;
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

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setLv(int lv) {
        this.lv = lv;
    }

    public void setDmg(double dmg) {
        this.dmg = dmg;
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

    public int getLv() {
        return lv;
    }

    public double getDmg() {
        return dmg;
    }

    @Override
    public void attackmonster(Monster target) {


    }

    @Override
    public void attackplayer(Player player) {
        System.out.println(TEXT_RED + "the " + this.getName() + " attacks " + TEXT_RESET + TEXT_BLUE + player.getName() + TEXT_RESET);
        player.setHp(player.getHp() - this.getStr());
        System.out.println(TEXT_RED + "the " + this.getName() + " dealt " + this.getStr() + " damage" + TEXT_RESET);
        System.out.println(TEXT_BLUE + player.getName() + TEXT_RESET + TEXT_GREEN + " current hp: " + player.getHp()+ TEXT_RESET);
    }

    @Override
    public int flee(Monster target) {
        return 0;
    }

    @Override
    public void bag() {

    }

    @Override
    public void status() {

    }
}

