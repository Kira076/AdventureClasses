package io.github.kira076.adventureclasses.commands;

import io.github.kira076.adventureclasses.catalogtypes.classes.ClassType;
import io.github.kira076.adventureclasses.catalogtypes.styles.StyleType;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.source.CommandBlockSource;
import org.spongepowered.api.command.source.ConsoleSource;
import org.spongepowered.api.data.type.HandTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.Text;

import java.util.Optional;

public class CommandAssociate extends PlayerOnlyCommand {

    @Override
    public void execute(final Player p, final CommandContext args) {
        Optional<ItemStack> itemInHand = p.getItemInHand(HandTypes.MAIN_HAND);
        StyleType targetStyle = args.<StyleType>getOne("style").get();
        try{
            ItemStack itemstack = itemInHand.get();
            ItemType item = itemstack.getType();
            targetStyle.addProf(item);
        }
        catch (Throwable T) {
            p.sendMessage(Text.of("You are not holding an item."));
        }

    }

    @Override
    public void execute(final ConsoleSource c, final CommandContext args) {
        Player p = args.<Player>getOne("player").get();
        StyleType targetStyle = args.<StyleType>getOne("style").get();

        Optional<ItemStack> itemInHand = p.getItemInHand(HandTypes.MAIN_HAND);
        try{
            ItemStack itemstack = itemInHand.get();
            ItemType item = itemstack.getType();
            targetStyle.addProf(item);
            c.sendMessage(Text.of("Added item " + item + " as prof to style " + targetStyle));
        }
        catch (Throwable T) {
            c.sendMessage(Text.of("Player " + p.getName() + " is not holding an item."));
        }
    }

    @Override
    public void execute(final CommandBlockSource b, final CommandContext args) {
        Player p = args.<Player>getOne("player").get();
        StyleType targetStyle = args.<StyleType>getOne("style").get();

        Optional<ItemStack> itemInHand = p.getItemInHand(HandTypes.MAIN_HAND);
        try{
            ItemStack itemstack = itemInHand.get();
            ItemType item = itemstack.getType();
            targetStyle.addProf(item);
            b.sendMessage(Text.of("Added item " + item + " as prof to style " + targetStyle));
        }
        catch (Throwable T) {
            b.sendMessage(Text.of("Player " + p.getName() + " is not holding an item."));
        }
    }
}