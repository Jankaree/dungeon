package com.martin.dungeon;

public class Monster implements ICombat {

    private int str;
    private int intelect;
    private int agi;
    private int hp;
    private int lv;
    private double dmg;

    private String name;

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
        System.out.println("the " + this.getName() + " attacks " + player.getName());
        player.setHp(player.getHp() - this.getStr());
        System.out.println("the " + this.getName() + " dealt " + this.getStr() + " damage");
        System.out.println(player.getName() + " current hp: " + player.getHp());
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

