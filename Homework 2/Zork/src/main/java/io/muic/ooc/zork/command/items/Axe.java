package io.muic.ooc.zork.command.items;

import io.muic.ooc.zork.command.Item;

public class Axe extends Item {
    public Axe(){
        super();
        this.name("Axe")
                .attack(10);
    }
}
