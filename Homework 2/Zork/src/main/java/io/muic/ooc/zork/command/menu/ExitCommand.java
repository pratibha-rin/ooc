package io.muic.ooc.zork.command.menu;

import io.muic.ooc.zork.Main;
import io.muic.ooc.zork.command.Command;
import io.muic.ooc.zork.command.Player;
import io.muic.ooc.zork.command.World;

public final class ExitCommand implements Command {
    /**
     * The exit Text.
     */
    String exitText =
            "====================\n"
            + " Thanks for playing\n"
            +  "   Bye!\n"
            + "====================";
    /**
     * The error Text.
     */
    String errorText =
            "===========================\n"
            + "Can't use this command in game\n"
            + "===========================\n";
    /**
     * Exit off the game.
     * @param args - This Command is used to execute.
     * @param state - This shows the state of the game.
     * @param player - This is the player Object.
     * @param world - This is the world Object.
     */
    @Override
    public void execute(final String[] args, final Main.Status state, Player player, World world) {
        if (state.equals(Main.Status.MENU)) {
        System.out.println(exitText);
        System.exit(0);
    } else {
            System.out.println(errorText);
        }
    }
}
