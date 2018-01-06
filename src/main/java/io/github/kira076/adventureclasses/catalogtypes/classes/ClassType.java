package io.github.kira076.adventureclasses.catalogtypes.classes;


import io.github.kira076.adventureclasses.AdventureClasses;
import io.github.kira076.adventureclasses.io.ConfigManager;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.util.annotation.CatalogedBy;

import javax.annotation.Nonnull;
import java.util.function.BiFunction;

@CatalogedBy(ClassTypes.class)
public class ClassType implements CatalogType {

    private final String name;
    private final String id;
    private final BiFunction<AdventureClasses, ConfigManager, Object> listener;

    ClassType(@Nonnull final String name, @Nonnull final String id, @Nonnull final BiFunction<AdventureClasses, ConfigManager, Object> listener) {
        this.name = name;
        this.id = id;
        this.listener = listener;
    }

    @Override
    @Nonnull
    public String getName() {
        return this.name;
    }

    @Override
    @Nonnull
    public String getId() {
        return this.id;
    }

    @Nonnull
    public BiFunction<AdventureClasses, ConfigManager, Object> getListener() {
        return this.listener;
    }
}
