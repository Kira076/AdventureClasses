package io.github.kira076.adventureclasses.io;

import com.google.common.collect.Maps;
import io.github.kira076.adventureclasses.AdventureClasses;

import javax.annotation.Nonnull;
import java.nio.file.Path;
import java.util.Map;

public class ConfigManager {

    private Path configdir;
    private AdventureClasses container;
    private Map<String, Config> map = Maps.newHashMap();

    public ConfigManager(@Nonnull final AdventureClasses advcl, @Nonnull final Path configdir) {
        this.configdir = configdir;
        this.container = advcl;
    }

    public void registerConfig(@Nonnull final String id, @Nonnull final String file) {
        Config config = new Config(this.container, id, this.configdir, file);
        this.map.put(config.getId(), config);
    }

    public Config get(@Nonnull final String id) {
        return this.map.get(id);
    }

    /*private final ConfigurationLoader<CommentedConfigurationNode> confLoader;
    private final CommentedConfigurationNode confNode;
    private final Path confPath;

    public ConfigManager(@Nonnull final AdventureClasses advcl, @Nonnull final Path configdir) {
        this.confPath = configdir.resolve("config.conf");
        this.confLoader = HoconConfigurationLoader.builder().setPath(confPath).build();

        if (!Files.exists(configdir)) {
            try {
                advcl.getContainer().getAsset("config.conf").get().copyToFile(configdir);
            }
            catch (final IOException exc) { advcl.getLogger().error("Failed to save config asset: {}", exc); }
        }
        this.confNode = this.loadConf(advcl.getLogger());
    }

    private CommentedConfigurationNode loadConf(@Nonnull final Logger logger) {
        try { return this.confLoader.load(); }
        catch (final IOException exc) { logger.error("Failed to load config file: {}", exc); return this.confLoader.createEmptyNode(); }
    }

    @Nonnull
    public CommentedConfigurationNode getConfNode(@Nonnull final Object... keys) {
        return this.confNode.getNode(keys);
    }*/
}
