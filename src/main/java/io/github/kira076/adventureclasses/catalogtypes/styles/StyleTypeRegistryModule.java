package io.github.kira076.adventureclasses.catalogtypes.styles;

import io.github.kira076.adventureclasses.catalogtypes.classes.ClassType;
import io.github.kira076.adventureclasses.catalogtypes.classes.ClassTypes;
import org.spongepowered.api.registry.CatalogRegistryModule;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Optional;

public class StyleTypeRegistryModule implements CatalogRegistryModule<StyleType> {

    @Override
    public Optional<StyleType> getById(@Nonnull final String id) { return StyleTypes.of(id); }

    @Override
    public Collection<StyleType> getAll() {
        return StyleTypes.VALUES;
    }
}