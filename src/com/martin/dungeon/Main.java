package com.martin.dungeon;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        DBC dbc = new DBC();


        Game game = new Game(dbc);
        game.setupGame();



       // dbc.open();
       // System.out.println(dbc.idFinder());
/*
        List<IItems> invent = new ArrayList<>(10);

        Player player = new Player(invent);

        HpPot hppot = new HpPot();
        HpPot hppot2 = new HpPot();
        StrPot strpot = new StrPot();

        player.addToInventory(hppot);
        player.addToInventory(hppot);
        player.addToInventory(strpot);
        player.addToInventory(strpot);


        player.checkInventory();

        strpot.use(player);

        System.out.println("");
        player.checkInventory();

        strpot.use(player);

        System.out.println("");
        player.checkInventory();

        player.addToInventory(strpot);

        System.out.println("");
        player.checkInventory();
        */



    }
}
