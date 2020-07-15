package io.muic.ooc.zork.command;

public class Item {
    /**
     * Name of the item.*/
    private String name = "Default item name";
    /**
     * Attack damage of the item.*/
    private int damage = 0;

    public Item() {

    }

    /**
     * Fetch name of the item.
     * @return - String of the item name.
     */
    public String name() {
        return this.name;
    }

    /**
     * Write the name of the item.
     * @param newName - Name th change to.
     * @return - Item with new name.
     */
    public Item name(final String newName) {
        this.name = newName;
        return this;
    }

    /**
     * Attack damage.
     * @return - Int of the damage
     */
    public int attack() {
        return this.damage;
    }

    /**
     * Change the damage of the item.
     * @param power - Change to what damage.
     * @return - Item with modified damage.
     */
    public Item attack(final int power) {
        this.damage = power;
        return this;
    }
}
