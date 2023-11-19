package com.martin.dungeon;

public interface IItems {

    String name();
    void use(Player player);

    void nameAndCap();

    void addCapacity();
    void removeCapacity();

}
