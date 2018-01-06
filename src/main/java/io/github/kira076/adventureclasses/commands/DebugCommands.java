package io.github.kira076.adventureclasses.commands;

import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.text.Text;

public class DebugCommands {
    public static CommandSpec identCommand = CommandSpec.builder()
            .description(Text.of("Output the currently held itemstack."))
            .permission("adventureclasses.command.identify")
            .arguments(
                    GenericArguments.optional(GenericArguments.onlyOne(GenericArguments.player(Text.of("player")))))
            .executor(new CommandIdentify())
            .build();
}
