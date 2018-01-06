package io.github.kira076.adventureclasses.catalogtypes.classes;

import com.google.common.collect.Lists;
import io.github.kira076.adventureclasses.listeners.WarriorListener;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Optional;

public class ClassTypes {

    private ClassTypes(){}

    public static final ClassType WARRIOR = new ClassType("Warrior", "warrior", (advcl, config) -> new WarriorListener(advcl));

    public static final List<ClassType> VALUES = Lists.newArrayList(WARRIOR);

    @Nonnull
    public static Optional<ClassType> of(@Nonnull final String id) {
        for (ClassType type : VALUES) { if (type.getId().equalsIgnoreCase(id)) { return Optional.of(type); } }
        return Optional.empty();
    }
}
