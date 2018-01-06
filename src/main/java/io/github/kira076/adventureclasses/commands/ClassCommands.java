package io.github.kira076.adventureclasses.commands;

import io.github.kira076.adventureclasses.utils.CommandMaps;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.text.Text;

public class ClassCommands {

    private static CommandMaps cmds = new CommandMaps();

    private static CommandSpec newCmd = CommandSpec.builder()
            .description(Text.of("Learn a new class."))
            .permission("adventureclasses.command.train.new")
            .arguments(
                    GenericArguments.onlyOne(GenericArguments.choices(Text.of("classes"), cmds.getClasses())) )
            .executor(new CommandTrain())
            .build();

    public static CommandSpec trainCommand = CommandSpec.builder()
            .description(Text.of("Learn new classes or manage existing ones."))
            .permission("adventureclasses.command.train")
            .child(newCmd, "new")
            .arguments(
                    GenericArguments.optional(GenericArguments.onlyOne(GenericArguments.player(Text.of("player")))))
            .executor(new CommandTrain())
            .build();
}
