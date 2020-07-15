package io.muic.ooc.zork.command;

import io.muic.ooc.zork.command.items.Axe;

public class StartGround extends Map<Stateless>{
    public StartGround(final World world){
        super(world);
        this.title("Room")
                .addItem(new Axe());
    }
}
