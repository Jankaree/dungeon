package com.martin.dungeon;

public class HpPot implements IItems{

    int capacity = 1;
    String name = "Hp potion";
    @Override
    public String name()
    {
        return this.name;
    }



    @Override
    public void use(Player player) {
        player.setHp(player.getBaseHp());
        removeCapacity();

        if(this.capacity == 0){
            player.removeFromInventory(this);
            this.capacity = 1;
        }
    }

    @Override
    public void nameAndCap() {
        System.out.println("Hp potion x" + this.capacity);
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
