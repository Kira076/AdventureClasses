package io.github.kira076.adventureclasses.io;

import io.github.kira076.adventureclasses.AdventureClasses;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import org.slf4j.Logger;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Config {
    private final ConfigurationLoader<CommentedConfigurationNode> loader;
    private final CommentedConfigurationNode node;

    public Config(@Nonnull final AdventureClasses advcl, @Nonnull final Path path) {
        this.loader = HoconConfigurationLoader.builder().setPath(path).build();

        if (!Files.exists(path)) {
            try { advcl.getContainer().getAsset("config.conf").get().copyToFile(path); }
            catch (final IOException exc) { advcl.getLogger().error("Failed to save config asset: {}", exc); }
        }
        this.node = this.load(advcl.getLogger());
    }

    private CommentedConfigurationNode load(@Nonnull final Logger logger) {
        try { return this.loader.load(); }
        catch (final IOException exc) { logger.error("Failed to load config file: {}", exc); return this.loader.createEmptyNode(); }
    }

    @Nonnull
    public CommentedConfigurationNode getNode(@Nonnull final Object... keys) {
        return this.node.getNode(keys);
    }
}
