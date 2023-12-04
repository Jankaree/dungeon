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

    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_BLACK = "\u001B[30m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_PURPLE = "\u001B[35m";
    public static final String TEXT_CYAN = "\u001B[36m";
    public static final String TEXT_YELLOW = "\u001B[33m";
    public static final String TEXT_WHITE = "\u001B[37m";


    public void setupGame() {
        Scanner sc = new Scanner(System.in);

        int play = 1;
        while(play == 1) {

            if (langInt == 1) {

                System.out.println("1 Play Game");
              //  System.out.println("2 Language");
                System.out.println("2 Quit");

                switch (sc.nextLine()) {
                    case "1" -> startGame();

                    case "2" -> System.exit(0);



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
            System.out.println("Ah, Hello " + TEXT_BLUE + player.getName() + TEXT_RESET);

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
                    System.out.println("===========================");
                    if(player.inventory.size() == 0){
                        System.out.println("Inventory is " + TEXT_RED + "empty" + TEXT_RESET);
                    }else {
                        inventoryMenu(player);
                    }
                    System.out.println("===========================");
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
        System.out.println("Name: " + TEXT_BLUE + player.getName() + TEXT_RESET);
        System.out.println("Level: " + TEXT_PURPLE + player.getLv() + TEXT_RESET);
        System.out.println("XP: " + TEXT_PURPLE + player.getXp() + TEXT_RESET);
        System.out.println("HP: " + TEXT_GREEN + player.getHp() +  "/" +  player.getBaseHp() + TEXT_RESET );
        System.out.println("Str: " + TEXT_RED + player.getStr() + TEXT_RESET);
        System.out.println("Agi: " + TEXT_YELLOW + player.getAgi() + TEXT_RESET);
        System.out.println("=================");

        mainMeny(player);

    }

    public void getcombatStatus(Player player, Monster monster){

        System.out.println(TEXT_BLUE + player.getName() + TEXT_RESET + " vs " + TEXT_RED + monster.getName() + TEXT_RESET);
        System.out.println(TEXT_BLUE + player.getName() + TEXT_RESET + " hp: " + TEXT_GREEN + player.getHp() + TEXT_RESET );
        System.out.println(TEXT_BLUE + player.getName() + TEXT_RESET + " Agi: " + TEXT_YELLOW + player.getAgi() + TEXT_RESET);
        System.out.println();
        System.out.println(TEXT_RED + monster.getName() + " hp: " + monster.getHp());
        System.out.println(monster.getName() + " Agi: " + monster.getAgi() + TEXT_RESET);



    }

    public void inventoryMenu(Player player){

        Scanner sc = new Scanner(System.in);

        player.checkInventory();
        System.out.println("press 1 to use item");
        switch (sc.nextLine()) {
            case "1" -> player.useItem(0);
            case "2" -> mainMeny(player);


            default -> System.out.println("If you want to use the item press 1 else press 2");
        }





    }

    public void fightMenu(Player player) {


        Monster randomMonster = getRandomMonster(player);
        Scanner sc = new Scanner(System.in);

        System.out.println(TEXT_RED + "a Wild " + randomMonster.getName() +  " appeared:" + TEXT_RESET );



        while(randomMonster.getHp() > 0 && player.getHp() > 0) {


            int choise = 1;
            while (choise == 1) {
                System.out.println("Choose what to do!");
                System.out.println("1 Attack");
                System.out.println("2 Inventory");
                System.out.println("3 Status");
                System.out.println("4 flee");

                switch (sc.nextLine()) {
                    case "1" -> {
                        player.attackmonster(randomMonster);
                        choise = 0;
                    }

                    case "2" -> {
                        System.out.println("===========================");
                        if (player.inventory.size() == 0) {
                            System.out.println("Inventory is " + TEXT_RED + "empty" + TEXT_RESET);
                        } else {
                            inventoryMenu(player);
                        }
                        System.out.println("===========================");


                    }

                    case "4" -> {
                        System.out.println("===========================");
                        if (player.flee(randomMonster) == 1) {
                            System.out.println(TEXT_GREEN + "you feld" + TEXT_RESET);
                            System.out.println("===========================");
                            mainMeny(player);
                        }else{
                            System.out.println(TEXT_RED + "you failed to flee" + TEXT_RESET);
                            choise = 0;
                        }
                        System.out.println("===========================");

                    }
                    case "3" -> {
                        System.out.println("===========================");
                        getcombatStatus(player, randomMonster);
                        System.out.println("===========================");
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
        int randomint = random.nextInt(1);
        if(randomint == 1) {
            System.out.println("============================");
            System.out.println("You win!");

            player.getReward(strpot);
            System.out.println("reward: 1x Str pot");
            System.out.println("============================");
        }
        if (randomint == 0){
            System.out.println("============================");
            System.out.println( TEXT_GREEN + "You win!");

            player.getReward(hppot);
            System.out.println("reward: 1x hp pot" + TEXT_RESET);
            System.out.println("============================");
        }
        player.setXp(26);
        if(player.getHasleveled() == 1){
            System.out.println("============================");
            System.out.println("Set stats!");
            for (int i = 5; i > 0; i--) {
                System.out.println("You have " + i + "skill points to use up");
                System.out.println("Write the stat you would like to increase:");

                switch (sc.nextLine()) {
                    case "hp" ->{
                        player.setBaseHp(1);
                        System.out.println(TEXT_GREEN + "new hp = " + player.getBaseHp() + TEXT_RESET);
                    }
                    case "str" ->{
                        player.setStr(1);
                        System.out.println(TEXT_RED + "new str = " + player.getStr() + TEXT_RESET);
                    }
                    case "agi" ->{
                        player.setAgi(1);
                        System.out.println(TEXT_YELLOW + "new agi = " + player.getAgi() + TEXT_RESET);
                    }
                    default -> System.out.println("Please write hp,str or agi");
                }
            }
            player.setHasleveled(0);

        }
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

        int randomint_1 = random.nextInt(1);
        int randomint_2 = random.nextInt(2);
        int randomint_3 = random.nextInt(3);
        if (player.getLv() == 1){
            return monsterList.get(randomint_1);
        }
        if (player.getLv() == 2){
            return monsterList.get(randomint_2);
        }else

        return monsterList.get(randomint_3);

    }

    public void levelUpMonster(){

    }
}
