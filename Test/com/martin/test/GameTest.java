package com.martin.test;

import com.martin.dungeon.Game;
import com.martin.dungeon.IItems;
import com.martin.dungeon.Monster;
import com.martin.dungeon.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void myTest(){
        List<IItems> invent = new ArrayList<>(3);
        Player player = new Player(invent);
        player.setBaseStats();
        player.setXp(140);

        assertEquals(player.getLv(), 2);
    }
    @Test
    public void myTest2(){
        List<IItems> invent = new ArrayList<>(3);
        Player player = new Player(invent);
        Game game = new Game();
        player.setBaseStats();

        player.setHp(0);
        game.fightMenu(player);
    }

    @Test
    public void myTest3(){
        List<IItems> invent = new ArrayList<>(3);
        Player player = new Player(invent);
        player.setBaseStats();

        Monster monster = new Monster(10,10,10,10,"monster");

        player.attackmonster(monster);

        assertEquals(10 - player.getStr(), monster.getHp());
    }

}