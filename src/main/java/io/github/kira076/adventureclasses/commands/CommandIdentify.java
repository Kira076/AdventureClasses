package io.github.kira076.adventureclasses.commands;

import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.source.CommandBlockSource;
import org.spongepowered.api.command.source.ConsoleSource;
import org.spongepowered.api.data.type.HandTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.Text;

import java.util.Optional;


public class CommandIdentify extends PlayerOnlyCommand {



    @Override
    public void execute(final Player p, final CommandContext args) {
        Optional<ItemStack> itemInHand = p.getItemInHand(HandTypes.MAIN_HAND);
        try{
            ItemStack itemstack = itemInHand.get();
            ItemType item = itemstack.getType();
            p.sendMessage(Text.of("You are holding: " + item.toString()));
        }
        catch (Throwable T) {
            p.sendMessage(Text.of("You are not holding an item."));
        }

    }

    @Override
    public void execute(final ConsoleSource c, final CommandContext args) {
        Player p = args.<Player>getOne("player").get();

        Optional<ItemStack> itemInHand = p.getItemInHand(HandTypes.MAIN_HAND);
        try{
            ItemStack itemstack = itemInHand.get();
            ItemType item = itemstack.getType();
            c.sendMessage(Text.of("Player " + p.getName() + " is holding item: " + item.toString()));
        }
        catch (Throwable T) {
            c.sendMessage(Text.of("Player " + p.getName() + " is not holding an item."));
        }
    }

    @Override
    public void execute(final CommandBlockSource b, final CommandContext args) {
        Player p = args.<Player>getOne("player").get();

        Optional<ItemStack> itemInHand = p.getItemInHand(HandTypes.MAIN_HAND);
        try{
            ItemStack itemstack = itemInHand.get();
            ItemType item = itemstack.getType();
            b.sendMessage(Text.of("Player " + p.getName() + " is holding item: " + item.toString()));
        }
        catch (Throwable T) {
            b.sendMessage(Text.of("Player " + p.getName() + " is not holding an item."));
        }
    }
}
