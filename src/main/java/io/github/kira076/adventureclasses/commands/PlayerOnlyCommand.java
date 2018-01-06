package io.github.kira076.adventureclasses.commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.source.CommandBlockSource;
import org.spongepowered.api.command.source.ConsoleSource;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

public abstract class PlayerOnlyCommand implements CommandExecutor {

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if (src instanceof Player) {
            Player p = (Player) src;

            this.execute(p, args);
            return CommandResult.success();
        }
        else if (src instanceof ConsoleSource) {
            ConsoleSource c = (ConsoleSource) src;

            this.execute(c, args);
            return CommandResult.success();
        }
        else if (src instanceof CommandBlockSource) {
            CommandBlockSource b = (CommandBlockSource) src;

            this.execute(b, args);
            return CommandResult.success();
        }

        return CommandResult.success();
    }

    public abstract void execute(Player p, CommandContext args) throws CommandException;
    public abstract void execute(ConsoleSource c, CommandContext args) throws CommandException;
    public abstract void execute(CommandBlockSource b, CommandContext args) throws CommandException;
}
