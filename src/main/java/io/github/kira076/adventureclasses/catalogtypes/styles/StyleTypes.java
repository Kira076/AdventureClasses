package io.github.kira076.adventureclasses.catalogtypes.styles;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.reflect.TypeToken;
import io.github.kira076.adventureclasses.io.Config;
import io.github.kira076.adventureclasses.io.ConfigManager;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.ItemTypes;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StyleTypes {

    private StyleTypes(){
    }

    private static final StyleType SWORDSTYLE = new StyleType("Swords Style", "swordsstyle", ItemTypes.DIAMOND_SWORD, ItemTypes.GOLDEN_SWORD, ItemTypes.IRON_SWORD, ItemTypes.STONE_SWORD, ItemTypes.WOODEN_SWORD);
    private static final StyleType AXESTYLE = new StyleType("Axes Style", "axesstyle", ItemTypes.DIAMOND_AXE, ItemTypes.GOLDEN_AXE, ItemTypes.IRON_AXE, ItemTypes.STONE_AXE, ItemTypes.WOODEN_AXE);
    private static final StyleType BREAKERSTYLE = new StyleType("Breaker Style", "breakerstyle", ItemTypes.DIAMOND_PICKAXE, ItemTypes.GOLDEN_PICKAXE, ItemTypes.IRON_PICKAXE, ItemTypes.STONE_PICKAXE, ItemTypes.WOODEN_PICKAXE);

    public static List<StyleType> VALUES = Lists.newArrayList(SWORDSTYLE, AXESTYLE, BREAKERSTYLE);

    //public static Map<String, StyleType> VALUES = Maps.newHashMap();

    @Nonnull
    public static Optional<StyleType> of(@Nonnull final String id) {
        for (StyleType type : VALUES) { if (type.getId().equalsIgnoreCase(id)) { return Optional.of(type); } }
        return Optional.empty();
    }

    public static void addNewStyle (@Nonnull final String name, @Nonnull final String id, ItemType... profs) {
        VALUES.add(new StyleType(name, id, profs));
    }

    public static void getStylesNode (@Nonnull final ConfigManager configer) {
        Config styleConf = configer.get("styles");
        try{
        VALUES = styleConf.getNode("Styles").getList(TypeToken.of(StyleType.class));}
        catch (ObjectMappingException exc) {
            styleConf.getLogger().error("Failed to get Style nodes from styles.conf");
        }
    }

    public static void setStylesNode (@Nonnull final ConfigManager configer) {
        Config styleConf = configer.get("styles");
        VALUES.forEach(styleType -> styleConf.getNode("Styles", styleType.getId()).setValue(styleType));
    }
}
