package io.github.kira076.adventureclasses.commands;

import io.github.kira076.adventureclasses.utils.CommandMaps;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.text.Text;

public class AdminCommands {

    private static CommandMaps cmds = new CommandMaps();

    private static CommandSpec assocCmd = CommandSpec.builder()
            .description(Text.of("Make the chosen class proficient with the held item."))
            .permission("adventureclasses.command.admin.associate")
            .arguments(
                    GenericArguments.onlyOne(GenericArguments.choices(Text.of("style"), cmds.getStyles())),
                    GenericArguments.optional(GenericArguments.onlyOne(GenericArguments.player(Text.of("player"))))
                    )
            .executor(new CommandAssociate())
            .build();

    public static CommandSpec adminCommand = CommandSpec.builder()
            .description(Text.of("Display a list of admin options."))
            .permission("adventureclasses.command.admin")
            .child(assocCmd, "associate")
            .executor(new CommandAdmin())
            .build();
}
