package io.github.kira076.adventureclasses.commands;

import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.source.CommandBlockSource;
import org.spongepowered.api.command.source.ConsoleSource;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;

public class CommandTrain extends PlayerOnlyCommand {

    @Override
    public void execute(final Player p, final CommandContext args) {
        p.sendMessage(Text.of("You are now trained!"));
    }

    @Override
    public void execute(final ConsoleSource c, final CommandContext args) {
        Player p = args.<Player>getOne("player").get();

        p.sendMessage(Text.of("You have been trained!"));
        c.sendMessage(Text.of("You have trained " + p.getName() + "!"));
    }

    @Override
    public void execute(final CommandBlockSource b, final CommandContext args) {
        Player p = args.<Player>getOne("player").get();

        p.sendMessage(Text.of("You have been trained!"));
        b.sendMessage(Text.of("You have trained " + p.getName() + "!"));
    }
}
