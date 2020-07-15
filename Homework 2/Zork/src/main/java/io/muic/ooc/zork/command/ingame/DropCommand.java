package io.muic.ooc.zork.command.ingame;

import io.muic.ooc.zork.Main;
import io.muic.ooc.zork.command.Command;
import io.muic.ooc.zork.command.Item;
import io.muic.ooc.zork.command.Player;
import io.muic.ooc.zork.command.World;

public class DropCommand implements Command {

    String errorText =
            "=================================\n"
            + "This command cannot be used\n"
            + "=================================\n";
    /**
     * Drop Item in player inventory.
     * @param args - This Command is used to execute.
     * @param state - This shows the state of the game.
     * @param player - This is the player Object.
     * @param world - This is the world Object.
     */
    @Override
    public void execute(final String[] args, final Main.Status state, Player player, World world) {
            if (state.equals(Main.Status.PLAYING)) {
                Item item = new Item().name(args[2]);
                if (item != null){
                    player.removeItem(item);
                    world.getMap(player.getCurrentMap()).addItem(item);
                    System.out.println("You have drop" + item.name() + "!!" );
                }
            } else {
                System.out.print(errorText);
            }
    }
}
