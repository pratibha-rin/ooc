package io.muic.ooc.zork;

import io.muic.ooc.zork.command.Command;
import io.muic.ooc.zork.command.CommandFactory;
import io.muic.ooc.zork.command.Player;
import io.muic.ooc.zork.command.World;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    Status state = Status.MENU;


    public enum Status {
        PLAYING, WIN, DIE, MENU
    }

    public static final Map<String, World.Direction> dirShorthand = Main.dirShorthand();

    private static Map<String, World.Direction> dirShorthand() {
        final Map<String, World.Direction> map = new HashMap<>();
        map.put("north", World.Direction.NORTH);
        map.put("n", World.Direction.NORTH);
        map.put("east", World.Direction.EAST);
        map.put("e", World.Direction.EAST);
        map.put("south", World.Direction.SOUTH);
        map.put("s", World.Direction.SOUTH);
        map.put("west", World.Direction.WEST);
        map.put("w", World.Direction.WEST);
        return map;
    }


    /**
     * Runs the game.
     *
     * @param args - Empty.
     */
    public void main(final String[] args) {

        final Player player = new Player(10, "Carlton");
        final World world = new World();
        Scanner scanner = new Scanner(System.in);
        Main game = new Main();
        player.getCurrentMap().enter(player);
        try (Scanner reader = new Scanner(System.in)) {
            Status death = null;
            while ((death = player.getDeath()) == Status.PLAYING) {
                final io.muic.ooc.zork.command.Map<?> currentMap
                        = player.getCurrentMap();
                final String currentTitle = currentMap.title();
                System.out.println(currentTitle);
            }
            System.out.println(" $ Zork $>");
            final String input = reader.nextLine();
            String[] cmds = input.split(" ");
            Command cmd = CommandFactory.getCommand(cmds[0]);
            if (cmd != null) {
                cmd.execute(cmds, state, player, world);
            }
            System.out.println("What?");
        }


    }
}