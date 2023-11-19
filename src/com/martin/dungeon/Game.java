package com.martin.dungeon;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private int langInt = 1;
    private HpPot hppot = new HpPot();
    private StrPot strpot = new StrPot();


    public void setupGame() {
        Scanner sc = new Scanner(System.in);

        int play = 1;
        while(play == 1) {

            if (langInt == 1) {

                System.out.println("1 Play Game");
                System.out.println("2 Language");
                System.out.println("3 Quit");

                switch (sc.nextLine()) {
                    case "1" -> startGame();

                    case "2" -> langMeny();

                    case "3" -> play = 2;

                    default -> System.out.println("1,2 or 3");
                }

            }

            if (langInt == 2) {

                System.out.println("1 프레이");
                System.out.println("2 언어");
                System.out.println("3 종료");

                switch (sc.nextLine()) {
                    case "1" -> startGame();

                    case "2" -> langMeny();

                    case "3" -> play = 2;

                    default -> System.out.println("1,2 or 3");
                }

            }
            if (langInt == 3) {

                System.out.println("1 Spela");
                System.out.println("2 Språk");
                System.out.println("3 Avsluta");

                switch (sc.nextLine()) {
                    case "1" -> startGame();

                    case "2" -> langMeny();

                    case "3" -> play = 2;

                    default -> System.out.println("1,2 or 3");
                }

            }
        }
    }

    public void langMeny(){

        Scanner sc = new Scanner(System.in);

        System.out.println("1 English");
        System.out.println("2 한국어");
        System.out.println("3 Svenska");

        switch (sc.nextLine()){
            case "1" -> this.langInt = 1;
            case "2" -> this.langInt = 2;
            case "3" -> this.langInt = 3;

            default -> System.out.println("1,2 or 3");
    }

    }

    public void startGame(){
        List<IItems> invent = new ArrayList<>(3);
        Scanner sc = new Scanner(System.in);
        Player player = new Player(invent);

        if (langInt == 1) {

            System.out.println("Hello adventurer!");
            System.out.println("What is your name?");
            player.setName(sc.nextLine());
            System.out.println("Ah, Hello " + player.getName());

            player.setBaseStats();
            mainMeny(player);


        }

        if (langInt == 2) {

            System.out.println("모험가 안녕하세요");
            System.out.println("이름이 어떻게 됩니까?");
            player.setName(sc.nextLine());
            System.out.println("아, 안녕하세요 " + player.getName() + "님");

            player.setBaseStats();
            mainMeny(player);

        }
        if (langInt == 3) {

            System.out.println("Hej äventyrare");
            System.out.println("Vad heter du?");
            player.setName(sc.nextLine());
            System.out.println("Ah, Hej " + player.getName());

            player.setBaseStats();
            mainMeny(player);

        }



    }

    public void mainMeny(Player player){

        Scanner sc = new Scanner(System.in);
       // player.addToInventory(hppot);
       // player.addToInventory(strpot);

        if (langInt == 1) {

            System.out.println("1 Fight!!");
            System.out.println("2 Status");
            System.out.println("3 Bag");
            System.out.println("4 Quit");

            switch (sc.nextLine()) {
                case "1" -> fightMenu(player);

                case "2" -> getStatus(player);

                case "3" -> {
                    if(player.inventory.size() == 0){
                        System.out.println("Inventory is empty");
                    }else {
                        inventoryMenu(player);
                    }
                }


                case "4" -> System.exit(0);

                default -> System.out.println("1,2,3 or 4");
            }
            mainMeny(player);

        }

        if (langInt == 2) {

            System.out.println("1 전투!!");
            System.out.println("2 통계");
            System.out.println("4 전리품 상장");
            System.out.println("4 종료");

            switch (sc.nextLine()) {
                case "1" -> startGame();

                case "2" -> System.out.println("korea");

                case "3" -> System.out.println();

                default -> System.out.println("1,2 or 3");
            }

        }
        if (langInt == 3) {

            System.out.println("1 Strid");
            System.out.println("2 Status");
            System.out.println("3 Förråd");
            System.out.println("4 Avsluta");

            switch (sc.nextLine()) {
                case "1" -> startGame();

                case "2" -> System.out.println("swäden");

                case "3" -> System.out.println();

                default -> System.out.println("1,2 or 3");
            }

        }


    }

    public void getStatus(Player player){
        System.out.println("STATS:");
        System.out.println("=================");
        System.out.println("Name: " +player.getName());
        System.out.println("Level: " + player.getLv());
        System.out.println("XP: " +player.getXp());
        System.out.println("HP: " + player.getHp() + "/" + player.getBaseHp());
        System.out.println("Str: " + player.getStr());
        System.out.println("Int: " + player.getIntelect());
        System.out.println("Agi: " + player.getAgi());
        System.out.println("=================");

        mainMeny(player);

    }

    public void inventoryMenu(Player player){

        Scanner sc = new Scanner(System.in);

        player.checkInventory();

        switch (sc.nextLine()) {
            case "1" -> player.useItem(0);

            case "2" -> player.useItem(1);

            case "3" -> System.out.println();

            default -> System.out.println("1,2 or 3");
        }





    }

    public void fightMenu(Player player) {


        Monster randomMonster = getRandomMonster(player);
        Scanner sc = new Scanner(System.in);

        System.out.println("a Wild " + randomMonster.getName() +  " appeared:");



        while(randomMonster.getHp() > 0 && player.getHp() > 0) {

            System.out.println("Choose what to do!");
            System.out.println("1 Attack");
            System.out.println("2 Inventory");
            System.out.println("3 flee");

            switch (sc.nextLine()) {
                case "1" -> player.attackmonster(randomMonster);

                case "2" -> {
                    if(player.inventory.size() == 0){
                        System.out.println("Inventory is empty");
                    }else {
                        inventoryMenu(player);
                    }
                }

                case "3" -> {
                    if(player.flee(randomMonster) == 1){
                        System.out.println("you feld");
                        mainMeny(player);
                    }

                }

            }
            randomMonster.attackplayer(player);
        }
        if(player.getHp() <= 0){
            System.out.println("You Died");
            System.exit(0);
        }
        Random random = new Random();
        int randomint = random.nextInt(2);
        if(randomint == 0) {
            System.out.println("============================");
            System.out.println("You win!");

            player.getReward(strpot);
            System.out.println("reward: 1x Str pot");
            System.out.println("============================");
        }
        if (randomint == 1){
            System.out.println("============================");
            System.out.println("You win!");

            player.getReward(hppot);
            System.out.println("reward: 1x hp pot");
            System.out.println("============================");
        }
        player.setXp(26);
    }

    public Monster getRandomMonster(Player player){

        Random random = new Random();

        Monster rat = new Monster(1 * player.getLv() - 1, 1 * player.getLv() - 1, 2 * player.getLv(), player.getLv(), "rat");
        Monster spider = new Monster(2* player.getLv(), 2* player.getLv(), 5* player.getLv(), player.getLv(), "spider");
        Monster dragon = new Monster(3* player.getLv(), 3* player.getLv(), 10* player.getLv(), player.getLv(), "dragon");

        List<Monster> monsterList = new ArrayList<>(3);
        monsterList.add(rat);
        monsterList.add(spider);
        monsterList.add(dragon);

        int randomint = random.nextInt(3);

        return monsterList.get(randomint);





    }

    public void levelUpMonster(){

    }
}
