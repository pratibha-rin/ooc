package io.muic.ooc.zork.command;

import io.muic.ooc.zork.Main;

public class HelpCommand implements Command {

    /**
     * Help text output.
     */
    private final String helpText = "\n"
            + "========================\n"
            + "   help - Print out all of the command.\n"
            + "========================\n"
            + "      Menu Command\n"
            + "========================\n"
            + "   exit - Exit from the game.\n"
            + "   play {map-name} - Load the map\n"
            + "   load {saved-point-name} - Load saved file\n"
            + "========================\n"
            + "      In-game Command\n"
            + "========================\n"
            + "   info - Give players and current all the map details.\n"
            + "   take {item} - Pick up the item in the room.\n"
            + "   drop {item} - Drop an item in the inventory.\n"
            + "   attack with {item} - Attack with an item.\n"
            + "   go {direction} - Move north, south, east, west.\n"
            + "   map - Show the map.\n"
            + "   autopilot {file} - Run the game by the input file.\n"
            + "   quit - Exit back to Menu.\n"
            + "   save {name} - Save the game.\n"
            + "========================\n";

    /**
     * Print out all command and it's uses.
     * @param args - This Command is used to execute.
     * @param state - This shows the state of the game.
     * @param player - This is the player Object.
     * @param world - This is the world Object.
     */
    @Override
    public void execute(final String[] args, final Main.Status state, Player player, World world) {
        System.out.print(helpText);
    }
}
