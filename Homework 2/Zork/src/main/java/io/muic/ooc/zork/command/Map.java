package io.muic.ooc.zork.command;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Map<S extends Serializable> {
    /**
     * World where map be place.
     */
    private final World world;
    /**
     * Title of the room.
     */
    private String title = "Default area title";
    /**
     * Description of the room.
     */
    private String description = "Default description.";
    /**
     * List of item in the map.
     */
    private final List<Item> items = new ArrayList<>();

    /**
     * Keep track of sate of the map.
     */
    private S state = null;


    /**
     * Initialise the world.
     * @param containWorld - World map will be place in.
     */
    public Map(final World containWorld) {
        this.world = containWorld;
    }

    /**
     * Fetch the world.
     * @return - World which map is in.
     */
    public World getWorld() {
        return this.world;
    }

    /**
     * Fetch title.
     * @return - String.
     */
    public String title() {
        return this.title;
    }

    /**
     * Create Title.
     * @param newTitle - String to be the title.
     * @return - Map with the new title.
     */
    public Map<S> title(final String newTitle) {
        this.title =  newTitle;
        return this;
    }

    /**
     * Fetch the description of the map.
     * @return - The description of the map.
     */
    public String description() {
        return this.description;
    }

    /**
     * Create a description of the map.
     * @param newDescription - String to be description.
     * @return - Map with new description.
     */
    public Map<S> description(final String newDescription) {
        this.description = newDescription;
        return this;
    }

    /**
     * Fetch state.
     * @return - State.
     */
    public S state() {
        return this.state;
    }

    /**
     * Write new state.
     * @param newState - New State.
     * @return - Map
     */
    public Map<S> state(final S newState) {
        this.state = newState;
        return this;
    }

    /**
     * Get List of item.
     * @return - item in the map.
     */
    public List<Item> items() {
        return this.items;
    }

    /**
     * Add item to the list.
     * @param item - item to be added
     * @return - new List of item.
     */
    public Map<S> addItem(final Item item) {
        this.items.add(item);
        return this;
    }

    /**
     * Remove item from the list.
     * @param item - item to be removed.
     * @return - New list with remove item.
     */
    public Map<S> removeItem(final Item item) {
        this.items.remove(item);
        return this;
    }

    public void enter(final Player player) {
        System.out.println(player.currentDescription());
    }
}
