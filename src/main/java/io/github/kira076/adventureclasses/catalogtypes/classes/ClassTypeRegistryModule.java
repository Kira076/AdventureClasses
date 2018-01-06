package io.github.kira076.adventureclasses.catalogtypes.classes;

import org.spongepowered.api.registry.CatalogRegistryModule;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Optional;

public class ClassTypeRegistryModule implements CatalogRegistryModule<ClassType> {

    @Override
    public Optional<ClassType> getById(@Nonnull final String id) {
        return ClassTypes.of(id);
    }

    @Override
    public Collection<ClassType> getAll() {
        return ClassTypes.VALUES;
    }
}
