package io.github.kira076.adventureclasses.utils;

import com.google.common.collect.Maps;
import io.github.kira076.adventureclasses.catalogtypes.ClassType;
import io.github.kira076.adventureclasses.catalogtypes.ClassTypes;

import javax.annotation.Nonnull;
import java.util.Map;

public class CommandMaps {
    private final Map<String, ClassType> classes;

    public CommandMaps() {
        this.classes = Maps.newHashMap();

        ClassTypes.VALUES.forEach(type -> this.classes.put(type.getId(), type));
    }

    @Nonnull
    public Map<String, ClassType> getClasses() {
        return this.classes;
    }
}
