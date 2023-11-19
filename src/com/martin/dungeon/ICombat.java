package com.martin.dungeon;

public interface ICombat {
    void attackmonster(Monster target);

    void attackplayer(Player player);
    int flee(Monster target);
    void bag();
    void status();
}
