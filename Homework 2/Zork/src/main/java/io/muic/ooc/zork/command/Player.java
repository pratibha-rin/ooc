package io.muic.ooc.zork.command;


import io.muic.ooc.zork.Main;

import java.util.ArrayList;
import java.util.List;

public class Player {
//player hp
    private int hp;
//Max Hp of the player.
    private int maxHp;
//Name of the player
    private String name;
//Current map player is in.
    private Map<?> currentArea;
//Inventory of the player.
    private final List<Item> inventory;
//State of the player if died.
    private Main.Status death;

    public Player(final int hp, final String name) {
        this.hp = hp;
        this.maxHp = hp;
        this.name = name;
        this.death = Main.Status.PLAYING;
        this.inventory = new ArrayList<>();
    }

    public String currentDescription() {
        final StringBuilder desc = new StringBuilder();
        final Map<?> currentArea = this.getCurrentMap();
        desc.append(currentArea.description());
        final List<Item> items = currentArea.items();
        desc.append(this.name);
        desc.append('\n');
        desc.append(" You have ").append(this.hp).append("Hp");
        desc.append('\n');
        desc.append("Your Max Hp is ").append(this.maxHp).append("Hp");
        desc.append('\n');
        List<Item> inven = this.getInventory();
        if (inven.size() > 0){
            desc.append("You have: ");
            for (final Item item : inven){
                desc.append('\n');
                desc.append(item.name());
            }
        }
        desc.append('\n');
        if (items.size() > 0) {
            desc.append("This Area contains: ");
            for (final Item item : items) {
                desc.append('\n');
                desc.append(item.name());
            }
        }
    return desc.toString();
    }

//Get the current map.
    public Map<?> getCurrentMap() {
            return this.currentArea;
    }
//Get name of the player.
    public String getName() {
        return this.name;
    }
//Rename the player.
    public void rename(final String newName) {
        this.name = newName;
    }
    public void addItem(final Item item) {
        this.inventory.add(item);
    }
    public void removeItem(final Item item) {
        this.inventory.remove(item);
    }

    /**
     * Check if player have an item.
     * @param name - Name of the item
     * @return - Boolean
     */
    public boolean hasItem(final String name) {
        for (final Item item : this.getInventory()) {
            if (item.name().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public List<Item> getInventory() {
        return this.inventory;
    }

    public void setCurrentMap(final Map<?> area) {
        this.currentArea = area;
    }

    public void setHp(final int n) {
        this.hp = n;
    }

    public int getHp() {
        return this.hp;
    }

    public void addHp(final int n) {
        this.hp += n;
    }

    public void setMaxHp(final int n) {
        this.maxHp = n;
    }

    public int getMaxHp() {
        return this.maxHp;
    }

    public void setDeath(Main.Status death) {
        death = Main.Status.DIE;
        this.death = death;
    }

    public Main.Status getDeath() {
        return this.death;
    }
}
