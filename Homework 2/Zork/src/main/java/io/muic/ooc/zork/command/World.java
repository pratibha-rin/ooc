package io.muic.ooc.zork.command;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class World {


    /**
     * Direction to travel.
     */
    public enum Direction {
        NORTH, EAST, SOUTH, WEST
    }

    /**
     * Map tto keep track of all maps.
     */
    private final HashMap<Class<? extends Map<?>>, Map<?>> map;

    /**
     * Initialise the hashmap to contain all map.
     */
    public World() {
        this.map = new HashMap<>();
    }

    /**
     * Add map to the world.
     * @param mapName - Name of map to be added.
     * @param newMap - Name of map to be add.
     * @return - World of the map added.
     */
    public World addMap(final Class<? extends Map<?>> mapName,
                         final Map<?> newMap) {
        this.map.put(mapName, newMap);
        return this;
    }

    /**
     * Make sure to add map with two var.
     * @param mapName - Map to be added.
     * @return - Null.
     */
    public World addMap(final Class<? extends Map<?>> mapName) {
        try {
            return this.addMap(mapName,
                    mapName
                            .getConstructor(World.class)
                            .newInstance(this));
        } catch (InstantiationException
                | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | NoSuchMethodException
                | SecurityException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Get the map to be use.
     * @param <T> - Hashmap.
     * @param thisMap - Map to fetch.
     * @return - Map from the world.
     */
    public <T extends Map<?>> T getMap(final Map<?> thisMap) {
        return (T) this.map.get(thisMap);
    }

    /**
     * Get map for class input.
     * @param clazz - input of class.
     * @return - map for the class.
     */
    public Map<?> getMap(Class<?> clazz) {
        return this.map.get(clazz);
    }
}
