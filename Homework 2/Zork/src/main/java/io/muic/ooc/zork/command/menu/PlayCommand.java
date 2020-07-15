package io.muic.ooc.zork.command.menu;

import io.muic.ooc.zork.Main;
import io.muic.ooc.zork.command.Command;
import io.muic.ooc.zork.command.Player;
import io.muic.ooc.zork.command.StartGround;
import io.muic.ooc.zork.command.World;

public class PlayCommand implements Command {

    /**
     * Error Text.
     */
    String errorText =
            "==============================\n"
            + "Can't use this command in-game\n"
            + "==============================\n";

    /**
     * Exit off the game.
     * @param args - This Command is used to execute.
     * @param state - This shows the state of the game.
     * @param player - This is the player Object.
     * @param world - This is the world Object.
     */
    @Override
    public void execute(final String[] args, Main.Status state, Player player, World world) {
        if (state.equals(Main.Status.MENU)) {
            player.setCurrentMap(world.getMap(StartGround.class));
            player.getCurrentMap().enter(player);
            state = Main.Status.PLAYING;
        } else {
            System.out.print(errorText);
        }
    }
}
