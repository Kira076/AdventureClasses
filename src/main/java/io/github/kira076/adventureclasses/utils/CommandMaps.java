package io.github.kira076.adventureclasses.utils;

import com.google.common.collect.Maps;
import io.github.kira076.adventureclasses.catalogtypes.classes.ClassType;
import io.github.kira076.adventureclasses.catalogtypes.classes.ClassTypes;
import io.github.kira076.adventureclasses.catalogtypes.styles.StyleType;

import javax.annotation.Nonnull;
import java.util.Map;

public class CommandMaps {
    private final Map<String, ClassType> classes;
    private final Map<String, StyleType> styles;

    public CommandMaps() {
        this.classes = Maps.newHashMap();
        this.styles = Maps.newHashMap();


        ClassTypes.VALUES.forEach(type -> this.classes.put(type.getId(), type));
    }

    @Nonnull
    public Map<String, ClassType> getClasses() {
        return this.classes;
    }

    @Nonnull
    public  Map<String, StyleType> getStyles() { return this.styles; }
}
