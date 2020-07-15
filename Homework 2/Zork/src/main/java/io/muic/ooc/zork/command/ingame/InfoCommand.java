package io.muic.ooc.zork.command.ingame;

import io.muic.ooc.zork.Main;
import io.muic.ooc.zork.command.Player;
import io.muic.ooc.zork.command.World;

public class InfoCommand implements io.muic.ooc.zork.command.Command {
    /**
     * Override Method to run the command.
     * @param args - This Command is used to execute.
     * @param state - This shows the state of the game.
     * @param player - This is the player Object.
     * @param world - This is the world Object.
     */

    @Override
    public void execute(String[] args, Main.Status state, Player player, World world) {
        if (state.equals(Main.Status.PLAYING)){
            System.out.print(player.currentDescription());
        }
    }
}
