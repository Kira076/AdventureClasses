package io.github.kira076.adventureclasses.io;

import io.github.kira076.adventureclasses.AdventureClasses;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import org.slf4j.Logger;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Config {
    private final String id;
    private final ConfigurationLoader<CommentedConfigurationNode> loader;
    private final CommentedConfigurationNode node;
    private final Path path;
    private final Logger logger;


    public Config(@Nonnull final AdventureClasses advcl, @Nonnull final String id, @Nonnull final Path configdir, @Nonnull final String file) {
        this.path = configdir.resolve(file);
        this.loader = HoconConfigurationLoader.builder().setPath(this.path).build();
        this.logger = advcl.getLogger();
        this.id = id;

        if (!Files.exists(this.path)) {
            try { advcl.getContainer().getAsset(file).get().copyToFile(this.path); }
            catch (final IOException exc) { this.logger.error("Failed to save config asset: " + this.id, exc); }
        }
        this.node = this.load();
    }

    private CommentedConfigurationNode load() {
        try { return this.loader.load(); }
        catch (final IOException exc) { this.logger.error("Failed to load config file: " + this.id, exc); return this.loader.createEmptyNode(); }
    }

    public void save() {
        try { this.loader.save(this.node); }
        catch (final IOException exc) { this.logger.error("Failed to save config file: " + this.id, exc); }
    }

    @Nonnull
    public String getId() { return this.id; }

    @Nonnull
    public CommentedConfigurationNode getNode(@Nonnull final Object... keys) { return this.node.getNode(keys); }

    @Nonnull public Logger getLogger() { return this.logger; }
}
