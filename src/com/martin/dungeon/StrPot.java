package com.martin.dungeon;

public class StrPot implements IItems{

    String name = "Str potion";
    int capacity = 1;
    @Override
    public String name() {
        return name;
    }

    @Override
    public void use(Player player) {
        System.out.println(this.name + " was used");
        player.setStr(10);
        System.out.println("+ 10 str");
        removeCapacity();

        if(this.capacity == 0){
            player.removeFromInventory(this);
            this.capacity = 1;
        }
    }

    @Override
    public void nameAndCap() {
        System.out.println("strpot x" + this.capacity);
    }

    @Override
    public void addCapacity() {
        this.capacity += 1;
    }

    @Override
    public void removeCapacity() {
        this.capacity -=1;
    }

}
