package io.muic.ooc.zork.command;

import io.muic.ooc.zork.Main;

public interface Command {

    /**
     * Override Method to run the command.
     * @param args - This Command is used to execute.
     * @param state - This shows the state of the game.
     * @param player - This is the player Object.
     * @param world - This is the world Object.
     */
    void execute(String[] args, Main.Status state, Player player, World world);
}
