package io.muic.ooc.zork.command;

import io.muic.ooc.zork.command.ingame.DropCommand;
import io.muic.ooc.zork.command.ingame.InfoCommand;
import io.muic.ooc.zork.command.menu.ExitCommand;
import io.muic.ooc.zork.command.menu.PlayCommand;

import java.util.HashMap;
import java.util.Map;

public final class CommandFactory {
    private CommandFactory() {
    }
    private static final Map<String, Command> COMMAND_MAP = new HashMap<>();

    static {
        COMMAND_MAP.put("exit", new ExitCommand());
        COMMAND_MAP.put("drop", new DropCommand());
        COMMAND_MAP.put("help", new HelpCommand());
        COMMAND_MAP.put("play", new PlayCommand());
        COMMAND_MAP.put("info", new InfoCommand());
    }

    /**
     *  Execute the command by sending to its class.
     * @param cmd - This Command is used to execute.
     * @return execution of the command.
     */
    public static Command getCommand(final String cmd) {
       return COMMAND_MAP.get(cmd);
    }
}
