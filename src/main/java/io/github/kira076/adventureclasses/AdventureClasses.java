package io.github.kira076.adventureclasses;

import javax.annotation.Nonnull;
import javax.inject.Inject;

import com.google.common.reflect.TypeToken;
import io.github.kira076.adventureclasses.catalogtypes.classes.ClassType;
import io.github.kira076.adventureclasses.catalogtypes.classes.ClassTypeRegistryModule;
import io.github.kira076.adventureclasses.catalogtypes.styles.StyleType;
import io.github.kira076.adventureclasses.catalogtypes.styles.StyleTypeRegistryModule;
import io.github.kira076.adventureclasses.catalogtypes.styles.StyleTypes;
import io.github.kira076.adventureclasses.commands.AdminCommands;
import io.github.kira076.adventureclasses.commands.ClassCommands;
import io.github.kira076.adventureclasses.commands.DebugCommands;
import io.github.kira076.adventureclasses.io.ConfigManager;
import io.github.kira076.adventureclasses.utils.StyleSerializer;
import ninja.leaping.configurate.objectmapping.serialize.TypeSerializers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.api.Game;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.config.ConfigDir;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameConstructionEvent;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.plugin.PluginContainer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Plugin(id = "adventureclasses",
        name = "Adventure Classes",
        version = "0.1-SNAPSHOT",
        description = "A plugin to add rpg style classes to minecraft",
        authors = {"Kira076"})

public class AdventureClasses {
    private final Game game;
    private final Logger logger;
    private final Path configdir;
    private final PluginContainer container;
    private final ConfigManager configer;

    @Inject
    public AdventureClasses(final Game game, @ConfigDir(sharedRoot = false) final Path path, final PluginContainer container) {
        this.game = game;
        this.container = container;
        this.logger = LoggerFactory.getLogger("AdventureClasses");
        this.configdir = path;
        this.configer = new ConfigManager(this, this.configdir);

        if (!Files.exists(path)) {
            try { Files.createDirectory(path); }
            catch (final IOException exc) { this.logger.error("Failed to create main config directory: {}", exc); }
        }
    }

    @Listener
    public void onGameConstruction(GameConstructionEvent e) {
        Sponge.getRegistry().registerModule(ClassType.class, new ClassTypeRegistryModule());
        Sponge.getRegistry().registerModule(StyleType.class, new StyleTypeRegistryModule());

        this.configer.registerConfig("conf", "config.conf");
        this.configer.registerConfig("styles", "styles.conf");


    }

    @Listener
    public void onInit(GameInitializationEvent e) {
        TypeSerializers.getDefaultSerializers().registerType(TypeToken.of(StyleType.class), new StyleSerializer());

        StyleTypes.setStylesNode(this.configer);

        Sponge.getCommandManager().register(this, ClassCommands.trainCommand, "train");
        Sponge.getCommandManager().register(this, DebugCommands.identCommand, "identify");
        Sponge.getCommandManager().register(this, AdminCommands.adminCommand, "advadmin");
    }

    @Nonnull public Logger getLogger() { return this.logger; }
    @Nonnull public PluginContainer getContainer() { return this.container; }
    @Nonnull public ConfigManager getConfiger() { return this.configer; }
}
